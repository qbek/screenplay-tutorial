package io.github.qbek.steps;

import io.cucumber.java.ParameterType;
import io.github.qbek.abilities.AuthoriseHimself;
import io.github.qbek.data.CredentialsGenerator;
import io.github.qbek.data.StaticCredentialsGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class ParameterDefs {
    @ParameterType(".*")
    public Actor actor(String name) {
        return OnStage.theActorCalled(name);
    }

    @ParameterType("account")
    public AuthoriseHimself userAccount (String a) {
        CredentialsGenerator account = new StaticCredentialsGenerator();
        return account.getAccount();
    }
}
