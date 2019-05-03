package com.customer.action;

import java.util.Map;

import com.customer.dao.CustomerDao;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerLogAction extends ActionSupport{
	private Customer customer;
	private CustomerDao cd;
	
	public CustomerLogAction(){}

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
		if(customer.getUserName().length()==0 || customer.getUserName()==null ){
			this.addFieldError("logUserName","*用户名不能为空！");
		}
		if(customer.getPassword().length()==0 || customer.getPassword()==null ){
			this.addFieldError("logPassword","*密码不能为空！");
		}
	}

	public String execute(){
		customer=cd.logCustomer(customer);
		if(customer!=null){
			Map m=ActionContext.getContext().getSession();
			m.put("loginUser", customer);
			return SUCCESS;
		}else{
			this.addFieldError("logError", "*用户名或密码错误，请重新登录!");
			return INPUT;
		}
	}
}
