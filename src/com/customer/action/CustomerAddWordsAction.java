package com.customer.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.customer.dao.CustomerDao;
import com.customer.models.Customer;
import com.customer.models.CustomerWords;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class CustomerAddWordsAction extends ActionSupport {
	private CustomerDao cd;
	private CustomerWords customerWords;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public CustomerAddWordsAction(){}

	public CustomerWords getCustomerWords() {
		return customerWords;
	}

	public void setCustomerWords(CustomerWords customerWords) {
		this.customerWords = customerWords;
	}

	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}	
	
	public void validate(){
		if(customerWords.getWords().length()==0 || customerWords.getWords()==null){
			this.addFieldError("words","*用户留言不能为空！");
		}
	}
	
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		if(cd.addCusWords(c, customerWords,df.format(new Date()))>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
