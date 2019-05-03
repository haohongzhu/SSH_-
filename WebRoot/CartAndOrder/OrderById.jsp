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
    
    <title>订单详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_CartAndOrder.css">

  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="order_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 我的订单 > 订单详情</h5>
    	</div>
    	
    	<div id="cart_logo" style="width:130px;">
    		<img src="images/order2.png" style="widht:30px;height:34px;margin-top:3px;">
    		<span id="your_cart">您的订单</span>
    	</div>
    	
    	<div id="payForOrder_main_middle">
    		<div id="payForOrder_left">
    			<div id="order_detail">
    				订单详情
    			</div>
    			<s:iterator value="#session.nowOrder.order_cartID.setCartInf" >
    				<div id="order_cartInf">
    					<s:property value="productID4.productName"/>
    					<font>
    						¥<s:property value="oneProductPrice"/>
    					</font>
    					<font>
    						<s:property value="productCount"/>份
    					</font>
    				</div>
    			</s:iterator>
    			
    			<hr style="width:465px;margin-left:15px;margin-top:10px;border:1px grey dashed;">
    			
    			<div id="order_cart">
    				数量：<s:property value="#session.nowOrder.order_cartID.totalCount"/>份<br>
    				总计：¥<s:property value="#session.nowOrder.order_cartID.totalPrice"/>
    			</div>
    			
    			<hr style="width:465px;margin-left:15px;border:1px grey dashed;">
    			
    			<div id="order_inf">
    				<font>订单编号：<s:property value="#session.nowOrder.id"/></font>
    				<font>下单顾客：<s:property value="#session.loginUser.realName"/></font>
    				<font>收货客人：<s:property value="#session.nowOrder.order_consignee.consigneeName"/>
    					(<s:property value="#session.nowOrder.order_consignee.sex"/>)
    				</font>
    				<font>
    					收货地址：<s:property value="#session.nowOrder.order_consignee.address"/>&nbsp;
    					<s:property value="#session.nowOrder.order_consignee.doorNum"/>
    				</font>
    				<font>收货电话：<s:property value="#session.nowOrder.order_consignee.addressTel"/></font>
    				<font>支付方式：<s:property value="#session.nowOrder.order_payment.paymentTypeName"/></font>
    				<font>
    				备注：<%
    					Order note=(Order)request.getSession().getAttribute("nowOrder");
    					if(note.getNote().length()==0){
    					%>（无）
    				<%}else{ %><s:property value="#session.nowOrder.note"/></font>
    				<%} %>
    				<font>下单时间：<s:property value="#session.nowOrder.orderTime"/></font>
    			</div>
    		</div>
    		
    		<div id="payForOrder_right">
    			<div id="order_detail2">
    				订单状态
    			</div>
    			
    			<div id="order_status">
					<%
						String status=(String)request.getSession().getAttribute("nowOrderStatus"); 
						if(status.equals("未接单")){
					%>
						<jsp:include page="/CartAndOrder/orderStatus.jsp" />
					<%}else if(status.equals("已接单")){%>
						<jsp:include page="/CartAndOrder/orderStatus3.jsp" />	
					<%}else if(status.equals("配送中")){%>
						<jsp:include page="/CartAndOrder/orderStatus4.jsp" />
					<%}else if(status.equals("已送达")){%>
						<jsp:include page="/CartAndOrder/orderStatus5.jsp" />
					<%} %>
    			</div>
    		</div>	
   		</div>
   	</div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
