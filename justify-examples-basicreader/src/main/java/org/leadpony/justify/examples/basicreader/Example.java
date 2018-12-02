package org.leadpony.justify.examples.basicreader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.JsonReader;
import javax.json.JsonValue;

import org.leadpony.justify.core.JsonSchema;
import org.leadpony.justify.core.Jsonv;
import org.leadpony.justify.core.ProblemHandler;

/**
 * Validating a JSON document with the Object Model API.
 */
public class Example {
    
    public void run(String instancePath, String schemaPath) throws IOException {
        Jsonv service = Jsonv.newInstance();
      
        Path pathToSchema = Paths.get(schemaPath);
        JsonSchema schema = service.readSchema(pathToSchema);

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
        }
    }
}
