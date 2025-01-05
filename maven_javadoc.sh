#!/bin/bash

# JavaDoc erzeugen für produktiven Code

clear

./mvnw clean javadoc:javadoc -Dshow=private -DadditionalJOption=-Xdoclint:none

echo

