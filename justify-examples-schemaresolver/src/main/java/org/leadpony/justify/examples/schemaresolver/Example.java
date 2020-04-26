package org.leadpony.justify.examples.schemaresolver;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonSchemaReader;
import org.leadpony.justify.api.JsonSchemaReaderFactory;
import org.leadpony.justify.api.JsonSchemaResolver;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

/**
 * Resolves a referenced schema with {@link JsonSchemaResolver}.
 */
public class Example {

    // The only instance of JSON validation service.
    private final JsonValidationService service = JsonValidationService.newInstance();

    // The configured factory which will produce schema readers.
    private JsonSchemaReaderFactory readerFactory;

    /**
     * Runs this example.
     *
     * @param schemaPath   the path to the JSON schema file.
     * @param instancePath the path to the JSON file to be validated.
     */
    public void run(String schemaPath, String instancePath) {

        // Builds a factory of schema readers.
        this.readerFactory = service.createSchemaReaderFactoryBuilder()
                .withSchemaResolver(this::resolveSchema)
                .build();

        JsonSchema schema = readSchema(Paths.get(schemaPath));

        // Problem handler
        ProblemHandler handler = service.createProblemPrinter(System.out::println);

        Path pathToInstance = Paths.get(instancePath);
        try (JsonReader reader = service.createReader(pathToInstance, schema, handler)) {
            JsonValue value = reader.readValue();
            System.out.println(value);
        }
    }

    /**
     * Reads the JSON schema from the specified path.
     *
     * @param path the path to the schema.
     * @return the read schema.
     */
    private JsonSchema readSchema(Path path) {
        try (JsonSchemaReader reader = readerFactory.createSchemaReader(path)) {
            return reader.read();
        }
    }

    /**
     * Resolves the referenced JSON schema.
     *
     * @param id the identifier of the referenced JSON schema.
     * @return referenced JSON schema.
     */
    private JsonSchema resolveSchema(URI id) {
        // The schema is available in the local filesystem.
        Path path = Paths.get(".", id.getPath());
        return readSchema(path);
    }

    public static void main(String[] args) {
        if (args.length >= 2) {
            new Example().run(args[0], args[1]);
        } else {
            System.err.println("Missing arguments: <path/to/JSON schema> <path/to/JSON instance>");
        }
    }
}
