<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_right_Customerword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
	<link rel="stylesheet" href="layui/css/layui.css"/>
	

  </head>
  <script type="text/javascript">
  //修改
	function queryUserDetails(id){
	location.href="queryAdminById?id="+id;
	}
  	function deleteUser(userId){
	if(confirm("你确定删除该用户吗?")){
		location.href="deleteAdminById?id="+userId;
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
  
  <div id="right_CustomerWord" style="overflow-y:scroll;overflow-x:scroll;">
  <h3 align="center">查询管理员资料</h3>
  <img src="img/bt_bottom.png" width="100%">
  <div id="right_mid_CustomerWord">
  	<table id="table_showWordMsg" class="layui-table">
		<tr>
			<th style="text-align:center"><span class="right_th">用户姓名</span></th>
			<th style="text-align:center"><span class="right_th">用户角色</span></th>
			<th style="text-align:center"><span class="right_th">操作</span></th>
		</tr>
		<s:iterator value="admin" var="admins">
		<tr align="center" >
			<td><s:property value="#admins.adminRealName"/></td>	
			<td><s:property value="#admins.role.positionName"/></td>
			<td>
				<a href="javascript:queryUserDetails('<s:property value="id"/>')" class="layui-btn layui-btn-xs" lay-event="edit" style="color:white;">修改</a>
				<a href="javascript:deleteUser('<s:property value="id"/>')" class="layui-btn layui-btn-xs" lay-event="del" style="color:white;">删除</a>
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
