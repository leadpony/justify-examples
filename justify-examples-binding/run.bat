@echo off
"%JAVA_HOME%\bin\java" -p target/modules/ ^
-m org.leadpony.justify.examples.binding/org.leadpony.justify.examples.binding.Example ^
person-bad.json person.schema.json
