package com.admin.action;

import java.util.List;
import com.admin.dao.AdminDao;
import com.customer.models.Customer;
import com.customer.models.CustomerWords;
import com.opensymphony.xwork2.ActionSupport;

public class AdminQueryByNameAction extends ActionSupport{
	AdminDao ad;	
	List<CustomerWords> customerWords; //持久化类集合
	private CustomerWords customerWord;
	private String realName;
	private int id; //界面显示数据的索引
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数
	
	public AdminQueryByNameAction(){
		
	}
	
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
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
	public String execute()throws Exception{
		//获得所有数据，得到数据的总个数
		customerWords=ad.queryCusWordByName(realName);
		if(customerWords==null||"".equals(customerWords)){
			return "failed";
		}else{
		//计算总页数
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
		//根据当前页查询要在该页上显示的数据
		customerWords=ad.queryCusWordByPageByName(realName,pageNo,pageSize);
		//设置当前页
		currentPage=pageNo;
		if(customerWords!=null)
			return SUCCESS;
		else
			return INPUT;
		}
	}
}
