@echo off
SET JAVA=%JAVA_HOME%\bin\java
"%JAVA%" -cp "libs/*" org.leadpony.justify.examples.defaultvalue.Example %*
