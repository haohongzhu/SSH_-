package com.admin.action;

import java.util.List;
import java.util.Map;

import com.admin.dao.AdminDao;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.Product;
import com.product.models.ProductEvaluate;

public class AdminQueryEva extends ActionSupport{
	private AdminDao ad;
	private List<ProductEvaluate> pes;
	private ProductEvaluate pe;
	private final int pageSize=3;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;
	private int id;
	private Product p;
	private int eid;
	
	public AdminQueryEva(){}

	
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
	

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public String execute(){
		Map m=ActionContext.getContext().getSession();
		p=ad.queryProById(id);
		m.put("now_pid", p);
		Product now_pid=(Product)m.get("now_pid");
		pes=ad.queryNowEva(now_pid.getId(), 1, 9999);
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
		pes=ad.queryNowEva(now_pid.getId(), pageNo, pageSize);
		m.put("admin_pes_session", pes);
		currentPage=pageNo;
		if(pes!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String deleteEva(){
		if(ad.deleteEvaluate(eid)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
