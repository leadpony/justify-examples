package org.leadpony.justify.examples.simpleparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.json.stream.JsonParser;

import org.leadpony.justify.core.JsonSchema;
import org.leadpony.justify.core.Jsonv;
import org.leadpony.justify.core.Problem;

/**
 * Validating JSON with the Streaming API.
 */
public class Example {

    private static final Path SCHEMA_PATH = Paths.get("person.schema.json");
    private static final Path INSTANCE_PATH = Paths.get("person-bad.json");
    
    public void run() throws IOException {
        JsonSchema schema = Jsonv.readSchema(Files.newInputStream(SCHEMA_PATH));
        
        List<Problem> problems = new ArrayList<>();
        try (JsonParser parser = Jsonv.createParser(
                Files.newInputStream(INSTANCE_PATH), schema, problems::addAll)) {
            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                System.out.println(event);
            }
        }
        if (!problems.isEmpty()) {
            problems.forEach(System.out::println);
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Example().run();
    }
}
