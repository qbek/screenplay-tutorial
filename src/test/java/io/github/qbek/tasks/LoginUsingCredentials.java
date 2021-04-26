package io.github.qbek.tasks;

import io.github.qbek.abilities.AuthoriseHimself;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

public class LoginUsingCredentials implements Task {

    private static Target emailInput = Target.the("email inupt").located(By.cssSelector("#email"));
    private static Target passwordInput = Target.the("password inupt").located(By.cssSelector("#password"));
    private static Target loginButton = Target.the("login button").located(By.cssSelector(".sel_login"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        String email = actor.usingAbilityTo(AuthoriseHimself.class).getEmail();
        String pass = actor.usingAbilityTo(AuthoriseHimself.class).getPassword();
        actor.attemptsTo(
                Task.where("fills login form",
                    Enter.theValue(email).into(emailInput),
                    Enter.theValue(pass).into(passwordInput)
                ),
                Click.on(loginButton)
        );
        actor.wasAbleTo(
                Wait.until(
                        Visibility.of(By.cssSelector("#loading")).asABoolean(),
                        Matchers.equalTo(false)
                ).forNoLongerThan(5).seconds()
        );
    }
}
