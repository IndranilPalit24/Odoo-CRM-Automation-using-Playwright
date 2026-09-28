package com.qa.pages;

import static com.microsoft.playwright.assertions
.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Page;
import com.qa.base.DriverManager;
import com.qa.utils.ConfigReader;

public class LoginPage {
	
	private Page page;
	
	//Constructor
	public LoginPage() {
		this.page = DriverManager.getPage();
	}
	
	//---NAVIGATION
	public void navigateToLoginPage() {
		page.navigate(ConfigReader.getBaseURL());
		page.getByText("Sign in").click();
		System.out.println("Navigated to Login Page");
	}
	
	
	//----ACTIONS
	public void enterUsername(String username) {
		page.getByPlaceholder("Enter your email").fill(username);
		System.out.println("Entered Username "+username);
	}
	
	public void enterPassword(String Password) {
		page.getByPlaceholder("Enter your password").fill(Password);
		System.out.println("Entered Password "+Password);
	}
	
	public void submitLogIn() {
		page.getByText("Log in").click();
		System.out.println("Logged in");
	}
	
	public void userisLoggedinSuccesfully(String companyName) {
		assertThat(page.getByText(companyName)).isVisible();;
		
	}
	

}
