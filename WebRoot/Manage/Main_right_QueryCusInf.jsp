<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_QueryCusInf.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
	<link rel="stylesheet" href="layui/css/layui.css"/>
  </head>
  
    <script type="text/javascript">
  	function deleteUser1(userId){
	if(confirm("你确定删除该用户吗?")){
		location.href="adminDeleteCusInfAction?id="+userId;
	}
}
  </script>
  
  <body style="overflow-y:hidden;overflow-x:hidden;">
  <div id="top">
		<jsp:include page="Main_top.jsp" flush="true"/>    
  </div>
  <div id="left">
  		<jsp:include page="Main_left.jsp" flush="true"/> 
  </div>
  <div id="right_QueryCusInf" style="overflow-y:scroll;overflow-x:scroll;">
  <h3 align="center">查询客户信息</h3>
  <img src="img/bt_bottom.png" width="100%">
  	<div id="right_mid_QueryCusInf">
  	<s:form method="post" action="adminQueryCusInfAction">
  		<s:submit value="显示所有用户" />
  	</s:form>
  	<s:form action="adminQueryCusInfByNameAction" method="post" namesapce="/" theme="simple">
		<span>姓名：</span><s:textfield name="realName"/>
		<s:submit value="查询"/>
	</s:form>
	<table id="table_showWordMsg" class="layui-table">
		<tr>
			<th style="text-align:center"><span class="right_th">用户姓名</span></th>
			<th style="text-align:center"><span class="right_th">用户账号</span></th>
			<th style="text-align:center"><span class="right_th">用户电话号码</span></th>
		</tr>
		<s:iterator value="customerWords" status="st" var="word">
		<tr align="center" >
			<td><s:property value="#word.realName"/></td>	
			<td><s:property value="#word.userName"/></td>	
			<td><s:property value="#word.userTelephone"/></td>
		</tr>
		</s:iterator>
	</table>
	[<a href="adminQueryCusInfAction?pageNo=1" class="yema">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="adminQueryCusInfAction?pageNo=${currentPage-1}" class="yema">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="adminQueryCusInfAction?pageNo=${currentPage+1}" class="yema">下一页</a>]
				</c:when>
			</c:choose>
	[<a href="adminQueryCusInfAction?pageNo=${totalPage}" class="yema">尾页</a>]
  	</div>
  </div>

 	<script>
 		layui.use(['layer', 'form', 'element','table'], function(){
  			var layer = layui.layer
		  ,form = layui.form
		  ,element = layui.element
		  ,table = layui.table;

		  form.render();
		  form.on('select(groupId)', function(data){

		    var obj = encodeURI(document.getElementById("groupId").value);
			obj = encodeURI(obj);
			var obj1=document.getElementById("groupId");
			var index = obj1.selectedIndex;
			var value = obj1.options[index].value;
			location.href="adminQueryTypeName0?addPro_obj="+obj;   
		  });
		});
 	</script>
  </body>
</html>
