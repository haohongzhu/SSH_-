package com.admin.action;

import com.admin.dao.AdminDao;
import com.admin.models.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminDeleteById extends ActionSupport{
	private Admin admin;
	private int id;
	private AdminDao ad;
	
	public AdminDeleteById(){}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	
	public String execute(){
		if(ad.deleteAdminById(id)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
