<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>优惠问题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/Foreground.js"></script>
	<style type="text/css">
		#lb2{
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
    		<h5>您的位置：首页 > 帮助中心 > 优惠问题</h5>
    	</div>
    	
    	<div id="problem_left_common">
    		<jsp:include page="Left_Menu.jsp"/>
    	</div>
    	
    	<div id="problem_right_common">
    		<h4 class="menu_head current">
				Q：哪些商家有优惠？都有些什么优惠？
			</h4>
			<div style="display: none" class="menu_nva">
				有优惠的商家在商家列表页均含有优惠标识；具体的优惠可以查看活动详情或者商家详情页中的描述。
			</div>
			<h4 class="menu_head">
				Q：在新用户享受的优惠中，新用户的条件是什么？
			</h4>
			<div style="display: none" class="menu_nva">
				新用户是指第一次在猪猪外卖下单的用户（同一设备、同一手机号、同一账户仅可享受一次）。
			</div>
			<h4 class="menu_head">
				Q：我达到了满赠、满减的优惠的金额，为什么没有享受相关的优惠？
			</h4>
			<div style="display: none" class="menu_nva">
				满赠与满减优惠是以订单内菜品的总额来计算的，不包含配送费与包装费。
			</div>
			<h4 class="menu_head">
				Q：超时赔付是什么意思？
			</h4>
			<div style="display: none" class="menu_nva">
				超时赔付模式即：商家承诺一个送达时间和一个折扣,从用户下单时间开始计算,如果外卖超过了承诺时间才送到,该份外卖按照折扣价收取费用。由于恶劣天气、某些美食烹调时间过长、或者其他因素,商家会选择性的延长承诺时间或者不做承诺。预订单不参与超时赔付。
			</div>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
