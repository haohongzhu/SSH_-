package com.customer.models;

public class ConsigneeInf {
	private int id;
	private String consigneeName;
	private String sex;
	private String address;
	private String addressTel;
	private String doorNum;
	private Customer customerID2;
	
	public ConsigneeInf(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressTel() {
		return addressTel;
	}

	public void setAddressTel(String addressTel) {
		this.addressTel = addressTel;
	}

	public String getDoorNum() {
		return doorNum;
	}

	public void setDoorNum(String doorNum) {
		this.doorNum = doorNum;
	}

	public Customer getCustomerID2() {
		return customerID2;
	}

	public void setCustomerID2(Customer customerID2) {
		this.customerID2 = customerID2;
	}
	
}
