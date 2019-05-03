<%@ page language="java" import="java.util.*,com.product.models.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>指定类型的商品</title>
    
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
    
    <div id="product_main_AllTop">
    	<div id="common_top">
    		<h5>您的位置：首页 > 分类 >
    			<%
    				List<ProductClass> pc=(List)request.getSession().getAttribute("productClass");
    				for(Iterator it=pc.iterator();it.hasNext();){
    					ProductClass pc2=(ProductClass)it.next();
    					request.getSession().setAttribute("now_typeID",pc2.getTypeName2().getId());
    					request.getSession().setAttribute("now_typeName",pc2.getTypeName2().getTypeName());
    					}
    			%>
    			<s:property value="#session.now_typeName"/>
    		</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="common_left_menu">
    		<jsp:include page="Foreground_leftMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="product_main_right_AllTop">
    		<div id="indicate">
 			   	<img src="images/this.png" id="this" style="width:38px;height:38px;'">
 			   	<span id="productTop" style="font-size:20px;margin-right:560px;">
 			   		商品类型：<s:property value="#session.now_typeName"/>
 			   	</span>
    		</div>
    		<s:iterator value="#session.productClass">
	    		<div class="product1">
	    			<img src="img/product/<s:property value="productID.img"/>" class="product_img"/>
	    			<font class="productName">
	    				<s:property value="productID.productName"/>
	    			</font><br>
	    			<font class="product_other">
	    				月售<s:property value="productID.monthSale"/>
	    			&nbsp;&nbsp;
	    				赞<s:property value="productID.praise"/>
	    			</font>
	    			<font class="productPrice">
	    				¥<s:property value="productID.price"/>
	    			</font>
	    			<font class="details"><a href="javascript:queryProById('<s:property value="productID.id"/>')">详情</a></font>
	    		</div>
    		</s:iterator>
    		<div id="top_choose">
				<a href="queryByType?tid=<s:property value="#session.now_typeID"/>&pageNo=1">[首页]</a>
				<a href="queryByType?tid=<s:property value="#session.now_typeID"/>&pageNo=${currentPage-1}">[上一页]</a>
				<a href="queryByType?tid=<s:property value="#session.now_typeID"/>&pageNo=${currentPage+1}">[上一页]</a>
				<a href="queryByType?tid=<s:property value="#session.now_typeID"/>&pageNo=${totalPage}">[尾页]</a>
				（当前第${currentPage}/${totalPage}页）
			</div>	
    	</div>
    	
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
