package com.admin.action;

import java.util.List;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.Product;

public class AdminQueryProAll extends ActionSupport{
	private Product product;
	private AdminDao ad;
	private List<Product> products;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=10; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String execute() throws Exception{
		//����������ݣ��õ����ݵ��ܸ���
		products=ad.queryProduct();
			//������ҳ��
		if(products.size()%pageSize==0){
			totalPage=products.size()/pageSize;
		}else{
			totalPage=products.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		products=ad.queryProByPage(pageNo, pageSize);
		//���õ�ǰҳ
		currentPage=pageNo;
		if(products!=null)
			return SUCCESS;
		else
			return INPUT;
	}
	
	
}
