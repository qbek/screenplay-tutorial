package io.github.qbek.pageobjects;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginFormObject {
    private static Target emailInput = Target.the("email inupt").located(By.cssSelector("#email"));
    private static Target passwordInput = Target.the("password inupt").located(By.cssSelector("#password"));
    private static Target loginButton = Target.the("login button").located(By.cssSelector(".sel_login"));

    public static Task fillWith(String email, String password) {
        return Task.where("{0} fills login form",
                Enter.theValue(email).into(emailInput),
                Enter.theValue(password).into(passwordInput)
        );
    }

    public static Task submit() {
        return Task.where("{0} submits the form", Click.on(loginButton));
    }

}
