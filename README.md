# Cucumber-Test für Bruchrechnen #

<br>

Das Repo enthält ein Maven-Projekt mit einer einfachen Java-Klasse `Bruch`, die verschiedene
Bruchberechnungen durchführen kann. Diese Klasse findet sich im Ordner `src/main/java/de/eldecker/dhbw/bruchrechnen/` .

Weiter enthält das Repo ein *Feature File* für [Cucumber](https://cucumber.io/), siehe Ordner
`src/test/resources/de/eldecker/dhbw/cucumber/bruchrechnen/` .
Diese *Feature File* enthält zwei Szenarien zum Test der Klasse `Bruch`.
Die zugehörigen Step-Methoden sind aber noch nicht implementiert, was als Übung nachzuholen
ist.
Die Klasse `StepDefinitions` mit den zu implementierenden Step-Methoden findet sich im Ordner
`src/test/java/de/eldecker/dhbw/cucumber/bruchrechnen/test/`.

Diese Cucumber-Tests können in Eclipse wie Unit-Tests ausgeführt werden, oder auch mit dem
Befehl `mvn test`.

<br>

Das Repo hat auche ein [Workflow-Datei](.github/workflows/maven.yml), in der das Maven-Projekt
gebaut wird; die Ausführung der Tests wird dabei mit der Option `-DskipTests` überspringen,
weil die Step-Methoden noch nicht implementiert sind und deshalb alle eine Exception werfen.

<br>

----

## License ##

<br>

See the [LICENSE file](LICENSE.md) for license rights and limitations (BSD 3-Clause License).

<br>