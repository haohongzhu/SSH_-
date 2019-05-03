<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单问题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/Foreground.js"></script>
	<style type="text/css">
		#lb3{
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
    		<h5>您的位置：首页 > 帮助中心 > 订单问题</h5>
    	</div>
    	
    	<div id="problem_left_common">
    		<jsp:include page="Left_Menu.jsp"/>
    	</div>
    	
    	<div id="problem_right_common">
    		<h4 class="menu_head current">
				Q：为什么提示我“账户存在异常，无法下单”？
			</h4>
			<div style="display: none" class="menu_nva">
				包含（但不仅限于）以下行为者，系统将自动予以封禁（客服无权解封）：<br>
				i）有过虚假交易（编造不存在真实买卖的订单）；<br>
				ii）有过恶意下单行为；<br>
			</div>
			<h4 class="menu_head">
				Q：如何取消订单？
			</h4>
			<div style="display: none" class="menu_nva">
				如果商家尚未接单，您可以在订单详情页通过“取消订单”功能进行取消;如果商家已接单，则需要您电话联系后由商家取消订单。
			</div>
			<h4 class="menu_head">
				Q：我的订单为什么被取消了？
			</h4>
			<div style="display: none" class="menu_nva">
				如果商家5分钟未接您的订单，为了保障您的权益，系统将会为您自动取消订单；商家接单后可能由于无法联系到您、菜品售完等原因无法配送，因而取消了您的订单，具体原因可查看系统发送的短信或通知。
			</div>
			<h4 class="menu_head">
				Q：如何进行催单？
			</h4>
			<div style="display: none" class="menu_nva">
				您可以在订单状态页面点击“电话催单”按钮向商家商家催单。
			</div>
			<h4 class="menu_head">
				Q：刚下单发现信息填错了怎么办？
			</h4>
			<div style="display: none" class="menu_nva">
				如果商家尚未接单，您可以自主取消订单；如果商家已经接单，您可以电话联系商家后由对方取消订单。然后重新下一单。
			</div>
			<h4 class="menu_head">
				Q：我的订单是否被商家确认？
			</h4>
			<div style="display: none" class="menu_nva">
				App用户可以在商家确认您的订单时收到推送通知，并且订单状态会实时更新；手机触屏版及微信用户可以刷新订单状态页查看。
			</div>
			<h4 class="menu_head">
				Q：预计送达的时间为什么与我实际收餐的时间不符？
			</h4>
			<div style="display: none" class="menu_nva">
				预计送达时间是系统根据用户评价的时间进行综合计算而得到的参考时间，餐厅的实际配送时间会受到当天的天气、订单量等外界因素影响。
			</div>
			<h4 class="menu_head">
				Q：为什么会出现无法下单的情况？
			</h4>
			<div style="display: none" class="menu_nva">
				无法下单有很多情况，可能是菜品售完、餐厅不在营业时间等，请查看无法下单时给的提示。
			</div>
			<h4 class="menu_head">
				Q：为什么提示下单次数过多，已无法下单？
			</h4>
			<div style="display: none" class="menu_nva">
				同一手机号在同一设备上一天最多可以成功提交7次订单（在线支付以完成支付为准，货到付款以提交订单为准）。
			</div>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
