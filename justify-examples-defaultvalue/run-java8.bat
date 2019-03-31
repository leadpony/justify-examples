@echo off
SET JAVA=%JAVA_HOME%\bin\java
"%JAVA%" -cp "target/modules/*" org.leadpony.justify.examples.defaultvalue.Example %*
