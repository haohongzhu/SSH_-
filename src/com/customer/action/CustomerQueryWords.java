package com.customer.action;

import java.util.List;
import java.util.Map;

import com.customer.dao.CustomerDao;
import com.customer.models.Customer;
import com.customer.models.CustomerWords;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerQueryWords extends ActionSupport{
	private CustomerDao cd;
	private List<CustomerWords> wordsList;
	private final int pageSize=4;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;
	private int id;
	
	private CustomerQueryWords(){}

	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public List<CustomerWords> getWordsList() {
		return wordsList;
	}

	public void setWordsList(List<CustomerWords> wordsList) {
		this.wordsList = wordsList;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		wordsList=cd.queryAllWords(c, 1, 5000);
		if(wordsList.size()%pageSize==0){
			totalPage=wordsList.size()/pageSize;
		}else{
			totalPage=wordsList.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		wordsList=cd.queryAllWords(c, pageNo, pageSize);
		m.put("all_words", wordsList);
		currentPage=pageNo;
		return SUCCESS;
	}
}
