package io.github.qbek.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static io.github.qbek.data.Notes.PROJECT_NAME;

public class CreateNewProject implements Task {

    private String projectName;

    public CreateNewProject(String name) {
        projectName = name;
    }

    @Override
    @Step("dowolna nazwa kroku, wykonany przez: {0}, tworzy projekt: #projectName")
    public <T extends Actor> void performAs(T actor) {
        Target NEW_PROJECT = Target.the("'Add Project' button").located(By.cssSelector("[aria-label=\"Add Project\"]"));
        Target PROJECT_NAME_INPUT = Target.the("Project name input field").locatedBy("#edit_project_modal_field_name");
        Target ADD_BUTTON = Target.the("Project name input field").locatedBy("[type=\"submit\"]");
        actor.remember(PROJECT_NAME, projectName);

        actor.attemptsTo(
                MoveMouse.to(NEW_PROJECT),
                Click.on(NEW_PROJECT),
                Enter.theValue(projectName).into(PROJECT_NAME_INPUT),
                Click.on(ADD_BUTTON)
        );
    }
}
