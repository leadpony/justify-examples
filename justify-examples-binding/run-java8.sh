#!/bin/bash

"${JAVA_HOME}/bin/java" -cp "target/modules/*" org.leadpony.justify.examples.binding.Example \
person-bad.json person.schema.json
