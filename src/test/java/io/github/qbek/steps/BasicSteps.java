package io.github.qbek.steps;

import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class BasicSteps {
    @Given("I'm Jakub!")
    public void i_m_jakub() {
        System.out.println("I'm Jakub");
    }

    @Given("Hello World!")
    public void hello_world() {
        System.out.println("Hello World!!!");
    }

    @Given("I can have a {string}")
    public void iCanHaveA(String value) {
        System.out.println("String: " + value);
    }

    @And("I can have and {int} number")
    public void iCanHaveAndNumber(int value) {
        System.out.println("int: " + value);
    }

    @And("I know the pi value {float}")
    public void iKnowThePiValue(float value) {
        System.out.println("Float: " + value);
    }

    @But("any word {word} be a {word}")
    public void andWordCanBeAValue(String value1, String value2) {
        System.out.println(String.format("Word: %s, %s", value1, value2));
    }

    @When("simple string list")
    public void simpleStringList(List<String> table) {
        System.out.println(table);
    }

    @When("another table")
    public void anotherTable(List<Map<String, String>> data) {
        System.out.println(data);
    }

    @And("one more table")
    public void oneMoreTable(Map<String, List<String>> data) {
        System.out.println(data);
    }

    @And("simple table")
    public void simpleTable(List<List<String>> data) {
        System.out.println(data);
    }

    @Then("magic multiline string")
    public void magicMultilineString(String multi) {
        System.out.println(multi);
    }
}
