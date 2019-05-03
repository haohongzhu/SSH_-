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
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
  </head>
  
  <body style="background: url(images/body_bg.jpg) no-repeat;background-size:100% 100%;">
    <div id="login">
    	<div id="login_header">
    		<img  src="images/pig.png" style="width:100px;height:80px;float:left;">
    		<span><b>校园订餐</b></span>
    	</div>
    	
    	<hr size="3" color="#663333" width="100%">
    	
    	<div id="login_main">
    		<div id="login_main_left">
    			<img src="images/pig2.png" style="width:350px;height:280px;margin-left:100px;">
    			<img src="images/p1.png" style="width:350px;height:140px;margin-left:100px;">
    		</div>
    		<div id="login_main_right">
    			<s:form id="log_f" theme="simple" action="logCusAction" method="post">
   					<img src="images/login.png" style="width:30px;height:25px;margin-bottom:-7px;"/>
   					<font color="grey" size="4px">用户登录</font><br>
   					<img src="images/user.png" style="width:28px;height:33px;margin-bottom:-12px;"/>
   					<s:textfield id="uname" placeholder="   请输入正确的用户名" name="customer.userName"/>
   					<font class="err"><s:property value="errors.logUserName[0]"/></font>
   					<font class="err"><s:property value="errors.logError[0]"/></font>
   					<br>
   					<img src="images/key.png"style="width:28px;height:34px;margin-bottom:-12px;"/>
   					<s:password id="pwd" placeholder="   请输入正确的密码" name="customer.password"/>
   					<font class="err"><s:property value="errors.logPassword[0]"/></font>
   					<br>
   					<span>
   						<a href="#">忘记密码?</a>&nbsp;|
   						<a href="Foreground_register.jsp">注册</a>
   					</span>
   					<s:reset value="重   置" cssClass="reg_b" cssStyle="margin-left:35px; margin-top:10px;"/>
   					<s:submit value="登    录" id="submit"/>
    			</s:form>
    			<br>
    			&nbsp;&nbsp;&nbsp;&nbsp;
    			<hr class="hrLine" style="width:57px;"/>
    			<font color="grey" size="4px">更多登录方式</font>
    			<hr class="hrLine" style="width:57px;"/><br>
    			<img src="images/qq.png" style="width:32px;height:32px;margin-left:125px;margin-bottom:-2px;margin-top:5px;">
    			<img src="images/blog.png" style="width:30px;height:30px;">
    		</div>
    	</div>
    	
    	<div id="login_footer">
    		<h4>Copyright © 2018 - ∞ 北京理工大学珠海学院34栋633</h3>
    	</div>
    </div>
  </body>
</html>
