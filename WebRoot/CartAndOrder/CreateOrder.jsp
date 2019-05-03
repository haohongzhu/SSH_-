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
    
    <title>订单创建</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_CartAndOrder.css">
	<script type="text/javascript">
		function queryConByName(){
			var obj=document.getElementById("order_option");
			var index = obj.selectedIndex;
			var value = obj.options[index].value;
			location.href="queryConByName?conID="+value;
		}
	</script>
  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="order_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 提交订单</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="../ShowProduct/Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="cart_logo" style="width:130px;">
    		<img src="images/order2.png" style="widht:30px;height:34px;margin-top:3px;">
    		<span id="your_cart">您的订单</span>
    	</div>
    	
    	<div id="order_main_middle">
    		<div id="order_left">
    			<div id="order_detail">
    				订单详情
    			</div>
    			<s:action name="queryCartNoByPage" executeResult="false"/>
    			<s:iterator value="#session.nowCartInf">
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
    				数量：<s:property value="#session.nowCart.totalCount"/>份<br>
    				总计：¥<s:property value="#session.nowCart.totalPrice"/>
    			</div>
    			<hr style="width:465px;margin-left:15px;border:1px grey dashed;">
    			<div id="order_form">
    				<s:action name="queryAllConInf" executeResult="false"/>
	    			<form method="post" action="createOrder.action" method="post">
	    				<font>下单顾客：&nbsp;<s:property value="#session.loginUser.realName"/>
	    					<font style="float: right;width:120px;">
	    						<a href="Foreground_addConsignee.jsp">→新增地址</a>
	    					</font>
	    				</font>
	    				<font>
	    					收货客人：
	    					<select name="consigneeName" id="order_option" onchange="queryConByName()">
	    						<option selected value="<s:property value="#session.nowConsignee.id"/>">
	    							<s:property value="#session.nowConsignee.consigneeName"/>&nbsp;
	    							<s:property value="#session.nowConsignee.sex"/>&nbsp;
	    						</option>
	    						<s:iterator value="#session.consigneeInf">
	    							<option value="<s:property value="id"/>" class="oreder_consigneeName">
	    								<s:property value="consigneeName" />
	    								&nbsp;<s:property value="sex"/>
	    							</option>
	    						</s:iterator>
	    					</select>
	    				</font>
	    				<font>
	    					收货地址：
	    					<select name="consigneeName" class="order_option">
	    						<option selected value="<s:property value="#session.nowConsignee.address"/>">
	    							<s:property value="#session.nowConsignee.address"/>&nbsp;&nbsp;&nbsp;
	    							<s:property value="#session.nowConsignee.doorNum"/>
	    						</option>
	    					</select>
	    				</font>
	    				<font>
	    					收货电话：
	    					<select name="consigneeName" class="order_option">
	    						<option selected value="<s:property value="#session.nowConsignee.addressTel"/>">
	    							<s:property value="#session.nowConsignee.addressTel"/>
	    						</option>
	    					</select>
	    				</font>
	    				<font>备注：</font>
	    				<textarea id="order_ta" placeholder="请留下您的要求！！！" name="order.note"></textarea>
	    				<input type="submit" value="提 交 订 单" id="order_submit"/>
	    			</form>
	    		</div>
    		</div>
    		
    		<div id="order_right">
    			<div id="order_detail2">
    				订单状态
    			</div>
    			
    			<div id="order_status">
    				<img src="images/ordetStatus1.png" id="status_img" >
    				<span class="order_status_span" style="margin-top:-1px;">
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
    		</div>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
