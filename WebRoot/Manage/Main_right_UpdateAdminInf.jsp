<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_right_QueryAdminInf.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="layui/css/layui.css"/>
  </head>
  <script type="text/javascript">
  	function checkRole(){
   		var obj = document.getElementById("theRole");
   		for(i=0;i<obj.length;i++){
        	if(obj[i].value.trim()=="<%=session.getAttribute("cid")%>".trim())
            obj[i].selected = true;
   		}
  	}
  </script>
  
 <link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
 
  <body onload="checkRole()" style="overflow-y:hidden;overflow-x:hidden;">
  <div id="top">
		<jsp:include page="Main_top.jsp" flush="true"/>    
  </div>
  <div id="left">
  		<jsp:include page="Main_left.jsp" flush="true"/> 
  </div>
  <div id="right_UpdateAdminInf" style="overflow-y:scroll;overflow-x:scroll;">
  <h3 align="center">修改管理员信息</h3>
  <img src="img/bt_bottom.png" width="91.5%">
  <div id="right_mid_UpdateAdminInf">
 	<form action="updateAdminAction.action"  method="post" class="layui-form">
		<table class="layui-table" lay-skin="nob">
		<tr>
			<th style="font-size:19px;">姓名:</th>
			<th>
			<input type="text" name="admin.adminRealName" id="adminRealName" 
				style="width:180px;align:left;height:30px;" value="<s:property value="admin.adminRealName" />" readonly= "true"/>
			</th>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<th style="font-size:19px;">角色:</th>
			<th>
		<select name="theRole" id="theRole">
			<option>
				请选择角色
			</option>
			<s:iterator value="role" var="roles">
				<option value=<s:property value="#roles.id" /> >
					<s:property value="#roles.positionName" />
				</option>
			</s:iterator>
		</select>	
			</th>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<th style="width:150px;height:30px;font-size:19px;">电话号码:</th>
			<th>
			<input type="text" style="width:180px;align:left;height:30px;" name="admin.telephone" value="<s:property value="admin.telephone" />" />
			</th>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<th style="width:150px;height:30px;font-size:19px;">私人电话号码:</th>
			<th>
			<input type="text"  style="width:180px;align:left;height:30px;" name="admin.telephonep" value="<s:property value="admin.telephonep" />" />
			</th>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<th style="width:150px;height:30px;font-size:19px;">qq:</th>
			<th>
			<input type="text" style="width:180px;align:left;height:30px;" name="admin.qq" value="<s:property value="admin.qq" />" />
			</th>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<th style="width:150px;height:30px;font-size:19px;">微信:</th>
			<th>
			<input type="text" style="width:180px;align:left;height:30px;" name="admin.wechat" value="<s:property value="admin.wechat" />" />
			</th>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<th style="width:150px;height:30px;font-size:19px;">电子邮箱:</th>
			<th>
			<input type="text" style="width:180px;align:left;height:30px;" name="admin.email" value="<s:property value="admin.email" />" />
			</th>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
		<td>&nbsp;</td>
			<td>
				<input type="hidden" name="admin.role.id" value="<s:property value="admin.role.id" />" />
				<input type="hidden" name="admin.id" value="<s:property value="admin.id" />" />
				<input type="submit" value="确认修改" id="changeAdmin"/>
			</td>
		</tr>
		</table>
	</form>
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
