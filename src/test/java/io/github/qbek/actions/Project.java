package io.github.qbek.actions;

import io.github.qbek.tasks.AddNewTask;
import io.github.qbek.tasks.CreateNewProject;
import io.github.qbek.tasks.SelectProject;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;

public class Project {

    public static Task createNewProject(String name) {
        return Instrumented.instanceOf(CreateNewProject.class).withProperties(name);
    }

    public static Task selectProject() {
        return Instrumented.instanceOf(SelectProject.class).newInstance();
    }

    public static Task addTaskToProject(String taskName) {
        return Instrumented.instanceOf(AddNewTask.class).withProperties(taskName);
    }
}
