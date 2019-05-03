package com.product.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.ProductClass;

public class ProductQueryByTypeAction extends ActionSupport{
	private List<ProductClass> lpc;
	private ProductDao pd;
	private int tid; 
	private final int pageSize=12;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;
	
	public ProductQueryByTypeAction(){}

	public List<ProductClass> getLpc() {
		return lpc;
	}

	public void setLpc(List<ProductClass> lpc) {
		this.lpc = lpc;
	}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
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
		Map m=ActionContext.getContext().getSession();
		lpc=pd.queryByType(tid);
		if(lpc.size()%pageSize==0){
			totalPage=lpc.size()/pageSize;
		}else{
			totalPage=lpc.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		lpc=pd.queryByTypeAndPage(tid, pageNo, pageSize);
		currentPage=pageNo;
		m.put("productClass", lpc);
		if(lpc.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
