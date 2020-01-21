package Cucumber_v4_8_0.experiment;
/**
 * Runner Class For Running With JUnit.
 *
 * More Reportings : https://cucumber.io/docs/cucumber/reporting/
 * Cucumber Reporting : https://github.com/damianszczepanik/cucumber-reporting
 * Cucumber Plugin Read : https://gitlab.com/monochromata-de/cucumber-reporting-plugin
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
// REPORTING :-
/*
File reportOutputDirectory = new File("target");
List<String> jsonFiles = new ArrayList<>();
jsonFiles.add("cucumber-report-1.json");
jsonFiles.add("cucumber-report-2.json");

String buildNumber = "1";
String projectName = "cucumberProject";

Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration - check javadoc for details
configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
// do not make scenario failed when step has status SKIPPED
configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
configuration.addClassifications("Platform", "Windows");
configuration.addClassifications("Browser", "Firefox");
configuration.addClassifications("Branch", "release/1.0");

// optionally add metadata presented on main page via properties file
List<String> classificationFiles = new ArrayList<>();
classificationFiles.add("properties-1.properties");
classificationFiles.add("properties-2.properties");
configuration.addClassificationFiles(classificationFiles);

ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
Reportable result = reportBuilder.generateReports();
// and here validate 'result' to decide what to do if report has failed
 */
