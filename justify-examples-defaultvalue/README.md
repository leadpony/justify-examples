# Default Value

## Description

This code sample shows how to fill the missing properties and/or items in the instance with default values given by `default` keyword in the schema.

By default the feature is disabled and the instance never be modified. The method `withDefaultValues()` in the interface `ValidationConfig` can be used to enable the feature.

```java
ValidationConfig config = service.createValidationConfig();
config.withSchema(schema)
      .withProblemHandler(handler)
      .withDefaultValues(true);

// Creates a configured reader factory.
JsonReaderFactory readerFactory = service.createReaderFactory(config.getAsMap());
```

The input JSON instance shown below
```json
{
    "color": {
        "r": 64,
        "g": 128,
        "b": 192
    },
    "point": [1, 2]
}
```

will be filled with the default values and modified to:
```json
{
    "color": {
        "r": 64,
        "g": 128,
        "b": 192,
        "a": 255
    },
    "point": [1, 2, 0]
}
```

## How to Build

Follow the instructions shown in [README](../README.md) in the repository root.

## How to Run

Using module path in Java 9 or higher:

```bash
$ ./run.sh point.schema.json point.json
```

Using classpath in Java 8:

```bash
$ ./run-java8.sh point.schema.json point.json
```

## License

Please see [LICENSE](../LICENSE) in the repository root.
