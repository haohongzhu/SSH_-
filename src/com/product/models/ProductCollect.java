package com.product.models;

import com.customer.models.Customer;

public class ProductCollect {
	private int id;
	private Customer customerID4;
	private Product productID3;
	
	public ProductCollect(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomerID4() {
		return customerID4;
	}

	public void setCustomerID4(Customer customerID4) {
		this.customerID4 = customerID4;
	}

	public Product getProductID3() {
		return productID3;
	}

	public void setProductID3(Product productID3) {
		this.productID3 = productID3;
	}
	
	
}
