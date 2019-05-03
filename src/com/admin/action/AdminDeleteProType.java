package com.admin.action;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.ProductType;

public class AdminDeleteProType extends ActionSupport{
	private AdminDao ad;
	private int id;
	private ProductType productType;
	
	public AdminDeleteProType(){
		
	}

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute(){
		
		if(ad.deleteProductType(id)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
