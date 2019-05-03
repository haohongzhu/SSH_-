package com.admin.action;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.admin.dao.AdminDao;
import com.admin.models.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class AdminLoginAction extends ActionSupport{
	private Admin admin;
	private String checkcode;  //接收验证码 
	AdminDao ad;
	
	public AdminLoginAction(){
		
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
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
	
	public String execute()throws Exception{
		
		if(ad.checkLogin(admin)!=null){
			Map session=ActionContext.getContext().getSession();
			admin=ad.checkLogin(admin);
			session.put("logadmin",admin);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public void validate(){
		String checkcode1 =(String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(admin.getAdminID().trim()==null||"".equals(admin.getAdminID().trim())){
			this.addFieldError("username", "用户名不能为空!");
		}
		if(ad.checkLogin(admin)==null){
			this.addFieldError("error", "用户名或密码错误!请重新输入");
		}
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addFieldError("error1", "验证码输入错误！");
		}
	}
}
