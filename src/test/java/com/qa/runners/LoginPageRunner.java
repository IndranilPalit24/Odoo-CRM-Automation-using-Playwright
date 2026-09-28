package com.qa.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources/features/Login.feature",
		glue = {"com.qa.stepdefn"},
		plugin = {
				"pretty",
				"html:target/cucumber-reports/report.html"
		}
		
		)

public class LoginPageRunner extends AbstractTestNGCucumberTests{

}
