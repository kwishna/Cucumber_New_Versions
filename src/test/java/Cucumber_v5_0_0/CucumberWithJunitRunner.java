package Cucumber_v5_0_0; /**
 * Runner Class For Running With JUnit.
 */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//	import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 *
 * To Run The Cucumber Parallel
 * https://cucumber.io/docs/guides/parallel-execution/
 * <plugin>
 *     <groupId>org.apache.maven.plugins</groupId>
 *     <artifactId>maven-surefire-plugin</artifactId>
 *     <version>2.22.0</version>
 *     <configuration>
 *         <parallel>methods</parallel>
 *         <useUnlimitedThreads>true</useUnlimitedThreads>
 *     </configuration>
 * </plugin>
 */
@RunWith(Cucumber.class)
@CucumberOptions(
				monochrome = true,
				features = "src/test/java/Cucumber_v5_0_0/Features",
				glue = {"Cucumber_v5_0_0/Implementation", "Cucumber_v5_0_0/Hooks"},
				tags = {"@Baba3"},
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
