package com.product.models;

import java.util.Set;

public class ProductType {
	private int id;
	private String typeMethod;
	private String typeName;
	private Set<ProductClass> productClass1;
	
	public ProductType(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeMethod() {
		return typeMethod;
	}

	public void setTypeMethod(String typeMethod) {
		this.typeMethod = typeMethod;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<ProductClass> getProductClass1() {
		return productClass1;
	}

	public void setProductClass1(Set<ProductClass> productClass1) {
		this.productClass1 = productClass1;
	}
	
	
}
