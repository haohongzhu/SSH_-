package com.customer.action;

import java.util.List;
import java.util.Map;
import com.customer.dao.CustomerDao;
import com.customer.models.ConsigneeInf;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ConsigneeQueryByCidAction extends ActionSupport{
	private List<ConsigneeInf> inf;
	private ConsigneeInf consigneeInf;
	private CustomerDao cd;
	private final int pageSize=6;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;	
	private int conID;
	
	public ConsigneeQueryByCidAction(){}

	public List<ConsigneeInf> getInf() {
		return inf;
	}

	public void setInf(List<ConsigneeInf> inf) {
		this.inf = inf;
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
	

	public int getConID() {
		return conID;
	}

	public void setConID(int conID) {
		this.conID = conID;
	}

	public String execute()throws Exception{
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		inf=cd.queryConByCid(c.getId());
		if(inf.size()%pageSize==0){
			totalPage=inf.size()/pageSize;
		}else{
			totalPage=inf.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		inf=cd.queryByPage(c.getId(), pageNo, pageSize);
		currentPage=pageNo;
		if(inf.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String queryAll(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		inf=cd.queryConByCid(c.getId());
		m.put("consigneeInf", inf);
		return null;
	}
	
	public String queryByName(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		consigneeInf=cd.queryConByName(conID, c.getId()).get(0);
		m.put("nowConsignee", consigneeInf);
		return SUCCESS;
	}
}
