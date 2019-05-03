package com.product.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;

public class ProductDeleteCollectAction extends ActionSupport{
	private ProductDao pd;
	
	public ProductDeleteCollectAction(){}

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
		if(pd.deleteCollect(c.getId(), p.getId())){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			if(session.getAttribute("productCollect") != null){
				session.removeAttribute("productCollect");
			}
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}
