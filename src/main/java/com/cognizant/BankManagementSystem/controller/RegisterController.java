package com.cognizant.BankManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.BankManagementSystem.Service.RegisterService;
import com.cognizant.BankManagementSystem.model.LoginData;
import com.cognizant.BankManagementSystem.model.UserData;
import com.cognizant.BankManagementSystem.repository.GCPUsersRepository;




@RestController
public class RegisterController {

	Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private GCPUsersRepository regrepo;

	@Autowired
	private RegisterService regService;

	@PostMapping("/register")
	public String saveUser(@RequestBody UserData userdata) {
		logger.info("START: User Registration");
		String val = regService.saveUserData(userdata);
		if (val.contains("ERROR:")) {
			logger.error("ERROR: User not registered");
		} else {
			logger.info("SUCCESS: " + val);
		}
		logger.info("END: User Registeration");
		return val;

	}

	@GetMapping("/register")
	public List<UserData> getAllUsers() {
		logger.info("START: Get All Users");
		if (regrepo.findAll() == null) {
			logger.warn("WARNING: No Bank Registered Users Found");
		}
		logger.info("END: Get All Users");
		List<UserData> list = new ArrayList<UserData>();
		for(UserData user : regrepo.findAll()) {
			list.add(user);
		}
		return list;
	}

	// ------------------- LOGIN -------------------------------

	@PostMapping("/login")
	public String loginDetails(@RequestBody LoginData logindata) {
		logger.debug("START: Login Function");
		UserData user = regrepo.findById(logindata.getUserid()).orElse(null);
		if (user == null) {
			logger.error("ERROR: User with entered ID - NOT FOUND");
			return "ERROR: User with entered ID - NOT FOUND";
		}
		String returnMessage = regService.loginMessage(user, logindata.getUserid(), logindata.getPassword());
		if (returnMessage.contains("ERROR:")) {
			logger.error(returnMessage);
		}
		logger.info("END: Login Function");
		return returnMessage;

	}

	// ------------------- UPDATE -------------------------------	

	@PostMapping("/update/address")
	public String updateAddress(@RequestBody UserData updatedata) {
		logger.info("START: updateAddress Function");
		UserData user = regrepo.findById(updatedata.getUserid()).orElse(null);
		if (user == null) {
			String msg = "Cannot Find User with User ID: " + updatedata.getUserid();
			logger.warn(msg);
			return msg;
		}
		if (user.getPassword().equals(updatedata.getPassword())) {
			if(updatedata.getAddress()!=null) {
			user.setAddress(updatedata.getAddress());
			}
			if(updatedata.getState()!=null) {
			user.setCountry(updatedata.getCountry());
			}
			if(updatedata.getCountry()!=null) {
			user.setState(updatedata.getState());
			}
			regrepo.save(user);
			logger.info("Address updated Successfully");
			logger.info("END: updateAddress Function");
			return "Address for User: " + user.getName() + " updated Successfully to: " + user.getAddress() + ", "
					+ user.getState() + ", " + user.getCountry();
		}
		logger.warn("PASSWORD or USERID incorrect");
		logger.info("END: updateAddress Function");
		return "PASSWORD or USERID incorrect";

	}

	@PostMapping("/update/contact")
	public String updateContact(@RequestBody UserData updatedata) {
		logger.info("START: updateContact Function");
		UserData user = regrepo.findById(updatedata.getUserid()).orElse(null);
		if (user == null) {
			String msg = "Cannot Find User with User ID: " + updatedata.getUserid();
			logger.warn(msg);
			return msg;
		}
		if (user.getPassword().equals(updatedata.getPassword())) {
			user.setContactNo(updatedata.getContactNo());
			logger.info("Contact updates Successfully");
			logger.info("END: updateContact Function");
			regrepo.save(user);
			return "Contact for User: " + user.getName() + " updated Successfully to: " + user.getContactNo();
		}
		logger.warn("PASSWORD or USERID incorrect");
		logger.info("END: updateContact Function");
		return "PASSWORD or USERID incorrect";
	}

	@PostMapping("/update/email")
	public String updateEmail(@RequestBody UserData updatedata) {
		logger.info("START: updateEmail Function");
		UserData user = regrepo.findById(updatedata.getUserid()).orElse(null);
		if (user == null) {
			String msg = "Cannot Find User with User ID: " + updatedata.getUserid();
			logger.warn(msg);
			return msg;
		}
		if (user.getPassword().equals(updatedata.getPassword())) {
			user.setEmail(updatedata.getEmail());
			logger.info("Email updates Successfully");
			logger.info("END: updateEmail Function");
			regrepo.save(user);
			return "Email for User: " + user.getName() + " updated Successfully to: " + user.getEmail();
		}
		logger.warn("PASSWORD or USERID incorrect");
		logger.info("END: updateEmail Function");
		return "PASSWORD or USERID incorrect";
	}

}
