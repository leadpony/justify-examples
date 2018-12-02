@echo off
"%JAVA_HOME%\bin\java" -cp "target/modules/*" org.leadpony.justify.examples.basicreader.Example ^
person-bad.json person.schema.json
