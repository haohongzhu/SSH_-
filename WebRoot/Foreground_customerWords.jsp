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
    
    <title>意见与反馈</title>
    
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
    
    <div id="cusWords_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 意见与反馈</h5>
    	</div>
    	<div id="cusWords_main_middle">
    		<s:form theme="simple" action="addWordsCusAction" method="post">
    			您的意见<s:textarea id="ta2" placeholder=" 请留下您宝贵的意见" name="customerWords.words"/>
    			<font class="err" style="float:right;margin-right:190px;margin-top:-165px;">
    				<s:property value="errors.words[0]"/>
    			</font>
    			<s:reset value="重 置" cssClass="cusWords_b" cssStyle="margin-top:20px;"/><br><br>
    			<s:submit value="提 交" cssClass="cusWords_b"/>
    		</s:form>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
