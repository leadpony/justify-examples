@echo off
"%JAVA_HOME%\bin\java" -p target/modules/ ^
-m org.leadpony.justify.examples.basicparser/org.leadpony.justify.examples.basicparser.Example ^
person-bad.json person.schema.json
