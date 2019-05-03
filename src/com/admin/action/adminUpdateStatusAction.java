package com.admin.action;

import java.io.UnsupportedEncodingException;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class adminUpdateStatusAction  extends ActionSupport{
	private AdminDao ad;
	private int orderid;
	private String nextStatus;
	public adminUpdateStatusAction(){}
	
	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getNextStatus() {
		return nextStatus;
	}
	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}
	public String execute(){
		try {
			nextStatus = new String(nextStatus.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int test=ad.adminUpdateStatus(orderid, nextStatus);
			if(test==1){
				return SUCCESS;
			}else{
				return INPUT;
			}
	}

}
