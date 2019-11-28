package Cucumber_v4_7_2; /**
 * Runner Class For Running With JUnit.
 */
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//	import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
				monochrome = true,
				features = "src/test/java/Cucumber_v4_7_2/Features",
				glue = {"Cucumber_v4_7_2/Implementation"},
				extraGlue = "Cucumber_v4_8_0\\Hooks",
				tags = {"@Baba1 or Baba2"},
				plugin = {
				"progress",
//				"summary",
//		        "pretty",
		        "usage:target/cucumber-reports/cucumber-usage.json",
		        "html:target/cucumber-reports/cucumber-pretty",
		        "json:target/cucumber-reports/cucumber.json",
		        "pretty:target/cucumber-reports/cucumber-pretty.txt",
		        "usage:target/cucumber-reports/cucumber-usage.json",
				"rerun:target/cucumber-report/failed_scenarios.txt"
				}
		)
public class CucumberWithJunitRunner
{

}
