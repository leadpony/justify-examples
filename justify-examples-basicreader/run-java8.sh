#!/bin/bash
JAVA=$JAVA_HOME/bin/java
"$JAVA" -cp "target/modules/*" org.leadpony.justify.examples.basicreader.Example \
person.schema.json person-bad.json
