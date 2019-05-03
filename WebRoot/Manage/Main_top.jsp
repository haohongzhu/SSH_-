<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'Main_left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="layui/css/layui.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<html>
<title></title>
<head>
</head>
<script type="text/javascript"></script>
<style type="text/css"><!--
	body{
		background-color: rgb(46,94,121);
	}
	#top{
		width: 100%;
		float: left;
	}
	#top_in{
		font-weight:normal;
		text-align:left;
		padding:2em 1em 1.6em 1em;
		
	}
	#top_left{
		float:left;
		margin-top: -15px;
	}
	#top_left span{
		font-family: 汉仪菱心体简;
		font-size: 24px;
		color:white;
	}
	#top_right{
		float:right;
		margin-top: -13px;
	}
	#top_right_left{
		float:left;
	}
	#top_right_right{
		float:right;
		margin-left: 10px;
	}
	#top_right_right ul li{
		color:#A1EAFF;
		float:left;
		list-style: none;
		font-weight:normal;
	}
	#top_right_right ul li a{
		color:#A1EAFF;
		text-decoration: none;
		font-weight:normal;
		margin-left: 10px;
	}
	#top_right_right ul li a:hover{
		color:#fff;
	}
	#top_right_right ul, #top_right_right ul li{
		margin:0px; 
		padding:0px; 
	}
--></style>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header header header-demo">
			<div id="top">
				<div id="top_in">
					<div id="top_left">
						<span>订餐后台管理系统</span>
					</div>	
					<div id="top_right">
						<div id="top_right_left">
							<img src="img/img-profile.jpg">
						</div>
						<div id="top_right_right">
							<ul>
								<li>Hello ${logadmin.adminID}</li>
								<li><a href="#">Config</a></li>
								<li>&nbsp;&nbsp;&nbsp;|</li>
								<li><a href="exitAction">退出</a></li>	
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>