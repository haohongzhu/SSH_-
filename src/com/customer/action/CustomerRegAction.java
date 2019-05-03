package com.customer.action;

import java.util.Map;
import java.util.regex.Pattern;

import com.customer.dao.CustomerDao;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class CustomerRegAction extends ActionSupport{
	private Customer customer;
	private String rePwd;
	private Map session;
	private CustomerDao cd;
	
	public CustomerRegAction(){
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public String getRePwd() {
		return rePwd;
	}

	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
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
		if(customer.getUserName().length()==0 || customer.getUserName()==null || customer.getUserName().indexOf(" ")!=-1){
			this.addFieldError("userName","*�û�������Ϊ�գ�");
		}
		boolean flag=true;
		flag=cd.isUserNameExist(customer);
		if(flag){
			this.addFieldError("userName2", "*�û����Ѵ��ڣ�");
		}
		if(customer.getRealName().length()==0 || customer.getRealName()==null || customer.getRealName().indexOf(" ")!=-1){
			this.addFieldError("realName","*��ʵ��������Ϊ�գ�");
		}
		if(!customer.getUserTelephone().matches("[0-9]{11}")){
			this.addFieldError("userTel", "*�ֻ��������Ϊ11λ���֣�");
		}
		if(customer.getPassword().length()<6){
			this.addFieldError("pwd1","*���볤�Ȳ���С��6λ��");
		}
		if(!rePwd.equals(customer.getPassword())){
			this.addFieldError("pwd2", "*�������벻һ�£�");
		}
	}
	
	public String execute(){
		if(cd.regCustomer(customer)>0){
			Map m=ActionContext.getContext().getSession();
			m.put("loginUser", customer);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
