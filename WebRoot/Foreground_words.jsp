<%@ page language="java" import="java.util.*,com.customer.models.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品评价页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">

  </head>

  <body>
  	<div id="common_header">
    	<jsp:include page="Foreground_header.jsp"></jsp:include>
    </div>
    <div id="product_evaluate_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 查看留言</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="/ShowProduct/Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="evaluate_right2">
	    	<div id="product_top3">
	    		<img src="images/evaluate.png" style="width:26px;height:27px;margin-top:3px;">
	    		<span id="evaluate_s2">您的历史留言</span>
	    	</div>
	    	
	    	<div id="product_evaluate_middle3">
			  	<% 
			  	List<CustomerWords> list=(List)request.getSession().getAttribute("all_words");
			  	if(list.size()==0){
			  	%>
				<div class="evaluate_detail" style="width:800px;">
				<br>
				&nbsp;&nbsp;暂无留言！！！
				</div>
				<%
				}else{
				%>
				<s:iterator value="#session.all_words">
					<div class="evaluate_detail2">
						<img src="images/customer_eva.png" style="width:30px;height:30px;margin-left:5px;margin-top:5px;">
						<span>
							顾客：<s:property value="customerID.userName"/>	
							<div id="blank2"></div><br>
							留言：<s:property value="words"/>
							<div id="blank2"></div><br>
							时间：<s:property value="wordsTime"/>
						</span>
					</div>
				</s:iterator>	
				<%
				}
				%>
			</div>
			
			<%if(list.size()==0){}else{ %>
			<div id="evaluate_choose2">
				<a href="queryWords?pageNo=1">[首页]</a>
				<a href="queryWords?pageNo=${currentPage-1}">[上一页]</a>
				<a href="queryWords?pageNo=${currentPage+1}">[下一页]</a>
				<a href="queryWords?pageNo=${totalPage}">[尾页]</a>
				（当前第${currentPage}/${totalPage}页）
			</div>
			<%} %>
		</div>
	</div>
	
	<div id="common_footer">
    	<jsp:include page="Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
