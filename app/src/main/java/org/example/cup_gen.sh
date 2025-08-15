#! /bin/bash

JCUP_HOME="/home/aaras/libs/java_cup/"

java -classpath $JCUP_HOME java_cup.Main -parser MyParser /home/aaras/fax/pascal/app/src/main/java/org/example/spec.cup

