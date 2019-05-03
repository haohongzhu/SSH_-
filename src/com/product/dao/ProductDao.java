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
	
	//查询所有商品
	public List<Product> queryAllProduct(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Product where productState='在售'";
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
	
	//根据ID查询商品
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
	
	//查询商品类别
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
	
	//根据类型查找商品
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
	
	//根据类型分页查找商品
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
	
	//查询指定商品的评价
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
	
	//查询当前登录用户的商品评价
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
	
	//删除指定ID的商品评价
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
	
	//按排行分类查询全部商品
	public List<Product> queryByPageTop(String topName,String sortType,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Product where productState='在售' order by " +topName+" "+sortType;
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
	
	//分页查询商品评价
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
	
	//查询Top6的商品
	public List<Product> queryTopSix(String topName,String sortType){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Product where productState='在售' order by "+topName+" "+sortType;
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
	
	//查询该商品是否已加入收藏
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
	
	//查询当前登录用户的收藏
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
	
	//分页查询当前登录用户的收藏
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
	
	//将商品加入到收藏
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
	
	//将商品移除收藏
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
	
	//添加商品评价
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
	
	//更新Product表praise字段
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
	
	//根据类别和商品名称模糊查询
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
