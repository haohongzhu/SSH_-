package com.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;

public class ProductQueryByNameAndType extends ActionSupport{
	private List<Product> products;
	private ProductDao pd;
	private Product product;
	private String search;
	
	public ProductQueryByNameAndType(){}
	
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
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String execute(){
		products=pd.queryProductByName(search);
		if(search.indexOf(" ")!=-1 || search.length()==0){
			return INPUT;
		}else if (products!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
