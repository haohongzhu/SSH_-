package com.order.action;

import java.util.List;
import java.util.Map;

import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.order.dao.OrderDao;
import com.order.models.ShoppingCart;
import com.order.models.ShoppingCartInf;
import com.product.models.Product;

public class ShoppingCartAction extends ActionSupport{
	private OrderDao od;
	private List<ShoppingCart> cartList;
	private ShoppingCart cart;
	private List<ShoppingCartInf> cartInfList;
	private ShoppingCartInf cartInf;
	private int totalCount;
	private double totalPrice;
	private String add="sci.productCount+1";
	private String reduce="sci.productCount-1";
	private int cartID;
	private int pid;
	private int id;
	private String type1="id";
	private String type2="cartID";
	private final int pageSize=10;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;	
	
	public ShoppingCartAction(){}

	public OrderDao getOd() {
		return od;
	}

	public void setOd(OrderDao od) {
		this.od = od;
	}

	public List<ShoppingCart> getCartList() {
		return cartList;
	}

	public void setCartList(List<ShoppingCart> cartList) {
		this.cartList = cartList;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public List<ShoppingCartInf> getCartInfList() {
		return cartInfList;
	}

	public void setCartInfList(List<ShoppingCartInf> cartInfList) {
		this.cartInfList = cartInfList;
	}

	public ShoppingCartInf getCartInf() {
		return cartInf;
	}

	public void setCartInf(ShoppingCartInf cartInf) {
		this.cartInf = cartInf;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getReduce() {
		return reduce;
	}

	public void setReduce(String reduce) {
		this.reduce = reduce;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	//添加购物车与商品
	public String execute(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		Product p=(Product)m.get("nowProduct");
		cartList=od.queryCart(c.getId());
		if(cartList.size()<1){
			od.addCart(c);
			cartList=od.queryCart(c.getId());
			cart=cartList.get(0);
		}
		cart=cartList.get(0);
		cartInfList=od.queryNowProduct(p.getId(),cart.getId());
		if(cartInfList.size()>0){
			cartInf=cartInfList.get(0);
			od.updateCartInf(add,(cartInf.getProductCount()+1)*cartInf.getProductID4().getPrice(),cartInf.getId());
		}else{
			od.addCartProduct(cart, p, 1, p.getPrice());	
		}
		cartInfList=od.queryCartProduct(cart.getId());
		for(ShoppingCartInf cartInf:cartInfList){
			totalCount+=cartInf.getProductCount();
			totalPrice+=cartInf.getOneProductPrice();
		}
		od.updateCart(totalCount, totalPrice, cart.getId());
		cart=od.queryCart(c.getId()).get(0);
		m.put("nowCart", cart);
		m.put("nowCartInf", cartInfList);
		return SUCCESS;
	}
	
	//购物车指定商品数量减1
	public String reduce(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		cartInfList=(List<ShoppingCartInf>)m.get("nowCartInf");
		cart=od.queryCart(c.getId()).get(0);
		cartInf=od.queryNowProduct(pid, cartID).get(0);
		if(cartInf.getProductCount()==1){
			od.deleteCartInf(type1,id);
		}else{
			od.updateCartInf(reduce, (cartInf.getProductCount()-1)*cartInf.getProductID4().getPrice(),cartInf.getId());
		}
		cartInfList=od.queryCartProduct(cart.getId());
		for(ShoppingCartInf cartInf:cartInfList){
			totalCount+=cartInf.getProductCount();
			totalPrice+=cartInf.getOneProductPrice();
		}
		od.updateCart(totalCount, totalPrice, cart.getId());
		return SUCCESS;
	}
	
	//购物车指定商品数量加1
	public String add(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		cartInfList=(List<ShoppingCartInf>)m.get("nowCartInf");
		cart=od.queryCart(c.getId()).get(0);
		cartInf=od.queryNowProduct(pid, cartID).get(0);
		od.updateCartInf(add, (cartInf.getProductCount()+1)*cartInf.getProductID4().getPrice(),cartInf.getId());
		cartInfList=od.queryCartProduct(cart.getId());
		for(ShoppingCartInf cartInf:cartInfList){
			totalCount+=cartInf.getProductCount();
			totalPrice+=cartInf.getOneProductPrice();
		}
		od.updateCart(totalCount, totalPrice, cart.getId());
		return SUCCESS;
	}
	
	//分页查询购物车商品信息
	public String queryCart(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		cartList=od.queryCart(c.getId());
		if(cartList.size()>0){
			cart=cartList.get(0);
		}else{
			return INPUT;
		}
		if(od.queryCartProduct(cart.getId()).size()>0){
			cartInfList=od.queryCartProduct(cart.getId());
		}else{
			return INPUT;
		}
		if(cartInfList.size()%pageSize==0){
			totalPage=cartInfList.size()/pageSize;
		}else{
			totalPage=cartInfList.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		cartInfList=od.queryCartByPage(cart.getId(), pageNo, pageSize);
		currentPage=pageNo;
		m.put("nowCart", cart);
		m.put("nowCartInf", cartInfList);
		return SUCCESS;
	}
	
	//查询购物车所有商品信息
	public String queryCartNoByPage(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		cart=od.queryCart(c.getId()).get(0);
		cartInfList=od.queryCartByPage(cart.getId(), 1, 50);
		m.put("nowCart", cart);
		m.put("nowCartInf", cartInfList);
		return SUCCESS;
	}
	
	//删除指定ID的购物车商品信息
	public String deleteOneInf(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		cart=od.queryCart(c.getId()).get(0);
		od.deleteCartInf(type1, id);
		cartInfList=od.queryCartProduct(cart.getId());
		for(ShoppingCartInf cartInf:cartInfList){
			totalCount+=cartInf.getProductCount();
			totalPrice+=cartInf.getOneProductPrice();
		}
		od.updateCart(totalCount, totalPrice, cart.getId());
		return SUCCESS;
	}
	
	//清空购物车
	public String deleteAllInf(){
		Map m=ActionContext.getContext().getSession();
		Customer c=(Customer)m.get("loginUser");
		cart=od.queryCart(c.getId()).get(0);
		od.deleteCartInf(type2, cart.getId());
		cartInfList=od.queryCartProduct(cart.getId());
		for(ShoppingCartInf cartInf:cartInfList){
			totalCount+=cartInf.getProductCount();
			totalPrice+=cartInf.getOneProductPrice();
		}
		od.updateCart(totalCount, totalPrice, cart.getId());
		return SUCCESS;
	}
}
