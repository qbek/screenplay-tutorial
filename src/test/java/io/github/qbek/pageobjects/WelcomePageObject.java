package io.github.qbek.pageobjects;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WelcomePageObject {

    private static final Target LOGIN_LINK = Target.the("link to login page").located(By.cssSelector("[href=\"/users/showlogin\"]"));

    public static Performable gotoLoginPage() {
        return Click.on(LOGIN_LINK);
    }
}
