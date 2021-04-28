package io.github.qbek.pageobjects;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProjectsListObject {
    private static final Target NEW_PROJECT = Target.the("'Add Project' button").located(By.cssSelector("[aria-label=\"Add Project\"]"));
    private static final Target PROJECTS = Target.the("Pojects").located(By.cssSelector("#projects_list li"));

    public static Task startCreatingNewProject() {
        return Task.where("{0} starts project creation",
                MoveMouse.to(NEW_PROJECT),
                Click.on(NEW_PROJECT)
        );
    }

    public static Task selectProjectById(long id) {
        String selecor = String.format("[data-id=\"%d\"", id);
        Target project = Target.the("project to select").located(By.cssSelector(selecor));
        return Task.where("{0} selects a project", Click.on(project));
    }

}
