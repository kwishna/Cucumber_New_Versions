package Cucumber_v4_8_0.experiment;
/**
 * Runner Class For Running With JUnit.
 *
 * More Reportings : https://cucumber.io/docs/cucumber/reporting/
 * Cucumber Reporting : https://github.com/damianszczepanik/cucumber-reporting
 */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//	import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(Cucumber.class)
@CucumberOptions(
				monochrome = true,
				features = "src/test/java/Cucumber_v4_8_0/experiment/feature",
				glue = {"Cucumber_v4_8_0/experiment/impl"},
				tags = {"@first"},
		//		tags = {"@first", "~@second"}
		// 		tags = {"@first", "not @second"},
		// 		tags = {"@first or @second"},
				plugin = {
		// 		"summary",
		//	    "pretty",
				"progress",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Working
				"de.monochromata.cucumber.report.PrettyReports:target/cucumber-reports/cucumber", // Working
				"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
		        "usage:target/cucumber-reports/cucumber-usage.json",
		        "html:target/cucumber-reports/cucumber-pretty",
		        "json:target/cucumber-reports/cucumber.json",
		        "pretty:target/cucumber-reports/cucumber-pretty.txt",
		        "usage:target/cucumber-reports/cucumber-usage.json",
				"rerun:target/cucumber-reports/failed_scenarios.txt"
				}
		)
public class CucumberWithJunitRunnerExperiment
{

}
