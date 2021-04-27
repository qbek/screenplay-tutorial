package io.github.qbek.steps;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import static io.github.qbek.asserts.Should.haveACookie;
import static io.github.qbek.data.Notes.PROJECT_NAME;

public class VerificationSteps {

    @Then("{actor} is logged in")
    public void heIsLoggedIn(Actor user) {
        user.should(haveACookie());
    }

    @Then("the project is created")
    public void theProjectIsCreated() {
            Target projectHeader = Target.the("project view header").located(By.cssSelector(".project_view h1"));
        Actor user = OnStage.theActorInTheSpotlight();
        user.should(
                new QuestionConsequence<>("project name",
                        Text.of(projectHeader).asAString(),
                        Matchers.equalTo(user.recall(PROJECT_NAME)))
        );
    }
}
