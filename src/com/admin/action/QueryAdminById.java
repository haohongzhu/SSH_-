package com.admin.action;

import java.util.List;
import java.util.Map;

import com.admin.dao.AdminDao;
import com.admin.models.Admin;
import com.admin.models.Role;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryAdminById extends ActionSupport{
	private AdminDao ad;
	private List<Role> role;
	private Admin admin;
	private int id;
	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute(){
		Map session=ActionContext.getContext().getSession();
		role=ad.QueryRole();
		if(ad.queryAdminById(id)!=null){
			admin=ad.queryAdminById(id);
			id=ad.queryAdminById(admin.getId()).getRole().getId();
			session.put("roles", role);
			session.put("cid", id);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
