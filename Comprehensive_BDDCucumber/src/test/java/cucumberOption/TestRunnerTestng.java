package cucumberOption;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src/test/java/Features"},
		glue={"stepDefinations"},
		dryRun =false,
		monochrome=true)
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunnerTestng extends AbstractTestNGCucumberTests {

}
