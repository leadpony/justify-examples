package org.leadpony.justify.examples.yamlvalidator;

import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

/**
 * Validates a YAML document against JSON schema file in YAML format.
 */
public class Example {

    // The only instance of JSON validation service.
    private static final JsonValidationService service = JsonValidationService.newInstance();

    /**
     * Runs this example.
     *
     * @param schemaPath the path to the JSON schema file.
     * @param instancePath the path to the YAML file to be validated.
     */
    public void run(String schemaPath, String instancePath) {
        JsonSchema schema = service.readSchema(Paths.get(schemaPath));

        Path pathToInstance = Paths.get(instancePath);

        // Validates the instance by using JsonParser.
        validateUsingJsonParser(schema, pathToInstance);

        // Validates the instance by using JsonReader.
        validateUsingJsonReader(schema, pathToInstance);
    }

    private void validateUsingJsonParser(JsonSchema schema, Path instancePath)  {
        // Problem handler
        ProblemHandler handler = service.createProblemPrinter(System.out::println);

        try (JsonParser parser = service.createParser(instancePath, schema, handler)) {
            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                System.out.println(event);
            }
        }
    }

    private void validateUsingJsonReader(JsonSchema schema, Path instancePath)  {
        // Problem handler
        ProblemHandler handler = service.createProblemPrinter(System.out::println);

        try (JsonReader reader = service.createReader(instancePath, schema, handler)) {
            JsonValue value = reader.readValue();
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        if (args.length >= 2) {
            new Example().run(args[0], args[1]);
        } else {
            System.err.println("Missing arguments: <path/to/JSON schema> <path/to/YAML instance>");
        }
    }
}
