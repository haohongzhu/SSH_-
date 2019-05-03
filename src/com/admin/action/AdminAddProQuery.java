package com.admin.action;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.jgroups.tests.adaptjms.Request;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.ProductType;

public class AdminAddProQuery extends ActionSupport{
	private List<ProductType> productTypes;
	private String obj;
	private AdminDao ad;
	
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

	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	public String execute(){
		try{
			obj = URLDecoder.decode(obj , "utf-8");
		}catch(Exception e){
	        e.printStackTrace();
		}
		System.out.println(obj.trim()+"4444");
		productTypes=ad.QueryProductTypeName(obj);
		if(productTypes!=null){
			Map session=ActionContext.getContext().getSession();
			session.put("typemethod1",obj);
			System.out.println(3333);
			return SUCCESS;
		}else{
			return INPUT;
		}

	}
}
