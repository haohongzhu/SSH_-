package com.admin.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;

import com.admin.dao.AdminDao;
import com.customer.models.ConsigneeInf;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.order.models.Order;
import com.order.models.PaymentType;
import com.order.models.ShoppingCart;
import com.order.models.ShoppingCartInf;

public class adminQueryOrderById extends ActionSupport{
	private Order order;
	private AdminDao ad;
	private final int pageSize=11;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;	
	private int id;
	private String status;
	private Map m=ActionContext.getContext().getSession();
	private String nextStatus;
	private String action;
	public  adminQueryOrderById(){}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}	
	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Map getM() {
		return m;
	}

	public void setM(Map m) {
		this.m = m;
	}

	public String getNextStatus() {
		return nextStatus;
	}

	public void setNextStatus(String nextStatus) {
		this.nextStatus = nextStatus;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	//��ѯָ��ID�Ķ���
	public String execute(){
		order=ad.queryOrderById(id);
		m.put("nowOrder", order);
		m.put("nowOrderStatus", order.getOrderStatus());
		System.out.println(order.getOrderStatus());
		if(order.getOrderStatus().equals("δ����")){
			nextStatus="δ�ӵ�";
		}else if(order.getOrderStatus().equals("δ�ӵ�")){
			action="�ӵ�";
			nextStatus="�ѽӵ�";
		}else if(order.getOrderStatus().equals("�ѽӵ�")){
			action="����";
			nextStatus="������";
		}else if(order.getOrderStatus().equals("������")){
			action="�������";
			nextStatus="���ʹ�";
		}
		m.put("action", action);
		m.put("nextStatus", nextStatus);
		return SUCCESS;
	}
}
