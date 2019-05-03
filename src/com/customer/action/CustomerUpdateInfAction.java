package com.customer.action;

import java.util.Map;

import com.customer.dao.CustomerDao;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerUpdateInfAction extends ActionSupport{
	private Customer customer;
	private CustomerDao cd;
	
	public CustomerUpdateInfAction(){}

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
		if(customer.getUserName().length()==0 || customer.getUserName()==null){
			this.addFieldError("userName","*用户名不能为空！");
		}
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		boolean flag=true;
		flag=cd.isUserNameExist2(customer,c.getId());
		if(flag){
			this.addFieldError("userName2", "*用户名已存在！");
		}
		if(customer.getRealName().length()==0 || customer.getRealName()==null){
			this.addFieldError("realName","*真实姓名不能为空！");
		}
		if(!customer.getUserTelephone().matches("[0-9]{11}")){
			this.addFieldError("userTel", "*手机号码必须为11位数字！");
		}
	}
	
	public String execute(){
		if(cd.updateCustomerInf(customer)){
			Map m=ActionContext.getContext().getSession();
			m.put("loginUser", customer);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
