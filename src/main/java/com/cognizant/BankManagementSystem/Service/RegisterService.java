package com.cognizant.BankManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BankManagementSystem.model.LoginData;
import com.cognizant.BankManagementSystem.model.UserData;
import com.cognizant.BankManagementSystem.repository.GCPUsersRepository;

import edu.emory.mathcs.backport.java.util.Arrays;

@Service
public class RegisterService {

	Logger logger = LoggerFactory.getLogger(RegisterService.class);
	
	@Autowired
	private GCPUsersRepository repo;

	public String isAvailable(UserData userdata) {
		logger.debug("START: isAvalaible Function");
		List<UserData> list = new ArrayList<UserData>();
		for(UserData user : repo.findAll()) {
			list.add(user);
		}
		if(list.isEmpty()) {
			logger.warn("WARNING: No Users Available");
			return "WARNING: No Users Available";
		}
		for (UserData user : list) {
			if (user.getPAN().equals(userdata.getPAN()))
				return "ERROR: user with entered PAN " + userdata.getPAN() + " already exists";
			if (user.getUserid() == userdata.getUserid())
				return "ERROR: user with Bank id " + userdata.getUserid() + " already exists";
		}
		logger.debug("END: isAvailable Function");
		return "Successfully registered";
	}
	

	public String saveUserData(UserData userdata) {
		logger.info("START: saveUserData Function");
		String val = isAvailable(userdata);
		if(val.contains("WARNING:") || val.contains("SUCCESS:")) {
			repo.save(userdata);
		}
		else if (val.contains("ERROR:")) {
			return val;
		}
			logger.info("INFO: UserData Saved");
			logger.info("END: saveUserData Function");
			return val;
		
	}

	public String loginMessage(UserData user, long userid, String pwd) {
		if (user.getUserid() == userid) {
			if (pwd.equals(user.getPassword())) {
				return "Logged in successfully";
			} else {
				return "ERROR: Incorrect Password";
			}
		}
		return "ERROR: Not found user with Bank id " + userid;
	}
	
	
	//----------- TEST METHOD FOR REGISTRATION ----------------
	
	
	public String isAvailableTest(UserData userdata) {
		List<UserData> list = new ArrayList<UserData>();
		UserData user1 = new UserData(451, "BYAKY6650L", "TestName3", "password3", "4/355 Vasant Kunj", "Delhi", "India",
				"testName3@testEmail.com", "7777700000", "Current");
		UserData user2 = new UserData(551, "BKLG0099P", "TestName4", "password4", "5/280 Saket", "Delhi", "India",
				"testName4@testEmail.com", "6666600000", "Saving");
		list.add(user1);
		list.add(user2);
		for (UserData user : list) {
			if (user.getPAN().equals(userdata.getPAN()))
				return "ERROR: user with entered PAN " + userdata.getPAN() + " already exists";
			if (user.getUserid() == userdata.getUserid())
				return "ERROR: user with Bank id " + userdata.getUserid() + " already exists";
		}
		return "Successfully registered";
	}

}
