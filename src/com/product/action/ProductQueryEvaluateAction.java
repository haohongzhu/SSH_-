package com.product.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.customer.dao.CustomerDao;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;
import com.product.models.ProductEvaluate;

public class ProductQueryEvaluateAction extends ActionSupport{
	private ProductDao pd;
	private List<ProductEvaluate> pes;
	private ProductEvaluate pe;
	private final int pageSize=4;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;
	private int id;
	
	public ProductQueryEvaluateAction(){}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}
	
	public List<ProductEvaluate> getPes() {
		return pes;
	}

	public void setPes(List<ProductEvaluate> pes) {
		this.pes = pes;
	}
	
	public ProductEvaluate getPe() {
		return pe;
	}

	public void setPe(ProductEvaluate pe) {
		this.pe = pe;
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

	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		pes=pd.queryAllEva(c.getId(), 1, 999);
		if(pes.size()%pageSize==0){
			totalPage=pes.size()/pageSize;
		}else{
			totalPage=pes.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		pes=pd.queryAllEva(c.getId(), pageNo, pageSize);
		m.put("pes_session", pes);
		currentPage=pageNo;
		if(pes!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String deleteEva(){
		if(pd.deleteEvaluate(id)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
