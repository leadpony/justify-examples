package org.leadpony.justify.examples.problemhandler;

import java.io.IOException;
import java.nio.file.Paths;

import javax.json.JsonReader;
import javax.json.JsonValue;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;

/**
 * Validates a JSON document with the Object Model API.
 *
 * The problems found in the validation will be handled by
 * a custom problem handler {@code MyProblemHandler}.
 */
public class Example {

    // The single instance of validation service.
    private static final JsonValidationService service = JsonValidationService.newInstance();

    /**
     * Runs this example.
     *
     * @param schemaPath the path to the JSON schema file.
     * @param instancePath the path to the JSON file to be validated.
     */
    public void run(String schemaPath, String instancePath) {

        // Reads the JSON schema from the given path.
        JsonSchema schema = service.readSchema(Paths.get(schemaPath));

        // Our own problem handler
        MyProblemHandler handler = new MyProblemHandler();

        // JSON value to be read.
        JsonValue value = null;

        // Creaates a JSON reader which will validate the instance while reading.
        try (JsonReader reader = service.createReader(Paths.get(instancePath), schema, handler)) {
            // Reads the root JSON value from the instance.
            value = reader.readValue();
        }

        handler.flush();

        // Pritns the read JSON value.
        System.out.println();
        System.out.println("JSON value: ");
        System.out.println(value.toString());
    }

    public static void main(String[] args) throws IOException {
        if (args.length >= 2) {
            new Example().run(args[0], args[1]);
        } else {
            System.err.println("Missing arguments: <path/to/JSON schema> <path/to/JSON instance>");
        }
    }
}
