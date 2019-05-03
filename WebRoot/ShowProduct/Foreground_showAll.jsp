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
    
    <title>所有商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/Foreground.js"></script>
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">
  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="product_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 分类 > 所有商品</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="common_left_menu">
    		<jsp:include page="Foreground_leftMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="product_main_right">
    		<div id="indicate">
 			   	<img src="images/this.png" id="this">
 			   	<span id="productTop" style="font-size:20px;">所有商品</span>
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
    		<div id="top_choose">
				<a href="queryAllProduct?pageNo=1">[首页]</a>
				<%
					int totalPage=(Integer)request.getSession().getAttribute("totalPage");
					for(int i=1;i<=totalPage;i++){
						request.getSession().setAttribute("nowPage", i);
				 %>
				 	<a href="queryAllProduct?pageNo=<s:property value="#session.nowPage"/>">
				 		[<s:property value="#session.nowPage"/>]
				 	</a>
				 <%}%>
				<a href="queryAllProduct?pageNo=${totalPage}">[尾页]</a>
				（当前第${currentPage}/${totalPage}页）
			</div>		
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
