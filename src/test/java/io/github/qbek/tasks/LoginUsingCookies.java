package io.github.qbek.tasks;

import io.github.qbek.data.Session;
import io.github.qbek.pageobjects.LoaderObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LoginUsingCookies implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Open.url("https://todoist.com/404"));
        WebDriver browser = actor.usingAbilityTo(BrowseTheWeb.class).getDriver();
        for (Cookie c : Session.COOKIES) {
            browser.manage().addCookie(c);
        }
        browser.navigate().to("https://todoist.com/app");
        actor.wasAbleTo(LoaderObject.waitForLoaderToClose());
    }
}
