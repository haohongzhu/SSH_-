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
	
	//��֤�û���¼	
	public Admin checkLogin(Admin admin){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="from Admin where adminID=? and adminPassword=?";
			//���Query����
			Query query=session.createQuery(hql);
			//���ò���,?����Ŵ�0��ʼ
			query.setParameter(0, admin.getAdminID());
			query.setParameter(1, admin.getAdminPassword());
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//��ѯ��¼����
	public List<Admin> queryAdminByID(Admin admin){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="select adminPassword from Admin where adminID=?";
			//������ѯ
			Query query=session.createQuery(queryString);
			query.setParameter(0, admin.getAdminID());
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//��ѯ����ǰ̨�û�,���ص��ǳ־û��༯�϶���
	public List<Customer> queryUsers(){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql���,Users������models���ʵ����,name��password����ʵ���������
			String queryString="from Customer order by id ASC";
			//������ѯ
			Query query=session.createQuery(queryString);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//��ѯ���к�̨�û�,���ص��ǳ־û��༯�϶���
	public List<Admin> queryAdminUsers(){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql���,Users������models���ʵ����,name��password����ʵ���������
			String queryString="from Admin";
			//������ѯ
			Query query=session.createQuery(queryString);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//��ѯÿҳ��Ҫ��ʾ������
	public List<Customer> queryByPage(int pageNo,int pageSize){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Customer";
			Query query=session.createQuery(queryString);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 

			//ÿ�����5����¼
			List<Customer> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//����������ѯ�û�����
	public List<Customer> queryUsersByName(){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql���,Users������models���ʵ����,name��password����ʵ���������
			String queryString="from Customer where realName=? order by id ASC";
			//������ѯ
			Query query=session.createQuery(queryString);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//��ѯÿҳ��Ҫ��ʾ������
	public List<Customer> queryByPageByName(String realName,int pageNo,int pageSize){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Customer where realName like'%"+realName+"%'";
			Query query=session.createQuery(queryString);
			
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 

			//ÿ�����5����¼
			List<Customer> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	//ɾ���û�����
	public boolean deleteCustomerWords(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			CustomerWords customerWords=(CustomerWords)session.get(CustomerWords.class,id);
			//ɾ��user����
			Transaction trans=session.beginTransaction();
			session.delete(customerWords);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}	
	}
	//ɾ���û�
	public boolean deleteAdminById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			Admin admin=(Admin)session.get(Admin.class,id);
			//ɾ��user����
			Transaction trans=session.beginTransaction();
			session.delete(admin);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}	
	}
	//ɾ���û���Ϣ
	public boolean deleteCustomerInf(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			Customer customer=(Customer)session.get(Customer.class,id);
			//ɾ��user����
			Transaction trans=session.beginTransaction();
			session.delete(customer);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//��ѯ����Ա��Ϣ,���ص��ǳ־û��༯�϶���
	public Admin queryAdminById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			Admin admin=(Admin)session.get(Admin.class, id);
			return admin;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//�޸Ĺ���Ա��Ϣ
	public boolean updateAdmin(Admin admin,Role role){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update Admin set adminRealName=?,telephone=?,telephonep=?,qq=?,wechat=?,email=?,role=? where id=?";
			//������ѯ
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
		}finally{//�ر�session
			session.close();
		}	
	}
	
	
	//��ѯȫ����ɫ
	public List<Role> QueryRole(){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="from Role";
			//���Query����
			Query query=session.createQuery(hql);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//��ѯ��ǰ��ɫ
	public Role queryRoleById(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			Role role=(Role)session.get(Role.class, cid);
			return role;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//�޸�����
	public boolean changePassword(Admin admin,String oldpwd,String newpwd){
		boolean flag=true;
		//�õ�session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			//hql���
			String queryString="from Admin where adminID=? and adminPassword=?";
			//������ѯ
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, admin.getAdminID());
			queryObject.setParameter(1, oldpwd);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
			List<Admin> list=queryObject.list();
			if(list.size()==0){
				flag=false;//���������
			}else{
				admin=list.get(0); //�ҵ�Ҫ�޸�������û�����
				admin.setAdminPassword(newpwd);
				transaction=session.beginTransaction();
				session.update(admin);//�ڻ����б������ݣ���Ӱ������
				transaction.commit();//д�����ݿ��
			}
			return flag;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//�����Ʒ�ķ���
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
	
	//��ѯ��һ�������Ʒ��Ϣ
	public Product queryAdded(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			Product product=(Product)session.get(Product.class, cid);
			return product;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//�����Ʒ����ķ���
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
	
	//���������ѯ��Ʒ��������
	public ProductType QueryProductType(String typeName){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="from ProductType where typeName=?";
			//���Query����
			Query query=session.createQuery(hql);
			query.setParameter(0,typeName);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//��ѯ��Ʒ����
	public List<ProductType> QueryProductTypeMethod(){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="select distinct typeMethod from ProductType";
			//���Query����
			Query query=session.createQuery(hql);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//��ѯ��Ʒ����
	public List<ProductType> QueryProductTypeName(String typeMethod){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="select typeName from ProductType where typeMethod=?";
			//���Query����
			Query query=session.createQuery(hql);
			query.setParameter(0,typeMethod);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//��ѯ�²�Ʒ�����name
	public ProductType newQueryProductTypeName(String typeMethod){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="from ProductType where typeMethod=?";
			//���Query����
			Query query=session.createQuery(hql);
			query.setParameter(0,typeMethod);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//�����Ʒ����ķ���
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
	
	//�����Ʒ����ķ���
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
	
	//�����Ʒ����ķ���1
	public boolean updateProType(String typeName,String typeMethod){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update ProductType set typeName=? where typeMethod=?";
			//������ѯ
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
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//��ѯ���в�Ʒ��Ϣ
	public List<Product> queryProduct(){
		//�õ�session
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
		}finally{//�ر�session
			session.close();
		}
	}
	
	//��ѯ��Ʒ��Ϣÿҳ��Ҫ��ʾ������
	public List<Product> queryProByPage(int pageNo,int pageSize){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Product";
			Query query=session.createQuery(queryString);
			
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 

			//ÿ�����5����¼
			List<Product> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//����id�����²�Ʒ���ݷ���
	public Product queryProById(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			Product product=(Product)session.get(Product.class, cid);
			return product;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	//�޸���Ʒ��Ϣ(����ͼƬ)
	public boolean updateProduct(Product product,String uploadFileName){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update Product set productName=?,description=?,price=?,img=?,productState=? where id=?";
			//������ѯ
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
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//�޸���Ʒ��Ϣ(������ͼƬ)
	public boolean updateProductnoImg(Product product){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update Product set productName=?,description=?,price=?,productState=? where id=?";
			//������ѯ
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
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//�޸���Ʒ���ķ���(����)
	public boolean updateProClass(Product product,ProductType productType,int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="Update ProductClass set productID=?,typeName2=? where id=? ";
			//������ѯ
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
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//�޸���Ʒ���ķ���(����)
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
	
	//���ݲ�Ʒ��ѯ��Ʒ��������
	public List<ProductClass> QueryProductTypeByPro(Product product){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="from ProductClass where productID=?";
			//���Query����
			Query query=session.createQuery(hql);
			query.setParameter(0,product);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//��ѯ�²�Ʒ�����name
	public List<ProductType> nowQueryProductTypeName(String typeMethod){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="from ProductType where typeMethod=?";
			//���Query����
			Query query=session.createQuery(hql);
			query.setParameter(0,typeMethod);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//��ѯ�²�Ʒ�����name
	public ProductType nowQueryProductTypeName1(String typeMethod){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="from ProductType where typeMethod=?";
			//���Query����
			Query query=session.createQuery(hql);
			query.setParameter(0,typeMethod);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//��ѯ��Ʒ��Ӧ��ProductClass
	public ProductClass QueryProClass(Product product,ProductType productType){
		Session session=null;
		try{
			//����SessionFactory���session
			session=sessionFactory.openSession();

			String hql="from ProductClass where productID=? and typeName2=?";
			//���Query����
			Query query=session.createQuery(hql);
			query.setParameter(0,product);
			query.setParameter(1,productType);
			//ִ�в�ѯ
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
			//�ر�session
			session.close();
		}
	}
	
	//ɾ����Ʒ��Ϣ
	public boolean deleteProduct(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			Product product=(Product)session.get(Product.class,id);
			//ɾ��user����
			Transaction trans=session.beginTransaction();
			session.delete(product);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//ɾ����Ʒ�����Ϣ
	public boolean deleteProductClass(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			Product product=(Product)session.get(Product.class,id);
			//ɾ��user����
			Transaction trans=session.beginTransaction();
			session.delete(product);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//��ѯָ��ʱ��ε�ҵ��
	public String querySumOrder(String sumType,String startTime,String endTime){
		Session session=null;
		String sum=null;
		try{
			session=sessionFactory.openSession();
			String sql="select "+sumType+
					   " from Table_Order o,Table_ShoppingCart sc "+
					   "where o.cartID=sc.id and "+ 
					   "o.orderStatus not in('δ�ӵ�') and "+
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
	
	//��ѯָ��ʱ��εĸ�����Ʒ���������
	public List queryCountOrder(String type,String startTime,String endTime,int pageNo,int pageSize){
		Session session=null;
		String sum=null;
		try{
			session=sessionFactory.openSession();
			String sql="select "+type+
					   " from Table_Order o,Table_ShoppingCart sc ,Table_ShoppingCartInf sci "+
					   "where o.cartID=sc.id and sci.cartID=sc.id and "+
					   "o.orderStatus not in('δ�ӵ�') and "+
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
	
	//��ѯ�����û�,���ص��ǳ־û��༯�϶���
	public List<CustomerWords> queryCustomerWord(){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql���,Users������models���ʵ����,name��password����ʵ���������
			String queryString="from CustomerWords order by id ASC";
			//������ѯ
			Query query=session.createQuery(queryString);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//��ѯÿҳ��Ҫ��ʾ������
	public List<CustomerWords> queryByPageWord(int pageNo,int pageSize){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from CustomerWords";
			Query query=session.createQuery(queryString);
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 

			//ÿ�����5����¼
			List<CustomerWords> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//����������ѯ�û�����
	public List<CustomerWords> queryCusWordByName(String realName){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql���,Users������models���ʵ����,name��password����ʵ���������
			String queryString="from CustomerWords where customerID.realName like'%"+realName+"%' order by id ASC";
			//������ѯ
			Query query=session.createQuery(queryString);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	//��ѯÿҳ��Ҫ��ʾ������
	public List<CustomerWords> queryCusWordByPageByName(String realName,int pageNo,int pageSize){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from CustomerWords where customerID.realName like'%"+realName+"%'";
			Query query=session.createQuery(queryString);
			
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 
			//ÿ�����5����¼
			List<CustomerWords> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//��ѯ��Ʒȫ������
	public List<ProductType> queryProductClass(){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//hql���,Users������models���ʵ����,name��password����ʵ���������
			String queryString="from ProductType";
			//������ѯ
			Query query=session.createQuery(queryString);
			//ִ�в�ѯ��õĽ��,list�е�ÿһ��Ԫ�ش���һ��Users�Ķ���
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}
	}
	
	//��ѯÿҳ��Ҫ��ʾ������(ɾ������)
	public List<ProductType> queryProClassByPage(int pageNo,int pageSize){
		//�õ�session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from ProductType";
			Query query=session.createQuery(queryString);
			
			//ÿ�λ�ȡ��һ�����ݵ�����
			query.setFirstResult((pageNo-1)*pageSize); //������һҳ��ʾ�ĵ�һ����¼������
			//��һҳ��ʾ�ļ�¼����
			query.setMaxResults(pageSize); 
			//ÿ�����5����¼
			List<ProductType> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
	}
	//ɾ����Ʒ����
	public boolean deleteProductType(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			ProductType productType=(ProductType)session.get(ProductType.class,id);
			//ɾ��user����
			Transaction trans=session.beginTransaction();
			session.delete(productType);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//�ر�session
			session.close();
		}	
	}
	
	//���ݹؼ�����������
	public List<Order> queryOrderByKey(String Key){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String sql="select distinct {o.*}"+" from Table_Order o,Table_Customer c,Table_ConsigneeInf ci"+" where c.id=o.customer and ci.id=o.consignee and"+"(o.orderStatus not in('δ����')) and"+"( c.realName like '%"+Key+"%' or ci.consigneeName like '%"+Key+"%' or o.orderStatus like '%"+Key+"%')";
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
	//���ݹؼ��ַ�ҳ��������
	public List<Order> queryOrdersByKeyOnPage(String Key,int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String sql="select distinct {o.*}"+" from Table_Order o,Table_Customer c,Table_ConsigneeInf ci"+" " +"where c.id=o.customer and ci.id=o.consignee and"+"(o.orderStatus not in('δ����')) and"+"" +"( c.realName like '%"+Key+"%' or ci.consigneeName like '%"+Key+"%' or o.orderStatus like '%"+Key+"%')";
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
		//��ѯ����
	public List<Order> queryOrders(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Order where orderStatus not in ('δ����')";
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
	//��ҳ��ѯ����
	public List<Order> queryOrdersByPage(int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from Order where orderStatus not in ('δ����')";
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
	
	//��ӹ���Ա
	public int addAdmin(Admin admin){
		int num=0;
		//�õ�session
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
		}finally{//�ر�session
			session.close();//����HibernateSessionFactory�ľ�̬�����ر�Session
		}
		return num;
	}
	//��ѯ��ǰְ��
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
			//�ر�session
			session.close();
		}
	}
	
	//�޸Ķ���״̬
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
			session.update(order);//�ڻ����б������ݣ���Ӱ������
			transaction.commit();//д�����ݿ��
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	
	//����û����Ƿ����
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
	
	//��ҳ��ѯ��Ʒ����
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
	
	//����ID���Ҷ���
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
