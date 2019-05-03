package com.admin.action;
import java.util.List;

import com.admin.dao.AdminDao;
import com.customer.models.Customer;
import com.customer.models.CustomerWords;
import com.opensymphony.xwork2.ActionSupport;
public class AdminQueryAllAction extends ActionSupport{
	AdminDao ad;	
	List<CustomerWords> customerWords; //�־û��༯��
	private CustomerWords customerWord;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=10; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������,�ӵ�1ҳ��ʼ��ʾ
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	
	public AdminQueryAllAction(){
		
	}
	
	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	public List<CustomerWords> getCustomerWords() {
		return customerWords;
	}

	public void setCustomerWords(List<CustomerWords> customerWords) {
		this.customerWords = customerWords;
	}

	public CustomerWords getCustomerWord() {
		return customerWord;
	}

	public void setCustomerWord(CustomerWords customerWord) {
		this.customerWord = customerWord;
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
		customerWords=ad.queryCustomerWord();
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
		customerWords=ad.queryByPageWord(pageNo,pageSize);
		System.out.println(customerWords.size());
		//���õ�ǰҳ
		currentPage=pageNo;
		if(customerWords!=null)
			return SUCCESS;
		else
			return INPUT;
	}
}
