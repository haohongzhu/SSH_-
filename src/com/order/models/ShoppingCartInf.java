package com.order.models;

import com.product.models.Product;

public class ShoppingCartInf {
	private int id;
	private ShoppingCart shoppingCart;
	private Product productID4;
	private int productCount;
	private Double oneProductPrice;
	
	public ShoppingCartInf(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Product getProductID4() {
		return productID4;
	}

	public void setProductID4(Product productID4) {
		this.productID4 = productID4;
	}
	
	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public Double getOneProductPrice() {
		return oneProductPrice;
	}

	public void setOneProductPrice(Double oneProductPrice) {
		this.oneProductPrice = oneProductPrice;
	}
	
	
}
