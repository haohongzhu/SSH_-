package com.product.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.customer.models.Customer;
import com.product.models.Product;
import com.product.models.ProductClass;
import com.product.models.ProductCollect;
import com.product.models.ProductEvaluate;
import com.product.models.ProductType;

public class ProductDao {
	SessionFactory sessionFactory;
	
	public ProductDao(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//��ѯ������Ʒ
	public List<Product> queryAllProduct(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Product where productState='����'";
			Query query=session.createQuery(hql);
			List<Product> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//����ID��ѯ��Ʒ
	public Product queryProById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Product product=(Product)session.get(Product.class, id);
			return product;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//��ѯ��Ʒ���
	public List<ProductType> queryType(String typeMethod){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ProductType where typeMethod=? order by id";
			Query query=session.createQuery(hql);
			query.setParameter(0, typeMethod);
			List<ProductType> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//�������Ͳ�����Ʒ
	public List<ProductClass> queryByType(int tid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ProductClass where typeName=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, tid);
			List<ProductClass> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//�������ͷ�ҳ������Ʒ
	public List<ProductClass> queryByTypeAndPage(int tid,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ProductClass where typeName=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, tid);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize); 
			List<ProductClass> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//��ѯָ����Ʒ������
	public List<ProductEvaluate> queryEvaluate(int pid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ProductEvaluate where productID=? order by id DESC";
			Query query=session.createQuery(hql);
			query.setParameter(0, pid);
			List<ProductEvaluate> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//��ѯ��ǰ��¼�û�����Ʒ����
	public List<ProductEvaluate> queryAllEva(int cid,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ProductEvaluate where customerID=? order by id DESC";
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize); 
			List<ProductEvaluate> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//ɾ��ָ��ID����Ʒ����
	public boolean deleteEvaluate(int id){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String hql="delete from ProductEvaluate where id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, id);
			transaction=session.beginTransaction();
			query.executeUpdate();
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	//�����з����ѯȫ����Ʒ
	public List<Product> queryByPageTop(String topName,String sortType,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Product where productState='����' order by " +topName+" "+sortType;
			Query query=session.createQuery(hql);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize); 
			List<Product> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//��ҳ��ѯ��Ʒ����
	public List<ProductEvaluate> queryByPage(int pid,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ProductEvaluate where productID=? order by id DESC";
			Query query=session.createQuery(hql);
			query.setParameter(0, pid);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize); 
			List<ProductEvaluate> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//��ѯTop6����Ʒ
	public List<Product> queryTopSix(String topName,String sortType){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Product where productState='����' order by "+topName+" "+sortType;
			Query query=session.createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(6); 
			List<Product> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//��ѯ����Ʒ�Ƿ��Ѽ����ղ�
	public ProductCollect checkCollect(int cid,int pid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ProductCollect where customerID=? and productID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			query.setParameter(1, pid);
			List<ProductCollect> list=query.list();
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
	
	//��ѯ��ǰ��¼�û����ղ�
	public List<ProductCollect> queryAllCollect(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ProductCollect where customerID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			List<ProductCollect> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//��ҳ��ѯ��ǰ��¼�û����ղ�
	public List<ProductCollect> queryCollect(int cid,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ProductCollect where customerID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<ProductCollect> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//����Ʒ���뵽�ղ�
	public int addProductCollect(Customer c,Product p){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			ProductCollect pc=new ProductCollect();
			pc.setCustomerID4(c);
			pc.setProductID3(p);
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(pc).toString());
			transaction.commit();
			return num;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	
	//����Ʒ�Ƴ��ղ�
	public boolean deleteCollect(int cid,int pid){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String hql="delete from ProductCollect where customerID=? and productID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, cid);
			query.setParameter(1, pid);
			transaction=session.beginTransaction();
			query.executeUpdate();
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	//�����Ʒ����
	public int addProductEvaluate(Customer c,Product p,ProductEvaluate pe,String time){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			ProductEvaluate pe2=new ProductEvaluate();
			pe2.setCustomerID3(c);
			pe2.setProductID2(p);
			pe2.setEvaluate(pe.getEvaluate());
			pe2.setDate(time);
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(pe2).toString());
			transaction.commit();
			return num;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	
	//����Product��praise�ֶ�
	public boolean updateProductPraise(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="update Product p set p.praise=p.praise+1 where id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, id);
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
	
	//����������Ʒ����ģ����ѯ
	public List<Product> queryProductByName(String search){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String sql="select distinct {p.*} from Table_Product p,Table_ProductClass pc,Table_ProductType pt " +
					"where p.id=pc.productID and pc.typeName=pt.id " +
					"and(p.productName like '%"+search+"%' or pt.typeName like '%"+search+"%')";
			Query query=session.createSQLQuery(sql).addEntity("p",Product.class);
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
}
