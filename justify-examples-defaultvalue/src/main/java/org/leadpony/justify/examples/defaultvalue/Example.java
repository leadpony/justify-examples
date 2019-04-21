package org.leadpony.justify.examples.defaultvalue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.json.JsonValue;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidatingException;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;
import org.leadpony.justify.api.ValidationConfig;

/**
 * This example demonstrates the validator fills a JSON document with default
 * values.
 */
public class Example {

    // The only instance of JSON validation service.
    private static final JsonValidationService service = JsonValidationService.newInstance();

    /**
     * Runs this example.
     *
     * @param schemaPath   the path to the JSON schema file.
     * @param instancePath the path to the JSON instance file.
     */
    public void run(String schemaPath, String instancePath) {

        // Reads the JSON schema at the path.
        JsonSchema schema = service.readSchema(Paths.get(schemaPath));

        // Problem handler just priting problems.
        ProblemHandler handler = service.createProblemPrinter(System.out::println);

        // Creates a configuration.
        // Filling with default values is enabled.
        ValidationConfig config = service.createValidationConfig();
        config.withSchema(schema)
              .withProblemHandler(handler)
              .withDefaultValues(true);

        // Creates a configured reader factory.
        JsonReaderFactory readerFactory = service.createReaderFactory(config.getAsMap());

        // Path to the instance file.
        Path pathToInstance = Paths.get(instancePath);

        // Creates JSON reader from the factory.
        try (JsonReader reader = readerFactory.createReader(Files.newInputStream(pathToInstance))) {
            // Reads the whole JSON object.
            JsonValue value = reader.readValue();
            // Prints the JSON object filled with default values.
            System.out.println(value);
        } catch (IOException e) {
            // The instance file was not found.
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        try {
        if (args.length >= 2) {
            new Example().run(args[0], args[1]);
        } else {
            System.err.println("Missing arguments: <path/to/JSON schema> <path/to/JSON instance>");
        }
        } catch (JsonValidatingException e) {
            System.out.println(e);
        }
    }
}
