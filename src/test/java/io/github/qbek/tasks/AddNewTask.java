package io.github.qbek.tasks;

import io.github.qbek.data.Notes;
import io.github.qbek.pageobjects.ProjectViewObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AddNewTask implements Task {

    private String name;

    public AddNewTask(String name) {
        this.name = name;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(Notes.TASK_NAME, name);
        actor.attemptsTo(ProjectViewObject.addNewTask(name));
    }
}
