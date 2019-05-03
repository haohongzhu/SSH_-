<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品查找导航栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">
	<script src="js/Foreground.js"></script>
	<script type="text/javascript">
		function queryProductByType(tid){
			location.href="queryByType?tid="+tid;
		}
	</script>
  </head>
  
  <body>
    <div id="top_menu">
    	<span class="top_menu_s">
    		按地区分：
    		<s:action name="queryType" executeResult="false"></s:action>
    		<s:iterator value="#session.type1">
    			<a href="javascript:queryProductByType('<s:property value="id"/>')">
    				<s:property value="typeName"/>
    			</a>|
    		</s:iterator>
    	</span>
    	<span class="top_menu_s">
    		按类型分：
    		<s:action name="queryType2" executeResult="false"></s:action>
    		<s:iterator value="#session.type2">
    			<a href="javascript:queryProductByType('<s:property value="id"/>')">
    				<s:property value="typeName"/>
    			</a>|
    		</s:iterator>
    	</span>
    	<span class="top_menu_s">
    		按其它方式分：
    		<a href="queryAllProduct">所有商品</a>&nbsp;|
    		<a href="queryAllSaleTop">销量排行</a>&nbsp;|
    		<a href="queryAllPraiseTop">好评排行</a>&nbsp;|
    		<a href="queryAllPriceTop">价格优惠</a>&nbsp;|
    	</span>
    </div>
  </body>
</html>
