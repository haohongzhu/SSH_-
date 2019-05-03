package com.admin.action;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import com.admin.models.*;
import com.admin.dao.*;
public class addAdminAction extends ActionSupport{
	private Admin admin;
	private AdminDao ad;
	private String Password1;
	private int roleID;
	private Role nowRole;
	public addAdminAction(){}

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

	public String getPassword1() {
		return Password1;
	}

	public void setPassword1(String password1) {
		Password1 = password1;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public void validate(){
		if(admin.getAdminID().length()==0||admin.getAdminID()==null||admin.getAdminID().indexOf(" ")!=-1){
			this.addFieldError("adminID", "*用户名不能为空！");
			System.out.println(456);
		}else if(ad.isIdExist(admin)==true){
			this.addFieldError("adminID2", "*此ID已存在");
			}
		if(admin.getAdminRealName().length()==0||admin.getAdminRealName()==null||admin.getAdminRealName().indexOf(" ")!=-1){
			this.addFieldError("adminRealName", "*姓名不可为空");
		}

		
		if(!admin.getTelephone().matches("[0-9]{11}")){
			this.addFieldError("telephone", "*手机号码必须为11位数字");
		}
		if(admin.getTelephonep().length()==0 || admin.getTelephonep()==null){
			this.addFieldError("telephonep", "*私人电话不能为空");
		}
		if(admin.getAdminPassword().length()<6||admin.getAdminPassword().length()>18){
			this.addFieldError("adminPassword", "*密码必须不小于6位且不大于18位");
		}
		if(!Password1.equals(admin.getAdminPassword())){
			this.addFieldError("adminPassword","*两次密码不一致");
		}
		if(roleID==-1){
			this.addFieldError("roleID","*请选择职务");
		}
	}

	public String execute() throws Exception{
		nowRole=ad.queryNowRole(roleID);
		admin.setRole(nowRole);
		if(ad.addAdmin(admin)>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}

}
