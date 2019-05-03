package com.admin.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.admin.dao.AdminDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.product.models.Product;
import com.product.models.ProductType;

public class AdminAddProduct extends ActionSupport{
	private File upload; //�ļ�����
	private String uploadFileName;//�ϴ��ļ���
	private String uploadContentType; //�ϴ��ļ�����
	private String savePath; //��struts.xml��param���õ��ļ�·��
	private Product product,product1;
	private ProductType productType;
	private String obj;
	private AdminDao ad;
	
	public AdminAddProduct(){
		
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
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public AdminDao getAd() {
		return ad;
	}
	public void setAd(AdminDao ad) {
		this.ad = ad;
	}
	
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	public Product getProduct1() {
		return product1;
	}
	public void setProduct1(Product product1) {
		this.product1 = product1;
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
	
	//Ĭ�Ϸ���
	public String execute()throws Exception{	
		System.out.println(product.toString());
		System.out.println(upload);
//System.out.println(product1.toString());
		
		//����ڷ������ϱ����ļ���·�����ļ���
		//String filePath=ServletActionContext.getServletContext().getRealPath("upload")+"\\"+uploadFileName;
		String filePath = savePath+"\\"+uploadFileName;
		//Ŀ���ļ�����
		File target =new File(filePath);
		//���÷��������ļ����ϴ���
//		copyFile(upload,target);
		
		String name = ServletActionContext.getRequest().getParameter("groupId1"); 
		System.out.println(name+"............");
		productType=ad.QueryProductType(name);
		System.out.println(productType+"...........");
		int num=ad.addproduct(product,uploadFileName);
		product1=ad.queryAdded(num);
		System.out.println(num);
		if(product1!=null){			
			ad.addproductClass(product1,productType);
			System.out.println("success add product");
			return SUCCESS;
		}else{
			System.out.println("faild add product");
			return INPUT;
		}
	}
//	public void validate(){
//		if(product.getDescription().length()>=150){
//			this.addFieldError("description", "*��������");
//		}
//		if(product.getProductName().length()==0||product.getProductName()==null||product.getProductName().equals(" ")){
//			this.addFieldError("productName", "*��Ʒ������Ϊ��");
//		}
//		if(product.getProductName().length()>15){
//			this.addFieldError("productName1", "��Ʒ������");
//		}
//		if(product.getPrice()==null){
//			this.addFieldError("price", "�۸񲻿�Ϊ��");
//		}
//	}
}
