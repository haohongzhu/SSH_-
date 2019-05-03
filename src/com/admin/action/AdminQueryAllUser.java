package com.admin.action;

import java.util.List;

import com.admin.dao.AdminDao;
import com.admin.models.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class AdminQueryAllUser extends ActionSupport{
	private AdminDao ad;
	private List<Admin> admin;
	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	
	public List<Admin> getAdmin() {
		return admin;
	}
	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}
	public String execute(){
		if(ad.queryAdminUsers()!=null){
			admin=ad.queryAdminUsers();
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
