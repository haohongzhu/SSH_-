<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv='refresh' content='0;url=queryTopSix'>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#header1{
			height:200px;
		}
		#footer1{
			height:200px;
		}
		#main1{
			background: url(images/body_bg.jpg) no-repeat;
			height:500px;
			background-size:100% 100%;
		}
	</style>
  </head>
  
  <body onload="">
  	<div id="header1">
    	<jsp:include page="Foreground_header.jsp"></jsp:include>
    </div>
    <div id="main1">
    </div>
    <div id="footer1">
    	<jsp:include page="Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
