package io.github.qbek.test.authorisation;

import io.github.qbek.actions.Navigate;
import io.github.qbek.asserts.Should;
import io.github.qbek.pageobjects.LoginFormObject;
import io.github.qbek.test.RequestSample;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Feature;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@Feature
public class UserLogsIn {

    @Managed
    WebDriver driver;

    @Steps
    RequestSample sample;


    @Test
    public void user_with_invalid_credentials_cannot_log_in() {
        Actor user = new Actor("User");
        user.can(BrowseTheWeb.with(driver));
//        user.can((new StaticCredentialsGenerator()).getAccount());
        user.wasAbleTo(Navigate.toLoginPage());
//        user.usingAbilityTo(AuthoriseHimself.class).setEmail("invalid@mail.pl");
        user.attemptsTo(
                LoginFormObject.fillWith("invalid", "invalide"),
                LoginFormObject.submit()
        );
        user.should(Should.notHaveACookie());
    }


    @Test
    public void simple_junit() {
        sample.sendRequest();
    }
}
