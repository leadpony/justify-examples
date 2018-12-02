#!/bin/bash

"${JAVA_HOME}/bin/java" -p target/modules/ \
-m org.leadpony.justify.examples.basicreader/org.leadpony.justify.examples.basicreader.Example \
person-bad.json person.schema.json
