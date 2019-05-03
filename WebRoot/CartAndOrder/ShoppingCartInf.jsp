<%@ page language="java" import="java.util.*,com.order.models.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_CartAndOrder.css">
	<script type="text/javascript">
		window.onload=function(){
			var index=document.getElementsByName("img_cart");
			var index2=document.getElementsByName("img_cart2");
			for(var i=0;i<index.length;i++){
				index[i].onmouseover=function(){
					this.src="images/reduce2.png";
				};
				index[i].onmouseout=function(){
					this.src="images/reduce.png";
				};
			}
			for(var i=0;i<index2.length;i++){
				index2[i].onmouseover=function(){
					this.src="images/add2.png";
				};
				index2[i].onmouseout=function(){
					this.src="images/add.png";
				};
			}
		};
	</script>
  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="cart_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 购物车</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="../ShowProduct/Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="cart_logo">
    		<img src="images/cart2.png" style="widht:40px;height:45px;margin-top:-3px;">
    		<span id="your_cart">您的购物车</span>
    	</div>
    	
    	<div id="cart_main_middle">
    		<div class="cart_menu">
    			<div class="cartInf">商品名称</div>
    			<div class="cartInf" style="width:192px;">单价</div>
    			<div class="cartInf" style="width:192px;">数量</div>
    			<div class="cartInf" style="width:192px;">小计</div>
    			<div class="cartInf" style="border-right:0px;">操作</div>
    		</div>
    		<s:iterator value="#session.nowCartInf">
    			<div class="cart_menu">
		    		<div class="cartInf">
		    			<a href="javascript:queryProById('<s:property value="productID4.id"/>')">
		    				<s:property value="productID4.productName"/>
		    			</a>
		    		</div>
		    		<div class="cartInf" style="width:192px;">
		    			¥<s:property value="productID4.price"/>
		    		</div>
		    		<div class="cartInf" style="width:192px;">
		    			<a href="shoppingCartReduce?pid=<s:property value="productID4.id"/>&cartID=<s:property value="shoppingCart.id"/>&id=<s:property value="id"/>">
		    				<img src="images/reduce.png" name="img_cart" class="AddOrReduce" style="margin-left:53px;">
		    			</a>
		    			<span id="add_or_reduce">
		    				<s:property value="productCount"/>
		    			</span>
		    			<a href="shoppingCartAdd?pid=<s:property value="productID4.id"/>&cartID=<s:property value="shoppingCart.id"/>">
		    				<img src="images/add.png" class="AddOrReduce" id="img_add" name="img_cart2">
		    			</a>
		    		</div>		
		    		<div class="cartInf" style="width:192px;">¥<s:property value="oneProductPrice"/></div>
		    		<div class="cartInf" style="border-right:0px;">
		    		<a href="shoppingCartDelete?id=<s:property value="id"/>">删除</a>
		    		</div>
    			</div>
    		</s:iterator>
    		<div class="cart_total">
    			<span style="border-right:0px;padding-left:10px;;">
    				<a href="CartAndOrder/CreateOrder.jsp">去结算</a>
    			</span>
    			<span>总价：¥<s:property value="#session.nowCart.totalPrice"/></span>
    			<span>共<s:property value="#session.nowCart.totalCount"/>件商品</span>
    			<span><a href="shoppingCartDeleteAll">清空购物车</a></span>
    			<span><a href="queryAllProduct">继续挑选</a></span>	
    		</div>
    		<div id="cart_choose">
				<a href="queryCart?pageNo=1">[首页]</a>
				<a href="queryCart?pageNo=${currentPage-1}">[上一页]</a>
				<a href="queryCart?pageNo=${currentPage+1}">[下一页]</a>
				<a href="queryCart?pageNo=${totalPage}">[尾页]</a>
				（当前第${currentPage}/${totalPage}页）
			</div>	
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
