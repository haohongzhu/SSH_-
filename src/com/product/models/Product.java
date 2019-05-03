package com.product.models;

import java.math.BigDecimal;
import java.util.Set;

public class Product {
	private int id;
	private String productName;
	private int monthSale;
	private int praise;
	private String description;
	private Double price;
	private String img;
	private String productState;
	private Set<ProductClass> productClass;
	
	public Product(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getMonthSale() {
		return monthSale;
	}

	public void setMonthSale(int monthSale) {
		this.monthSale = monthSale;
	}
	
	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public Set<ProductClass> getProductClass() {
		return productClass;
	}

	public void setProductClass(Set<ProductClass> productClass) {
		this.productClass = productClass;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", monthSale=" + monthSale + ", praise=" + praise
				+ ", description=" + description + ", price=" + price
				+ ", img=" + img + ", productState=" + productState
				+ ", productClass=" + productClass + "]";
	}
	
	
}
