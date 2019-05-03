<%@ page language="java" import="java.util.*,com.product.models.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %><%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的全部收藏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">

  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="product_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 我的收藏</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="common_left_menu">
    		<jsp:include page="Foreground_leftMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="product_main_right">
    		<%
    			List<ProductCollect> collect=(List)request.getSession().getAttribute("collects2"); 
    			if(collect.size()>0){
    		%>
	    		<div id="indicate">
	 			   	<img src="images/my_collect.png" id="this" style="width:30px;height:30px;">
	 			   	<span id="productTop" style="font-size:20px;">我的收藏</span>
	    		</div>
	    		<s:iterator value="#session.collects2" >
		    		<div class="product1">
		    			<img src="img/product/<s:property value="productID3.img"/>" class="product_img"/>
		    			<font class="productName">
		    				<s:property value="productID3.productName"/>
		    			</font><br>
		    			<font class="product_other">
		    				月售<s:property value="productID3.monthSale"/>
		    			&nbsp;&nbsp;
		    				赞<s:property value="productID3..praise"/>
		    			</font>
		    			<font class="productPrice">
		    				¥<s:property value="productID3.price"/>
		    			</font>
		    			<font class="details"><a href="javascript:queryProById('<s:property value="productID3.id"/>')">详情</a></font>
		    		</div>
	    		</s:iterator>
	    		<div id="top_choose">
					<a href="queryCollect?pageNo=1">[首页]</a>
					<a href="queryCollect?pageNo=${currentPage-1}">[上一页]</a>
					<a href="queryCollect?pageNo=${currentPage+1}">[下一页]</a>
					<a href="queryCollect?pageNo=${totalPage}">[尾页]</a>
					（当前第${currentPage}/${totalPage}页）
				</div>
			<%
				}else{
			 %>	
			 	<div id="no_collect2">
			 		您还没有收藏！赶快选取您喜欢的商品进行收藏吧！
			 	</div>	
			 <%} %>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
