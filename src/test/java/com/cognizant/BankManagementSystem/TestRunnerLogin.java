package com.cognizant.BankManagementSystem;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "Login.feature",
				 plugin = { "json:target/Destination/CucumberLoginReportJSON.json",
					        "junit:target/Destination/CucumberLoginReportXML.xml" },
				 monochrome = true)
public class TestRunnerLogin {

}
