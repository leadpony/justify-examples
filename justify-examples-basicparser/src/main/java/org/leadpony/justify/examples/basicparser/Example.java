package org.leadpony.justify.examples.basicparser;

import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.json.stream.JsonParser;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

/**
 * Validates a JSON document with the Streaming API.
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
        try (JsonParser parser = service.createParser(pathToInstance, schema, handler)) {
            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                System.out.println(event);
            }
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
