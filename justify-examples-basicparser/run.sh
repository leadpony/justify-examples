#!/bin/bash
JAVA=$JAVA_HOME/bin/java
"$JAVA" -p target/modules/ \
-m org.leadpony.justify.examples.basicparser/org.leadpony.justify.examples.basicparser.Example \
person.schema.json person-bad.json
