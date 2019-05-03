package com.product.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;

public class ProductQueryAllTopAction extends ActionSupport{
	private List<Product> products;
	private ProductDao pd;
	private Product product;
	private String saleTop="monthSale";
	private String praiseTop="praise";
	private String priceTop="price";
	private String sortType="DESC";
	private String sortType2="ASC";
	private final int pageSize=12;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	
	public ProductQueryAllTopAction(){}


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


	public String getSaleTop() {
		return saleTop;
	}


	public void setSaleTop(String saleTop) {
		this.saleTop = saleTop;
	}


	public String getPraiseTop() {
		return praiseTop;
	}


	public void setPraiseTop(String praiseTop) {
		this.praiseTop = praiseTop;
	}


	public String getPriceTop() {
		return priceTop;
	}


	public void setPriceTop(String priceTop) {
		this.priceTop = priceTop;
	}


	public String getSortType() {
		return sortType;
	}


	public void setSortType(String sortType) {
		this.sortType = sortType;
	}


	public String getSortType2() {
		return sortType2;
	}


	public void setSortType2(String sortType2) {
		this.sortType2 = sortType2;
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
		products=pd.queryByPageTop(saleTop, sortType, pageNo, pageSize);
		currentPage=pageNo;
		m.put("sale", products);
		m.put("totalPage", totalPage);
		if(products.size()>0){
			if(session.getAttribute("praise") != null){
				session.removeAttribute("paise");
			}
			if(session.getAttribute("price") != null){
				session.removeAttribute("price");
			}
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String queryPraise(){
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
		products=pd.queryByPageTop(praiseTop, sortType, pageNo, pageSize);
		currentPage=pageNo;
		m.put("praise", products);
		m.put("totalPage", totalPage);
		if(products.size()>0){
			if(session.getAttribute("sale") != null){
				session.removeAttribute("sale");
			}
			if(session.getAttribute("price") != null){
				session.removeAttribute("price");
			}
			return "praiseS";
		}else{
			return "praiseI";
		}
	}
	
	public String queryPrice(){
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
		products=pd.queryByPageTop(priceTop, sortType2, pageNo, pageSize);
		currentPage=pageNo;
		m.put("price", products);
		m.put("totalPage", totalPage);
		if(products.size()>0){
			if(session.getAttribute("praise") != null){
				session.removeAttribute("praise");
			}
			if(session.getAttribute("sale") != null){
				session.removeAttribute("sale");
			}
			return "priceS";
		}else{
			return "priceI";
		}
	}
	
	
}
