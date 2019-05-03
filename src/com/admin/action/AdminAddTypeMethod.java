package com.admin.action;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.ProductType;

public class AdminAddTypeMethod extends ActionSupport{
	private AdminDao ad;
	private String typeMethod;
	private ProductType productType;
	
	public AdminAddTypeMethod(){
		
	}
	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	public String getTypeMethod() {
		return typeMethod;
	}
	public void setTypeMethod(String typeMethod) {
		this.typeMethod = typeMethod;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public String execute(){
		if(ad.addTypeMethod(typeMethod)>0){
			System.out.println(111);
			return SUCCESS;
		}else{
			System.out.println(222);
			return INPUT;
		}
	}
}
