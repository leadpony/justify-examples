@echo off
SET JAVA=%JAVA_HOME%\bin\java
"%JAVA%" -p libs/ ^
-m org.leadpony.justify.examples.basicparser/org.leadpony.justify.examples.basicparser.Example %*
