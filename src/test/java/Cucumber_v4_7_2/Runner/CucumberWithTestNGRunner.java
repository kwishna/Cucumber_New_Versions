package Cucumber_v4_7_2.Runner;
/**
 * Runner Class For Running With TestNG.
 */

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		strict = true,
		monochrome = true,
		features = "src/test/java/Cucumber_v4_7_2/Features",
		glue = {"Cucumber_v4_8_0/Implementation", "Cucumber_v4_8_0/Hooks"},
		tags= {"@Baba"},
		plugin = {
				"progress",
				"summary",
//		        	"pretty",
				"timeline:target/cucumber-reports",
				"usage:target/cucumber-reports/cucumber-usage.json",
				"html:target/cucumber-reports/cucumber-pretty",
//						"json:target/cucumber-reports/cucumber.json",
				"pretty:target/cucumber-reports/cucumber-pretty.txt",
				"usage:target/cucumber-reports/cucumber-usage.json",
				"rerun:target/cucumber-report/failed_scenarios.txt"
		},
		snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class CucumberWithTestNGRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false) // true Or false
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
