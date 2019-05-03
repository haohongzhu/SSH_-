package com.order.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.customer.dao.CustomerDao;
import com.customer.models.ConsigneeInf;
import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.order.dao.OrderDao;
import com.order.models.Order;
import com.order.models.PaymentType;
import com.order.models.ShoppingCart;
import com.order.models.ShoppingCartInf;

public class OrderAction extends ActionSupport{
	private Order order;
	private OrderDao od;
	private CustomerDao cd;
	private ConsigneeInf conInf;
	private ShoppingCart cart;
	private List<Order> orderList;
	private List<ConsigneeInf> conInfList;
	private ShoppingCartInf cartInf;
	private List<PaymentType> payList;
	private int payment;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final int pageSize=11;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;	
	private int id;
	private String status;
	private String status1="orderStatus=\'未付款\'";
	private String status2="orderStatus=\'未接单\'";
	private String status3="orderStatus=\'已接单\'";
	private String status4="orderStatus=\'配送中\'";
	private String status5="orderStatus=\'已送达\'";
	private Map m=ActionContext.getContext().getSession();
	private Customer c=(Customer)m.get("loginUser");
	private String searchByAll;
	private List<ShoppingCartInf> cartInfList;
	public  OrderAction(){}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderDao getOd() {
		return od;
	}

	public void setOd(OrderDao od) {
		this.od = od;
	}
	
	public ConsigneeInf getConInf() {
		return conInf;
	}

	public void setConInf(ConsigneeInf conInf) {
		this.conInf = conInf;
	}
	
	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	
	
	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	public List<ConsigneeInf> getConInfList() {
		return conInfList;
	}

	public void setConInfList(List<ConsigneeInf> conInfList) {
		this.conInfList = conInfList;
	}
	
	public ShoppingCartInf getCartInf() {
		return cartInf;
	}

	public void setCartInf(ShoppingCartInf cartInf) {
		this.cartInf = cartInf;
	}
	
	public List<PaymentType> getPayList() {
		return payList;
	}

	public void setPayList(List<PaymentType> payList) {
		this.payList = payList;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	public SimpleDateFormat getDf() {
		return df;
	}

	public void setDf(SimpleDateFormat df) {
		this.df = df;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSearchByAll() {
		return searchByAll;
	}

	public void setSearchByAll(String searchByAll) {
		this.searchByAll = searchByAll;
	}
	
	public List<ShoppingCartInf> getCartInfList() {
		return cartInfList;
	}

	public void setCartInfList(List<ShoppingCartInf> cartInfList) {
		this.cartInfList = cartInfList;
	}

	//创建订单
	public String execute(){
		ConsigneeInf conInf2=(ConsigneeInf)m.get("nowConsignee");
		if(conInf2==null){
			return "no_con";
		}else{
			conInf=cd.queryConByName(conInf2.getId(), c.getId()).get(0);
		}
		cart=od.queryCart(c.getId()).get(0);
		orderList=od.queryNotOrder(c.getId());
		if(orderList.size()>0){
			return INPUT;
		}else{
			od.createOrder(cart, c, conInf, null, "未付款", order.getNote());
			return SUCCESS;
		}
	}
	
	//查询当前未付款的订单
	public String queryNoPay(){
		orderList=od.queryNotOrder(c.getId());
		if(orderList.size()<1){
			return INPUT;
		}else{
			order=od.queryNotOrder(c.getId()).get(0);
			m.put("nowOrder", order);
			return SUCCESS;
		}
	}
	
	//查询支付方式
	public String queryPayment(){
		payList=od.queryPayment();
		m.put("allPay",payList);
		return SUCCESS;
	}
	
	//支付订单
	public String payForOrder(){
		order=od.queryNotOrder(c.getId()).get(0);
		cartInfList=od.queryCartProduct(order.getOrder_cartID().getId());
		payList=od.queryPayment(payment);
		if(payList.size()>0 && cartInfList.size()>0){
			od.payForOrder(df.format(new Date()),payList.get(0), order.getOrder_cartID().getId());
			od.updateCartStatus(c);
			order=od.queryOrderById(order.getId());
			m.put("nowOrder", order);
			m.put("nowOrderStatus", order.getOrderStatus());
			m.remove("nowConsignee");
			return SUCCESS;
		}else if(payList.size()<1){
			return INPUT;
		}else{
			return "no_p";
		}
	}
	
	//查看当前登录用户的所有订单
	public String queryAllOrder(){
		orderList=od.queryAllOrder(c.getId(), 1, 100);
		if(orderList.size()<1){
			return INPUT;
		}
		if(orderList.size()%pageSize==0){
			totalPage=orderList.size()/pageSize;
		}else{
			totalPage=orderList.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		orderList=od.queryAllOrder(c.getId(), pageNo, pageSize);
		currentPage=pageNo;
		m.put("allOrder", orderList);
		return SUCCESS;
	}
	
	//查询指定ID的订单
	public String queryOrderById(){
		order=od.queryOrderById(id);
		m.put("nowOrder", order);
		m.put("nowOrderStatus", order.getOrderStatus());
		if(order.getOrderStatus().equals("未付款")){
			return INPUT;
		}else{
			return SUCCESS;
		}
	}
	
	//撤销还没支付的订单
	public String deleteOrderById(){
		Order o=(Order)m.get("nowOrder");
		od.deleteOrderByID(o.getId());
		return SUCCESS;
	}
	
	//根据订单状态查询当前登录用户的订单
	public String queryByStatus(){
		orderList=od.queryByStatus(c.getId(), status1);
		if(orderList.size()>0){
			m.put("allOrder", orderList);
			m.put("nowStatus", orderList.get(0).getOrderStatus());
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String queryByStatus2(){
		orderList=od.queryByStatus(c.getId(), status2);
		if(orderList.size()>0){
			m.put("allOrder", orderList);
			m.put("nowStatus", orderList.get(0).getOrderStatus());
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String queryByStatus3(){
		orderList=od.queryByStatus(c.getId(), status3);
		if(orderList.size()>0){
			m.put("allOrder", orderList);
			m.put("nowStatus", orderList.get(0).getOrderStatus());
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String queryByStatus4(){
		orderList=od.queryByStatus(c.getId(), status4);
		if(orderList.size()>0){
			m.put("allOrder", orderList);
			m.put("nowStatus", orderList.get(0).getOrderStatus());
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String queryByStatus5(){
		orderList=od.queryByStatus(c.getId(), status5);
		if(orderList.size()>0){
			m.put("allOrder", orderList);
			m.put("nowStatus", orderList.get(0).getOrderStatus());
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
	//根据其他条件查询订单
	public String queryByAll(){
		orderList=od.queryOrderByAll(c.getId(), searchByAll);
		if(searchByAll.indexOf(" ")!=-1 || searchByAll.length()==0){
			return INPUT;
		}else if(orderList.size()>0){
			m.put("allOrder", orderList);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
