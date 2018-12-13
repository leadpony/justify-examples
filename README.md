# Justify Examples
[![Build Status](https://travis-ci.org/leadpony/justify-examples.svg?branch=master)](https://travis-ci.org/leadpony/justify-examples)

This project provides various kinds of code samples demonstrating how to validate JSON documents using [Justify].

## How to Build Examples

The commands below build all examples in this project.

```bash
$ git clone https://github.com/leadpony/justify-examples.git
$ cd justify-examples
$ mvn clean package
```

## Examples

### 1. [Basic Parser](justify-examples-basicparser/)

This code sample demonstrates how to validate a JSON document using the Streaming API of [JSON Processing API].

### 2. [Basic Reader](justify-examples-basicreader/)

This code sample demonstrates how to validate a JSON document using the Object Model API of [JSON Processing API].

### 3. [Binding](justify-examples-binding/)

This code sample demonstrates how to validate a JSON document while unmarshalling the JSON document into a Plain Old Java Object, using [JSON Binding API].

## License

All examples in this directory are free and unencumbered software released into the public domain. Please read [LICENSE] file for more information.

[Justify]: https://github.com/leadpony/justify
[JSON Processing API]: https://javaee.github.io/jsonp/
[JSON Binding API]: http://json-b.net/
[LICENSE]: LICENSE
