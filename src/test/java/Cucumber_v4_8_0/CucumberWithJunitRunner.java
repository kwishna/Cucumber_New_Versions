package Cucumber_v4_8_0; /**
 * Runner Class For Running With JUnit.
 */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//	import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(Cucumber.class)
@CucumberOptions(
				monochrome = true,
				features = "src/test/java/Cucumber_v4_8_0/Features",
				glue = {"Cucumber_v4_8_0/Implementation"},
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
