package com.order.models;

import java.util.Date;

import com.customer.models.ConsigneeInf;
import com.customer.models.Customer;

public class Order {
	private int id;
	private ShoppingCart order_cartID;
	private Customer order_customer;
	private ConsigneeInf order_consignee;
	private String orderTime;
	private PaymentType order_payment;
	private String orderStatus;
	private String note;
	
	public Order(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ShoppingCart getOrder_cartID() {
		return order_cartID;
	}

	public void setOrder_cartID(ShoppingCart order_cartID) {
		this.order_cartID = order_cartID;
	}

	public Customer getOrder_customer() {
		return order_customer;
	}

	public void setOrder_customer(Customer order_customer) {
		this.order_customer = order_customer;
	}

	public ConsigneeInf getOrder_consignee() {
		return order_consignee;
	}

	public void setOrder_consignee(ConsigneeInf order_consignee) {
		this.order_consignee = order_consignee;
	}
	
	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public PaymentType getOrder_payment() {
		return order_payment;
	}

	public void setOrder_payment(PaymentType order_payment) {
		this.order_payment = order_payment;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
