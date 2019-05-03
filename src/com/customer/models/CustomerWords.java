package com.customer.models;

public class CustomerWords {
	private int id;
	private Customer customerID;
	private String words;
	private String wordsTime;
	
	public CustomerWords(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getWordsTime() {
		return wordsTime;
	}

	public void setWordsTime(String wordsTime) {
		this.wordsTime = wordsTime;
	}
	
}
