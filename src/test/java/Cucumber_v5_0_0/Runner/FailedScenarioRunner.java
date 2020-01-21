package Cucumber_v5_0_0.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"@target/cucumber-report/failed_scenarios.txt"}, // Error If @ Is Not Mentioned!
		// Complete Path Of failed_scenario.txt File
		monochrome = true,
		plugin = {
				"pretty", "html:target/cucumber-report/single",
				"json:target/cucumber-report/single/rerun_cucumber.json"
		},
		glue = {"Cucumber_v5_0_0/Implementation", "Cucumber_v5_0_0/Hooks"}
)
public class FailedScenarioRunner {
}
