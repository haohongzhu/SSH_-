package com.customer.action;

import com.customer.dao.CustomerDao;
import com.customer.models.ConsigneeInf;
import com.opensymphony.xwork2.ActionSupport;

public class ConsigneeUpdateInfAction extends ActionSupport{
	private ConsigneeInf consigneeInf;
	private CustomerDao cd;
	
	public ConsigneeUpdateInfAction(){}

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
		if(consigneeInf.getConsigneeName().length()==0 || consigneeInf.getConsigneeName()==null ){
			this.addFieldError("con1","*��ϵ����������Ϊ�գ�");
		}
		if(!consigneeInf.getAddressTel().matches("[0-9]{11}")){
			this.addFieldError("con2", "*�ֻ��������Ϊ11λ���֣�");
		}
		if(consigneeInf.getAddress().length()==0 || consigneeInf.getAddress()==null){
			this.addFieldError("con3","*�ջ���ַ����Ϊ�գ�");
		}
		if(consigneeInf.getDoorNum().length()==0 || consigneeInf.getDoorNum()==null){
			this.addFieldError("con4","*���ƺŲ���Ϊ�գ�");
		}
	}
	
	public String execute(){
		if(cd.updateConInf(consigneeInf)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
