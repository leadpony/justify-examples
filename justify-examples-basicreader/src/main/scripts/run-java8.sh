#!/bin/bash
JAVA=$JAVA_HOME/bin/java
"$JAVA" -cp "libs/*" org.leadpony.justify.examples.basicreader.Example $*
