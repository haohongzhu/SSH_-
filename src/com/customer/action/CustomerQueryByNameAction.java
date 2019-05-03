package com.customer.action;

import java.util.List;
import java.util.Map;

import com.customer.dao.CustomerDao;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerQueryByNameAction extends ActionSupport {
	private Customer customer;
	private CustomerDao cd;
	private List<Customer> cus;
	
	public CustomerQueryByNameAction(){}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Customer> getCus() {
		return cus;
	}

	public void setCus(List<Customer> cus) {
		this.cus = cus;
	}

	public CustomerDao getCd() {
		return cd;
	}
	
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		customer=cd.cusQueryByName(c.getId());
		if(customer!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}

}
