package com.admin.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.admin.models.Admin;
import com.admin.models.Role;
import com.customer.models.Customer;
import com.customer.models.CustomerWords;
import com.order.models.Order;
import com.product.models.Product;
import com.product.models.ProductClass;
import com.product.models.ProductEvaluate;
import com.product.models.ProductType;

public class AdminDao {
	SessionFactory sessionFactory;
	
	public AdminDao(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//验证用户登录	
	public Admin checkLogin(Admin admin){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="from Admin where adminID=? and adminPassword=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			//设置参数,?的序号从0开始
			query.setParameter(0, admin.getAdminID());
			query.setParameter(1, admin.getAdminPassword());
			//执行查询
			List<Admin> list=query.list();
			if(list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//查询登录密码
	public List<Admin> queryAdminByID(Admin admin){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="select adminPassword from Admin where adminID=?";
			//创建查询
			Query query=session.createQuery(queryString);
			query.setParameter(0, admin.getAdminID());
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	
	//查询所有前台用户,返回的是持久化类集合对象
	public List<Customer> queryUsers(){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql语句,Users代表是models里的实体类,name和password代表实体类的属性
			String queryString="from Customer order by id ASC";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	
	//查询所有后台用户,返回的是持久化类集合对象
	public List<Admin> queryAdminUsers(){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql语句,Users代表是models里的实体类,name和password代表实体类的属性
			String queryString="from Admin";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	
	//查询每页需要显示的数据
	public List<Customer> queryByPage(int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Customer";
			Query query=session.createQuery(queryString);
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 

			//每次最多5条记录
			List<Customer> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//根据姓名查询用户留言
	public List<Customer> queryUsersByName(){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql语句,Users代表是models里的实体类,name和password代表实体类的属性
			String queryString="from Customer where realName=? order by id ASC";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	
	//查询每页需要显示的数据
	public List<Customer> queryByPageByName(String realName,int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Customer where realName like'%"+realName+"%'";
			Query query=session.createQuery(queryString);
			
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 

			//每次最多5条记录
			List<Customer> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	//删除用户留言
	public boolean deleteCustomerWords(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			CustomerWords customerWords=(CustomerWords)session.get(CustomerWords.class,id);
			//删除user数据
			Transaction trans=session.beginTransaction();
			session.delete(customerWords);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	//删除用户
	public boolean deleteAdminById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			Admin admin=(Admin)session.get(Admin.class,id);
			//删除user数据
			Transaction trans=session.beginTransaction();
			session.delete(admin);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	//删除用户信息
	public boolean deleteCustomerInf(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			Customer customer=(Customer)session.get(Customer.class,id);
			//删除user数据
			Transaction trans=session.beginTransaction();
			session.delete(customer);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//查询管理员信息,返回的是持久化类集合对象
	public Admin queryAdminById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			Admin admin=(Admin)session.get(Admin.class, id);
			return admin;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//修改管理员信息
	public boolean updateAdmin(Admin admin,Role role){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update Admin set adminRealName=?,telephone=?,telephonep=?,qq=?,wechat=?,email=?,role=? where id=?";
			//创建查询
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, admin.getAdminRealName().trim());
			queryObject.setParameter(1, admin.getTelephone().trim());
			queryObject.setParameter(2, admin.getTelephonep().trim());
			queryObject.setParameter(3, admin.getQq().trim());
			queryObject.setParameter(4, admin.getWechat().trim());
			queryObject.setParameter(5, admin.getEmail().trim());
			queryObject.setParameter(6, role);
			queryObject.setParameter(7, admin.getId());
			Transaction trans=session.beginTransaction();
			
			queryObject.executeUpdate();
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	
	//查询全部角色
	public List<Role> QueryRole(){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="from Role";
			//获得Query对象
			Query query=session.createQuery(hql);
			//执行查询
			List<Role> list=query.list();
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//查询当前角色
	public Role queryRoleById(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			Role role=(Role)session.get(Role.class, cid);
			return role;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//修改密码
	public boolean changePassword(Admin admin,String oldpwd,String newpwd){
		boolean flag=true;
		//得到session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			//hql语句
			String queryString="from Admin where adminID=? and adminPassword=?";
			//创建查询
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, admin.getAdminID());
			queryObject.setParameter(1, oldpwd);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List<Admin> list=queryObject.list();
			if(list.size()==0){
				flag=false;//旧密码错误
			}else{
				admin=list.get(0); //找到要修改密码的用户对象
				admin.setAdminPassword(newpwd);
				transaction=session.beginTransaction();
				session.update(admin);//在缓存中保存数据，受影响行数
				transaction.commit();//写入数据库表
			}
			return flag;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}
	}
	
	//添加商品的方法
	public int addproduct(Product product,String uploadFileName){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			Product pd=new Product();
			pd.setProductName(product.getProductName());
			pd.setMonthSale(product.getMonthSale());
			pd.setDescription(product.getDescription());
			pd.setPraise(product.getPraise());
			pd.setPrice(product.getPrice());
			pd.setImg(uploadFileName);
			pd.setProductState(product.getProductState());
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(pd).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//查询上一条添加商品信息
	public Product queryAdded(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			Product product=(Product)session.get(Product.class, cid);
			return product;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//添加商品分类的方法
	public int addproductClass(Product product,ProductType productType){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			ProductClass pd=new ProductClass();
			pd.setProductID(product);
			pd.setTypeName2(productType);
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(pd).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//根据子类查询产品种类两列
	public ProductType QueryProductType(String typeName){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="from ProductType where typeName=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			query.setParameter(0,typeName);
			//执行查询
			List<ProductType> list=query.list();
			if(list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//查询产品父类
	public List<ProductType> QueryProductTypeMethod(){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="select distinct typeMethod from ProductType";
			//获得Query对象
			Query query=session.createQuery(hql);
			//执行查询
			List<ProductType> list=query.list();
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//查询产品子类
	public List<ProductType> QueryProductTypeName(String typeMethod){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="select typeName from ProductType where typeMethod=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			query.setParameter(0,typeMethod);
			//执行查询
			List<ProductType> list=query.list();
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//查询新产品子类的name
	public ProductType newQueryProductTypeName(String typeMethod){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="from ProductType where typeMethod=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			query.setParameter(0,typeMethod);
			//执行查询
			List<ProductType> list=query.list();
			if(list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//添加商品父类的方法
	public int addTypeMethod(String typeMethod){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			ProductType pd=new ProductType();
			pd.setTypeMethod(typeMethod);
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(pd).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//添加商品子类的方法
	public int addTypeName(String typeMethod,String typeName){
		
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			ProductType pd=new ProductType();
			pd.setTypeMethod(typeMethod);
			pd.setTypeName(typeName);
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(pd).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//添加商品子类的方法1
	public boolean updateProType(String typeName,String typeMethod){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update ProductType set typeName=? where typeMethod=?";
			//创建查询
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0,typeName);
			queryObject.setParameter(1,typeMethod);
			Transaction trans=session.beginTransaction();
			
			queryObject.executeUpdate();
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//查询所有产品信息
	public List<Product> queryProduct(){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();			
			String queryString="from Product";			
			Query query=session.createQuery(queryString);
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	
	//查询产品信息每页需要显示的数据
	public List<Product> queryProByPage(int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Product";
			Query query=session.createQuery(queryString);
			
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 

			//每次最多5条记录
			List<Product> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//根据id来更新产品数据方法
	public Product queryProById(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			Product product=(Product)session.get(Product.class, cid);
			return product;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	//修改商品信息(包括图片)
	public boolean updateProduct(Product product,String uploadFileName){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update Product set productName=?,description=?,price=?,img=?,productState=? where id=?";
			//创建查询
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, product.getProductName().trim());
			queryObject.setParameter(1, product.getDescription().trim());
			queryObject.setParameter(2, product.getPrice());
			queryObject.setParameter(3, uploadFileName);
			queryObject.setParameter(4, product.getProductState().trim());
			queryObject.setParameter(5, product.getId());
			Transaction trans=session.beginTransaction();
			
			queryObject.executeUpdate();
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//修改商品信息(不包括图片)
	public boolean updateProductnoImg(Product product){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update Product set productName=?,description=?,price=?,productState=? where id=?";
			//创建查询
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, product.getProductName().trim());
			queryObject.setParameter(1, product.getDescription().trim());
			queryObject.setParameter(2, product.getPrice());
			queryObject.setParameter(3, product.getProductState().trim());
			queryObject.setParameter(4, product.getId());
			Transaction trans=session.beginTransaction();
			
			queryObject.executeUpdate();
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//修改商品类别的方法(更新)
	public boolean updateProClass(Product product,ProductType productType,int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update ProductClass set productID=?,typeName2=? where id=? ";
			//创建查询
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0,product);
			queryObject.setParameter(1,productType);
			queryObject.setParameter(2,id);
			Transaction trans=session.beginTransaction();
			
			queryObject.executeUpdate();
			trans.commit();
			return true;
			
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//修改商品类别的方法(插入)
	public int insertProductClass(Product product,ProductType productType){
		int num=0;
		Session session=null;
		Transaction transaction=null;
		try{
			ProductClass pd=new ProductClass();
			pd.setProductID(product);
			pd.setTypeName2(productType);
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(pd).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	//根据产品查询产品种类两列
	public List<ProductClass> QueryProductTypeByPro(Product product){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="from ProductClass where productID=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			query.setParameter(0,product);
			//执行查询
			List<ProductClass> list=query.list();
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//查询新产品子类的name
	public List<ProductType> nowQueryProductTypeName(String typeMethod){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="from ProductType where typeMethod=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			query.setParameter(0,typeMethod);
			//执行查询
			List<ProductType> list=query.list();
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//查询新产品子类的name
	public ProductType nowQueryProductTypeName1(String typeMethod){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="from ProductType where typeMethod=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			query.setParameter(0,typeMethod);
			//执行查询
			List<ProductType> list=query.list();
			if(list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//查询产品对应的ProductClass
	public ProductClass QueryProClass(Product product,ProductType productType){
		Session session=null;
		try{
			//调用SessionFactory获得session
			session=sessionFactory.openSession();

			String hql="from ProductClass where productID=? and typeName2=?";
			//获得Query对象
			Query query=session.createQuery(hql);
			query.setParameter(0,product);
			query.setParameter(1,productType);
			//执行查询
			List<ProductClass> list=query.list();
			if(list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//删除产品信息
	public boolean deleteProduct(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			Product product=(Product)session.get(Product.class,id);
			//删除user数据
			Transaction trans=session.beginTransaction();
			session.delete(product);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//删除产品类别信息
	public boolean deleteProductClass(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			Product product=(Product)session.get(Product.class,id);
			//删除user数据
			Transaction trans=session.beginTransaction();
			session.delete(product);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//查询指定时间段的业绩
	public String querySumOrder(String sumType,String startTime,String endTime){
		Session session=null;
		String sum=null;
		try{
			session=sessionFactory.openSession();
			String sql="select "+sumType+
					   " from Table_Order o,Table_ShoppingCart sc "+
					   "where o.cartID=sc.id and "+ 
					   "o.orderStatus not in('未接单') and "+
					   "CAST(o.orderTime as date) between CAST('"+startTime+"' as date) and CAST('"+endTime+"' as date)";
			Query query=session.createSQLQuery(sql);
			if(query.list().get(0)!=null){
				sum=query.list().get(0).toString();
			}
			return sum;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//查询指定时间段的各种商品的售卖情况
	public List queryCountOrder(String type,String startTime,String endTime,int pageNo,int pageSize){
		Session session=null;
		String sum=null;
		try{
			session=sessionFactory.openSession();
			String sql="select "+type+
					   " from Table_Order o,Table_ShoppingCart sc ,Table_ShoppingCartInf sci "+
					   "where o.cartID=sc.id and sci.cartID=sc.id and "+
					   "o.orderStatus not in('未接单') and "+
					   "CAST(o.orderTime as date) between CAST('"+startTime+"' as date) and CAST('"+endTime+"' as date) "+
					   "group by sci.productID "+
					   "order by sci.productID";
			Query query=session.createSQLQuery(sql);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//查询所有用户,返回的是持久化类集合对象
	public List<CustomerWords> queryCustomerWord(){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql语句,Users代表是models里的实体类,name和password代表实体类的属性
			String queryString="from CustomerWords order by id ASC";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	
	//查询每页需要显示的数据
	public List<CustomerWords> queryByPageWord(int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from CustomerWords";
			Query query=session.createQuery(queryString);
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 

			//每次最多5条记录
			List<CustomerWords> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//根据姓名查询用户留言
	public List<CustomerWords> queryCusWordByName(String realName){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql语句,Users代表是models里的实体类,name和password代表实体类的属性
			String queryString="from CustomerWords where customerID.realName like'%"+realName+"%' order by id ASC";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	//查询每页需要显示的数据
	public List<CustomerWords> queryCusWordByPageByName(String realName,int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from CustomerWords where customerID.realName like'%"+realName+"%'";
			Query query=session.createQuery(queryString);
			
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 
			//每次最多5条记录
			List<CustomerWords> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//查询产品全部种类
	public List<ProductType> queryProductClass(){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql语句,Users代表是models里的实体类,name和password代表实体类的属性
			String queryString="from ProductType";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	
	//查询每页需要显示的数据(删除分类)
	public List<ProductType> queryProClassByPage(int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ProductType";
			Query query=session.createQuery(queryString);
			
			//每次获取第一条数据的索引
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//这一页显示的记录个数
			query.setMaxResults(pageSize); 
			//每次最多5条记录
			List<ProductType> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	//删除商品类型
	public boolean deleteProductType(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			ProductType productType=(ProductType)session.get(ProductType.class,id);
			//删除user数据
			Transaction trans=session.beginTransaction();
			session.delete(productType);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	//根据关键字搜索订单
	public List<Order> queryOrderByKey(String Key){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String sql="select distinct {o.*}"+" from Table_Order o,Table_Customer c,Table_ConsigneeInf ci"+" where c.id=o.customer and ci.id=o.consignee and"+"(o.orderStatus not in('未付款')) and"+"( c.realName like '%"+Key+"%' or ci.consigneeName like '%"+Key+"%' or o.orderStatus like '%"+Key+"%')";
			Query query=session.createSQLQuery(sql).addEntity("o",Order.class);
			List<Order> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	//根据关键字分页搜索订单
	public List<Order> queryOrdersByKeyOnPage(String Key,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String sql="select distinct {o.*}"+" from Table_Order o,Table_Customer c,Table_ConsigneeInf ci"+" " +"where c.id=o.customer and ci.id=o.consignee and"+"(o.orderStatus not in('未付款')) and"+"" +"( c.realName like '%"+Key+"%' or ci.consigneeName like '%"+Key+"%' or o.orderStatus like '%"+Key+"%')";
			Query query=session.createSQLQuery(sql).addEntity("o",Order.class);
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
		//查询订单
	public List<Order> queryOrders(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Order where orderStatus not in ('未付款')";
			Query query=session.createQuery(hql);
			List<Order> list=query.list();
			if(list!=null){
				return list;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();}}
	//分页查询订单
	public List<Order> queryOrdersByPage(int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Order where orderStatus not in ('未付款')";
			Query query=session.createQuery(hql);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
			List<Order> list=query.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	//添加管理员
	public int addAdmin(Admin admin){
		int num=0;
		//得到session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(admin).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			session.close();//调用HibernateSessionFactory的静态方法关闭Session
		}
		return num;
	}
	//查询当前职务
	public Role queryNowRole(int roleID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Role where id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0,roleID);
			List<Role> nowRole=query.list();
			if(nowRole!=null){
				return nowRole.get(0);
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//修改订单状态
	public int adminUpdateStatus(int orderid,String nextStatus){
		Session session=null;
		Transaction transaction=null;
		try{
			System.out.println(nextStatus);
			session=sessionFactory.openSession();
			String hql="from Order where id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, orderid);
			List<Order> list=query.list();
			Order order=list.get(0);
			order.setOrderStatus(nextStatus);
			transaction=session.beginTransaction();
			session.update(order);//在缓存中保存数据，受影响行数
			transaction.commit();//写入数据库表
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	
	//检查用户名是否存在
	public boolean isIdExist(Admin admin){
		Session session=null;
		boolean flag=true;
		try{
			String hql="from Admin where adminID=?";
			session=sessionFactory.openSession();
			Query query=session.createQuery(hql);
			query.setParameter(0, admin.getAdminID());
			List list=query.list();
			if(list.size()==0){
				flag=false;
			}else{
				flag=true;
			}
			return flag;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
	}
	
	//分页查询商品评价
	public List<ProductEvaluate> queryNowEva(int pid,int pageNo,int pageSize){
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
	
	//根据ID查找订单
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
}
