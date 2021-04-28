package io.github.qbek.steps;

import io.cucumber.java.ParameterType;
import io.github.qbek.abilities.AuthoriseHimself;
import io.github.qbek.data.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.ArrayList;
import java.util.List;

public class ParameterDefs {
    @ParameterType(".*")
    public Actor actor(String name) {
        return OnStage.theActorCalled(name);
    }

    @ParameterType("account|token")
    public AuthoriseHimself userAccount (String a) {
        CredentialsGenerator account = new StaticCredentialsGenerator();
        return account.getAccount();
    }

    @ParameterType("project")
    public String projectName (String s) {
        TestDataGenerator generator = getGenerator();
        return generator.getProjectName();
    }

    @ParameterType("task")
    public String taskName(String s) {
        TestDataGenerator generator = getGenerator();
        return generator.getTaskName();
    }

    private TestDataGenerator getGenerator() {
        List<TestDataGenerator> generators = new ArrayList<>();
        generators.add(new RandomTestDataGenerator());
        generators.add(new StaticTestDataGenerator());
        String type = System.getProperty("testData", "random");
        for (TestDataGenerator g : generators) {
            if (g.isTypeOf(type)) {return g;}
        }
        return new StaticTestDataGenerator();
    }

}
