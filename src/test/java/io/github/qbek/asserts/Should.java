package io.github.qbek.asserts;

import io.github.qbek.questions.BrowserCookie;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.QuestionConsequence;
import org.hamcrest.Matchers;

public class Should {
    public static Consequence haveACookie () {
        return new QuestionConsequence("Cookie is there!", new BrowserCookie(), Matchers.notNullValue());
    }

    public static Consequence notHaveACookie () {
        return new QuestionConsequence("Cookie is not there!", new BrowserCookie(), Matchers.nullValue());
    }
}
