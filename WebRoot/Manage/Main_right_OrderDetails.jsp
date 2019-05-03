<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
		<base href="<%=basePath%>">
		<title>My JSP 'Main_right_OrderDetails.jsp' starting page</title>
		<script src="<%=basePath%>/js/Foreground.js"></script>
		<link rel="stylesheet" href="layui/css/layui.css"/>
	</head>

	<body style="overflow-y:hidden;overflow-x:hidden;">
		<div id="top">
			<jsp:include page="Main_top.jsp" flush="true" />
		</div>
		<div id="left">
			<jsp:include page="Main_left.jsp" flush="true" />
		</div>
		<div id="right_AddProduct"  style="overflow-y:scroll;overflow-x:scroll;">
			<h3 align="center">
				修改订单
			</h3>
			<img src="img/bt_bottom.png" width="100%">
			<div id="orderDetail">
				<table id="orderDetail_table" class="layui-table">
					<tr>
						<td>
							商品
						</td>
						<td>
							单价
						</td>
						<td>
							数量
						</td>
					</tr>
					<s:iterator value="#session.nowOrder.order_cartID.setCartInf">
						<tr>
							<td>
								<s:property value="productID4.productName" />
							</td>
							<td>
								<font>¥<s:property value="oneProductPrice" />
								</font>
							</td>
							<td>
								<font><s:property value="productCount" />份</font>
							</td>
						</tr>
					</s:iterator>
					</table>
					<table id="OrderCount" class="layui-table">
					<tr>
						<td colspan="2">
							总数：
						</td>
						<td>
							<s:property value="#session.nowOrder.order_cartID.totalCount" />
							份
						</td>
					</tr>
					<tr>
						<td colspan="2">
							总计：¥
						</td>
						<td>
							<s:property value="#session.nowOrder.order_cartID.totalPrice" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							订单编号：
						</td>
						<td>
							<s:property value="#session.nowOrder.id" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							下单顾客：
						</td>
						<td>
							<s:property value="#session.nowOrder.order_customer.realName" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							收货客人：
						</td>
						<td>
							<s:property
								value="#session.nowOrder.order_consignee.consigneeName" />
							(
							<s:property value="#session.nowOrder.order_consignee.sex" />
							)
						</td>
					</tr>
					<tr>
						<td colspan="2">
							收货地址：
						</td>
						<td>
							<s:property value="#session.nowOrder.order_consignee.address" />
							&nbsp;
							<s:property value="#session.nowOrder.order_consignee.doorNum" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							收货电话：
						</td>
						<td>
							<s:property value="#session.nowOrder.order_consignee.addressTel" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							支付方式：
						</td>
						<td>
							<s:property
								value="#session.nowOrder.order_payment.paymentTypeName" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							备注：
						</td>
						<td>
							<s:property value="#session.nowOrder.note" />
						</td>
					<tr>
						<td colspan="2">
							订单状态：
						</td>
						<td>
							<s:property value="#session.nowOrderStatus" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<%
								String status = (String) request.getSession().getAttribute(
										"nowOrderStatus");
								if (status.equals("未接单")) {
							%>是否接单
							<%
								} else if (status.equals("已接单")) {
							%>是否配送
							<%
								} else if (status.equals("配送中")) {
							%>是否配送完成<%
								}
							%>
						</td>
						<td>
							<%
								if (!status.equals("已送达")) {
							%>
							<a href="javascript:adminUpdateStatus('<s:property value="id"/>','<s:property value="#session.nextStatus"/>')">确认</a>
							<%
								}
							%>
						</td>
					</tr>
				</table>
			</div>
		</div>

 		<script>
	 		layui.use(['layer', 'form', 'element','table'], function(){
	  			var layer = layui.layer
			  ,form = layui.form
			  ,element = layui.element
			  ,table = layui.table;
		
			});
 		</script>
	</body>
</html>
