package io.github.qbek.bdd;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "classpath:features", glue = "io.github.qbek.bdd.steps")
public class CucumberTest {
}
