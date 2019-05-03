<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'Main_right_sumOfOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
	<link rel="stylesheet" href="layui/css/layui.css"/>
	
	<style type="text/css">
		#sum{
			width:600px;
			height:1000px;
			padding-top:20px;
			padding-left:20px;
		}
		#sum2{
			width:270px;
			float:left;
			margin-top:35px;
		}
		.sum3{
			margin-left:20px;
			width:100px;
			float:left;
			margin-top:35px;
		}
		#sum4{
			width:180px;
			position:relative;
			float:left;
			font-size:19px;
			font-weight:bold;
			color:rgb(90,90,90);
		}
		#sum2 span{
			display:block;
			width:270px;
			height:30px;
			font-size:19px;
			font-weight:bold;
			color:grey;
		}
		.sum3 span{
			display:block;
			width:100px;
			height:30px;
			font-size:19px;
			font-weight:bold;
			color:grey;
		}
		#de_s{
			position:absolute;
			display:block;
			width:530px;
			height:30px;
			font-size:19px;
			font-weight:bold;
			color:rgb(90,90,90);
		}
		#sum_choose{
			width:500px;
			height:30px;
			font-size:18px;
			font-weight:bold;
			color:grey;
			float:left;
			margin-top:10px;
			margin-left:25px;
		}
		a{
		text-decoration:none;
		}
		a:link{
			color:grey;
		}
		a:visited{
			color:grey;
		}
		a:link{
			color:grey;
		}
		a:active{
			color:grey;
		}
		a:hover{
			color:black;
		}
		#sum_check{
			width:100px;
			background:skyblue;
			font-weight:bold;
			color:black;
		}
		#sum_check:hover{
			background:blue;
			cursor:pointer;
			color:white;
		}
	</style>
  </head>
  
  <body style="overflow-y:hidden;overflow-x:hidden;">
    <div id="top">
		<jsp:include page="Main_top.jsp" flush="true"/>    
  </div>
  <div id="left">
  		<jsp:include page="Main_left.jsp" flush="true"/> 
  </div>
  <div id="right_sum" style="overflow-y:scroll;overflow-x:scroll;">
  	<h3 align="center">查看业绩</h3>
 	<img src="img/bt_bottom.png" width="91.5%">
  	<div id="sum">
	    <form action="adminSumOfOrder" method="post">
	    	时间：<input type="text" name="startTime" placeholder="例：2018-06-06">
	    	&nbsp;到&nbsp;
	    	<input type="text" name="endTime" placeholder="例：2018-06-20">&nbsp;
	    	<input type="submit" value="查询" id="sum_check">
	    </form>
	    
	    <%
	    	Integer count=(Integer)request.getSession().getAttribute("p_count");
	    	if(count!=null){
	     %>
	       
	    <span id="de_s"><s:property value="startTime"/>&nbsp;到&nbsp;<s:property value="endTime"/>共接了<s:property value="orderCount"/>单，业绩详情如下：</span>    
	    <div id="sum2">
	    	<s:iterator value="infList">
	    		<span>
		        	<s:action name="queryP" executeResult="false">
		        		<s:param name="id"><s:property/></s:param>
		        	</s:action>
		        	商品：<s:property value="#session.now_P.productName"/>
		        </span>
	        </s:iterator>
	    </div>   
	    
	    <div class="sum3">
	    	<s:iterator value="oneProductCount">
	    		<span>
	    			<s:property/>份
	    		</span>
	    	</s:iterator>
	    </div> 
	    
	    <div class="sum3">
	    	<s:iterator value="oneProductPrice">
	    		<span>
	    			¥<s:property/>
	    		</span>
	    	</s:iterator>
	    </div>

	    <div id="sum_choose">
    		<a href="adminSumOfOrder?pageNo=1&startTime=<s:property value="#session.startTime"/>&endTime=<s:property value="#session.endTime"/>">[首页]</a>
			<a href="adminSumOfOrder?pageNo=${currentPage-1}&startTime=<s:property value="#session.startTime"/>&endTime=<s:property value="#session.endTime"/>">[上一页]</a>
			<a href="adminSumOfOrder?pageNo=${currentPage+1}&startTime=<s:property value="#session.startTime"/>&endTime=<s:property value="#session.endTime"/>">[下一页]</a>
			<a href="adminSumOfOrder?pageNo=${totalPage}&startTime=<s:property value="#session.startTime"/>&endTime=<s:property value="#session.endTime"/>">[尾页]</a>
			(当前第${currentPage}/${totalPage}页)
		</div>
	     
	    <hr style="width:490px;margin-left:-10px;border:1px grey dashed;">
	       
	    <div id="sum4">
	    	&nbsp;&nbsp;种类：<s:property value="#session.p_count"/>种<br>
	    	&nbsp;&nbsp;数量：<s:property value="sumCount"/>份<br>
	    	总金额：¥<s:property value="sumPrice"/>
	    </div>
	    <%
	    }
	    request.getSession().removeAttribute("p_count"); 
	    %>
	</div>
	</div>
  </body>
</html>
