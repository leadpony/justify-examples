# Binding

## Description

This code sample demonstrates how to validate a JSON document while unmarshalling the JSON document into a Plain Old Java Object, using [JSON Binding API].

## How to Build

Follow the instructions shown in [README](../README.md) in the project root.

## How to Run

Using module path in Java 9 or higher:

```bash
$ java -p target/modules/ -m org.leadpony.justify.examples.binding/org.leadpony.justify.examples.binding.Example <path/to/schema> <path/to/instance>
```

Using classpath in Java 8:

```bash
$ java -cp "target/modules/*" org.leadpony.justify.examples.binding.Example <path/to/schema> <path/to/instance>
```

## License

Please see [LICENSE](../LICENSE) in the project root.

[JSON Processing API]: https://javaee.github.io/jsonp/
[JSON Binding API]: http://json-b.net/
