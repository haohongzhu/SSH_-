package com.admin.action;

import java.util.List;
import java.util.Map;

import com.admin.dao.AdminDao;
import com.admin.models.Admin;
import com.admin.models.Role;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryAdminAction extends ActionSupport{
	private AdminDao ad;
	private int id;
	private String positionName;
	private Admin admin;
	private Role role;
	
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String execute(){
		Map session=ActionContext.getContext().getSession();
		Admin m=(Admin)session.get("logadmin");
		admin=ad.queryAdminById(m.getId());
		positionName=ad.queryAdminById(m.getId()).getRole().getPositionName();
		role=ad.queryAdminById(m.getId()).getRole();
		System.out.println(role.getPositionName()+"======");
		id=ad.queryAdminById(m.getId()).getRole().getId();
		if(admin!=null){
			session.put("roles", role);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
