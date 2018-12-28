#!/bin/bash
JAVA=$JAVA_HOME/bin/java
"$JAVA" -p target/modules/ \
-m org.leadpony.justify.examples.schemabuilder/org.leadpony.justify.examples.schemabuilder.Example $*
