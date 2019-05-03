<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>My JSP 'Main_right_QueryOrder.jsp' starting page</title>
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
				修改订单
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
					</tr>
				</table>

				<s:action name="queryOrder" namespace="/" executeResult="false" />
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
					<s:iterator value="#session.ordersList">
						<tr>
							<td>
								<s:property value="id" />
							</td>
							<td>
								<s:property value="order_customer.realName" />
							</td>
							<td>
								<s:property value="order_consignee.consigneeName" />
							</td>
							<td>
								<s:property value="orderTime" />
							</td>
							<td>
								<s:property value="orderStatus" />
							</td>
							<td>
								<s:property value="note" />
							</td>
							<td>
								<a href="adminQueryOrderById?id=<s:property value="id"/>">详情</a>
							</td>
						</tr>
					</s:iterator>
					<tr style="border-buttom: none">
						<td colspan="7">
							<a href="queryOrder?pageNo=1">首页</a>
							<a href="queryOrder?pageNo=${currentPage-1}">上一页</a>
							<a href="queryOrder?pageNo=${currentPage+1}">下一页</a>
							<a href="queryOrder?pageNo=${totalPage}">末页</a>
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
