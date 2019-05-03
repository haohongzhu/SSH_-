<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>其他问题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/Foreground.js"></script>
	<style type="text/css">
		#lb4{
			font-weight:900;
		}
	</style>

  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
  
    <div id="problem_common">
   	 	<div id="common_top">
    		<h5>您的位置：首页 > 帮助中心 > 其他问题</h5>
    	</div>
    	
    	<div id="problem_left_common">
    		<jsp:include page="Left_Menu.jsp"/>
    	</div>
    	
    	<div id="problem_right_common">
    		<h4 class="menu_head current">
				Q：如果对商家服务不满意如何进行投诉？
			</h4>
			<div style="display: none" class="menu_nva">
				您可以在该订单完成评价后点击订单详情页中的意见反馈向客服投诉，或者拨打猪猪外卖的客服电话（1-200-346-2986）向客服进行投诉。
			</div>
			<h4 class="menu_head">
				Q：如何联系客服解决问题？
			</h4>
			<div style="display: none" class="menu_nva">
				您可以拨打猪猪外卖的客服电话（1-200-346-2986）或者在“我的”——>“意见反馈”页面提交反馈。
			</div>
			<h4 class="menu_head">
				Q：为什么无法定位？
			</h4>
			<div style="display: none" class="menu_nva">
				请先检查网络以及是否开启定位功能。若确认正常，请试着在户外或wifi环境下进行定位。
			</div>
			<h4 class="menu_head">
				Q：如何修改自己的账户信息？
			</h4>
			<div style="display: none" class="menu_nva">
				猪猪外卖使用的是猪猪账号，您可以在“我的”页面修改个人账号信息，也可以在猪猪网账号页面修改个人账号。
			</div>
			<h4 class="menu_head">
				Q：为什么有时需要输入短信验证码？
			</h4>
			<div style="display: none" class="menu_nva">
				为了保障您的账号安全及商家利益，对于新用户及一些有异常行为的下单系统会提示您输入短信验证码。如果迟迟未接收到短信验证码，您同样可以选择接听语音验证码。
			</div>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
