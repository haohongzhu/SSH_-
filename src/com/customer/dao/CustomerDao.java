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
	
	//�û�ע��
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
	
	//����û����Ƿ����
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
	
	//������ǰ��¼�û���������û����Ƿ����
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
	
	//�û���¼
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
	
	//�޸�����
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
	
	//��ѯ��ǰ��¼�û�����Ϣ
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
	
	//�޸ĸ�����Ϣ
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
	
	//��ӹ˿�����
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
	
	//����ջ���ַ
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
	
	//��ѯ��ǰ��¼�û����ջ���ַ
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
	
	//�����ջ���������ѯ�ջ���ַ
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
	
	//ɾ����ǰ�û����ջ���ַ
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
	
	//��ѯָ��ID���ջ���ַ
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
	
	//����ID�����ջ���ַ
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
	
	//��ҳ��ѯ�ջ���ַ
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
	
	//��ѯ��¼�û�������
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
