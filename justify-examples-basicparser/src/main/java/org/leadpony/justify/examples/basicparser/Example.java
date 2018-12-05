package org.leadpony.justify.examples.basicparser;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.stream.JsonParser;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

/**
 * Validating a JSON document with the Streaming API.
 */
public class Example {

    public void run(String instancePath, String schemaPath) throws IOException {
        JsonValidationService service = JsonValidationService.newInstance();
        
        Path pathToSchema = Paths.get(schemaPath);
        JsonSchema schema = service.readSchema(pathToSchema);

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
    
    public static void main(String[] args) throws IOException {
        if (args.length >= 2) {
            new Example().run(args[0], args[1]);
        }
    }
}
