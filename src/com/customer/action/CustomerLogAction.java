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
			this.addFieldError("logUserName","*�û�������Ϊ�գ�");
		}
		if(customer.getPassword().length()==0 || customer.getPassword()==null ){
			this.addFieldError("logPassword","*���벻��Ϊ�գ�");
		}
	}

	public String execute(){
		customer=cd.logCustomer(customer);
		if(customer!=null){
			Map m=ActionContext.getContext().getSession();
			m.put("loginUser", customer);
			return SUCCESS;
		}else{
			this.addFieldError("logError", "*�û�����������������µ�¼!");
			return INPUT;
		}
	}
}
