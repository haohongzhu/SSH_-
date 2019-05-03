package com.customer.dao;

import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.customer.models.ConsigneeInf;
import com.customer.models.Customer;
import com.customer.models.CustomerWords;
import com.opensymphony.xwork2.ActionContext;


public class CustomerDao {
	SessionFactory sessionFactory;
	
	public CustomerDao(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//用户注册
	public int regCustomer(Customer customer){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(customer).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//检查用户名是否存在
	public boolean isUserNameExist(Customer customer){
		Session session=null;
		boolean flag=true;
		try{
			String hql="from Customer where userName=?";
			session=sessionFactory.openSession();
			Query query=session.createQuery(hql);
			query.setParameter(0, customer.getUserName());
			List list=query.list();
			if(list.size()==0){
				flag=false;
			}
			return flag;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	//检查除当前登录用户外的其他用户名是否存在
	public boolean isUserNameExist2(Customer customer,int cid){
		Session session=null;
		boolean flag=true;
		try{
			String hql="from Customer where userName=? and id not in ?";
			session=sessionFactory.openSession();
			Query query=session.createQuery(hql);
			query.setParameter(0, customer.getUserName());
			query.setParameter(1, cid);
			List list=query.list();
			if(list.size()==0){
				flag=false;
			}
			return flag;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	//用户登录
	public Customer logCustomer(Customer customer){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Customer where userName=? and password=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, customer.getUserName());
			queryObject.setParameter(1, customer.getPassword());
			List<Customer> list=queryObject.list();
			if(list.size()==0){
				return null;
			}else{
				return list.get(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//修改密码
	public boolean ChangePwd(Customer customer,String oldPwd,String newPwd){
		boolean flag=true;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Customer where userName=? and password=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, customer.getUserName());
			query.setParameter(1, oldPwd);
			List<Customer> list=query.list();
			if(list.size()==0){
				flag=false;
			}else{
				customer=list.get(0); 
				customer.setPassword(newPwd);
				transaction=session.beginTransaction();
				session.update(customer);
				transaction.commit();
			}
			return flag;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	//查询当前登录用户的信息
	public Customer cusQueryByName(int cid){
		Session session=null;
		Transaction t=null;
		try{
			session=sessionFactory.openSession();
			t=session.beginTransaction();
			Customer customer=(Customer)session.get(Customer.class, cid);
			t.commit();
			return customer;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}				
	}
	
	//修改个人信息
	public boolean updateCustomerInf(Customer customer){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Query query=session.createQuery("Update Customer c set c.userName=?,c.realName=?,c.userTelephone=? where id=?");
			query.setParameter(0, customer.getUserName());
			query.setParameter(1, customer.getRealName());
			query.setParameter(2, customer.getUserTelephone());
			query.setParameter(3, customer.getId());
			Transaction trans=session.beginTransaction();
			query.executeUpdate();
			trans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}	
	}
	
	//添加顾客留言
	public int addCusWords(Customer customer,CustomerWords customerWords,String time){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			CustomerWords cw=new CustomerWords();
			cw.setCustomerID(customer);
			cw.setWords(customerWords.getWords());
			cw.setWordsTime(time);
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(cw).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//添加收货地址
	public int addConsigneeInf(Customer customer,ConsigneeInf consigneeInf){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			ConsigneeInf ci=new ConsigneeInf();
			ci.setCustomerID2(customer);
			ci.setConsigneeName(consigneeInf.getConsigneeName());
			ci.setSex(consigneeInf.getSex());
			ci.setAddress(consigneeInf.getAddress());
			ci.setAddressTel(consigneeInf.getAddressTel());
			ci.setDoorNum(consigneeInf.getDoorNum());
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(ci).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//查询当前登录用户的收货地址
	public List<ConsigneeInf> queryConByCid(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ConsigneeInf where customerID=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, cid);
			List<ConsigneeInf> list=queryObject.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}				
	}
	
	//根据收货人姓名查询收货地址
	public List<ConsigneeInf> queryConByName(int conID,int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ConsigneeInf where id=? and customerID=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, conID);
			queryObject.setParameter(1, cid);
			List<ConsigneeInf> list=queryObject.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//删除当前用户的收货地址
	public boolean deleteConInfById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			ConsigneeInf cf=(ConsigneeInf)session.get(ConsigneeInf.class, id);
			Transaction trans=session.beginTransaction();
			session.delete(cf);
			trans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}	
	}
	
	//查询指定ID的收货地址
	public ConsigneeInf queryUserById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			ConsigneeInf cf=(ConsigneeInf)session.get(ConsigneeInf.class, id);
			return cf;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//根据ID更新收货地址
	public boolean updateConInf(ConsigneeInf consigneeInf){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Query query=session.createQuery("Update ConsigneeInf cf set cf.consigneeName=?,cf.sex=?,cf.address=?,cf.addressTel=?,cf.doorNum=? where id=?");
			query.setParameter(0, consigneeInf.getConsigneeName());
			query.setParameter(1, consigneeInf.getSex());
			query.setParameter(2, consigneeInf.getAddress());
			query.setParameter(3, consigneeInf.getAddressTel());
			query.setParameter(4, consigneeInf.getDoorNum());
			query.setParameter(5, consigneeInf.getId());
			Transaction trans=session.beginTransaction();
			query.executeUpdate();
			trans.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}	
	}
	
	//分页查询收货地址
	public List<ConsigneeInf> queryByPage(int cid,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ConsigneeInf where customerID=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize); 
			List<ConsigneeInf> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//查询登录用户的留言
	public List<CustomerWords> queryAllWords(Customer c,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from CustomerWords where customerID=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, c);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize); 
			List<CustomerWords> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
}
