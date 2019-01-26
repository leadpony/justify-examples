package org.leadpony.justify.examples.schemaresolver;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.JsonReader;
import javax.json.JsonValue;

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

    /**
     * Runs this example.
     *
     * @param schemaPath   the path to the JSON schema file.
     * @param instancePath the path to the JSON file to be validated.
     */
    public void run(String schemaPath, String instancePath) {

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
     * @param path
     * @return
     */
    private JsonSchema readSchema(Path path) {
        JsonSchemaReaderFactory factory = service.createSchemaReaderFactoryBuilder()
                .withSchemaResolver(new LocalJsonSchemaResolver()).build();
        try (JsonSchemaReader reader = factory.createSchemaReader(path)) {
            return reader.read();
        }
    }

    /**
     * Schema resolver which will provide schemas from the current directory.
     */
    private class LocalJsonSchemaResolver implements JsonSchemaResolver {

        @Override
        public JsonSchema resolveSchema(URI id) {
            Path path = Paths.get(".", id.getPath());
            return service.readSchema(path);
        }
    };

    public static void main(String[] args) {
        if (args.length >= 2) {
            new Example().run(args[0], args[1]);
        } else {
            System.err.println("Missing arguments: <path/to/JSON schema> <path/to/JSON instance>");
        }
    }
}
