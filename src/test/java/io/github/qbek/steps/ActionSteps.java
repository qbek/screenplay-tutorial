package io.github.qbek.steps;

import io.cucumber.java.en.When;
import io.github.qbek.abilities.AuthoriseHimself;
import io.github.qbek.data.Notes;
import io.github.qbek.restapi.ProjectRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static io.github.qbek.actions.Navigate.performUserLogin;
import static io.github.qbek.actions.Project.createNewProject;

public class ActionSteps {

    @When("{actor} enters correct mail and password")
    public void heEntersCorrectMailAndPassword(Actor user) {
        user.attemptsTo(performUserLogin());
    }


    @When("{actor} creates a new {projectName}")
    public void heCreatesANewProject(Actor user, String projectName) {
        user.attemptsTo(createNewProject(projectName));
    }

    @When("{actor} creates new {projectName} using rest")
    public void userCreatesNewProjectUsingRest(Actor user, String projectName) {
        ProjectRequest payload = new ProjectRequest();
        payload.setName(projectName);
        user.remember(Notes.PROJECT_NAME, projectName);
        user.attemptsTo(
                Post.to("/projects").with(req -> {
                    req.headers("Authorization", user.usingAbilityTo(AuthoriseHimself.class).getToken());
                    req.contentType(ContentType.JSON);
                    req.body(payload);
                    return req;
                })
        );
    }
}
