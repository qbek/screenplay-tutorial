package io.github.qbek.tasks;

import io.github.qbek.data.Notes;
import io.github.qbek.pageobjects.ProjectsListObject;
import io.github.qbek.restapi.ProjectResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class SelectProject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        ProjectResponse project = actor.recall(Notes.PROJECT);
        actor.attemptsTo(ProjectsListObject.selectProjectById(project.getId()));
    }
}
