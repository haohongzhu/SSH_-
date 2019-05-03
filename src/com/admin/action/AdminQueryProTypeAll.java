package com.admin.action;

import java.util.List;
import java.util.Map;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.ProductType;

public class AdminQueryProTypeAll extends ActionSupport{
	private AdminDao ad;
	private List<ProductType> productType;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=17; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	
	public AdminQueryProTypeAll(){
		
	}

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public List<ProductType> getProductType() {
		return productType;
	}

	public void setProductType(List<ProductType> productType) {
		this.productType = productType;
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
	
	public String execute(){
		//����������ݣ��õ����ݵ��ܸ���
		productType=ad.queryProductClass();
		//������ҳ��
		if(productType.size()%pageSize==0){
			totalPage=productType.size()/pageSize;
		}else{
			totalPage=productType.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		productType=ad.queryProClassByPage(pageNo,pageSize);
		//���õ�ǰҳ
		currentPage=pageNo;
		if(productType!=null){
			return SUCCESS;
		}
		else
			return INPUT;
	}
	
}
