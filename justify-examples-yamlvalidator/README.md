# YAML Validator

## Description

This code sample demonstrates how to validate a YAML document using JsonParser and JsonReader provided by [Jakarta JSON Processing API].

All you need to do for validating YAML documents is just replacing any JSON-P implementation with [joy-yaml], which is another JSON-P implementation, as follows:

```xml
<dependency>
    <groupId>org.leadpony.joy</groupId>
    <artifactId>joy-yaml</artifactId>
    <version>${joy.version}</version>
    <scope>runtime</scope>
</dependency>
```

## How to Build

Follow the instructions shown in [README](../README.md) in the repository root.

## How to Run

Navigate to the generated `target` or `build` directory.

```shell
$ ./run.sh <path/to/JSON schema> <path/to/YAML document>
```

[Jakarta JSON Processing API]: https://eclipse-ee4j.github.io/jsonp/
[joy-yaml]: https://github.com/leadpony/joy
