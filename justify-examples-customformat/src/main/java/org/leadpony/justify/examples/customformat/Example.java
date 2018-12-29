package org.leadpony.justify.examples.customformat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.JsonReader;
import javax.json.JsonValue;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

/**
 * Validates a JSON document against the JSON schema
 * which contains a custom format.
 */
public class Example {

    /**
     * Run this example.
     * 
     * @param schemaPath the path to the JSON schema file.
     * @param instancePath the path to the JSON file to be validated.
     * @throws IOException if an I/O error occurs while reading JSON files. 
     */
    public void run(String schemaPath, String instancePath) throws IOException {
        JsonValidationService service = JsonValidationService.newInstance();
      
        JsonSchema schema = service.readSchema(Paths.get(schemaPath));

        // Problem handler
        ProblemHandler handler = service.createProblemPrinter(System.out::println);
        
        Path pathToInstance = Paths.get(instancePath);
        try (JsonReader reader = service.createReader(pathToInstance, schema, handler)) {
            JsonValue value = reader.readValue();
            System.out.println(value);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length >= 2) {
            new Example().run(args[0], args[1]);
        } else {
            System.err.println("Missing arguments: <path/to/JSON schema> <path/to/JSON instance>");
        }
    }
}
