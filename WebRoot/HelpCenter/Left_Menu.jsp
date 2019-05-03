<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>帮助中心左侧菜单栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground.css">	
  </head>
  
  <body>
    <div id="Left_Menu">
    	<ul>
    		<a href="HelpCenter/PaymentProblem.jsp"><li class="li1" id="lb1">在线支付问题</li></a>
    		<a href="HelpCenter/DiscountProblem.jsp"><li class="li1" id="lb2">优惠问题</li></a>
    		<a href="HelpCenter/OrderProblem.jsp"><li class="li1" id="lb3">订单问题</li></a>
    		<a href="HelpCenter/OtherProblem.jsp"><li class="li1" id="lb4">其他问题</li></a>
    	</ul>
    </div>
  </body>
</html>
