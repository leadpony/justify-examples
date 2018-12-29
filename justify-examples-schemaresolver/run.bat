@echo off
SET JAVA=%JAVA_HOME%\bin\java
"%JAVA%" -p target/modules/ ^
-m org.leadpony.justify.examples.schemaresolver/org.leadpony.justify.examples.schemaresolver.Example %*
