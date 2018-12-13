# Basic Reader

## Description

This code sample demonstrates how to validate a JSON document using the Object Model API of [JSON Processing API].

## How to Build

Follow the instructions shown in [README](../README.md) in the project root.

## How to Run

Using module path in Java 9 or higher:

```bash
$ java -p target/modules/ -m org.leadpony.justify.examples.basicreader/org.leadpony.justify.examples.basicreader.Example <path/to/instance> <path/to/schema>
```

Using classpath in Java 8:

```bash
$ java -cp "target/modules/*" org.leadpony.justify.examples.basicreader.Example <path/to/instance> <path/to/schema>
```

## License

Please see [LICENSE](../LICENSE) in the project root.

[JSON Processing API]: https://javaee.github.io/jsonp/
