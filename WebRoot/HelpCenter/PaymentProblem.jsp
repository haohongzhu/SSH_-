<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线支付问题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/Foreground.js"></script>
	<style type="text/css">
		#lb1{
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
    		<h5>您的位置：首页 > 帮助中心 > 在线支付问题</h5>
    	</div>
    	
    	<div id="problem_left_common">
    		<jsp:include page="Left_Menu.jsp"/>
    	</div>
    	
    	<div id="problem_right_common">
    		<h4 class="menu_head current">
				Q：在线支付取消订单后钱怎么返还？
			</h4>
			<div style="display: none" class="menu_nva">
				订单取消后，款项会在一个工作日内，直接返还到您的猪猪账户余额。
			</div>
			<h4 class="menu_head">
				Q：怎么查看退款是否成功？
			</h4>
			<div style="display: none" class="menu_nva">
				退款会在一个工作日之内到猪猪账户余额，可在“账号管理——我的账号”中查看是否到账。
			</div>
			<h4 class="menu_head">
				Q：猪猪账户里的余额怎么提现？
			</h4>
			<div style="display: none" class="menu_nva">
				余额可到猪猪网——“我的猪猪→猪猪余额”里提取到您的银行卡或者支付宝账号，另外，余额也可直接用于支付外卖订单（限支持在线支付的商家）。
			</div>
			<h4 class="menu_head">
				Q：余额提现到账时间是多久？
			</h4>
			<div style="display: none" class="menu_nva">
				1-7个工作日内可退回您的支付账户。由于银行处理可能有延迟，具体以账户的到账时间为准。
			</div>
			<h4 class="menu_head">
				Q：申请退款后，商家拒绝了怎么办？
			</h4>
			<div style="display: none" class="menu_nva">
				申请退款后，如果商家拒绝，此时回到订单页面点击“退款申诉”，猪猪客服介入处理。
			</div>
			<h4 class="menu_head">
				Q：怎么取消退款呢？
			</h4>
			<div style="display: none" class="menu_nva">
				请在订单页点击“不退款了”，商家还会正常送餐的。
			</div>
			<h4 class="menu_head">
				Q：前面下了一个在线支付的单子，由于未付款，订单自动取消了，这单会计算我的参与活动次数吗？
			</h4>
			<div style="display: none" class="menu_nva">
				不会。如果是未支付的在线支付订单，可以先将订单取消（如果不取消需要15分钟后系统自动取消），订单无效后，此时您再下单仍会享受活动的优惠。
			</div>
			<h4 class="menu_head">
				Q：为什么我用微信订餐，却无法使用在线支付？
			</h4>
			<div style="display: none" class="menu_nva">
				目前只有网页版和猪猪外卖手机App(非猪猪手机客户端)订餐，才能使用在线支付，请更换到网页版和猪猪外卖手机App下单。
			</div>
			<h4 class="menu_head">
				Q：如何进行付款？
			</h4>
			<div style="display: none" class="menu_nva">
				猪猪外卖现在支持货到付款与在线支付，其中微信版与手机触屏版暂不支持在线支付。
			</div>
			<h4 class="menu_head">
				Q：如何查看可以在线支付的商家？
			</h4>
			<div style="display: none" class="menu_nva">
				你可以在商家列表页寻找带有“付”标识的商家，提交订单时可以选择支付方式。
			</div>
			<h4 class="menu_head">
				Q：猪猪外卖支持哪些支付方式？
			</h4>
			<div style="display: none" class="menu_nva">
				现已支持猪猪余额、支付宝、网银（储蓄卡、信用卡）。
			</div>
			<h4 class="menu_head">
				Q：在线支付订单如何退款？
			</h4>
			<div style="display: none" class="menu_nva">
				商家接单前，您可以直接取消订单，订单金额会自动退款到猪猪余额；商家接单后，您在点击“申请退款”，在线申请。提交退款申请之后，商家有24小时处理您的退款申请。商家同意退款，或24小时内没有处理您的退款申请，您的支付金额会退款至您的猪猪余额。
			</div>
			<h4 class="menu_head">
				Q：在线支付的过程中，订单显示未支付成功，款项却被扣了，怎么办？
			</h4>
			<div style="display: none" class="menu_nva">
				出现此问题，可能是银行/支付宝的数据没有即时传输至猪猪，请您不要担心，稍后刷新页面查看。 如半小时后仍显示"未付款"，请先联系银行/支付宝客服，获取您扣款的交易号，然后致电	外卖客服1-200-346-2986  ，我们会协助您解决。
			</div>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
