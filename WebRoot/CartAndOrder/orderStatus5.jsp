<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>已送达</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_CartAndOrder.css">

  </head>
  
  <body>
    <div id="order_status">
    	<img src="images/orderStatus7.png" id="status_img" >
    	<span class="order_status_span" style="margin-top:-1px;color:rgb(255,192,0);" >
    		添加购物车商品成功，等待提交订单！
    	</span>
    	<span class="order_status_span" style="margin-top:-330px;color:rgb(255,192,0);">
    		订单提交成功，等待付款！
    	</span>
    	<span class="order_status_span" style="margin-top:-252px;color:rgb(255,192,0);">
    		付款成功，等待接单！
    	</span>
    	<span class="order_status_span" style="margin-top:-174px;color:rgb(255,192,0);">
    		商家已接单，商品制作中！
    	</span>
    	<span class="order_status_span" style="margin-top:-96px;color:rgb(255,192,0);">
    		送货员配送中！
    	</span>
    	<span class="order_status_span" style="margin-top:-18px;color:rgb(255,192,0);">
    		商品已送达！
    	</span>
    </div>
  </body>
</html>
