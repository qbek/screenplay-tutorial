package io.github.qbek.steps;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

import static io.github.qbek.asserts.Should.haveACookie;

public class VerificationSteps {

    @Then("{actor} is logged in")
    public void heIsLoggedIn(Actor user) {
        user.should(haveACookie());
    }
}
