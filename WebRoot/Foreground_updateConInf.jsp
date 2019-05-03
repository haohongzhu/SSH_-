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
    
    <title>编辑收货地址</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">

  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="addCon_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 收货地址 > 编辑收货地址</h5>
    	</div>
    	
    	<div id="addCon_main_middle">
    		<s:form id="addCon_f" theme="simple" action="updateConInfAction" method="post">
    			&nbsp;联系人&nbsp;&nbsp;
    			<s:textfield cssClass="t2" placeholder="  请填写收货人的姓名" name="consigneeInf.consigneeName"/>
    			<font class="err"><s:property value="errors.con1[0]"/></font>
    			<br><br>
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<s:radio list="%{#{'先生':'先生','女士':'女士'}}" cssClass="r1" name="consigneeInf.sex"/>
    			<br><br>
    			手机号码&nbsp;
    			<s:textfield cssClass="t2" placeholder="  请填写收货手机号码" name="consigneeInf.addressTel"/>
    			<font class="err"><s:property value="errors.con2[0]"/></font>
    			<br><br>
    			收货地址&nbsp; 
    			<s:textarea id="ta1" placeholder=" 请填写收货地址" name="consigneeInf.address"/>
    			<font class="err" style="float:right;margin-right:413px;margin-top:-39px;"><s:property value="errors.con3[0]"/></font>
    			<br><br>
    			&nbsp;门牌号&nbsp;&nbsp;
    			<s:textfield cssClass="t2" cssStyle="margin-top:15px;" placeholder="  例：34栋633" name="consigneeInf.doorNum"/>
    			<font class="err"><s:property value="errors.con4[0]"/></font>
    			<br><br>
    			<s:reset value="重  置" cssClass="change_b" /><br><br>
    			<s:submit value="编 辑 地 址" cssClass="change_b" />
    			<s:hidden name="consigneeInf.id"/>
    		</s:form>
    	</div>
    </div>
    
    <div id="common_footer">
    	<jsp:include page="Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
