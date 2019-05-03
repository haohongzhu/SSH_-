package com.customer.action;

import com.customer.dao.CustomerDao;
import com.opensymphony.xwork2.ActionSupport;

public class ConsigneeInfDeleteAction extends ActionSupport {
	private int id;
	private CustomerDao cd;
	
	public ConsigneeInfDeleteAction(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	
	public String execute(){
		if(cd.deleteConInfById(id)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
