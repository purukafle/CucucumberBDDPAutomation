package sepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MortgageCalculatorSteps {
	private WebDriver driver;
	
	@Given("I go to mortgag calculator website")
	public void i_go_to_mortgag_calculator_website() {
	    
	}

	@When("I enter mortgage amount {string}")
	public void i_enter_mortgage_amount(String string) {
	   
	}

	@When("I enter interest rate {string}")
	public void i_enter_interest_rate(String string) {
	    
	}

	@When("I enter amortization year {string} and month {string}")
	public void i_enter_amortization_year_and_month(String string, String string2) {
	    
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
