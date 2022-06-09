package expleo;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(strict = true, glue = { "expleo" }, features = { "src/test/features" }, plugin = { "html:target/cucumber/",
        "json:target/cucumber.json" }, tags = { "@TechExercise" })
public class TestHarnessRunnerIT {

}