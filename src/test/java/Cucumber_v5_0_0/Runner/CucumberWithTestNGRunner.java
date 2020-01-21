package Cucumber_v5_0_0.Runner;
/**
 * Runner Class For Running With TestNG.
 *
 * Parallel Through Command Line :-
 * java -cp .;<path to cucumber jar folder>/* io.cucumber.core.cli.Main --threads 4 -g parallel parallel
 */

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
				strict = true,
				monochrome = true,
				features = "src/test/java/Cucumber_v5_0_0/Features",
				glue = {"Cucumber_v5_0_0/Implementation", "Cucumber_v5_0_0/Hooks"},
				tags = {"@Baba3"},
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

public class CucumberWithTestNGRunner extends AbstractTestNGCucumberTests
{
	@DataProvider(parallel = false) // true Or false
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
}
