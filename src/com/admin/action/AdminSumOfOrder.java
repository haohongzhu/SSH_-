package com.admin.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.order.models.ShoppingCartInf;
import com.product.models.Product;

public class AdminSumOfOrder extends ActionSupport{
	private AdminDao ad;
	private String sumPrice;
	private String sumCount;
	private String orderCount;
	private String sumType1="SUM(sc.totalPrice)";
	private String sumType2="SUM(sc.totalCount)";
	private String sumType3="COUNT(*)";
	private String startTime;
	private String endTime;
	private List<Integer> oneProductCount;
	private List<Integer> infList;
	private List<Double> oneProductPrice;
	private String type1="SUM(sci.productCount)";
	private String type2="distinct sci.productID";
	private String type3="SUM(sci.oneProductPrice)";
	private Product p;
	private int id;
	private Map m=ActionContext.getContext().getSession();
	private final int pageSize=11;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;	

	
	public AdminSumOfOrder(){}

	
	public AdminDao getAd() {
		return ad;
	}


	public void setAd(AdminDao ad) {
		this.ad = ad;
	}


	public String getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}

	public String getSumCount() {
		return sumCount;
	}

	public void setSumCount(String sumCount) {
		this.sumCount = sumCount;
	}

	public String getSumType1() {
		return sumType1;
	}

	public void setSumType1(String sumType1) {
		this.sumType1 = sumType1;
	}

	public String getSumType2() {
		return sumType2;
	}

	public void setSumType2(String sumType2) {
		this.sumType2 = sumType2;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public List<Integer> getOneProductCount() {
		return oneProductCount;
	}

	public void setOneProductCount(List<Integer> oneProductCount) {
		this.oneProductCount = oneProductCount;
	}

	public List<Integer> getInfList() {
		return infList;
	}

	public void setInfList(List<Integer> infList) {
		this.infList = infList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Double> getOneProductPrice() {
		return oneProductPrice;
	}

	public void setOneProductPrice(List<Double> oneProductPrice) {
		this.oneProductPrice = oneProductPrice;
	}
	
	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getType3() {
		return type3;
	}

	public void setType3(String type3) {
		this.type3 = type3;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public Map getM() {
		return m;
	}

	public void setM(Map m) {
		this.m = m;
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

	public String getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	public String getSumType3() {
		return sumType3;
	}

	public void setSumType3(String sumType3) {
		this.sumType3 = sumType3;
	}

	public void validate(){
		if(!(startTime.matches("\\d{4}-\\d{2}-\\d{2}")) || !(endTime.matches("\\d{4}-\\d{2}-\\d{2}"))){
			this.addFieldError("dateError！", "日期格式错误");
		}
	}
	
	public String execute(){
		if(endTime.length()!=0 && startTime.length()!=0){
			m.put("startTime", startTime);
			m.put("endTime", endTime);
		}
		if(ad.querySumOrder(sumType1,startTime,endTime)==null || ad.querySumOrder(sumType2,startTime,endTime)==null){
			return "failed";
		}else{
			orderCount=ad.querySumOrder(sumType3, startTime, endTime);
			sumPrice=ad.querySumOrder(sumType1,startTime,endTime);
			sumCount=ad.querySumOrder(sumType2,startTime,endTime);
			oneProductCount=ad.queryCountOrder(type1,startTime,endTime,1,9999);
			oneProductPrice=ad.queryCountOrder(type3, startTime, endTime,1,9999);
			infList=ad.queryCountOrder(type2,startTime,endTime,1,9999);
			m.put("p_count", infList.size());
			if(infList.size()%pageSize==0){
				totalPage=infList.size()/pageSize;
			}else{
				totalPage=infList.size()/pageSize+1;
			}
			if(pageNo<=0){
				pageNo=1;
			}else if(pageNo>totalPage){
				pageNo=totalPage;
			}
			infList=ad.queryCountOrder(type2,startTime,endTime,pageNo,pageSize);
			oneProductCount=ad.queryCountOrder(type1,startTime,endTime,pageNo,pageSize);
			oneProductPrice=ad.queryCountOrder(type3, startTime, endTime,pageNo,pageSize);
			currentPage=pageNo;
			return SUCCESS;
		}
	}
	
	public String queryP(){
		p=ad.queryProById(id);
		m.put("now_P", p);
		return null;
	}
}



