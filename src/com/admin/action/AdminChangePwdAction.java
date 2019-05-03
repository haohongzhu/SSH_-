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
		//��õ�ǰ��¼�û�
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
			this.addFieldError("ErrorOldpwd", "�����벻��Ϊ�գ�����������!");
		}
		else if(!oldpwd.trim().equals(admin.getAdminPassword().trim())){
			this.addFieldError("ErrorPwd", "������������������룡");
		}
		if(newpwd.trim()==null||"".equals(newpwd.trim())||newpwd.length()<6){
			this.addFieldError("ErrorNewpwd", "�����벻��Ϊ��,�Ҵ���6λ�����������룡");
		}
		if(renewpwd.trim()==null||"".equals(renewpwd.trim())){
			this.addFieldError("ErrorRenewpwd", "ȷ�����벻��Ϊ�գ����������룡");
		}
		else if(!newpwd.trim().equals(renewpwd.trim())){
			this.addFieldError("ErrorRePwd", "������������벻��ͬ�����������룡");
		}
		else if(newpwd.trim().equals(oldpwd.trim())){
			this.addFieldError("ErrorReOldpwd", "�����벻�����������ͬ�����������룡");
		}
	}
}
