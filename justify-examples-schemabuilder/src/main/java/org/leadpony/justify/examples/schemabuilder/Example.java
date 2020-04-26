package org.leadpony.justify.examples.schemabuilder;

import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

import org.leadpony.justify.api.InstanceType;
import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonSchemaBuilderFactory;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

/**
 * Builds a JSON schema programmatically.
 */
public class Example {

    // The only instance of JSON validation service.
    private final JsonValidationService service = JsonValidationService.newInstance();

    /**
     * Runs this example.
     *
     * @param instancePath the path to the JSON file to be validated.
     */
    public void run(String instancePath) {
        JsonSchema schema = buildSchema();

        // Problem handler
        ProblemHandler handler = service.createProblemPrinter(System.out::println);

        Path pathToInstance = Paths.get(instancePath);
        try (JsonReader reader = service.createReader(pathToInstance, schema, handler)) {
            JsonValue value = reader.readValue();
            System.out.println(value);
        }
    }

    /**
     * Builds a JSON schema programmatically with {@link JsonSchemaBuilder}.
     *
     * @return newly built JSON schema.
     */
    private JsonSchema buildSchema() {
        JsonSchemaBuilderFactory f = service.createSchemaBuilderFactory();

        JsonSchema schema = f.createBuilder()
                .withType(InstanceType.OBJECT)
                .withProperty("firstName",
                        f.createBuilder().withType(InstanceType.STRING).build())
                .withProperty("lastName",
                        f.createBuilder().withType(InstanceType.STRING).build())
                .withProperty("age",
                        f.createBuilder()
                            .withType(InstanceType.INTEGER)
                            .withMinimum(0)
                            .build())
                .withProperty("hobbies",
                        f.createBuilder()
                            .withType(InstanceType.ARRAY)
                            .withItems(
                                    f.createBuilder().withType(InstanceType.STRING).build())
                            .build())
                .withRequired("firstName", "lastName")
                .build();

        return schema;
    }

    public static void main(String[] args) {
        if (args.length >= 1) {
            new Example().run(args[0]);
        } else {
            System.err.println("Missing arguments: <path/to/JSON instance>");
        }
    }
}
