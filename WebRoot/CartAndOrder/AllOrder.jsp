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
    
    <title>查询所有订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_CartAndOrder.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">
  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="order_main" style="height:800px;">
    	<div id="common_top">
    		<h5>您的位置：首页 > 我的订单</h5>
    	</div>
    	<div id="top_menu" style="margin-left:250px;height:30px;margin-top:20px;width:1000px;">
	    	<span class="top_menu_s">
	    		按订单状态查找：
	    		<a href="queryByStatus">未付款</a>&nbsp;|
	    		<a href="queryByStatus2">未接单</a>&nbsp;|
	    		<a href="queryByStatus3">已接单</a>&nbsp;|
	    		<a href="queryByStatus4">配送中</a>&nbsp;|
	    		<a href="queryByStatus5">已送达</a>&nbsp;|
	    	</span>
	    </div>
    	<div id="cart_logo" style="width:177px;margin-left:250px;">
    		<img src="images/order2.png" style="widht:30px;height:34px;margin-top:3px;">
    		<span id="your_cart">您的所有订单</span>
    	</div>
    	
    	<form action="queryByAll" method="post" id="queryByOther">
    		<input type="text" name="searchByAll" id="search2" placeholder="您可以根据订单编号、收货顾客、下单时间、订单状态搜索" >
			<input type="submit" id="search_btn" value="搜索">
    	</form>
    	<div id="all_order">
    		<div id="all_order_menu" >
    			<span class="all_order_menu_span" style="border-left:0px;">订单编号</span>
    			<span class="all_order_menu_span">下单顾客</span>
    			<span class="all_order_menu_span">收货顾客</span>
    			<span class="all_order_menu_span" style="width:270px;">下单时间</span>
    			<span class="all_order_menu_span">订单状态</span>
    			<span class="all_order_menu_span" style="width:150px;">操作</span>
    		</div>
    		<s:iterator value="#session.allOrder">
	    		<div id="all_order_menu" >
	    			<span class="all_order_menu_span" style="border-left:0px;">
						<s:property value="id"/>
					</span>
	    			<span class="all_order_menu_span">
	    				<s:property value="order_customer.realName"/>
					</span>
	    			<span class="all_order_menu_span" >
	    				<s:property value="order_consignee.consigneeName"/>
	    			</span>
	    			<span class="all_order_menu_span" style="width:270px;">
	    				<s:property value="orderTime"/>
	    			</span>
	    			<span class="all_order_menu_span">
	    				<s:property value="orderStatus"/>
	    			</span>
	    			<span class="all_order_menu_span" style="width:150px;">
	    				<a href="queryOrderById?id=<s:property value="id"/>">详情</a>
	    			</span>
	    		</div>		
    		</s:iterator>
    		<div id="allOrder_choose">
				<a href="queryAllOrder?pageNo=1">[首页]</a>
				<a href="queryAllOrder?pageNo=${currentPage-1}">[上一页]</a>
				<a href="queryAllOrder?pageNo=${currentPage+1}">[下一页]</a>
				<a href="queryAllOrder?pageNo=${totalPage}">[尾页]</a>
				（当前第${currentPage}/${totalPage}页）
			</div>	
    	</div>
    	
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
