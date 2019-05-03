package com.admin.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.admin.dao.AdminDao;
import com.admin.models.Admin;
import com.admin.models.Role;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAdminAction extends ActionSupport{
	private Admin admin;
	private Role role;
	private AdminDao ad;
	
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
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void validate(){
		if(admin.getAdminRealName().length()==0||admin.getAdminRealName()==null){
			this.addFieldError("adminRealName", "*��������Ϊ��");
		}
		if(!admin.getTelephone().matches("[0-9]{11}")){
			this.addFieldError("telephone", "*�ֻ��������Ϊ11λ����");
		}
		if(admin.getTelephonep().length()==0 || admin.getTelephonep()==null){
			this.addFieldError("telephonep", "*˽�˵绰����Ϊ��");
		}
	}
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		String cid = ServletActionContext.getRequest().getParameter("theRole"); 
		role=ad.queryRoleById(Integer.parseInt(cid));
		if(ad.updateAdmin(admin,role)){
			System.out.println(111111111);
			return SUCCESS;
		}else{
			System.out.println(22222222);
			return INPUT;
		}
	}
}
