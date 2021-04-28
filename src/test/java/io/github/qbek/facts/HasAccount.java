package io.github.qbek.facts;

import io.github.qbek.data.CredentialsGenerator;
import io.github.qbek.data.StaticCredentialsGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

public class HasAccount implements Fact {
    @Override
    public void setup(Actor actor) {
        CredentialsGenerator account = new StaticCredentialsGenerator();
        actor.can(account.getAccount());
    }
}
