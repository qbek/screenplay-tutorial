package io.github.qbek.steps;

import io.cucumber.java.en.Then;
import io.github.qbek.asserts.Should;
import io.github.qbek.data.Session;
import io.github.qbek.pageobjects.ProjectViewObject;
import io.github.qbek.restapi.ProjectResponse;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.rest.questions.TheResponse;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.github.qbek.data.Notes.PROJECT_NAME;
import static io.github.qbek.data.Notes.TASK_NAME;

public class VerificationSteps {

    @Then("{actor} is logged in")
    public void heIsLoggedIn(Actor user) {
        user.should(Should.haveACookie());
        WebDriver browser = user.usingAbilityTo(BrowseTheWeb.class).getDriver();
        Session.COOKIES = browser.manage().getCookies();
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


    @Then("project is created by rest")
    public void projectIsCreatedByRest() {
        Actor user = OnStage.theActorInTheSpotlight();
        Response resp = user.asksFor(LastResponse.received()) ;
        ProjectResponse project = resp.then().extract().body().as(ProjectResponse.class);
        user.should(
            new QuestionConsequence<>("status code", TheResponse.statusCode(), Matchers.equalTo(201)),
            new QuestionConsequence<>("project name is correct", a -> project.getName(), Matchers.equalTo(user.recall(PROJECT_NAME)))
        );

    }

    @Then("the task is correctly created")
    public void theTaskIsCorrectlyCreated() {
        Actor user = OnStage.theActorInTheSpotlight();
        user.should(
                new QuestionConsequence("task is on the list",
                        ProjectViewObject.isTaskOnList(user.recall(TASK_NAME)),
                        Matchers.equalTo(true)));

    }
}
