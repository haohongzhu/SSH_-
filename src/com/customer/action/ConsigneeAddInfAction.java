package com.customer.action;

import java.util.Map;

import com.customer.dao.CustomerDao;
import com.customer.models.ConsigneeInf;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ConsigneeAddInfAction extends ActionSupport{
	private ConsigneeInf consigneeInf;
	private CustomerDao cd;
	
	public ConsigneeAddInfAction(){}
	

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
	
	public void validate(){
		if(consigneeInf.getConsigneeName().length()==0 || consigneeInf.getConsigneeName()==null || consigneeInf.getConsigneeName().indexOf(" ")!=-1){
			this.addFieldError("con1","*��ϵ����������Ϊ�գ�");
		}
		if(!consigneeInf.getAddressTel().matches("[0-9]{11}")){
			this.addFieldError("con2", "*�ֻ��������Ϊ11λ���֣�");
		}
		if(consigneeInf.getAddress().length()==0 || consigneeInf.getAddress()==null || consigneeInf.getAddress().indexOf(" ")!=-1){
			this.addFieldError("con3","*�ջ���ַ����Ϊ�գ�");
		}
		if(consigneeInf.getDoorNum().length()==0 || consigneeInf.getDoorNum()==null || consigneeInf.getDoorNum().indexOf(" ")!=-1){
			this.addFieldError("con4","*���ƺŲ���Ϊ�գ�");
		}
	}
	
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		if(cd.addConsigneeInf(c, consigneeInf)>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
