package com.product.action;

import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;

public class ProductUpdatePraiseAction extends ActionSupport{
	private Product product;
	private ProductDao pd;
	
	public ProductUpdatePraiseAction(){}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}
	
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		product=(Product)m.get("nowProduct");
		if(pd.updateProductPraise(product.getId())){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
