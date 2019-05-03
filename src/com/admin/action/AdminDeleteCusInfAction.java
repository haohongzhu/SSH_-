package com.admin.action;
import com.admin.dao.AdminDao;
import com.admin.models.Admin;
import com.opensymphony.xwork2.ActionSupport;
public class AdminDeleteCusInfAction extends ActionSupport{
	private Admin admin;
	private int id;
	AdminDao ad;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
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
		if(ad.deleteCustomerInf(id)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
