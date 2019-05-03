package com.product.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;
import com.product.models.ProductEvaluate;

public class ProductAddEvaluateAtion extends ActionSupport {
	private ProductEvaluate pe;
	private ProductDao pd;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public ProductAddEvaluateAtion(){}

	public ProductEvaluate getPe() {
		return pe;
	}

	public void setPe(ProductEvaluate pe) {
		this.pe = pe;
	}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}
	
	public void validate(){
		if(pe.getEvaluate().length()==0 || pe.getEvaluate()==null){
			this.addFieldError("pe1","*评价不能为空！");
		}
	}
	
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		Product p=(Product)m.get("nowProduct");
		if(pd.addProductEvaluate(c, p, pe,df.format(new Date()))>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
