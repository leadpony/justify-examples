#!/bin/bash
JAVA=$JAVA_HOME/bin/java
"$JAVA" -p libs/ \
-m org.leadpony.justify.examples.binding/org.leadpony.justify.examples.binding.Example $*
