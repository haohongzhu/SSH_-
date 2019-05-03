package com.admin.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.ProductType;

public class AdminAddTypeName extends ActionSupport{
	private AdminDao ad;
	private ProductType productType;
	private String typeName;
	private String type;
	
	public AdminAddTypeName(){
		
	}

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String execute(){
//		String method= ServletActionContext.getRequest().getParameter("type"); 
//		Map session=ActionContext.getContext().getSession();
//		String method=(String)session.get("typemethod1");
		try {
			type = new String(type.getBytes("ISO-8859-1"),"utf-8");
			typeName = new String(typeName.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productType=ad.newQueryProductTypeName(type);
		System.out.println(typeName+"111111111111");
		if(productType.getTypeName()==null){
			ad.updateProType(typeName, type);
			System.out.println("333...");
			return SUCCESS;
		}else if(productType.getTypeName()!=null){
				ad.addTypeName(type,typeName);
				System.out.println("111...");
				return SUCCESS;
		}else{
				System.out.println("222...");
				return INPUT;
			}
		}
}
