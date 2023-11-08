package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/AccountManagement.feature",
        glue = "tests.bdd"
                )
public class BddTestRunner extends AbstractTestNGCucumberTests {
}
