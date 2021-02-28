package org.leadpony.justify.examples.yasson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.yasson.YassonJsonb;
import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;
import org.leadpony.justify.api.ValidationConfig;

import jakarta.json.bind.JsonbBuilder;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParserFactory;

/**
 * Validates a JSON document while unmarshalling the document into
 * Plain Old Java Objects.
 */
public class Example {

    // The only instance of JSON validation service.
    private static final JsonValidationService service = JsonValidationService.newInstance();

    /**
     * Runs this example.
     *
     * @param schemaPath the path to the JSON schema file.
     * @param instancePath the path to the JSON file to be validated.
     * @throws IOException if an I/O error occurs while reading JSON files.
     */
    public void run(String schemaPath, String instancePath) throws IOException {
        JsonSchema schema = service.readSchema(Paths.get(schemaPath));

        // Problem handler
        ProblemHandler handler = service.createProblemPrinter(System.out::println);

        // Creates a configuration.
        // Filling with default values is enabled.
        ValidationConfig config = service.createValidationConfig();
        config.withSchema(schema)
              .withProblemHandler(handler)
              .withDefaultValues(true);

        // Creates a configured reader factory.
        JsonParserFactory parserFactory = service.createParserFactory(config.getAsMap());

        YassonJsonb jsonb = (YassonJsonb) JsonbBuilder.create();

        Path pathToInstance = Paths.get(instancePath);
        try (JsonParser parser = parserFactory.createParser(Files.newInputStream(pathToInstance))) {
            Point point = jsonb.fromJson(parser, Point.class);
            System.out.println(point);
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
