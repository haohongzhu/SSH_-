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
    
    <title>订单支付</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_CartAndOrder.css">
	<script type="text/javascript">
		function deleteOrder(){
			location.href="deleteOrderById";
			alert("撤销订单成功，你可以重新提交订单！！！");
		}
	</script>
  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="payForOrder_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 支付订单</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="../ShowProduct/Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="cart_logo" style="width:130px;">
    		<img src="images/order2.png" style="widht:30px;height:34px;margin-top:3px;">
    		<span id="your_cart">您的订单</span>
    	</div>
    	
    	<div id="payForOrder_main_middle">
    		<s:action name="queryNoPay" executeResult="false"/>
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
    				<s:action name="queryNoPay" executeResult="false"/>
    				<font>订单编号：<s:property value="#session.nowOrder.id"/></font>
    				<font>下单顾客：<s:property value="#session.loginUser.realName"/>
    				</font>
    				<font>收货客人：<s:property value="#session.nowOrder.order_consignee.consigneeName"/>
    					(<s:property value="#session.nowOrder.order_consignee.sex"/>)
    				</font>
    				<font>
    					收货地址：<s:property value="#session.nowOrder.order_consignee.address"/>&nbsp;
    					<s:property value="#session.nowOrder.order_consignee.doorNum"/>
    				</font>
    				<font>收货电话：<s:property value="#session.nowOrder.order_consignee.addressTel"/></font>
    				<font>备注：<%
    					Order note=(Order)request.getSession().getAttribute("nowOrder");
    					if(note.getNote().length()==0){
    					%>（无）
    				<%}else{ %><s:property value="#session.nowOrder.note"/>
    				<%} %></font>
    			</div>
    		</div>
    		
    		<div id="payForOrder_right">
    			<div id="order_detail2">
    				订单状态
    			</div>
    			
    			<div id="order_status">
    				<img src="images/ordetStatus2.png" id="status_img" >
    				<span class="order_status_span" style="margin-top:-1px;color:rgb(255,192,0	)" >
    					添加购物车商品成功，等待提交订单！
    				</span>
    				<span class="order_status_span" style="margin-top:-330px;">
    					订单提交成功，等待付款！
    				</span>
    				<span class="order_status_span" style="margin-top:-252px;">
    					付款成功，等待接单！
    				</span>
    				<span class="order_status_span" style="margin-top:-174px;">
    					商家已接单，商品制作中！
    				</span>
    				<span class="order_status_span" style="margin-top:-96px;">
    					送货员配送中！
    				</span>
    				<span class="order_status_span" style="margin-top:-18px;">
    					商品已送达！
    				</span>
    			</div>
    			
    			<hr style="width:468px;margin-top:20px;border:1px grey dashed;">
    			
    			<div id="paymentType">
    				<s:action name="queryAllPayment" executeResult="false"/>
    				<form action="payForOrder" method="post">
    					支付方式：
    					<div id="payment_in" style="width:390px;float:right">
	    					<s:iterator value="#session.allPay">
	    						<input type="radio" name="payment" value="<s:property value="id"/>" />
	    						<s:property value="paymentTypeName" />
	    						<img src="images/<s:property value="pay_img" />"><br><br>
	    					</s:iterator>
    					</div>
    					<input type="button" value="撤 销 订 单" class="pay_submit" style="margin-top:150px;" onclick="deleteOrder()"/>
    					<input type="submit" value="支 付 订 单" class="pay_submit"/>
    				</form>
    			</div>
    		</div>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
