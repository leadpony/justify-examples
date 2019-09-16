@echo off
SET JAVA=%JAVA_HOME%\bin\java
"%JAVA%" -p libs/ ^
-m org.leadpony.justify.examples.schemaresolver/org.leadpony.justify.examples.schemaresolver.Example %*
