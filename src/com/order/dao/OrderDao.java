package com.order.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.customer.models.ConsigneeInf;
import com.customer.models.Customer;
import com.order.models.Order;
import com.order.models.PaymentType;
import com.order.models.ShoppingCart;
import com.order.models.ShoppingCartInf;
import com.product.models.Product;

public class OrderDao {
	SessionFactory sessionFactory;
	
	public OrderDao(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* ���ﳵ��ɾ�Ĳ� */
	//��ѯ��¼�û��Ƿ�������ʹ�õĹ��ﳵ
	public List<ShoppingCart> queryCart(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ShoppingCart where customerID=? and cartStatus='����ʹ��'";
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			List<ShoppingCart> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//Ϊ��¼�û���ӹ��ﳵ
	public int addCart(Customer customerID){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			ShoppingCart cart=new ShoppingCart();
			cart.setCustomerID5(customerID);
			cart.setCartStatus("����ʹ��");
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(cart).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//��ѯ���ﳵ���Ƿ�����Ʒ
	public List<ShoppingCartInf> queryCartProduct(int cartID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ShoppingCartInf where cartID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, cartID);
			List<ShoppingCartInf> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//��ҳ��ѯ���ﳵ��Ϣ
	public List<ShoppingCartInf> queryCartByPage(int cartID,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ShoppingCartInf where cartID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, cartID);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<ShoppingCartInf> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//���¹��ﳵ��Ϣ
	public void updateCart(int totalCount,double totalPrice,int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="update ShoppingCart sc set sc.totalCount=?,sc.totalPrice=? where id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, totalCount);
			query.setParameter(1, totalPrice);
			query.setParameter(2, id);
			Transaction trans=session.beginTransaction();
			query.executeUpdate();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();

		}finally{
			session.close();
		}	
	}
	
	
	//��ѯ��ǰ��Ʒ�ڹ��ﳵ���Ƿ����
	public List<ShoppingCartInf> queryNowProduct(int pid,int cartID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ShoppingCartInf where productID=? and cartID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, pid);
			query.setParameter(1, cartID);
			List<ShoppingCartInf> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//�ڹ��ﳵ�����Ʒ
	public int addCartProduct(ShoppingCart cart,Product productID,int count,double oneProductPrice){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			ShoppingCartInf cartInf=new ShoppingCartInf();
			cartInf.setShoppingCart(cart);
			cartInf.setProductID4(productID);
			cartInf.setProductCount(count);
			cartInf.setOneProductPrice(oneProductPrice);
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(cartInf).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//���¹��ﳵ��Ʒ��Ϣ
	public void updateCartInf(String AddOrReduce,double oneProductPrice,int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="update ShoppingCartInf sci set sci.productCount="+AddOrReduce+",sci.oneProductPrice=? where id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, oneProductPrice);
			query.setParameter(1, id);
			Transaction trans=session.beginTransaction();
			query.executeUpdate();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();

		}finally{
			session.close();
		}	
	}
	
	//ɾ�����ﳵ��Ʒ��Ϣ
	public void deleteCartInf(String type,int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="delete from ShoppingCartInf where "+type+"=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, id);
			Transaction trans=session.beginTransaction();
			query.executeUpdate();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	
	
	
	
	
	/* ������ɾ�Ĳ� */
	//��������
	public int createOrder(ShoppingCart order_cartID,Customer order_customer,
						   ConsigneeInf order_consignee,String orderTime,
						   String orderStatus,String note){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			Order o=new Order();
			o.setOrder_cartID(order_cartID);
			o.setOrder_customer(order_customer);
			o.setOrder_consignee(order_consignee);
			o.setOrderTime(orderTime);
			o.setOrderStatus(orderStatus);
			o.setNote(note);
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(o).toString());
			transaction.commit();
			return num;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	
	//��ѯ�Ƿ���δ����Ķ���
	public List<Order> queryNotOrder(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Order where customer=? and orderStatus='δ����'";
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			List<Order> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	//֧������
	public void payForOrder(String orderTime,PaymentType paymentID,int cartID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="update Order o set o.orderTime=?,o.order_payment=?,o.orderStatus='δ�ӵ�' where cartID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, orderTime);
			query.setParameter(1, paymentID);
			query.setParameter(2, cartID);
			Transaction trans=session.beginTransaction();
			query.executeUpdate();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	//��ѯ֧����ʽ
	public List<PaymentType> queryPayment(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from PaymentType";
			Query query=session.createQuery(hql);
			List<PaymentType> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//����ID��ѯ֧����ʽ
	public List<PaymentType> queryPayment(int paymentID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from PaymentType where id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, paymentID);
			List<PaymentType> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//֧��������ʹ�õĹ��ﳵ����Ϊʹ�����
	public void updateCartStatus(Customer cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="update ShoppingCart sc set sc.cartStatus='ʹ�����' where sc.customerID5=? and sc.cartStatus='����ʹ��'";
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			Transaction trans=session.beginTransaction();
			query.executeUpdate();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	//��ѯ��¼�û������ж���
	public List<Order> queryAllOrder(int cid,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Order where customer=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<Order> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//����ָ��ID��ѯ��¼�û��Ķ���
	public Order queryOrderById(int id){
		Session session=null;
		Transaction t=null;
		try{
			session=sessionFactory.openSession();
			t=session.beginTransaction();
			Order order=(Order)session.get(Order.class, id);
			t.commit();
			return order;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}				
	}
	
	//��������
	public void deleteOrderByID(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="delete from Order where id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, id);
			Transaction trans=session.beginTransaction();
			query.executeUpdate();
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	//���ݶ���״̬���ҵ�ǰ��¼�û��Ķ���
	public List<Order> queryByStatus(int cid,String orderStatus){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Order where customer=? and "+orderStatus;
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			List<Order> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//ģ����ѯ����
	public List<Order> queryOrderByAll(int cid,String searchByAll){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String sql="select distinct {o.*} " +
					"from Table_Order o,Table_Customer c,Table_ConsigneeInf ci " +
					"where o.customer=c.id and o.consignee=ci.id and o.customer=? and " +
					"(o.id like '%"+searchByAll+"%' or ci.consigneeName like '%"+searchByAll+"%' " +
					"or o.orderTime like '%"+searchByAll+"%' or o.orderStatus like '%"+searchByAll+"%')";	
			Query query=session.createSQLQuery(sql).addEntity("o",Order.class);
			query.setParameter(0, cid);
			List<Order> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

}
