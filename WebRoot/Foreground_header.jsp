<%@ page language="java" import="java.util.*,com.customer.models.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>头部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<script src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		function queryByNameOrType(){
			location.href="ProductQueryByNameAndType";
		}
		
		$(function(){
			$(".navmenu").mouseover(function(){
				$(this).children("ul").show();
			});
		});
		
		$(function(){
			$(".navmenu").mouseout(function(){
				$(this).children("ul").hide();
			});
		});
	</script>
  </head>
  
  <body>
	<div id="header">
		<div id="container">
			<div id="header_top">
				<ul id="phone">
					<li id="phone_left" style="margin-left: 50px;line-height: 28px;">
						<img src="images/mobile.png" style="width: 20px;height: 20px;margin-bottom: 3px;">&nbsp;
						<span class="phone_num"><b>1-200-346-2986</b></span>
					</li>
					<li id="phone_right" style="margin-left: 200px;"><span class="phone_num" style="color: #B7C9E0;line-height: 28px;"><b>欢迎来到订餐系统!</b></span></li>
					<li style="margin-left: 60px;"><img src="images/logo.jpg" style="width: 150px;height: 30px;">
					<li>
						<div id="msg">
							<b>购物车与未付款订单→</b>
						</div>
						<a href="">
							<div id="cart">
								<a href="queryCart"><img src="images/cart1.png" style="width: 35px;height: 30px;margin-left: 10px;"></a>
							</div>
						</a>
						<a href="">
							<div id="order">
								<a href="queryNoPay"><img src="images/order.png" style="width: 25px;height: 23px;margin-top: 3px;margin-left: 10px;"></a>
							</div>
						</a>
					</li>
				</ul>
			</div>
			<div id="header_bottom">
				<div id="shopName">
					<img src="images/logo.png">
				</div>
				<div id="header_bottom_right">
					<div id="navigation">
						<div id="menu">
							<ul id="menu_ul">
								<a href=""><li>首页</li></a>
								<a href="queryConInfAction"><li style="">收货地址</li></a>
								<a href="queryAllOrder"><li style="margin-left: 40px;">我的订单</li></a>
								<a href="HelpCenter/PaymentProblem.jsp"><li style="margin-left: 40px;">帮助中心</li></a>
								<a href="Foreground_customerWords.jsp"><li style="margin-left: 40px;">意见与反馈</li></a>
							</ul>
						</div>
						<div id="search">
							<form action="ProductQueryByNameAndType" method="post">
								<input type="text" name="search" placeholder="请输入要搜索的类别或菜名" style="width: 250px;height: 30px;margin-top: 5px;margin-left: 35px;font-size: 18px;">
								<input class="s1" type="submit" value="搜索" >
							</form>
						</div>
					</div>
					<%
		    			Customer customer=(Customer)request.getSession().getAttribute("loginUser");
		    			if(customer==null){
		    		 %>
					<div id="LogAndReg">
						<a href="Foreground_login.jsp">
							<div id="Log">
								<img src="images/lock.png" style="width: 20px;height: 20px;margin-left: 8px;margin-top: 5px;">
								<span><b>登录</b></span>
							</div>
						</a>
						<a href="Foreground_register.jsp">
							<div id="Reg">
								<img src="images/pencil.png" style="width: 20px;height: 20px;margin-left: 8px;margin-top: 5px;">
								<span><b>注册</b></span>
							</div>
						</a>
					</div>
					<%}else{ %>		
					<div id="updateMsg">
						<ul>
							<li class="navmenu">
							欢迎你,<s:property value="#session.loginUser.realName"/>
							<font id="sanjiao">▼</font>
							<br>
								<ul>
									<li class="li_none"><a href="queryByNameCusAction">【修改资料】</a></li><br>
									<li class="li_none"><a href="Foreground_changePwd.jsp">【更改密码】</a></li><br>
									<li class="li_none"><a href="queryProductEvaluate">【查看评价】</a></li><br>
									<li class="li_none"><a href="queryWords">【查看留言】</a></li><br>
									<li class="li_none"><a href="exitCusAction">【退出登录】</a></li><br>
								</ul>
							</li>
						</ul>
					</div>
					<%} %>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
