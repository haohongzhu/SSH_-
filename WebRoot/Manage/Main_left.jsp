<%@ page language="java" import="java.util.*,com.admin.models.*" pageEncoding="utf-8"%>
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
  </head>
  <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#firstpaneDiv .menu_nva:eq(0)").show();
	$("#firstpaneDiv h3.menu_head").click(function(){
		$(this).addClass("current").next("div.menu_nva").slideToggle(200).siblings("div.menu_nva").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
	$("#secondpane .menu_nva:eq(0)").show();
	$("#secondpane h3.menu_head").mouseover(function(){
		$(this).addClass("current").next("div.menu_nva").slideDown(400).siblings("div.menu_nva").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
});
</script>
<!--<style type="text/css">
			.menu_list {
				width: 268px;
				margin: 0;
				height:650px;
				background-color:rgb(209,222,228);
				margin-top:50px;
				border-radius:25px;
			}
			
			.menu_head {
				height: 47px;
				line-height: 47px;
				padding-left: 38px;
				font-size: 14px;
				color: #525252;
				cursor: pointer;
				border: 1px solid #f1f1f1;
				position: relative;
				margin: 0px;
				font-weight: bold;
				background:url(img/1.png) no-repeat;
				background-size:100% 100%;
				border-radius:10px;
			}
			
			.menu_list .current {
				background: #51a9f18c;
				
			}
			
			.menu_nva {
				line-height: 38px;
				border-left: 1px solid #51a9f18c;
				backguound: #fff;
				border-right: 1px solid #51a9f18c;
			}
			
			.menu_nva a {
				display: block;
				height: 38px;
				line-height: 38px;
				padding-left: 38px;
				color: #777777;
				background: #fff;
				text-decoration: none;
				border-bottom: 1px solid #777777;
				border-radius:5px;
			}
			
			.menu_head:hover{
				background:#708090;
			}
			
			.menu_nva a:hover {
				text-decoration: none;
				background:#eee;
				
			}
			.menu_nva a:active{
				background:#ccc;
			}
--></style>
  <%
  		Admin ad=(Admin)request.getSession().getAttribute("logadmin");
  		
  		if(ad.getRole().getId()==1){
  %>
  <body>
		<!--<div id="firstpaneDiv" class="menu_list">
			<h3 class="menu_head current">商品管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="Manage/Main_right_AddProductType.jsp">添加新类型商品</a>
				<a href="adminQueryProTypeAll">删除商品类别</a>
				<a href="Manage/Main_right_AddProduct.jsp">添加商品</a>
				<a href="adminQueryProAll">查看商品</a>
				<a href="adminQueryProAll0">修改商品</a>
			</div>
			<h3 class="menu_head">订单管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="Manage/Main_right_QueryOrder.jsp">修改订单</a>
			</div>
			<h3 class="menu_head">顾客管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="Manage/Main_right_QueryCusInf.jsp">查看资料</a>
				<a href="Manage/Main_right_QueryCusWord.jsp">查看留言信息</a>
			</div>
			<h3 class="menu_head">管理员管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="queryAdminAction">修改资料</a>
				<a href="adminQueryAllUser">查看管理员资料</a>
				<a href="Manage/Main_right_AddAdmin.jsp">添加管理员</a>
				<a href="Manage/Main_right_AdminChangePwd.jsp">修改密码</a>
			</div>
			<h3 class="menu_head">店铺管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="Manage/Main_right_sumOfOrder.jsp">查看业绩</a>
			</div>
		</div>
		
		-->
		<div class="layui-layout layui-layout-admin" style="position:ab">
		<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
		<div class="layui-tab" lay-filter="demo">
		<ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="test">
			<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
			  <li class="layui-nav-item layui-nav-itemed">
			    <a href="javascript:;">商品管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="Manage/Main_right_AddProductType.jsp">添加新类型商品</a></dd>
			      <dd><a href="adminQueryProTypeAll">删除商品类别</a></dd>
			      <dd><a href="Manage/Main_right_AddProduct.jsp">添加商品</a></dd>
			      <dd><a href="adminQueryProAll">查看商品</a></dd>
			      <dd><a href="adminQueryProAll0">修改商品</a></dd>
			    </dl>
			  </li>
			  <li class="layui-nav-item">
			    <a href="javascript:;">订单管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="Manage/Main_right_QueryOrder.jsp">修改订单</a></dd>		
			    </dl>
			  </li>
			  <li class="layui-nav-item">
			    <a href="javascript:;">顾客管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="Manage/Main_right_QueryCusInf.jsp">查看资料</a></dd>		
			      <dd><a href="Manage/Main_right_QueryCusWord.jsp">查看留言信息</a></dd>	
			    </dl>
			  </li>
			  <li class="layui-nav-item">
			    <a href="javascript:;">管理员管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="queryAdminAction">修改资料</a></dd>		
			      <dd><a href="adminQueryAllUser">查看管理员资料</a></dd>	
			      <dd><a href="Manage/Main_right_AddAdmin.jsp">添加管理员</a></dd>		
			      <dd><a href="Manage/Main_right_AdminChangePwd.jsp">修改密码</a></dd>	
			    </dl>
			  </li>
			  <li class="layui-nav-item">
			    <a href="javascript:;">店铺管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="Manage/Main_right_sumOfOrder.jsp">查看业绩</a></dd>				
			    </dl>
			  </li>			
		</ul>
		</div>
		</div>
		</div>
		</div>
		<%
		}else if(ad.getRole().getId()==2){
		%>
		<!--<div id="firstpaneDiv" class="menu_list">
			<h3 class="menu_head current">商品管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="adminQueryProAll">查看商品</a>
			</div>
			<h3 class="menu_head">订单管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="Manage/Main_right_QueryOrder.jsp">修改订单</a>
			</div>
			<h3 class="menu_head">顾客管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="Manage/Main_right_QueryCusInf.jsp">查看资料</a>
				<a href="Manage/Main_right_QueryCusWord.jsp">查看留言信息</a>
			</div>
			<h3 class="menu_head">管理员管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="queryAdminAction">修改资料</a>
				<a href="Manage/Main_right_AdminChangePwd.jsp">修改密码</a>
			</div>
			<h3 class="menu_head">店铺管理</h3>
			<div style="display:none" class="menu_nva">
				<a href="Manage/Main_right_sumOfOrder.jsp">查看业绩</a>
			</div>
		</div>
		-->
		<div class="layui-tab" lay-filter="demo">
		<ul class="layui-nav layui-nav-tree" lay-filter="test">
			<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
			  <li class="layui-nav-item layui-nav-itemed">
			    <a href="javascript:;">商品管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="adminQueryProAll">查看商品</a></dd>
			    </dl>
			  </li>
			  <li class="layui-nav-item">
			    <a href="javascript:;">订单管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="Manage/Main_right_QueryOrder.jsp">修改订单</a></dd>		
			    </dl>
			  </li>
			  <li class="layui-nav-item">
			    <a href="javascript:;">顾客管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="Manage/Main_right_QueryCusInf.jsp">查看资料</a></dd>		
			      <dd><a href="Manage/Main_right_QueryCusWord.jsp">查看留言信息</a></dd>	
			    </dl>
			  </li>
			  <li class="layui-nav-item">
			    <a href="javascript:;">管理员管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="queryAdminAction">修改资料</a></dd>			
			      <dd><a href="Manage/Main_right_AdminChangePwd.jsp">修改密码</a></dd>	
			    </dl>
			  </li>
			  <li class="layui-nav-item">
			    <a href="javascript:;">店铺管理</a>
			    <dl class="layui-nav-child">
			      <dd><a href="Manage/Main_right_sumOfOrder.jsp">查看业绩</a></dd>				
			    </dl>
			  </li>			
		</ul>
		</div>
		<%
		}
		%>
		<script src="layui/layui.js"></script>
		<script>
		layui.use('element', function(){
		  var element = layui.element;
	
		});
		</script>
  </body>
</html>
