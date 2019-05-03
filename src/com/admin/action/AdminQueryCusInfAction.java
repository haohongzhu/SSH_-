package com.admin.action;

import java.util.List;

import com.admin.dao.AdminDao;
import com.customer.models.Customer;
import com.customer.models.CustomerWords;
import com.opensymphony.xwork2.ActionSupport;

public class AdminQueryCusInfAction extends ActionSupport{
	AdminDao ad;	
	List<Customer> customerWords; //�־û��༯��
	private String realName;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=5; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	public List<Customer> getCustomerWords() {
		return customerWords;
	}
	public void setCustomerWords(List<Customer> customerWords) {
		this.customerWords = customerWords;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
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
	
	public String execute()throws Exception{
		//����������ݣ��õ����ݵ��ܸ���
		customerWords=ad.queryUsers();
		//������ҳ��
		if(customerWords.size()%pageSize==0){
			totalPage=customerWords.size()/pageSize;
		}else{
			totalPage=customerWords.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		customerWords=ad.queryByPage(pageNo,pageSize);
		//���õ�ǰҳ
		currentPage=pageNo;
		if(customerWords!=null)
			return SUCCESS;
		else
			return INPUT;
	}
}
