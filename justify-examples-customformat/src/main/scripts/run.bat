@echo off
SET JAVA=%JAVA_HOME%\bin\java
"%JAVA%" -p libs/ ^
-m org.leadpony.justify.examples.customformat/org.leadpony.justify.examples.customformat.Example %*
