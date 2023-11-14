package runTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
    features = "src/test/resources", glue = "stepDefinition",
    plugin = { "html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class RunTest{

}
