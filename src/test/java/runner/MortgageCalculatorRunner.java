package runner;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
		//tags="@SmokeTest" 
		)


public class MortgageCalculatorRunner {
	public static final Logger log=LogManager.getLogger(MortgageCalculatorRunner.class);

	@AfterClass
	public static void generateExtentReport() {
		log.info("running...........");
	}
}