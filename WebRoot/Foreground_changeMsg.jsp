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
    
    <title>修改资料</title>
    
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
    		<h5>您的位置：首页 > 修改资料</h5>
    	</div>
    	
    	<div id="change_main_middle">
    		<s:form id="changePwd_f" theme="simple" action="updateCusAction" method="post">
    			&nbsp;用户名&nbsp;&nbsp;
    			<s:textfield cssClass="t2" name="customer.userName"/>
    			<font class="err"><s:property value="errors.userName[0]"/></font>
    			<font class="err"><s:property value="errors.userName2[0]"/></font>
    			<br><br>
    			真实姓名&nbsp;
    			<s:textfield cssClass="t2" name="customer.realName"/>
				<font class="err"><s:property value="errors.realName[0]"/></font>
    			<br><br>
    			手机号码&nbsp; 
    			<s:textfield cssClass="t2" name="customer.userTelephone"/>
				<font class="err"><s:property value="errors.userTel[0]"/></font>
    			<br><br>
    			<s:reset value="重  置" cssClass="change_b" /><br><br>
    			<s:submit value="确 定 修 改" cssClass="change_b" />
    			<s:hidden name="customer.id"/>
    		</s:form>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
