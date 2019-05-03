package com.product.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;

public class ProductQueryAllAction extends ActionSupport{
	private List<Product> products;
	private ProductDao pd;
	private Product product;
	private String id="id";
	private String sortType="ASC";
	private final int pageSize=12;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;
	
	public ProductQueryAllAction(){}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
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
		products=pd.queryAllProduct();
		if(products.size()%pageSize==0){
			totalPage=products.size()/pageSize;
		}else{
			totalPage=products.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		products=pd.queryByPageTop(id, sortType, pageNo, pageSize);
		currentPage=pageNo;
		m.put("totalPage", totalPage);
		if(products.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
