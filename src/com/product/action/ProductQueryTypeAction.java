package com.product.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.ProductType;

public class ProductQueryTypeAction extends ActionSupport{
	private List<ProductType> pt;
	private List<ProductType> pt2;
	private ProductDao pd;
	private String typeMethod="地区";
	private String typeMethod2="类型";
	private Map m=ActionContext.getContext().getSession();
	
	public ProductQueryTypeAction(){}

	public List<ProductType> getPt() {
		return pt;
	}

	public void setPt(List<ProductType> pt) {
		this.pt = pt;
	}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}
	
	public List<ProductType> getPt2() {
		return pt2;
	}

	public void setPt2(List<ProductType> pt2) {
		this.pt2 = pt2;
	}

	public String getTypeMethod() {
		return typeMethod;
	}

	public void setTypeMethod(String typeMethod) {
		this.typeMethod = typeMethod;
	}

	public String getTypeMethod2() {
		return typeMethod2;
	}

	public void setTypeMethod2(String typeMethod2) {
		this.typeMethod2 = typeMethod2;
	}

	public String execute(){
		pt=pd.queryType(typeMethod);
		if(pt.size()>0){
			m.put("type1", pt);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String queryType(){
		pt2=pd.queryType(typeMethod2);
		if(pt2.size()>0){
			m.put("type2", pt2);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}
