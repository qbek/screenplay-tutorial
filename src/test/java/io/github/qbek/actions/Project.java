package io.github.qbek.actions;

import io.github.qbek.tasks.CreateNewProject;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;

public class Project {

    public static Task createNewProject(String name) {
        return Instrumented.instanceOf(CreateNewProject.class).withProperties(name);
    }
}
