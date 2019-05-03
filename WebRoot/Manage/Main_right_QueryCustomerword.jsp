<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'Main_right_Customerword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
	<link rel="stylesheet" href="layui/css/layui.css"/>

  </head>
  <script type="text/javascript">
  	function deleteUser(userId){
	if(confirm("你确定删除该用户吗?")){
		location.href="adminDeleteWordAction?id="+userId;
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
  
  <div id="right_CustomerWord" style="overflow-y:scroll;overflow-x:scroll;">
  <h3 align="center">查询客户留言</h3>
  <img src="img/bt_bottom.png" width="100%">
  <div id="right_mid_CustomerWord">
  	<s:form method="post" action="adminQueryAllAction">
  		<s:submit value="显示所有用户" />
  	</s:form>

  	<s:form action="adminQueryByNameAction" method="post" namesapce="/" theme="simple">
		<span>姓名：</span><s:textfield name="realName"/>
		<s:submit value="查询"/>
	</s:form>
  	<table id="table_showWordMsg"  class="layui-table">
		<tr>
			<th style="text-align:center"><span class="right_th">用户姓名</span></th>
			<th style="text-align:center"><span class="right_th">用户电话号码</span></th>
			<th style="text-align:center"><span class="right_th">用户留言</span></th>
			<th style="text-align:center"><span class="right_th">用户留言时间</span></th>
			<th style="text-align:center"><span class="right_th">操作</span></th>
		</tr>
		<s:iterator value="customerWords" status="st" var="word">
		<tr align="center" >
			<td><s:property value="#word.customerID.realName"/></td>	
			<td><s:property value="#word.customerID.userTelephone"/></td>
			<td><s:property value="#word.words"/></td>
			<td><s:property value="#word.wordsTime"/></td>
			<td>
				<a href="javascript:deleteUser('<s:property value="id"/>')">删除</a>
			</td>
		</tr>
		</s:iterator>
	</table>
	[<a href="adminQueryByNameAction?pageNo=1" class="yema">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="adminQueryByNameAction?pageNo=${currentPage-1}" class="yema">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="adminQueryByNameAction?pageNo=${currentPage+1}" class="yema">下一页</a>]
				</c:when>
			</c:choose>
	[<a href="adminQueryByNameAction?pageNo=${totalPage}" class="yema">尾页</a>]
	（当前第${currentPage}/${totalPage}页）
  </div>
  </div>

 		<script>
	 		layui.use(['layer', 'form', 'element','table'], function(){
	  			var layer = layui.layer
			  ,form = layui.form
			  ,element = layui.element
			  ,table = layui.table;
		
			});
 		</script>
  </body>
</html>
