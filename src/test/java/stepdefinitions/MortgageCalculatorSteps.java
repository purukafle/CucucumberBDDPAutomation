package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MortgageCalculatorSteps {
	public static final Logger log=LogManager.getLogger(MortgageCalculatorSteps.class);
	private WebDriver driver;
	
	@Given("I go to mortgag calculator website")
	public void i_go_to_mortgag_calculator_website() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.mortgagecalculator.net/");    
	}

	@When("I enter mortgage amount {string}")
	public void i_enter_mortgage_amount(String amountstring) {
	  WebElement amount= driver.findElement(By.cssSelector("#amount"));
	  amount.clear();
	  amount.sendKeys(amountstring);
	   
	}

	@When("I enter interest rate {string}")
	public void i_enter_interest_rate(String intrestrate) {
		WebElement intRate= driver.findElement(By.xpath("//input[@id='rate']"));
		intRate.clear();
		intRate.sendKeys(intrestrate);
	    
	}

	@When("I enter amortization year {string} and month {string}")
	public void i_enter_amortization_year_and_month(String year, String month) {
		WebElement yearelem= driver.findElement(By.xpath("//input[@id='amortizationYears']"));
		WebElement monthelem= driver.findElement(By.xpath("//input[@id='amortizationMonths']"));
		yearelem.clear();
		yearelem.sendKeys(year);
		monthelem.clear();
		monthelem.sendKeys(month);	    
	}

	@When("I select start year {string} and month {string}")
	public void i_select_start_year_and_month(String year, String month) {
		WebElement Styearelem= driver.findElement(By.cssSelector("#startYear"));
		Select yearSelect=new Select(Styearelem);
		yearSelect.selectByVisibleText(year);
		
		WebElement Stmonthelem= driver.findElement(By.cssSelector("#startMonth"));
		Select monthSelect=new Select(Stmonthelem);
		monthSelect.selectByVisibleText(month);
		
	    
	}

	@When("I enter interest term year {string} and month {string}")
	public void i_enter_interest_term_year_and_month(String year, String month) {
		WebElement IntTermYear= driver.findElement(By.cssSelector("#interestTermYears"));
		IntTermYear.clear();
		IntTermYear.sendKeys(year);
		WebElement IntTermMonth= driver.findElement(By.xpath("#interestTermMonth"));
		IntTermMonth.clear();
		IntTermMonth.sendKeys(month);	    
	}
	@When("I select payment period {string}")
	public void i_select_payment_period(String paymentModeValue) {
		WebElement paymentMode=driver.findElement(By.name("paymentMode"));
		Select paymentModeSelect=new Select(paymentMode);
		paymentModeSelect.selectByVisibleText(paymentModeValue);
	    
	}

	@When("I select interest type {string}")
	public void i_select_interest_type(String intType) {
		WebElement interestType=driver.findElement(By.name("paymentMode"));
		Select intTypeSelect=new Select(interestType);
		intTypeSelect.selectByVisibleText(intType);
	}

	@When("I click clculate button")
	public void i_click_clculate_button() {
		WebElement calculateButton=driver.findElement(By.cssSelector("#button"));
		calculateButton.click();
		
	}


	@Then("I verify monthly payment results {string}")
	public void i_verify_results(String expectedAmount) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement resultBoxArea=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("resultBox")));
	
		List<WebElement>list=resultBoxArea.findElements(By.tagName("li"));
		WebElement firstline=list.get(0);
		WebElement inputElem=firstline.findElement(By.tagName("input"));
		
		String monthlyPaymentText=inputElem.getAttribute("value");
		log.info("monthly payment is: "+ monthlyPaymentText);
		assertEquals(monthlyPaymentText, expectedAmount);
	    
	}
	@Then("I closed the chrome browser")
	public void i_closed_the_chrome_browser() {
	   driver.quit();
	}

}
















