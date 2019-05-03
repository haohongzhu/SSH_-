<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>跳转</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv='refresh' content='1;url=queryByNameCusAction'>
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<script src="js/Foreground.js"></script>
	<script type='text/javascript'>
		var i=1;   
		window.onload=getTime;
	</script> 
  </head>
  
  <body>
  	<div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div class="skip_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 跳转页面</h5>
    	</div>
    	<div class="skip_main_bottom">
           	 修改成功!!将在<span id='num' style='display=inline;'>1</span>秒后跳转至个人资料页面！  
		</div>
    </div> 
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
