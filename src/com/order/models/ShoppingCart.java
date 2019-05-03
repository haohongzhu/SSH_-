package com.order.models;

import java.util.Set;

import com.customer.models.Customer;

public class ShoppingCart {
	private int id;
	private Customer customerID5;
	private int totalCount;
	private double totalPrice;
	private String cartStatus;
	private Set<ShoppingCartInf> setCartInf;
	
	public ShoppingCart(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomerID5() {
		return customerID5;
	}

	public void setCustomerID5(Customer customerID5) {
		this.customerID5 = customerID5;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Set<ShoppingCartInf> getSetCartInf() {
		return setCartInf;
	}

	public void setSetCartInf(Set<ShoppingCartInf> setCartInf) {
		this.setCartInf = setCartInf;
	}
	
}
