package Cucumber_v6_4_0;
/*
  Runner Class For Running With JUnit.
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
				features = {"src/test/java/Cucumber_v6_4_0/Features"},
				glue = {"Cucumber_v6_4_0/Implementation", "Cucumber_v6_4_0/Hooks"}, // Steps, Hooks, Plugins
				tags = "@Baba3",
//				name = {".*"}, // Matching Name Scenario Will Run
				plugin = {
					"progress",
//					"summary",
//		        	"pretty",
					"usage:target/cucumber-reports/cucumber-usage.json",
					"html:target/cucumber-reports/cucumber-pretty",
					"json:target/cucumber-reports/cucumber.json",
					"pretty:target/cucumber-reports/cucumber-pretty.txt",
					"timeline:/cucumber-reports/",
					"usage:target/cucumber-reports/cucumber-usage.json",
					"rerun:target/cucumber-reports/failures/failed_scenarios.txt"
				}
		)

// java -cp <classpath> io.cucumber.core.cli.Main -p timeline:<report folder> --threads <thread count> -g <steps package> <path to feature files>
// mvn clean install -Dcucumber.glue="package_name_of_step_definitions" -Dcucumber.plugin="pretty path\to\featurefiles"
/*
Alternatively if you are using a Maven project, you can run the CLI using the Exec Maven plugin:
mvn exec:java                                  \
    -Dexec.classpathScope=test                 \
    -Dexec.mainClass=io.cucumber.core.cli.Main \
    -Dexec.args="/path/to/your/feature/files --glue hellocucumber"
 */
public class CucumberWithJunitRunner
{

}
