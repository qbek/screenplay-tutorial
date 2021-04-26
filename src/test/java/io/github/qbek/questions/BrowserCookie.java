package io.github.qbek.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Cookie;

public class BrowserCookie implements Question<Cookie> {

    @Override
    public Cookie answeredBy(Actor actor) {
        BrowseTheWeb browser = actor.usingAbilityTo(BrowseTheWeb.class);
        return browser.getDriver().manage().getCookieNamed("todoistd");
    }
}
