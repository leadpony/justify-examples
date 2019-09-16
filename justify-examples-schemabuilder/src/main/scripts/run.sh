#!/bin/bash
JAVA=$JAVA_HOME/bin/java
"$JAVA" -p libs/ \
-m org.leadpony.justify.examples.schemabuilder/org.leadpony.justify.examples.schemabuilder.Example $*
