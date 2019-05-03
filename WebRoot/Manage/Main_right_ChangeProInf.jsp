<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_right_QueryProInf.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/manage_check.js"></script>
	<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
	<link rel="stylesheet" href="layui/css/layui.css"/>
  </head>
  
  <body style="overflow-y:hidden;overflow-x:hidden;">
	<div id="top">
		<jsp:include page="Main_top.jsp" flush="true"/>    
	</div>
	<div id="left">
  		<jsp:include page="Main_left.jsp" flush="true"/> 
	</div>
	<div id="right_ChangeProInf" style="overflow-y:scroll;overflow-x:scroll;">
  	<h3 align="center">全部商品信息</h3>
 	<img src="img/bt_bottom.png" width="100%">
 	<div id="right_mid_ChangeProInf">
 	<div class="layui-form">
	  	<table class="layui-table" id="table_showProMsg">
	  		<tr align="center">
 				<th colspan="2" style="text-align:center">商品名称</th>				
 				<th style="text-align:center">月售</th>
 				<th style="text-align:center">点赞次数</th>
 				<th colspan="2" style="text-align:center">详情</th>
 				<th style="text-align:center">价格</th>
 				<th style="text-align:center">图片路径</th>
 				<th style="text-align:center">操作</th>
 			</tr>
 		<s:iterator value="products" status="st" var="pro">
			<tr align="center">
				<td colspan="2"><s:property value="#pro.productName"/></td>	
				<td><s:property value="#pro.monthSale"/></td>	
				<td><s:property value="#pro.praise"/></td>
				<td colspan="2"><s:property value="#pro.description"/></td>
				<td><s:property value="#pro.price"/></td>
				<td><s:property value="#pro.img"/></td>
				<td>
					<a href="javascript:queryUserDetails('<s:property value="id"/>')" class="layui-btn layui-btn-xs" lay-event="edit" style="color:white;">修改</a>
					<a href="javascript:deleteProduct('<s:property value="id"/>')" class="layui-btn layui-btn-xs" lay-event="del" style="color:white;">删除</a>
				</td>
			</tr>
		</s:iterator>
	  	</table>
	  	[<a href="adminQueryProAll0?pageNo=1" class="yema">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="adminQueryProAll0?pageNo=${currentPage-1}" class="yema">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="adminQueryProAll0?pageNo=${currentPage+1}" class="yema">下一页</a>]
				</c:when>
			</c:choose>
		[<a href="adminQueryProAll0?pageNo=${totalPage}" class="yema">尾页</a>]
  	</div>
 	<!--<center>
 		<table id="table_showProMsg" cellspacing="7" cellpadding="7">
 			<tr align="center"">
 				<th colspan="2">商品名称</th>				
 				<th>月售</th>
 				<th>点赞次数</th>
 				<th colspan="2">详情</th>
 				<th>价格</th>
 				<th>图片路径</th>
 			</tr>
 		<s:iterator value="products" status="st" var="pro">
			<tr align="center">
				<td colspan="2"><s:property value="#pro.productName"/></td>	
				<td><s:property value="#pro.monthSale"/></td>	
				<td><s:property value="#pro.praise"/></td>
				<td colspan="2"><s:property value="#pro.description"/></td>
				<td><s:property value="#pro.price"/></td>
				<td><s:property value="#pro.img"/></td>
				<td>
					<a href="javascript:queryUserDetails('<s:property value="id"/>')">修改</a>
					<a href="javascript:deleteProduct('<s:property value="id"/>')">删除</a>
				</td>
			</tr>
		</s:iterator>
 		</table>
 		[<a href="adminQueryProAll0?pageNo=1" class="yema">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="adminQueryProAll0?pageNo=${currentPage-1}" class="yema">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="adminQueryProAll0?pageNo=${currentPage+1}" class="yema">下一页</a>]
				</c:when>
			</c:choose>
		[<a href="adminQueryProAll0?pageNo=${totalPage}" class="yema">尾页</a>]
		</center>
 	-->
 	</div>
 	</div>
 	
 	
 	<script>
 		layui.use('table', function(){
		  var table = layui.table;
		});
 	</script>
  </body>
</html>
