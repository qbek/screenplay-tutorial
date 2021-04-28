package io.github.qbek.tasks;

import io.github.qbek.pageobjects.CreateProjectFormObject;
import io.github.qbek.pageobjects.ProjectsListObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static io.github.qbek.data.Notes.PROJECT_NAME;

public class CreateNewProject implements Task {

    private String projectName;

    public CreateNewProject(String name) {
        projectName = name;
    }

    @Override
    @Step("dowolna nazwa kroku, wykonany przez: {0}, tworzy projekt: #projectName")
    public <T extends Actor> void performAs(T actor) {
        actor.remember(PROJECT_NAME, projectName);
        actor.attemptsTo(
                ProjectsListObject.startCreatingNewProject(),
                CreateProjectFormObject.fillWith(projectName),
                CreateProjectFormObject.submit()
        );
    }
}
