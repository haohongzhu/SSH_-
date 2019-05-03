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
    
    <title>My JSP 'Main_right_AdminChangePwd.jsp' starting page</title>
    
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
		<jsp:include page="Main_top.jsp" flush="true"/>    
  </div>
  <div id="left">
  		<jsp:include page="Main_left.jsp" flush="true"/> 
  </div>
  <div id="right_AdminChangePwd" style="overflow-y:scroll;overflow-x:scroll;">
  	<h3 align="center">修改密码</h3>
 	<img src="img/bt_bottom.png" width="100%">
 	<div id="right_mid_AdminChangePwd">
 	<center>
 		<form action="adminChangePwdAction.action" method="post" class="layui-form">
 			<div class="layui-form-item">
				<label class="layui-form-label">旧密码:</label>
				<div class="layui-input-block">
					<input type="password" name="oldpwd" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					<s:property value="errors.ErrorOldpwd[0]"/>
					<s:property value="errors.ErrorPwd[0]"/>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">新密码:</label>
				<div class="layui-input-block">
					<input type="password" name="newpwd" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					<s:property value="errors.ErrorNewpwd[0]"/>
					<s:property value="errors.ErrorReOldpwd[0]"/>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">确认密码:</label>
				<div class="layui-input-block">
					<input type="password" name="renewpwd" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					<s:property value="errors.ErrorRenewpwd[0]"/>
					<s:property value="errors.ErrorRePwd[0]"/>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
 			<!--<table>
 				<tr>
 					<td><span class="right_th">旧密码:</span></td>
 					<td><input type="password" name="oldpwd" style="width:180px;align:left;height:26px;"/></td>
 					<td class="errormsg"><s:property value="errors.ErrorOldpwd[0]"/></td>
 					<td class="errormsg"><s:property value="errors.ErrorPwd[0]"/></td>
 				</tr>
 				<tr><td>&nbsp;</td></tr>
 				<tr>
 					<td><span class="right_th">新密码:</span></td>
 					<td><input type="password" name="newpwd" style="width:180px;align:left;height:26px;"/></td>
 					<td class="errormsg"><s:property value="errors.ErrorNewpwd[0]"/></td>
 					<td class="errormsg"><s:property value="errors.ErrorReOldpwd[0]"/></td>
 				</tr>
 				<tr><td>&nbsp;</td></tr>
 				<tr>
 					<td><span class="right_th">确认密码:</span></td>
 					<td><input type="password" name="renewpwd" style="width:180px;align:left;height:26px;"/></td>
 					<td class="errormsg"><s:property value="errors.ErrorRenewpwd[0]"/></td>
 					<td class="errormsg"><s:property value="errors.ErrorRePwd[0]"/></td>
 				</tr>
 				<tr><td>&nbsp;</td></tr>
 				<tr>
 					<td><input type="submit" value="提交" id="changepwd"/></td>
 				</tr>
 			</table>
 		-->
 		</form>
 	</center>
 	</div>
  </div>
  
 		<script>
	 		layui.use(['layer', 'form', 'element'], function(){
	  			var layer = layui.layer
			  ,form = layui.form
			  ,element = layui.element;
		
			});
 		</script>
  </body>
</html>
