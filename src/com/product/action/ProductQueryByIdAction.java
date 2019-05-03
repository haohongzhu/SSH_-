package com.product.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.dao.ProductDao;
import com.product.models.Product;
import com.product.models.ProductClass;
import com.product.models.ProductCollect;
import com.product.models.ProductEvaluate;
import com.product.models.ProductType;

public class ProductQueryByIdAction extends ActionSupport{
	private Product product;
	private ProductCollect pc;
	private ProductDao pd;
	private int id;
	private List<ProductEvaluate> pes;
	private ProductEvaluate pe;
	private final int pageSize=4;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;
	
	public ProductQueryByIdAction(){}

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

	public ProductCollect getPc() {
		return pc;
	}

	public void setPc(ProductCollect pc) {
		this.pc = pc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<ProductEvaluate> getPes() {
		return pes;
	}

	public void setPes(List<ProductEvaluate> pes) {
		this.pes = pes;
	}

	public ProductEvaluate getPe() {
		return pe;
	}

	public void setPe(ProductEvaluate pe) {
		this.pe = pe;
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
		product=pd.queryProById(id);
		if(product!=null){
			Set type=product.getProductClass();
			m.put("type", type); 
			m.put("nowProduct", product);
			Customer c=(Customer)m.get("loginUser");
			Product p=(Product)m.get("nowProduct");
			if(c!=null){
				pc=pd.checkCollect(c.getId(),p.getId());
				if(pc!=null){
					m.put("productCollect", pc);
				}
			}
			pes=pd.queryEvaluate(p.getId());
			if(pes.size()%pageSize==0){
				totalPage=pes.size()/pageSize;
			}else{
				totalPage=pes.size()/pageSize+1;
			}
			if(pageNo<=0){
				pageNo=1;
			}else if(pageNo>totalPage){
				pageNo=totalPage;
			}
			pes=pd.queryByPage(p.getId(), pageNo, pageSize);
			m.put("pes_session", pes);
			currentPage=pageNo;
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}
