<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'Main_right_QueryResult.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
		<link rel="stylesheet" href="layui/css/layui.css"/>
	</head>

	<body style="overflow-y:hidden;overflow-x:hidden;">
		<div id="top">
			<jsp:include page="Main_top.jsp" flush="true" />
		</div>
		<div id="left">
			<jsp:include page="Main_left.jsp" flush="true" />
		</div>
		<div id="right_AddProduct" style="overflow-y:scroll;overflow-x:scroll;">
			<h3 align="center">
				查询
			</h3>
			<img src="img/bt_bottom.png" width="100%">
			<div id="orderList">
				<table id="orderList_search" class="layui-table">
					<tr>
						<s:form action="queryOrderByKey" method="post" theme="simple">
							<td>
								<s:textfield name="key" />
								<s:submit value="搜索" theme="simple" />
							</td>								
							<s:property value="Errors.Key[0]" />
						</s:form>
						<s:property value="Errors.Key[0]" />
					</tr>
				</table>
				<table id="orderList_table" class="layui-table">
					<tr>
						<th style="text-align:center">
							订单号
						</th>
						<th style="text-align:center">
							客户
						</th>
						<th style="text-align:center">
							收货人
						</th>
						<th style="text-align:center">
							下单时间
						</th>
						<th style="text-align:center">
							订单状态
						</th>
						<th style="text-align:center">
							备注
						</th>
						<th style="text-align:center">
							查看详情
						</th>
					</tr>
					<s:iterator value="orders" var="order">
						<tr>
							<td>
								<s:property value="#order.id" />
							</td>
							<td>
								<s:property value="#order.order_customer.realName" />
							</td>
							<td>
								<s:property value="#order.order_consignee.consigneeName" />
							</td>
							<td>
								<s:property value="#order.orderTime" />
							</td>
							<td>
								<s:property value="#order.orderStatus" />
							</td>
							<td>
								<s:property value="#order.note" />
							</td>
							<td>
								<a href="adminQueryOrderById?id=<s:property value="id"/>">详情</a>
							</td>
						</tr>
					</s:iterator>
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
