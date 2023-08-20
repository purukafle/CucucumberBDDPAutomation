package runner;



import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/resources/features/mortgageCalculatorTest.feature",
		glue= {"stepdefinitions"},
		monochrome=true,
		plugin= {"pretty",
				"html:target/htmlReports/htmlReport.html",
				"json:target/jsonReports/jsonReport.json",
				"junit:target/junitReports/junitReport.xml"					
				
		},
		dryRun=true
		)


public class MortgageCalculatorRunner {

	@AfterClass
	public static void generateExtentReport() {
		System.out.println("running...........");
	}
}