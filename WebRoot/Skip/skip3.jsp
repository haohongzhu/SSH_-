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
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_CartAndOrder.css">
	<script>
		window.onload=function(){
			alert("该购物车的订单已创建，现为您跳转到支付页面！！！");
			location.href="queryNoPay";
		}
	</script>

  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="payForOrder_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 购物车</h5>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>