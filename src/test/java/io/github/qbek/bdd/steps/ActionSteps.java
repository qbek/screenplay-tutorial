package io.github.qbek.bdd.steps;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static io.github.qbek.actions.Navigate.performUserLogin;

public class ActionSteps {

    @When("{actor} enters correct mail and password")
    public void heEntersCorrectMailAndPassword(Actor user) {
        user.attemptsTo(performUserLogin());
    }


}
