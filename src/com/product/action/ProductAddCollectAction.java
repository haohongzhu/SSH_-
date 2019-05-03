package com.product.action;

import java.util.Map;

import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;

public class ProductAddCollectAction extends ActionSupport {
	private ProductDao pd;
	
	public ProductAddCollectAction(){}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}
	
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		Product p=(Product)m.get("nowProduct");
		if(pd.addProductCollect(c, p)>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
