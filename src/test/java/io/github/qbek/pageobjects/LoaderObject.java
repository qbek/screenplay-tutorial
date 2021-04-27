package io.github.qbek.pageobjects;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.Wait;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

public class LoaderObject {

    public static Performable waitForLoaderToClose() {
        return Wait.until(
                Visibility.of(By.cssSelector("#loading")).asABoolean(),
                Matchers.equalTo(false)
        ).forNoLongerThan(5).seconds();
    }
}
