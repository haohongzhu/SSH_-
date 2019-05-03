package com.admin.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.Product;
import com.product.models.ProductClass;
import com.product.models.ProductType;

public class AdminQueryProById extends ActionSupport{
	private AdminDao ad;
	private int id;
	private Product product;
	private String obj;
	private String typeMethod;
	private ProductType productType;
	private ProductClass productClass;
	private List<ProductType> productTypes;
	private List<ProductClass> productClasses;

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getTypeMethod() {
		return typeMethod;
	}

	public void setTypeMethod(String typeMethod) {
		this.typeMethod = typeMethod;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductClass getProductClass() {
		return productClass;
	}

	public void setProductClass(ProductClass productClass) {
		this.productClass = productClass;
	}

	public List<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public List<ProductClass> getProductClasses() {
		return productClasses;
	}

	public void setProductClasses(List<ProductClass> productClasses) {
		this.productClasses = productClasses;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String execute(){
		Map session=ActionContext.getContext().getSession();
		if(ad.queryProById(id)!=null){
			//获取当前产品
			product=ad.queryProById(id);
			System.out.println(id+"!!!!!!!!!!!!");
			//获取当前产品所在的productClass行
			productClasses=ad.QueryProductTypeByPro(product);
			//获取当前产品的ProductType
			session.put("productid", product);
			session.put("nowproductClass", productClasses);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
