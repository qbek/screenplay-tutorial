package io.github.qbek.actions;

import io.github.qbek.tasks.LoginUsingCredentials;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;

public class Navigate {
    public static Task performUserLogin() {
        return new LoginUsingCredentials();
    }

    public static Task toLoginPage() {
        return Task.where("navigates to login page",
                Open.url("https://todoist.com"),
                Click.on(By.cssSelector("[href=\"/users/showlogin\"]"))
        );
    }
}
