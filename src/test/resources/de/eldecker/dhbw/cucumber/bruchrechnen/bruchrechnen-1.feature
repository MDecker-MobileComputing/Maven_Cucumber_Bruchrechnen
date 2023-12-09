Feature: Bruchrechnen

  Scenario: Addition 
    Given ich habe einen Bruch mit Zähler <1> und Nenner <2>
     When ich addiere einen anderen Bruch mit Zähler <1> und Nenner <3>
     Then dann hat der Bruch den Zähler <5> und den Nenner <6>
     
  Scenario: Multiplikation 
    Given ich habe einen Bruch mit Zähler <2> und Nenner <3>
     When ich einen anderen Bruch mit Zähler <3> und Nenner <4> multipliziere
     Then dann hat der Bruch den Zähler <1> und den Nenner <2>
