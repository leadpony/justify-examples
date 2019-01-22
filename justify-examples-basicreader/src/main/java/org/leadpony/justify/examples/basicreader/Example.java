package org.leadpony.justify.examples.basicreader;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.JsonReader;
import javax.json.JsonValue;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

/**
 * Validates a JSON document with the Object Model API.
 */
public class Example {

    // The only instance of JSON validation service.
    private static final JsonValidationService service = JsonValidationService.newInstance();

    /**
     * Runs this example.
     *
     * @param schemaPath the path to the JSON schema file.
     * @param instancePath the path to the JSON file to be validated.
     */
    public void run(String schemaPath, String instancePath) {
        JsonSchema schema = service.readSchema(Paths.get(schemaPath));

        // Problem handler
        ProblemHandler handler = service.createProblemPrinter(System.out::println);

        Path pathToInstance = Paths.get(instancePath);
        try (JsonReader reader = service.createReader(pathToInstance, schema, handler)) {
            JsonValue value = reader.readValue();
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        if (args.length >= 2) {
            new Example().run(args[0], args[1]);
        } else {
            System.err.println("Missing arguments: <path/to/JSON schema> <path/to/JSON instance>");
        }
    }
}
