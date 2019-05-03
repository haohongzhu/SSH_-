<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_right_DeleteProType.jsp' starting page</title>
    
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
  <script type="text/javascript">
  //根据id删除产品类别
	function deleteProductType(id){
		if(confirm("你确定删除该产品吗?")){
			location.href="adminDeleteProType?id="+id;
		}
	}
  </script>
  
  <body style="overflow-y:hidden;overflow-x:hidden;">
  <div id="top">
		<jsp:include page="Main_top.jsp" flush="true"/>    
  </div>
  <div id="left">
  		<jsp:include page="Main_left.jsp" flush="true"/> 
  </div>
  <div id="right_UpdateAdminInf" style="overflow-y:scroll;overflow-x:scroll;">
  <h3 align="center">删除商品类别</h3>
  <img src="img/bt_bottom.png" width="100%">
  
  <div id="right_mid_UpdateAdminInf">
  <center>
		<table class="layui-table">
			<tr>
				<th>大类 </th>
				
				<th>小类 </th>
				
				<th>操作</th>
			</tr>
			<tr>
				<s:iterator value="productType">
					<tr>
						<td>${typeMethod}</td>
						
						<td>${typeName}</td>
						
						<td><button type='button' onclick="return deleteProductType('${id}');" >删除</button></td>
					</tr>
				</s:iterator>
			</tr>
		</table>
		[<a href="adminQueryProTypeAll?pageNo=1" class="yema">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="adminQueryProTypeAll?pageNo=${currentPage-1}" class="yema">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="adminQueryProTypeAll?pageNo=${currentPage+1}" class="yema">下一页</a>]
				</c:when>
			</c:choose>
		[<a href="adminQueryProTypeAll?pageNo=${totalPage}" class="yema">尾页</a>]
		（当前第${currentPage}/${totalPage}页）
  </center>
  </div>
  </div>
  </body>
</html>
