<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>尾部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">

  </head>
  
  <body>
	<div id="footer">
		<div id="footer_container">
			<ul class="about">
				<li>开店申请</li>
				<li>配送加盟</li>
				<li>城市代理</li>
				<li>零售加盟</li>
			</ul>
			<ul class="about" style="margin-left: 70px">
				<li>开放平台</li>
				<li>关于本站</li>
				<li>媒体报道</li>
				<li>平台制度</li>
			</ul>
			<ul class="about" style="margin-left: 70px">
				<li>常见问题</li>
				<li>用户反馈</li>
				<li>诚信举报</li>
				<li>加入我们</li>
			</ul>
			<span id="service">
				<h3>客服电话:1-200-346-2986</h3><br>
				周一至周日&nbsp;9:00-23:00<br>
				客服不受理商务合作
			</span>
			<div id="payment">
				<img src="images/marker1.png" style="width: 17px;height: 17px;">
				<span style="display: block;margin-right: 47px;margin-top:-1px;float: right;"><b>您的付款方式：</b></span>
				<img src="images/payment.png" style="width: 220px;height: 70px;margin-top: 10px;">
			</div>
			<div id="copyright">
				<h3>Copyright © 2018 - ∞ 北京理工大学珠海学院34栋633</h3>
			</div>

		</div>
	</div>
  </body>
</html>
