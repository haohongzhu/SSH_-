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
    
    <title>查询收货地址</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/Foreground.js"></script>
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="updateCon_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 收货地址</h5>
    	</div>
    	
    	<div id="updateCon_main_middle">
    		<div id="updateCon_main_middle_top">
    		我的地址(当前第${currentPage}/${totalPage}页)
    		<span id="newCon"><a href="Foreground_addConsignee.jsp">新增地址</a></span>
    		</div>
    		
    		<div id="conInf">
				<s:iterator value="inf" status="st" var="consigneeInf">
	    			<div id="conInf_left">
						<s:property value="#consigneeInf.address" />
		    			<s:property value="#consigneeInf.doorNum" /><br><br>
		    			<s:property value="#consigneeInf.consigneeName" />
		    			<s:property value="#consigneeInf.sex" />
		    			&nbsp;&nbsp;&nbsp;<s:property value="#consigneeInf.addressTel" />
	    			</div>
    			
		    		<div id="conInf_right">
		    			<div id="conInf_right_main" style="border-bottom:2px solid grey;">
		    				<img src="images/edit.png" class="conInf_img" >
		    				&nbsp;
		    				<a href="javascript:queryConById('<s:property value="id"/>')">
		    					编辑
		    				</a>
		    			</div>
		    			<div id="conInf_right_main">
		    			<img src="images/delete.png" class="conInf_img" style="width:23px;height:23px;">
		    				&nbsp;
		    				<a href="javascript:deleteConInf('<s:property value="id"/>')" >
		    					删除
		    				</a>
		    			</div>
		    		</div>
		    	</s:iterator>
    		</div>
    		<div id="choose">
    			<a href="queryConInfAction?pageNo=1">[首页]</a>
				<a href="queryConInfAction?pageNo=${currentPage-1}">[上一页]</a>
				<a href="queryConInfAction?pageNo=${currentPage+1}">[下一页]</a>
				<a href="queryConInfAction?pageNo=${totalPage}">[尾页]</a>
			</div>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
