package io.github.qbek.bdd.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.qbek.abilities.AuthoriseHimself;
import io.github.qbek.actions.Navigate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class PreconditionSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("{actor} has an {userAccount}")
    public void userHasAnAccount(Actor user, AuthoriseHimself authorise) {
        user.can(authorise);
    }

    @And("{actor} is on Login page")
    public void heIsOnLoginPage(Actor user) {
        user.wasAbleTo(Navigate.toLoginPage());
    }

}
