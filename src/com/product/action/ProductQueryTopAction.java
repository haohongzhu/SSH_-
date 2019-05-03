package com.product.action;

import java.util.List;
import java.util.Map;

import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;
import com.product.models.ProductCollect;

public class ProductQueryTopAction extends ActionSupport{
	private List<Product> products;
	private List<Product> products2;
	private List<Product> products3;
	private List<ProductCollect> collects;
	private ProductDao pd;
	private Product product;
	private String saleTop="monthSale";
	private String praiseTop="praise";
	private String priceTop="price";
	private String sortType="DESC";
	private String sortType2="ASC";
	
	public ProductQueryTopAction(){}

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
	
	public List<Product> getProducts2() {
		return products2;
	}

	public void setProducts2(List<Product> products2) {
		this.products2 = products2;
	}
	
	public List<Product> getProducts3() {
		return products3;
	}

	public void setProducts3(List<Product> products3) {
		this.products3 = products3;
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
	
	public List<ProductCollect> getCollects() {
		return collects;
	}

	public void setCollects(List<ProductCollect> collects) {
		this.collects = collects;
	}

	public String getPriceTop() {
		return priceTop;
	}

	public void setPriceTop(String priceTop) {
		this.priceTop = priceTop;
	}

	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		if(c!=null){
			collects=pd.queryCollect(c.getId(), 1, 5);
			m.put("collects", collects);
		}
		products=pd.queryTopSix(saleTop,sortType);
		products2=pd.queryTopSix(praiseTop,sortType);
		products3=pd.queryTopSix(priceTop, sortType2);
		if(products.size()>0 && products2.size()>0 && products3.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
