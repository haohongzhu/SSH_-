package com.customer.models;

import java.util.Set;

public class Customer {
	private int id;
	private String userName;
	private String password;
	private String realName;
	private String userTelephone;
	private Set<CustomerWords> customerWords;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	public Set<CustomerWords> getCustomerWords() {
		return customerWords;
	}
	public void setCustomerWords(Set<CustomerWords> customerWords) {
		this.customerWords = customerWords;
	}
	
	
}
