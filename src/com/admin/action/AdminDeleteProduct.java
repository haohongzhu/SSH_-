package com.admin.action;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminDeleteProduct extends ActionSupport{
	private AdminDao ad;
	private int id;
	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String execute(){
		if(ad.deleteProduct(id)){
			System.out.println(111);
			return SUCCESS;
		}else{
			System.out.println(222);
			return INPUT;
		}
	}
}
