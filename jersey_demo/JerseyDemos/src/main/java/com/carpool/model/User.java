package com.carpool.model;

import java.util.List;

public class User {

	public String username;
	public String user;
	public String address;
	public String mobileNo;
	public String emailId;
	public List<User> userList;
	
	public User() {}
	
	public User(String username, String user, String address, String mobileNo, String emailId) {
		this.username = username;
		this.user = user;
		this.address = address;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List getUserList() {
		return userList;
	}
	public void setUserList(List userList) {
		this.userList = userList;
	}
	
	
}
