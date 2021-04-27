package io.github.qbek.tasks;

import io.github.qbek.abilities.AuthoriseHimself;
import io.github.qbek.pageobjects.LoaderObject;
import io.github.qbek.pageobjects.LoginFormObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class LoginUsingCredentials implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String email = actor.usingAbilityTo(AuthoriseHimself.class).getEmail();
        String pass = actor.usingAbilityTo(AuthoriseHimself.class).getPassword();
        actor.attemptsTo(
                LoginFormObject.fillWith(email, pass),
                LoginFormObject.submit()
        );
        actor.wasAbleTo(LoaderObject.waitForLoaderToClose());
    }
}
