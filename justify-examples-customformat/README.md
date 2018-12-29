# Custom Format

## Description

This code sample shows how to implement your own format attribute,
which can be used as the value of "format" keyword in the schema definition.

The library core will load custom format attributes through  [Service Provider Interface] in the run time.

For Java 9 and higher, `module-info.java` is the place where the implemented format attribute should be specified as a service provider.

```java
provides org.leadpony.justify.spi.FormatAttribute
    with your.own.CustomFormatAttribute;
```  

For Java 8, `META-INF/services` directory must hava a file named as `org.leadpony.justify.spi.FormatAttribute`, which contains a following line:

```java
your.own.CustomFormatAttribute
```

## How to Build

Follow the instructions shown in [README](../README.md) in the repository root.

## How to Run

Using module path in Java 9 or higher:

```bash
$ ./run.sh <path/to/JSON schema> <path/to/JSON instance>
```

Using classpath in Java 8:

```bash
$ ./run-java8.sh <path/to/JSON schema> <path/to/JSON instance>
```

## License

Please see [LICENSE](../LICENSE) in the repository root.

[Java API for JSON Processing]: https://javaee.github.io/jsonp/
[Service Provider Interface]: https://docs.oracle.com/javase/9/docs/api/java/util/ServiceLoader.html
