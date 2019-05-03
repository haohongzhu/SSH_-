package com.admin.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.Product;
import com.product.models.ProductClass;
import com.product.models.ProductType;

public class UpdateAdminProduct extends ActionSupport{
	private int proClassId;
	private int index;
	private AdminDao ad;
	private String typeName1;
	private String typeMethod1;
	private Product product;
	private ProductType productType;
	private ProductClass productClass,productClass1;
	private List<ProductClass> productClasses;
	private File upload; //�ļ�����
	private String uploadFileName;//�ϴ��ļ���
	private String uploadContentType; //�ϴ��ļ�����
	private String savePath; //��struts.xml��param���õ��ļ�·��
	
	public int getProClassId() {
		return proClassId;
	}

	public void setProClassId(int proClassId) {
		this.proClassId = proClassId;
	}

	public AdminDao getAd() {
		return ad;
	}

	public void setAd(AdminDao ad) {
		this.ad = ad;
	}

	public String getTypeName1() {
		return typeName1;
	}

	public void setTypeName1(String typeName1) {
		this.typeName1 = typeName1;
	}

	public String getTypeMethod1() {
		return typeMethod1;
	}

	public void setTypeMethod1(String typeMethod1) {
		this.typeMethod1 = typeMethod1;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductClass getProductClass() {
		return productClass;
	}

	public void setProductClass(ProductClass productClass) {
		this.productClass = productClass;
	}

	public ProductClass getProductClass1() {
		return productClass1;
	}

	public void setProductClass1(ProductClass productClass1) {
		this.productClass1 = productClass1;
	}

	public List<ProductClass> getProductClasses() {
		return productClasses;
	}

	public void setProductClasses(List<ProductClass> productClasses) {
		this.productClasses = productClasses;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	//�������ļ����Ƶ�Tomcat��������
	public void copyFile(File source,File target){
		try{
			//������������������Ķ���
			FileInputStream fis=new FileInputStream(source);
			DataInputStream dis=new DataInputStream(fis);
			
			FileOutputStream fos=new FileOutputStream(target);
			DataOutputStream dos=new DataOutputStream(fos);
			int temp;
			//����
			while((temp=dis.read())!=-1){
				//д���ļ�
				dos.write(temp);
			}
			//�ر�
			fis.close();
			dis.close();
			fos.close();
			dos.close();
			
		}catch(FileNotFoundException ex1){
			ex1.printStackTrace();
		}catch(IOException ex2){
			ex2.printStackTrace();
		}
	}
	
	public String execute(){
		
		//����ڷ������ϱ����ļ���·�����ļ���
//		String filePath=ServletActionContext.getServletContext().getRealPath("upload")+"\\"+uploadFileName;
		String filePath = savePath+"\\"+uploadFileName;
		//Ŀ���ļ�����
		File target =new File(filePath);
		typeName1 = ServletActionContext.getRequest().getParameter("typeName1"); 
//		try {
//			typeName1 = new String(typeName1.getBytes("ISO-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(111111111);
		System.out.println(typeName1+"ttttttttttttt");
		productType=ad.QueryProductType(typeName1);
		System.out.println(productType.getTypeMethod()+"oooooooooo");
		productClasses=ad.QueryProductTypeByPro(product);
		System.out.println(productClasses.get(0).getTypeName2().getTypeMethod());
		for(int i=0;i<productClasses.size();i++){
			System.out.println(i+"yyyyyyyyyyyy");
			if(productClasses.get(i).getTypeName2().getTypeMethod().trim().equals(productType.getTypeMethod().trim())){
				System.out.println(i+"uuuuuuuuuuuuuu");
				proClassId=productClasses.get(i).getId();
				System.out.println(i+"-------------");		
				index=0;
				break;
			}else if(!productClasses.get(i).getTypeName2().getTypeMethod().trim().equals(productType.getTypeMethod().trim())){
				index=1;
				System.out.println("abc");
			}else{
				System.out.println("ggg");
			}
		}
		if(index==0){
		System.out.println(product.getId()+";;;");
		System.out.println(productType.getId()+"ppp");
		System.out.println(1111111);
		System.out.println(proClassId+"............");
		if(upload==null||"".equals(upload)){
			ad.updateProductnoImg(product);
			ad.updateProClass(product, productType,proClassId);
			System.out.println(55555555);
			return SUCCESS;
		}else{
			//���÷��������ļ����ϴ���
			copyFile(upload,target);
			System.out.println(666666);
			ad.updateProduct(product, uploadFileName);
			System.out.println(333);
			ad.updateProClass(product,productType,proClassId);
			System.out.println(111);
			return SUCCESS;
		}
		}else if(index==1){
			if(upload==null||"".equals(upload)){
				ad.updateProductnoImg(product);
				ad.insertProductClass(product, productType);
				System.out.println("aaaaaaaaaaaa");
				return SUCCESS;
			}else{
				//���÷��������ļ����ϴ���
				copyFile(upload,target);
				System.out.println(666666);
				ad.updateProduct(product, uploadFileName);
				System.out.println(333);
				ad.insertProductClass(product, productType);
				System.out.println("bbbbbbbbbbbb");
				return SUCCESS;
			}
		}else{
			return INPUT;
		}
	}
	
	public void validate(){
		System.out.println(typeMethod1+"========");
		if(typeMethod1.trim()==null||"".equals(typeMethod1.trim())){
			this.addFieldError("ErrorTypeMethod", "��Ʒ���಻��Ϊ�գ���ѡ��!");
		}
		if(product.getProductName().trim()==null||"".equals(product.getProductName().trim())){
			this.addFieldError("ErrorProName", "��Ʒ���ֲ���Ϊ�գ�������!");
		}
		if(product.getDescription().trim()==null||"".equals(product.getDescription().trim())){
			this.addFieldError("ErrorProDescription", "��Ʒ��������Ϊ�գ�������!");
		}
		if(product.getPrice()==null||"".equals(product.getPrice())){
			this.addFieldError("ErrorProPrice", "��Ʒ�۸���Ϊ�գ�������!");
		}
	}
}
