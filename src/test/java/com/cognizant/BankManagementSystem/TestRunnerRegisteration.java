package com.cognizant.BankManagementSystem;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Registration.feature", 
				 plugin = { "json:target/Destination/CucumberRegisterationReportJSON.json",
		   					"junit:target/Destination/CucumberRegisterationReportXML.xml" })
public class TestRunnerRegisteration {

}
