<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/css_manage_login.css" type="text/css" />
	<!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">-->
	
  </head>
  <script type="text/javascript">
function change(){  
    var img1=document.getElementById("checkImg");  
    img1.src="${pageContext.request.contextPath}/adminCheckImgAction.action?"+new Date().getTime(); //加时间戳防止缓存  
}  
  </script>
  <body>
    <div id ="up">
    	<div id="h_login"><img src="img/h_login.png"></div>
    	<div id="login_left"><img src="img/Zhu2.png"></div>
    		<div id="login">
    				<s:form action="adminLoginAction" namespace="/" method="post" theme="simple">
    				<table style="border-collapse:separate; border-spacing:0px 30px; font-size:28px;" class="table">
    					<tr id="tr1">
    						<td>账&nbsp;号:</td>
    						<td><s:textfield name="admin.adminID" placeholder="请输入账号" cssStyle="height:32px;width:200px;"/></td>
    					</tr>
    					<tr><td class="errormsg" colspan="2"><s:property value="errors.username[0]"/></td></tr>
    					<tr>
    						<td>密&nbsp;码:</td>
    						<td><s:password name="admin.adminPassword" placeholder="请输入密码" cssStyle="height:32px;width:200px;"/></td>
    					</tr>
    					<tr><td class="errormsg" colspan="2"><s:property value="errors.error[0]"/></td></tr>
    					<tr>
    						<td>验证码：</td>
    						<td><input type="text" id="checkcode" name="checkcode" class="text captcha" maxlength="4" autocomplete="off" style="height:30px;" placeholder="请输入验证码">
    						<img id="checkImg" class="captchaImage" src="${pageContext.request.contextPath}/adminCheckImgAction.action" onclick="change()" title="点击更换验证码"> </td>
    					</tr>
    					<tr><td class="errormsg" colspan="2"><s:property value="errors.error1[0]"/></td></tr>
    				</table>
    					<s:submit value="登录" id="btn"></s:submit>
    				</s:form>
    		</div>
    	</div>
    	
  </body>
</html>
