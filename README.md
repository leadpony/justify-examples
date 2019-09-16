# Justify Examples
[![Build Status](https://travis-ci.org/leadpony/justify-examples.svg?branch=master)](https://travis-ci.org/leadpony/justify-examples)

This project provides various kinds of code samples demonstrating how to validate JSON documents based on [JSON Schema Specification], using [Justify].

## How to Build Examples

### Prerequisites

The following tools are required to build and run the examples in this repository.

* JDK 8, 9, 10, 11, or 12.
* One of the following build tools
  * [Apache Maven] 3.6.0 or higher
  * [Gradle] 5.6.2 or higher

### Downloading Examples

The commands below download all of the examples.

```bash
$ git clone https://github.com/leadpony/justify-examples.git
```

Alternatively you can download a ZIP file containing all source code from [Download].

### Building Examples

The commands below build all of the examples.

*Maven*
```bash
$ cd path/to/justify-examples
$ mvn package
```

*Gradle*
```bash
$ cd path/to/justify-examples
$ gradle build
```

## Examples

### 1. [Basic Parser](justify-examples-basicparser/README.md)

This code sample shows how to validate a JSON document using the Streaming API of [Java API for JSON Processing].

### 2. [Basic Reader](justify-examples-basicreader/README.md)

This code sample shows how to validate a JSON document using the Object Model API of [Java API for JSON Processing].

### 3. [Binding](justify-examples-binding/README.md)

This code sample shows how to validate a JSON document while unmarshalling the JSON document into a Plain Old Java Object, using [Java API for JSON Binding].

### 4. [Problem Handler](justify-examples-problemhandler/README.md)

This code sample shows how to implement your own problem handler,
which processes the problems found in the validation.

### 5. [Schema Builder](justify-examples-schemabuilder/README.md)

This code sample shows how to build a JSON schema programmatically.
The code validates a JSON document against the built schema.

### 6. [Schema Resolver](justify-examples-schemaresolver/README.md)

This code sample shows how to resolve a referenced external JSON schema using
the implementation class of JsonSchemaResolver.

### 7. [Custom Format](justify-examples-customformat/README.md)

This code sample shows how to implement your own format attribute,
which can be used as the value of "format" keyword in the schema definition.

### 8. [Default Value](justify-examples-defaultvalue/README.md)

This code sample shows how to fill the missing properties and/or items in the instance with default values given by `default` keyword in the schema.

## License

All code samples in this repository are free and unencumbered software released into the public domain. Please read [LICENSE] file for more information.

[JSON Schema Specification]: https://json-schema.org/
[Justify]: https://github.com/leadpony/justify
[Java API for JSON Processing]: https://eclipse-ee4j.github.io/jsonp/
[Java API for JSON Binding]: http://json-b.net/
[LICENSE]: LICENSE
[Apache Maven]: https://maven.apache.org/
[Gradle]: https://gradle.org/
[Download]: https://github.com/leadpony/justify-examples/archive/master.zip
