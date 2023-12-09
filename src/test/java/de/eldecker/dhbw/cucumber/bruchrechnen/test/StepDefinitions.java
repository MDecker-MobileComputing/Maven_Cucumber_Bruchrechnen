package de.eldecker.dhbw.cucumber.bruchrechnen.test;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.eldecker.dhbw.bruchrechnen.Bruch;


public class StepDefinitions {

    private Bruch _bruch = null;
    
    
    @Given("ich habe einen Bruch mit Zähler <{int}> und Nenner <{int}>")
    public void givenIchHabeEinenBruch(Integer zaehler, Integer nenner) {

        throw new PendingException();
    }
    
    @When("ich addiere einen anderen Bruch mit Zähler <{int}> und Nenner <{int}>")
    public void whenIchAddiereEinenBruch(Integer zaehler, Integer nenner) {

        throw new PendingException();
    }
    
    @When("ich einen anderen Bruch mit Zähler <{int}> und Nenner <{int}> multipliziere")
    public void whenIchMultipliziereEinenBruch(Integer zaehler, Integer nenner) {
        
        throw new PendingException();
    }
    
    
    @Then("dann hat der Bruch den Zähler <{int}> und den Nenner <{int}>")
    public void thenHatDerBruchZaehlerUndNenner(Integer zaehler, Integer nenner) {

        throw new PendingException();
    }

}
