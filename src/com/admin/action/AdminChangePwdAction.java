package com.admin.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.admin.dao.AdminDao;
import com.admin.models.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminChangePwdAction extends ActionSupport{
	private String oldpwd;
	private String newpwd;
	private String renewpwd;
	private Admin admin;
	private AdminDao ad;
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getRenewpwd() {
		return renewpwd;
	}
	public void setRenewpwd(String renewpwd) {
		this.renewpwd = renewpwd;
	}
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
	
	public String execute(){ 
		//获得当前登录用户
		Map map=ActionContext.getContext().getSession();
		admin=(Admin)map.get("logadmin");
		if(ad.changePassword(admin, oldpwd, newpwd)){
			System.out.println(111);
			return SUCCESS;
		}
		else{
			System.out.println(222);
			return INPUT;
		}
	}
	
	public void validate(){
		System.out.println(oldpwd);
		System.out.println(newpwd+"444");
		System.out.println(renewpwd+"555");
		Map map=ActionContext.getContext().getSession();
		admin=(Admin)map.get("logadmin");
		if(oldpwd.trim()==null||"".equals(oldpwd.trim())){
			this.addFieldError("ErrorOldpwd", "旧密码不能为空，请重新输入!");
		}
		else if(!oldpwd.trim().equals(admin.getAdminPassword().trim())){
			this.addFieldError("ErrorPwd", "旧密码错误，请重新输入！");
		}
		if(newpwd.trim()==null||"".equals(newpwd.trim())||newpwd.length()<6){
			this.addFieldError("ErrorNewpwd", "新密码不能为空,且大于6位，请重新输入！");
		}
		if(renewpwd.trim()==null||"".equals(renewpwd.trim())){
			this.addFieldError("ErrorRenewpwd", "确认密码不能为空，请重新输入！");
		}
		else if(!newpwd.trim().equals(renewpwd.trim())){
			this.addFieldError("ErrorRePwd", "输入的两次密码不相同，请重新输入！");
		}
		else if(newpwd.trim().equals(oldpwd.trim())){
			this.addFieldError("ErrorReOldpwd", "新密码不能与旧密码相同，请重新输入！");
		}
	}
}
