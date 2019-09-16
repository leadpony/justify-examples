@echo off
SET JAVA=%JAVA_HOME%\bin\java
"%JAVA%" -p libs/ ^
-m org.leadpony.justify.examples.defaultvalue/org.leadpony.justify.examples.defaultvalue.Example %*
