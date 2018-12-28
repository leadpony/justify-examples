# Justify Examples
[![Build Status](https://travis-ci.org/leadpony/justify-examples.svg?branch=master)](https://travis-ci.org/leadpony/justify-examples)

This project provides various kinds of code samples demonstrating how to validate JSON documents based on [JSON Schema Specification], using [Justify].

## How to Build Examples

The following tools are required to build and run the examples.

* JDK 8, 9, 10 or 11.
* [Apache Maven]

The commands below build all examples in this repository.

```bash
$ git clone https://github.com/leadpony/justify-examples.git
$ cd justify-examples
$ mvn clean package
```

## Examples

### 1. [Basic Parser](justify-examples-basicparser/)

This code sample demonstrates how to validate a JSON document using the Streaming API of [Java API for JSON Processing].

### 2. [Basic Reader](justify-examples-basicreader/)

This code sample demonstrates how to validate a JSON document using the Object Model API of [Java API for JSON Processing].

### 3. [Binding](justify-examples-binding/)

This code sample demonstrates how to validate a JSON document while unmarshalling the JSON document into a Plain Old Java Object, using [Java API for JSON Binding].

## License

All examples in this repository are free and unencumbered software released into the public domain. Please read [LICENSE] file for more information.

[JSON Schema Specification]: https://json-schema.org/
[Justify]: https://github.com/leadpony/justify
[Java API for JSON Processing]: https://javaee.github.io/jsonp/
[Java API for JSON Binding]: http://json-b.net/
[LICENSE]: LICENSE
[Apache Maven]: https://maven.apache.org/
