package io.github.qbek.steps;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static io.github.qbek.actions.Navigate.performUserLogin;
import static io.github.qbek.data.Notes.PROJECT_NAME;

public class ActionSteps {

    @When("{actor} enters correct mail and password")
    public void heEntersCorrectMailAndPassword(Actor user) {
        user.attemptsTo(performUserLogin());
    }


    @When("{actor} creates a new project")
    public void heCreatesANewProject(Actor user) {
        Target NEW_PROJECT = Target.the("'Add Project' button").located(By.cssSelector("[aria-label=\"Add Project\"]"));
        Target PROJECT_NAME_INPUT = Target.the("Project name input field").locatedBy("#edit_project_modal_field_name");
        Target ADD_BUTTON = Target.the("Project name input field").locatedBy("[type=\"submit\"]");
        user.remember(PROJECT_NAME, "My first project");

        user.attemptsTo(
                MoveMouse.to(NEW_PROJECT),
                Click.on(NEW_PROJECT),
                Enter.theValue((String) user.recall(PROJECT_NAME)).into(PROJECT_NAME_INPUT),
                Click.on(ADD_BUTTON)
        );

    }
}
