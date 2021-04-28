package io.github.qbek.pageobjects;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProjectViewObject {

    private static final Target TASK_LIST = Target.the("task list").located(By.cssSelector(".project_view .section_list"));

    private static final Target ADD_TASK_PLUS = Target.the("add task icon").located(By.cssSelector(".task_actions .plus_add_button"));
    private static final Target CREATE_TASK_BUTTON = Target.the("project name input field").locatedBy("[type=\"submit\"]");


    public static Task addNewTask(String taskName) {
        return Task.where("{0} creates new task",
                    Click.on(ADD_TASK_PLUS),
                    SendKeys.of(taskName).into(Target.the("todo name input").located(By.cssSelector("body"))),
                    Click.on(CREATE_TASK_BUTTON)
                );
    }

    public static Question<Boolean> isTaskOnList(String taskName) {
        return new Question<Boolean>() {
            @Override
            public Boolean answeredBy(Actor actor) {
                String tasks = actor.asksFor(Text.of(TASK_LIST).asAString());
                return tasks.contains(taskName);
            }
        };
    }
}
