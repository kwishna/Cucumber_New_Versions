package Cucumber_v4_5_2.Runner;
/**
 * Runner Class For Running With TestNG.
 */
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				monochrome = true,
				features = "src/test/java/Cucumber_v4_5_2/Features",
				glue = {"Cucumber_v4_5_2/Implementation"},
				tags = {"@Baba"},
				plugin = {
				"progress",
				"summary",
//		        "pretty",
		        "usage:target/cucumber-reports/cucumber-usage.json",
		        "html:target/cucumber-reports/cucumber-pretty",
		        "json:target/cucumber-reports/cucumber.json",
		        "pretty:target/cucumber-reports/cucumber-pretty.txt",
		        "usage:target/cucumber-reports/cucumber-usage.json",
						"rerun:target/cucumber-report/failed_scenarios.txt"
				}
		)

public class CucumberWithTestNGRunner extends AbstractTestNGCucumberTests
{
	@DataProvider(parallel = false) // true Or false
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
}
