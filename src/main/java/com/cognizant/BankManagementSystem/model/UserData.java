package com.cognizant.BankManagementSystem.model;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity(name="users")
public class UserData {

	@Id
	private long userid;
	private String pan;
	private String name;
	private String password;
	private String address;
	private String state;
	private String country;
	private String email;
	private String contactNo;
	private String accountType;

	
	
	public UserData() {
		super();
	}

	public UserData(long userid, String pan, String name, String password, String address, String state, String country,
			String email, String contactNo, String accountType) {
		super();
		this.userid = userid;
		this.pan = pan;
		this.name = name;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.contactNo = contactNo;
		this.accountType = accountType;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getPAN() {
		return pan;
	}

	public void setPAN(String pAN) {
		this.pan = pAN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "UserData [userid=" + userid + ", pan=" + pan + ", name=" + name + 
				", password=" + password + ", address=" + address + ", state=" + state + ", country=" + country
				+ ", email=" + email + ", contactNo=" + contactNo + ", accountType=" + accountType + "]";
	}

}
