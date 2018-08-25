package org.leadpony.justify.examples.simplereader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.JsonReader;
import javax.json.JsonValue;

import org.leadpony.justify.core.JsonSchema;
import org.leadpony.justify.core.Jsonv;
import org.leadpony.justify.core.ProblemHandler;

/**
 * Validating JSON with the Object Model API.
 */
public class Example {
    
    public void run() throws IOException {
        Jsonv jsonv = Jsonv.newInstance();
      
        Path pathToSchema = Paths.get("person.schema.json");
        JsonSchema schema = jsonv.readSchema(pathToSchema);

        // Problem handler
        ProblemHandler handler = ProblemHandler.printingWith(System.out::println);
        
        Path pathToInstance = Paths.get("person-bad.json");
        try (JsonReader reader = jsonv.createReader(pathToInstance, schema, handler)) {
            JsonValue value = reader.readValue();
            System.out.println(value);
        }
    }

    public static void main(String[] args) throws IOException {
        new Example().run();
    }
}
