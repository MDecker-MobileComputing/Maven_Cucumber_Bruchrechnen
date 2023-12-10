#!/bin/bash

# JavaDoc erzeugen für produktiven Code

clear

./mvnw clean javadoc:javadoc -Dshop=private -DadditionalJOption=-Xdoclint:none

echo

