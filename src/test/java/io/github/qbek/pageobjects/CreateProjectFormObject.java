package io.github.qbek.pageobjects;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class CreateProjectFormObject {

    private static final Target PROJECT_NAME_INPUT = Target.the("Project name input field").locatedBy("#edit_project_modal_field_name");
    private static final Target ADD_BUTTON = Target.the("Project name input field").locatedBy("[type=\"submit\"]");

    public static Task fillWith(String projectName) {
        return Task.where("{0} fill project creation form",
                Enter.theValue(projectName).into(PROJECT_NAME_INPUT)
        );
    }

    public static Task submit() {
        return Task.where("{0} submits form",
                Click.on(ADD_BUTTON)
        );
    }
}
