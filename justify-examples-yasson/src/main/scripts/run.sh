#!/bin/bash
JAVA=$JAVA_HOME/bin/java
"$JAVA" -p libs/ \
-m org.leadpony.justify.examples.yasson/org.leadpony.justify.examples.yasson.Example $*
