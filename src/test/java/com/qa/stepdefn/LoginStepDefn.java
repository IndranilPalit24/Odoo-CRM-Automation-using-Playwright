package com.qa.stepdefn;

import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.cdimascio.dotenv.Dotenv;

public class LoginStepDefn {
	
	//Create LoginPage instance
	LoginPage loginpage = new LoginPage();
	Dotenv dotenv = Dotenv.configure().load();
	
	
	@Given("User is on the Login page")
	public void userIsOnTheLoginPage() {
		loginpage.navigateToLoginPage();
	}
	
	
	@When("User provides the {string} username and {string} password")
	public void userProvidesTheUsernameAndPassword(String Odoo_USERNAME, String Odoo_PASSWORD) {
		loginpage.enterUsername(dotenv.get("Odoo_USERNAME"));
		loginpage.enterPassword(dotenv.get("Odoo_PASSWORD"));
	}
	
	
	@When("User clicks on LogIn button")
	public void userClicksOnLogInButton() {
		loginpage.submitLogIn();
		
	}
	
	@Then("User is logged into the Odoo Application")
	public void userIsLoggedIntoTheOdooApplication() {
		loginpage.userisLoggedinSuccesfully("ABC Company, Jas Laslow");
		
	}
	
	
	

}
