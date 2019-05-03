<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'AddAdmin.jsp' starting page</title>

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

	<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
	<body style="overflow-y:hidden;overflow-x:hidden;">
		<s:action name="queryRole"></s:action>
		<div id="top">
			<jsp:include page="Main_top.jsp" flush="true" />
		</div>
		<div id="left">
			<jsp:include page="Main_left.jsp" flush="true" />
		</div>
		<div id="right_UpdateAdminInf" style="overflow-y:scroll;overflow-x:scroll;">
			<h3 align="center">
				添加管理员
			</h3>
			<img src="img/bt_bottom.png" width="100%">
			<div id="right_mid_UpdateAdminInf">
				<form action="addAdmin.action" method="post" id="reg_f" theme="simple" class="layui-form">
					<div class="layui-form-item">
					    <label class="layui-form-label">管理员id:</label>
					    <div class="layui-input-block">
					      <input type="text" name="admin.adminID" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input" >
					      <s:property value="Errors.adminID2[0]" />
						  <s:property value="Errors.adminID[0]" />
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">管理员真实姓名:</label>
					    <div class="layui-input-block">
					      <input type="text" name="admin.adminRealName" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">管理员密码:</label>
					    <div class="layui-input-block">
					      <input type="password" name="admin.adminPassword" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					      <s:property value="Errors.adminPassword[0]" />
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">确认密码:</label>
					    <div class="layui-input-block">
					      <input type="password" name="Password1" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">	
					      <s:property value="Errors.Password[0]" />				      
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">手机号码:</label>
					    <div class="layui-input-block">
					      <input type="text" name="admin.telephone" lay-verify="required\phone\number" autocomplete="off" placeholder="请输入" class="layui-input">	
					      <s:property value="Errors.telephone[0]" />				      
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">私人电话:</label>
					    <div class="layui-input-block">
					      <input type="text" name="admin.telephonep" lay-verify="required\phone\number" autocomplete="off" placeholder="请输入" class="layui-input">	
					      <s:property value="Errors.telephone[0]" />				      
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">qq号码:</label>
					    <div class="layui-input-block">
					      <input type="text" name="admin.qq" lay-verify="number" autocomplete="off" placeholder="请输入" class="layui-input">					      
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">微信:</label>
					    <div class="layui-input-block">
					      <input type="text" name="admin.wechat" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">					      
					    </div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">邮箱:</label>
					    <div class="layui-input-block">
					      <input type="text" name="admin.email" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">					      
					    </div>
					</div>
					<div class="layui-form-item">
				    <label class="layui-form-label">职位：</label>
					    <div class="layui-input-block">
					      <s:action name="queryRole" namespace="/" executeResult="false" />
								<select name="roleID">
									<option value=-1>
										请选择角色
									</option>
									<s:iterator value="#session.roleList">
										<option value=<s:property value="id" />>
											<s:property value="positionName" />
										</option>
									</s:iterator>
								</select>
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
							<td>
								管理员id:
							</td>
							<td>
								<input type="text" name="admin.adminID" />
							</td>
							<td>
								<s:property value="Errors.adminID2[0]" />
								<s:property value="Errors.adminID[0]" />
							</td>
						</tr>
						<tr>
							<td>
								管理员真实姓名:
							</td>
							<td>
								<input type="text" name="admin.adminRealName" />
							</td>
							<td>
								<s:property value="Errors.adminRealName[0]" />
							</td>
						</tr>
						<tr>
							<td>
								管理员密码:
							</td>
							<td>
								<input type="password" name="admin.adminPassword">
							</td>
							<td>
								<s:property value="Errors.adminPassword[0]" />
							</td>
						</tr>
						<tr>
							<td>
								确认密码:
							</td>
							<td>
								<input type="password" name="Password1">
							</td>
							<td>
								<s:property value="Errors.Password[0]" />
							</td>
						</tr>
						<tr>
							<td>
								手机号码:
							</td>
							<td>
								<input type="text" name="admin.telephone"
									onkeyup="value=value.replace(/[^\d]/g,'')" />
							</td>
							<td>
								<s:property value="Errors.telephone[0]" />
							</td>
						</tr>
						<tr>
							<td>
								私人电话:
							</td>
							<td>
								<input type="text" name="admin.telephonep"
									onkeyup="value=value.replace(/[^\d]/g,'')" />
							</td>
							<td>
								<s:property value="Errors.telephonep[0]" />
							</td>
						</tr>
						<tr>
							<td>
								qq号码:
							</td>
							<td>
								<input type="text" name="admin.qq"
									onkeyup="value=value.replace(/[^\d]/g,'')" />
							</td>
						</tr>
						<tr>
							<td>
								微信:
							</td>
							<td>
								<input type="text" name="admin.wechat"
									onkeyup="value=value.replace(/[^\d]/g,'')" />
							</td>
						</tr>
						<tr>
							<td>
								邮箱:
							</td>
							<td>
								<input type="text" name="admin.email"
									onkeyup="value=value.replace(/[^\d]/g,'')" />
							</td>
						</tr>
						<tr>
							<td>
								职位:
							</td>
							<td>
								<s:action name="queryRole" namespace="/" executeResult="false" />
								<select name="roleID">
									<option value=-1>
										请选择角色
									</option>
									<s:iterator value="#session.roleList">
										<option value=<s:property value="id" />>
											<s:property value="positionName" />
										</option>
									</s:iterator>
								</select>
							</td>
							<td>
								<s:property value="Errors.roleID[0]" />
							</td>
						</tr>
						<tr>
							<td>
								<input type="submit" value="提交" />
								&nbsp&nbsp&nbsp&nbsp&nbsp
								<input type="reset" value="重置" />
							</td>
						</tr>

					</table>
				-->
				</form>
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
