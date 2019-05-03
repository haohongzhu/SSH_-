package com.admin.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.ProductClass;
import com.product.models.ProductType;

public class AdminQueryProType extends ActionSupport{
	private List<ProductType> productTypes;
	private ProductClass productClass;
	private AdminDao ad;
	
	public AdminQueryProType(){
		
	}

	public List<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	
	public ProductClass getProductClass() {
		return productClass;
	}

	public void setProductClass(ProductClass productClass) {
		this.productClass = productClass;
	}

	public String QueryProType(){
		productTypes=ad.QueryProductTypeMethod();
		System.out.println(productTypes);	
			Map session=ActionContext.getContext().getSession();
			session.put("productTypes2", productTypes);
			return SUCCESS;
		
	}
	public String QueryProType1(){
		productTypes=ad.QueryProductTypeMethod();
		System.out.println(productTypes);	
			Map session=ActionContext.getContext().getSession();
			session.put("productTypes3", productTypes);
			System.out.println("QueryProType3");
			return SUCCESS;
		
	}
	
	public String QueryProType2(){
		productTypes=ad.queryProductClass();
		System.out.println(productTypes);	
			Map session=ActionContext.getContext().getSession();
			session.put("productTypes4", productTypes);
			System.out.println("QueryProType4");
			return SUCCESS;
		
	}

	public String execute(){
		productTypes=ad.QueryProductTypeMethod();
		System.out.println(productTypes);
		if(productTypes!=null){		
			Map session=ActionContext.getContext().getSession();
			session.put("productTypes1", productTypes);
			System.out.println(1111);
			return SUCCESS;
		}else{
			System.out.println(2222);
			return INPUT;
		}
		
	}
}
