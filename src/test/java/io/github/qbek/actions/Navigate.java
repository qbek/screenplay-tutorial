package io.github.qbek.actions;

import io.github.qbek.data.Session;
import io.github.qbek.tasks.LoginUsingCookies;
import io.github.qbek.tasks.LoginUsingCredentials;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.Wait;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import static java.util.Objects.nonNull;

public class Navigate {
    public static Task performUserLogin() {
        return new LoginUsingCredentials();
    }

    public static Task toLoginPage() {
        return Task.where("{0} navigates to login page",
                Open.url("https://todoist.com"),
                Click.on(By.cssSelector("[href=\"/users/showlogin\"]"))
        );
    }

    public static Performable waitForLoaderToClose() {
        return Wait.until(
                Visibility.of(By.cssSelector("#loading")).asABoolean(),
                Matchers.equalTo(false)
        ).forNoLongerThan(5).seconds();
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
