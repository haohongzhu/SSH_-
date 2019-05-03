package com.customer.action;

import java.util.Map;

import com.customer.dao.CustomerDao;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class CustomerChangePwdAction extends ActionSupport{
	private String oldPwd;
	private String newPwd;
	private String newPwd2;
	private Customer customer;
	private CustomerDao cd;
	
	public CustomerChangePwdAction(){
		
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getNewPwd2() {
		return newPwd2;
	}

	public void setNewPwd2(String newPwd2) {
		this.newPwd2 = newPwd2;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	
	public void validate(){
		if(oldPwd.length()==0 || oldPwd==null){
			this.addFieldError("pwd1","*�����벻��Ϊ�գ�");
		}
		if(newPwd.length()<6){
			this.addFieldError("pwd2","*���볤�Ȳ���С��6λ��");
		}
		if(newPwd.equals(oldPwd)){
			this.addFieldError("pwd4","*�����벻�����������ͬ��");
		}
		if(!newPwd2.equals(newPwd)){
			this.addFieldError("pwd3", "*�������벻һ�£�");
		}
	}
	
	public String execute(){
		Map map=ActionContext.getContext().getSession();
		customer=(Customer)map.get("loginUser");
		if(cd.ChangePwd(customer, oldPwd, newPwd)){;
			return SUCCESS;
		}else{
			this.addFieldError("changeError", "*�����벻��ȷ��");
			return INPUT;
		}
	}
}
