package com.admin.action;

import java.util.List;
import java.util.Map;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.order.models.Order;
public class queryOrderByKeyAction extends ActionSupport{
	private AdminDao ad;
	private String Key;
	private List<Order> orders;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=8; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	public queryOrderByKeyAction() {
		
	}
	
	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
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
	public void validate(){
		if(Key.length()==0||Key==null||Key.indexOf(" ")!=-1){
			this.addFieldError("Key","������ؼ���");
		}
	}
	public String execute(){
		orders=ad.queryOrderByKey(Key);
		Map m=ActionContext.getContext().getSession();
		m.put("ordersList", orders);
		m.put("currentPage", currentPage);
		if(orders.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}

}
