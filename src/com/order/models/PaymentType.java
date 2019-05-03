package com.order.models;

public class PaymentType {
	private int id;
	private String paymentTypeName;
	private String pay_img;
	public PaymentType(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentTypeName() {
		return paymentTypeName;
	}

	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}

	public String getPay_img() {
		return pay_img;
	}

	public void setPay_img(String pay_img) {
		this.pay_img = pay_img;
	}
	
	
}
