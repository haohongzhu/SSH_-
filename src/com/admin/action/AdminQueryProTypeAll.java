package com.admin.action;

import java.util.List;
import java.util.Map;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.ProductType;

public class AdminQueryProTypeAll extends ActionSupport{
	private AdminDao ad;
	private List<ProductType> productType;
	private int id; //界面显示数据的索引
	private final int pageSize=17; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数
	
	public AdminQueryProTypeAll(){
		
	}

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public List<ProductType> getProductType() {
		return productType;
	}

	public void setProductType(List<ProductType> productType) {
		this.productType = productType;
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
		//获得所有数据，得到数据的总个数
		productType=ad.queryProductClass();
		//计算总页数
		if(productType.size()%pageSize==0){
			totalPage=productType.size()/pageSize;
		}else{
			totalPage=productType.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		productType=ad.queryProClassByPage(pageNo,pageSize);
		//设置当前页
		currentPage=pageNo;
		if(productType!=null){
			return SUCCESS;
		}
		else
			return INPUT;
	}
	
}
