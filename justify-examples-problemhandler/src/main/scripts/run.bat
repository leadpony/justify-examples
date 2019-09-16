@echo off
SET JAVA=%JAVA_HOME%\bin\java
"%JAVA%" -p libs/ ^
-m org.leadpony.justify.examples.problemhandler/org.leadpony.justify.examples.problemhandler.Example %*
