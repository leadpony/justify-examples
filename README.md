# Justify Examples
[![Build Status](https://travis-ci.org/leadpony/justify-examples.svg?branch=master)](https://travis-ci.org/leadpony/justify-examples)

This project provides various kinds of code samples demonstrating how to validate JSON documents based on [JSON Schema Specification], using [Justify].

## How to Build Examples

The following tools are required to build and run the examples.

* JDK 8, 9, 10, 11, or 12.
* [Apache Maven] 3.6.0

The commands below build all examples in this repository.

```bash
$ git clone https://github.com/leadpony/justify-examples.git
$ cd justify-examples
$ mvn package
```

The ZIP file containing all source code is also available from [Download].

## Examples

### 1. [Basic Parser](justify-examples-basicparser/)

This code sample shows how to validate a JSON document using the Streaming API of [Java API for JSON Processing].

### 2. [Basic Reader](justify-examples-basicreader/)

This code sample shows how to validate a JSON document using the Object Model API of [Java API for JSON Processing].

### 3. [Binding](justify-examples-binding/)

This code sample shows how to validate a JSON document while unmarshalling the JSON document into a Plain Old Java Object, using [Java API for JSON Binding].

### 4. [Problem Handler](justify-examples-problemhandler/)

This code sample shows how to implement your own problem handler,
which processes the problems found in the validation.

### 5. [Schema Builder](justify-examples-schemabuilder/)

This code sample shows how to build a JSON schema programmatically.
The code validates a JSON document against the built schema.

### 6. [Schema Resolver](justify-examples-schemaresolver/)

This code sample shows how to resolve a referenced external JSON schema using
the implementation class of JsonSchemaResolver.

### 7. [Custom Format](justify-examples-customformat/)

This code sample shows how to implement your own format attribute,
which can be used as the value of "format" keyword in the schema definition.

### 8. [Default Value](justify-examples-defaultvalue/)

This code sample shows how to fill the missing properties and/or items in the instance with default values given by `default` keyword in the schema.

## License

All code samples in this repository are free and unencumbered software released into the public domain. Please read [LICENSE] file for more information.

[JSON Schema Specification]: https://json-schema.org/
[Justify]: https://github.com/leadpony/justify
[Java API for JSON Processing]: https://javaee.github.io/jsonp/
[Java API for JSON Binding]: http://json-b.net/
[LICENSE]: LICENSE
[Apache Maven]: https://maven.apache.org/
[Download]: https://github.com/leadpony/justify-examples/archive/master.zip
