package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MortgageCalculatorSteps {
	private WebDriver driver;
	
	@Given("I go to mortgag calculator website")
	public void i_go_to_mortgag_calculator_website() {
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
	    
	}

	@When("I select start year {string} and month {string}")
	public void i_select_start_year_and_month(String string, String string2) {
	    
	}

	@When("I enter interest term year {string} and month {string}")
	public void i_enter_interest_term_year_and_month(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I verify results\"{double}\"")
	public void i_verify_results(Double double1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
