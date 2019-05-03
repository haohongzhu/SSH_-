<%@ page language="java" import="java.util.*,com.customer.models.*,com.product.models.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的收藏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">

  </head>
  
  <body>
    <div id="left_collect">
    	<div id="my_collect">
    	 我的收藏&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	 <a href="queryCollect">>>更多</a>
    	</div>
    	
    	<%
    		Customer c=(Customer)request.getSession().getAttribute("loginUser");
			List<ProductCollect> pc=(List)request.getSession().getAttribute("collects");
    		if(c==null){
    	%>
	    	<div id="no_collect">
	    		请先登录！才能查看您的收藏！
	    	</div>
    	<%
    		}else if(pc.size()>0){
    	 %>
	    	<s:action name="queryCollect" executeResult="false"/>
	    	<s:iterator value="#session.five_collect">
		    	<div id="collect_product">
		    		<img src="img/product/<s:property value="productID3.img"/>" id="collect_img">
		    		<span id="collect_s2">
			    		<s:property value="productID3.productName"/>
			    		<font>
			    			<a href="queryProductById?id=<s:property value="productID3.id" />">详情</a>
		    			</font>
		    		</span>
		    	</div>
	    	</s:iterator>
    	<%}else{ %>
    		<div id="no_collect">
	    		暂无收藏！请选择你喜欢的商品添加收藏！
	    	</div>
    	<%} %>
    </div>
  </body>
</html>
