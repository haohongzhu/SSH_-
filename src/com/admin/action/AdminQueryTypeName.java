package com.admin.action;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.jgroups.tests.adaptjms.Request;
import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.Product;
import com.product.models.ProductType;

public class AdminQueryTypeName extends ActionSupport{
	private List<ProductType> productTypes;
	private Product product;
	private String obj;
	private int id;
	private String addPro_obj;
	private AdminDao ad;
	
	public List<ProductType> getProductTypes() {
		return productTypes;
	}
	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}
	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	
	public String getAddPro_obj() {
		return addPro_obj;
	}
	public void setAddPro_obj(String addPro_obj) {
		this.addPro_obj = addPro_obj;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String updatePro(){
		try{
			addPro_obj = URLDecoder.decode(addPro_obj , "utf-8");
		}catch(Exception e){
	        e.printStackTrace();
		}
		productTypes=ad.QueryProductTypeName(addPro_obj);
		if(productTypes!=null){
			Map session=ActionContext.getContext().getSession();
			Product c=(Product)session.get("productid");
			product=ad.queryProById(c.getId());
			session.put("typeName", productTypes);
			session.put("typemethod",addPro_obj);
			System.out.println(addPro_obj+"[[[[[[[[[[[[");
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String execute(){
		try{
			obj = URLDecoder.decode(obj , "utf-8");
		}catch(Exception e){
	        e.printStackTrace();
		}
		productTypes=ad.QueryProductTypeName(obj);
		if(productTypes!=null){
			Map session=ActionContext.getContext().getSession();
			session.put("typeName", productTypes);
			session.put("typemethod",obj);
			return SUCCESS;
		}else{
			return INPUT;
		}

	}
}
