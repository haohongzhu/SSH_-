<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_right_AddProductType.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
 	<link rel="stylesheet" href="layui/css/layui.css"/>
	<script type="text/javascript" src="js/manage_check.js"></script>
  </head>

  <body style="overflow-y:hidden;overflow-x:hidden;">
  <div id="top">
		<jsp:include page="Main_top.jsp" flush="true"/>    
  </div>
  <div id="left">
  		<jsp:include page="Main_left.jsp" flush="true"/> 
  </div>
  <div id="right_AddProType" style="overflow-y:scroll;overflow-x:scroll;">
  <h3 align="center">添加分类</h3>
  <img src="img/bt_bottom.png" width="100%">
  <div id="right_mid_AddProType">
  <s:action name="adminQueryProType1" executeResult="false" namespace="/"/>
  
  	<center>
  		<form action="adminAddTypeMethod.action" method="post" onsubmit="return MethodCheck();">
  			<table>
  				<tr><th><center><span>添加产品分类</span></center><th></tr>
  				<tr>
  					<td><span>添加产品大类：</span></td>
  					<td><input type="text" name="typeMethod" id="typeMethod"/></td>
  					<td><input type="submit" value="添加"></td>
  				</tr>
  			</table> 			
  		</form>
  		<br/>
  		<br/>
  		<form action="adminAddTypeName.action" ,method="post" onsubmit="return TypeNameCheck();">
  			<table>
  				<tr>
  					<td>添加产品子类</td>
  				</tr>
  				<tr>
  				<td><span>选择产品大类：</span></td>
  					<td>
  					<select name="type" id="type">
  						<option value="">
  						
  						</option>
<!--					<option  value="${typemethod1}" selected>-->
<!--						${typemethod1}-->
<!--					</option>-->
					<s:iterator value="#session.productTypes2" var="productTypes2">
							<option value="<s:property value="productTypes2"/>">
      							<s:property value="productTypes2"/>
							</option>
					</s:iterator>
					</select>
					</td>
  				</tr>
  				<tr>
  					<td><span>添加产品子类：</span></td>
  					<td><input type="text" name="typeName" id="typeName"/></td>
  					<td><input type="submit" value="添加"></td>
  				</tr>
  			</table> 
  		</form>
  	</center>
  </div>
   	<%request.getSession().removeAttribute("typemethod1"); %>
  </div>
  </body>
</html>
