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
    
    <title>更改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">

  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="change_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 更改密码</h5>
    	</div>
    	
    	<div id="change_main_middle">
    		<s:form id="changePwd_f" theme="simple" action="changePwdCusAction" method="post">
    			&nbsp;旧密码&nbsp;&nbsp;
    			<s:password cssClass="t2" name="oldPwd"/>
    			<font class="err"><s:property value="errors.pwd1[0]"/></font>
    			<font class="err"><s:property value="errors.changeError[0]"/></font>
    			<br><br>
    			&nbsp;新密码&nbsp;&nbsp;
    			<s:password cssClass="t2" name="newPwd"/>
    			<font class="err"><s:property value="errors.pwd2[0]"/></font>
    			<font class="err"><s:property value="errors.pwd4[0]"/></font>
    			<br><br>
    			确认密码&nbsp; 
    			<s:password cssClass="t2" name="newPwd2"/>
    			<font class="err"><s:property value="errors.pwd3[0]"/></font>
    			<br><br>
    			<s:reset value="重  置" cssClass="change_b" /><br><br>
    			<s:submit value="确 定 修 改" cssClass="change_b" />
    		</s:form>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
