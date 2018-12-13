package org.leadpony.justify.examples.binding;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.spi.JsonProvider;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

/**
 * Validating a JSON document while unmarshalling the document into
 * Plain Old Java Objects.
 */
public class Example {

    /**
     * Run this example.
     * 
     * @param instancePath the path to the JSON file to be validated.
     * @param schemaPath the path to the JSON schema file.
     * @throws IOException if an I/O error occurs while reading JSON files. 
     */
    public void run(String instancePath, String schemaPath) throws IOException {
        JsonValidationService service = JsonValidationService.newInstance();

        JsonSchema schema = service.readSchema(Paths.get(schemaPath));

        // Problem handler
        ProblemHandler handler = service.createProblemPrinter(System.out::println);
        
        JsonProvider provider = service.createJsonProvider(schema, parser->handler);
        Jsonb jsonb = JsonbBuilder.newBuilder().withProvider(provider).build();
        
        try (InputStream stream = Files.newInputStream(Paths.get(instancePath))) {
            Person person = jsonb.fromJson(stream, Person.class);
            System.out.println(person);
        }
    }
    
    public static void main(String[] args) throws IOException {
        if (args.length >= 2) {
            new Example().run(args[0], args[1]);
        }
    }
}
