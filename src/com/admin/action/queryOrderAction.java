package com.admin.action;
import com.admin.dao.AdminDao;
import com.order.models.*;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class queryOrderAction extends ActionSupport{
	private List<Order> orders;
	private AdminDao ad;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=8; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	
	public queryOrderAction(){
		
	}
	public  List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String execute(){
		orders=ad.queryOrders();
		if(orders.size()%pageSize==0){
			totalPage=orders.size()/pageSize;
		}else{
			totalPage=orders.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		orders=ad.queryOrdersByPage(pageNo,pageSize);
		currentPage=pageNo;
		Map m=ActionContext.getContext().getSession();
		m.put("ordersList", orders);
		m.put("currentPage", currentPage);
		if(orders!=null)
			return SUCCESS;
		else
			return INPUT;
	}
}
