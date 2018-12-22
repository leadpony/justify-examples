#!/bin/bash
JAVA=$JAVA_HOME/bin/java
"$JAVA" -p target/modules/ \
-m org.leadpony.justify.examples.binding/org.leadpony.justify.examples.binding.Example \
person.schema.json person-bad.json 
