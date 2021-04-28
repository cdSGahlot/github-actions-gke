package com.cognizant.BankManagementSystem.ServiceTest;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.BankManagementSystem.Service.RegisterService;
import com.cognizant.BankManagementSystem.model.UserData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import io.cucumber.java.en.Then;

public class serviceTest {

	RegisterService registerService;
	RegisterService registerService2;

	String output1 = "";
	String output2 = "";

	UserData testUser = new UserData(101, "BYAKG1229M", "TestName", "password", "2/455 Vasundhara", "U.P.", "India",
			"testName@testEmail.com", "9999900000", "Saving");

	UserData testUser2 = new UserData(122, "BYAKJ8907J", "TestName2", "password2", "3/155 Vasant Kunj", "Delhi",
			"India", "testName2@testEmail.com", "8888800000", "Current");

	// ------------ Login Feature -------------

	@Given("I visit \\/login endpoint")
	public void i_visit_login_endpoint() {
		registerService = new RegisterService();
	}

	@When("I enter userid {int} and password {string}")
	public void i_enter_userid_and_password(Integer userid, String pwd) throws Throwable {
		output1 = registerService.loginMessage(testUser, userid, pwd);
	}

	@Then("I should get {string}")
	public void i_should_get(String string) {
		Assert.assertEquals(output1, string);
	}

	// ------------ Registration Feature -------------

	@Given("I visit \\/register endpoint")
	public void i_visit_register_endpoint() {
		registerService2 = new RegisterService();
	}

	@When("I enter userdetails")
	public void i_enter_userdetails() {
		output2 = registerService2.isAvailableTest(testUser2);
	}

	@When("I enter userdetails with existing PAN {string}")
	public void i_enter_userdetails_with_existing_pan(String string) {
		testUser2.setPAN(string);
		output2 = registerService2.isAvailableTest(testUser2);
	}

	@When("I enter userdetails with existing Bank Id {int}")
	public void i_enter_userdetails_with_existing_bank_id(Integer id) {
		testUser2.setUserid(id);
		output2 = registerService2.isAvailableTest(testUser2);
	}

	@Then("I get {string}")
	public void i_get(String string) {
		Assert.assertEquals(output2, string);
	}

}
