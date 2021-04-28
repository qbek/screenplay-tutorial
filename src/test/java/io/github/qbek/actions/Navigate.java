package io.github.qbek.actions;

import io.github.qbek.data.Session;
import io.github.qbek.pageobjects.WelcomePageObject;
import io.github.qbek.tasks.LoginUsingCookies;
import io.github.qbek.tasks.LoginUsingCredentials;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static java.util.Objects.nonNull;

public class Navigate {
    public static Task performUserLogin() {
        return new LoginUsingCredentials();
    }

    public static Task toLoginPage() {
        return Task.where("{0} navigates to **login page**",
                Open.url("https://todoist.com"),
                WelcomePageObject.gotoLoginPage()
        );
    }

    public static Task toMainPage() {

        if(nonNull(Session.COOKIES)) {
            return SilentTask.where(new LoginUsingCookies());
        }
        return SilentTask.where(
                Navigate.toLoginPage(),
                Navigate.performUserLogin()
        );
    }
}
