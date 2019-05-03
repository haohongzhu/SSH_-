<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">
	<script src="js/Foreground.js"></script>
  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="productTop_main">
    	<div id="common_top">
    		<h5>您的位置：首页</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="common_left_menu">
    		<jsp:include page="Foreground_leftMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="productTop_main_right">
    		<div id="indicate">
 			   	<img src="images/sale.png" id="sale">
 			   	<span id="productTop">销量前6</span>
 			   	<span id="more_top"><a href="queryAllSaleTop">>>>查看更多销量排行</a></span>
    		</div>
    		<s:iterator value="products" status="st" var="product">
	    		<div class="product1">
	    			<img src="img/product/<s:property value="#product.img"/>" class="product_img"/>
	    			<font class="productName">
	    				<s:property value="#product.productName"/>
	    			</font><br>
	    			<font class="product_other">
	    				月售<s:property value="#product.monthSale"/>
	    			&nbsp;&nbsp;
	    				赞<s:property value="#product.praise"/>
	    			</font>
	    			<font class="productPrice">
	    				¥<s:property value="#product.price"/>
	    			</font>
	    			<font class="details"><a href="javascript:queryProById('<s:property value="id"/>')">详情</a></font>
	    		</div>
    		</s:iterator>	
    	</div>
    	
    	<div id="productTop_main_right">
    		<div id="indicate">
 			   	<img src="images/good3.png" id="good3">
 			   	<span id="productTop">好评前6</span>
 			   	<span id="more_top"><a href="queryAllPraiseTop">>>>查看更多好评排行</a></span>
    		</div>
    		<s:iterator value="products2" status="st" var="product">
	    		<div class="product1">
	    			<img src="img/product/<s:property value="#product.img"/>" class="product_img"/>
	    			<font class="productName">
	    				<s:property value="#product.productName"/>
	    			</font><br>
	    			<font class="product_other">
	    				月售<s:property value="#product.monthSale"/>
	    			&nbsp;&nbsp;
	    				赞<s:property value="#product.praise"/>
	    			</font>
	    			<font class="productPrice">
	    				¥<s:property value="#product.price"/>
	    			</font>
	    			<font class="details"><a href="javascript:queryProById('<s:property value="id"/>')">详情</a></font>
	    		</div>
    		</s:iterator>	
    	</div>
    	
    	<div id="productTop_main_right">
    		<div id="indicate">
 			   	<img src="images/pay3.png" id="pay3">
 			   	<span id="productTop">价格前6</span>
 			   	<span id="more_top"><a href="queryAllPriceTop">>>>查看更多价格排行</a></span>
    		</div>
    		<s:iterator value="products3" status="st" var="product">
	    		<div class="product1">
	    			<img src="img/product/<s:property value="#product.img"/>" class="product_img"/>
	    			<font class="productName">
	    				<s:property value="#product.productName"/>
	    			</font><br>
	    			<font class="product_other">
	    				月售<s:property value="#product.monthSale"/>
	    			&nbsp;&nbsp;
	    				赞<s:property value="#product.praise"/>
	    			</font>
	    			<font class="productPrice">
	    				¥<s:property value="#product.price"/>
	    			</font>
	    			<font class="details"><a href="javascript:queryProById('<s:property value="id"/>')">详情</a></font>
	    		</div>
    		</s:iterator>	
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
