package io.github.qbek.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.qbek.abilities.AuthoriseHimself;
import io.github.qbek.actions.Navigate;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class PreconditionSteps {

    @Before
    public void setup() {
        Ability[] abilities = new Ability[]
                {
                        CallAnApi.at("https://api.todoist.com/rest/v1")
                };

        OnStage.setTheStage(new OnlineCast(abilities));
    }


    @Given("{actor} has a(n) {userAccount}")
    public void userHasAnAccount(Actor user, AuthoriseHimself authorise) {
        user.can(authorise);
    }

    @And("{actor} is on Login page")
    public void heIsOnLoginPage(Actor user) {
        user.wasAbleTo(Navigate.toLoginPage());
    }

    @Given("{actor} is on Main page")
    public void userIsOnMainPage(Actor user) {
        user.wasAbleTo( Navigate.toMainPage() );
    }
}
