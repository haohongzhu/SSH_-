package com.customer.action;

import com.customer.dao.CustomerDao;
import com.customer.models.ConsigneeInf;
import com.opensymphony.xwork2.ActionSupport;

public class ConsigneeQueryByIdAction extends ActionSupport{
	private int id;
	private ConsigneeInf consigneeInf;
	private CustomerDao cd;
	
	public ConsigneeQueryByIdAction(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ConsigneeInf getConsigneeInf() {
		return consigneeInf;
	}

	public void setConsigneeInf(ConsigneeInf consigneeInf) {
		this.consigneeInf = consigneeInf;
	}

	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	
	public String execute(){
		consigneeInf=cd.queryUserById(id);
		if(consigneeInf!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
}
