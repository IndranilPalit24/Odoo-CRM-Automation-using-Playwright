package com.qa.stepdefn;

import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDefn {
	
	//Create LoginPage instance
	LoginPage loginpage = new LoginPage();
	
	
	@Given("User is on the Login page")
	public void userIsOnTheLoginPage() {
		loginpage.navigateToLoginPage();
	}
	
	
	@When("User provides the username and password")
	public void userProvidesTheUsernameAndPassword() {
		loginpage.enterUsername("Your Email");
		loginpage.enterPassword("Your Password");	
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
