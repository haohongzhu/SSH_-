package com.product.models;

import com.customer.models.Customer;

public class ProductEvaluate {
	private int id;
	private Customer customerID3;
	private Product productID2;
	private String evaluate;
	private String date;
	
	public ProductEvaluate(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomerID3() {
		return customerID3;
	}

	public void setCustomerID3(Customer customerID3) {
		this.customerID3 = customerID3;
	}

	public Product getProductID2() {
		return productID2;
	}

	public void setProductID2(Product productID2) {
		this.productID2 = productID2;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
