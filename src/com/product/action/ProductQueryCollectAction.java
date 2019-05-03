package com.product.action;

import java.util.List;
import java.util.Map;

import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.ProductCollect;

public class ProductQueryCollectAction extends ActionSupport{
	private List<ProductCollect> collects;
	private ProductDao pd;
	private List<ProductCollect> collects2;
	private final int pageSize=12;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;
	
	public ProductQueryCollectAction(){}

	public List<ProductCollect> getCollects() {
		return collects;
	}

	public void setCollects(List<ProductCollect> collects) {
		this.collects = collects;
	}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
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

	public List<ProductCollect> getCollects2() {
		return collects2;
	}

	public void setCollects2(List<ProductCollect> collects2) {
		this.collects2 = collects2;
	}

	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		collects=pd.queryAllCollect(c.getId());
		collects2=pd.queryCollect(c.getId(), 1, 5);
		m.put("five_collect", collects2);
		if(collects.size()%pageSize==0){
			totalPage=collects.size()/pageSize;
		}else{
			totalPage=collects.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		collects=pd.queryCollect(c.getId(), pageNo, pageSize);
		currentPage=pageNo;
		m.put("collects2", collects);
		if(collects.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
