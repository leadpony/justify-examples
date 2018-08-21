package org.leadpony.justify.examples.simplereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonReader;
import javax.json.JsonValue;

import org.leadpony.justify.core.JsonSchema;
import org.leadpony.justify.core.Jsonv;
import org.leadpony.justify.core.Problem;

/**
 * Validating JSON with the Object Model API.
 */
public class Example {
    
    private static final Path SCHEMA_PATH = Paths.get("person.schema.json");
    private static final Path INSTANCE_PATH = Paths.get("person-bad.json");

    public static void main(String[] args) throws IOException {
        JsonSchema schema = Jsonv.readSchema(Files.newInputStream(SCHEMA_PATH));
        
        List<Problem> problems = new ArrayList<>();
        try (JsonReader reader = Jsonv.createReader(
                Files.newInputStream(INSTANCE_PATH), schema, problems::addAll)) {
            JsonValue value = reader.readValue();
            System.out.println(value);
        }
        if (!problems.isEmpty()) {
            problems.forEach(System.out::println);
        }
    }
}
