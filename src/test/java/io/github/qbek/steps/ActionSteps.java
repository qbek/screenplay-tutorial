package io.github.qbek.steps;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

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
}
