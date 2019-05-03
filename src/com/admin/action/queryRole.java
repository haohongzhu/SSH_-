package com.admin.action;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.struts2.ServletActionContext;
import com.admin.dao.AdminDao;
import com.admin.models.Admin;
import com.admin.models.Role;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class queryRole extends ActionSupport{
	private Admin admin;
	private List<Role> role;
	private AdminDao ad;
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
	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	public String execute(){
		String cid = ServletActionContext.getRequest().getParameter("theRole"); 
		role=ad.QueryRole();
		Map m=ActionContext.getContext().getSession();
		m.put("roleList", role);
		return SUCCESS;

	}

}
