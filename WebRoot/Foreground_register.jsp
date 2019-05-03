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
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">

  </head>
  
  <body style="background: url(images/body_bg.jpg) no-repeat;background-size:100% 100%;">
    <div id="register">
    	<div id="register_header">
    		<img  src="images/pig.png" style="width:100px;height:80px;float:left;">
    		<span><b>订餐系统</b></span>
    	</div>
    	
    	<hr size="3" color="#663333" width="100%">
    	
    	<div id="register_main">
    		<s:form id="reg_f" theme="simple" action="regCusAction" method="post">
    			<img src="images/login.png" style="width:30px;height:25px;margin-bottom:-7px;margin-left:105px;"/>
   				<font color="grey" size="4px">用户注册</font><br>
   				&nbsp;用户名&nbsp;&nbsp;&nbsp;
   				<s:textfield style="margin-top:10px;" cssClass="t1" name="customer.userName"/>
   				<font class="err"><s:property value="errors.userName[0]"/></font>
   				<font class="err"><s:property value="errors.userName2[0]"/></font>
   				<br><br>
   				真实姓名&nbsp;&nbsp;
   				<s:textfield cssClass="t1" name="customer.realName"/>
   				<font class="err"><s:property value="errors.realName[0]"/></font>
   				<br><br>
   				手机号码&nbsp;&nbsp;
   				<s:textfield cssClass="t1" name="customer.userTelephone"/>
   				<font class="err"><s:property value="errors.userTel[0]"/></font>
   				<br><br>
   				创建密码&nbsp;&nbsp;
   				<s:password cssClass="t1" name="customer.password"/>
   				<font class="err"><s:property value="errors.pwd1[0]"/></font>
   				<br><br>
   				确认密码&nbsp;&nbsp;
   				<s:password cssClass="t1" name="rePwd"/>
   				<font class="err"><s:property value="errors.pwd2[0]"/></font>
   				<br><br>
   				<span id="login_span">
   					已有账号？|
   					<a href="Foreground_login.jsp">登录</a>
   				</span><br><br>
   				<s:reset cssClass="reg_b" value="重  置"/><br><br>
   				<s:submit cssClass="reg_b" value="同意以下协议并注册"/><br><br>
   				<a href="#" id="agreement" style="margin-left:107px;color:#663333;font-size:15px;">《用户协议》</a>
    		</s:form>
    	</div>
    	
    	<div id="register_footer">
    		<h4>Copyright © 2018 - ∞ 北京理工大学珠海学院34栋633</h3>
    	</div>
    </div>
  </body>
</html>
