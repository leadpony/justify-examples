package org.leadpony.justify.examples.simpleparser;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.stream.JsonParser;

import org.leadpony.justify.core.JsonSchema;
import org.leadpony.justify.core.Jsonv;
import org.leadpony.justify.core.ProblemHandler;

/**
 * Validating JSON with the Streaming API.
 */
public class Example {

    public void run() throws IOException {
        Jsonv jsonv = Jsonv.newInstance();
        
        Path pathToSchema = Paths.get("person.schema.json");
        JsonSchema schema = jsonv.readSchema(pathToSchema);

        // Problem handler
        ProblemHandler handler = ProblemHandler.printingWith(System.out::println);

        Path pathToInstance = Paths.get("person-bad.json");
        try (JsonParser parser = jsonv.createParser(pathToInstance, schema, handler)) {
            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                System.out.println(event);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Example().run();
    }
}
