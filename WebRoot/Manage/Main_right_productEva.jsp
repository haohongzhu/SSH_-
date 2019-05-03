<%@ page language="java" import="java.util.*,com.admin.models.*,com.product.models.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_right_productEva.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="layui/css/layui.css"/>
	<link rel="stylesheet" type="text/css" href="css/css_manage_main.css">
	<script type="text/javascript">
		window.onload=function(){
			var index=document.getElementsByName("delete");
			for(var i=0;i<index.length;i++){
				index[i].onmouseover=function(){
					this.src="images/delete.png";
				};
				index[i].onmouseout=function(){
					this.src="images/delete2.png";
				};
			}
		};
		
		function deleteEva(id){
			if(confirm("确定删除该评价吗？")){
				location.href="adminDeleteEva?eid="+id;
				alert("删除成功！！！！！");
			}
		}
	</script>
	<style type="text/css">
		.evaluate_detail2{
			width:600px;
			height:140px;
			border-top:2px grey solid;
			border-left:2px grey solid;
			border-right:2px grey solid;
			margin-left:250px;
		}
		.evaluate_detail{
			width:450px;
			height:450px;
			border:2px grey solid;
			margin-left:230px;
			margin-top:50px;
			font-size:18px;
			font-weight:bold;
			color:grey;
		}
		.evaluate_detail2 span{
			display:block;
			width:560px;
			float:right;
			margin-top:10px;
		}
		#eva_delete{
			width:30px;
			height:35px;
			margin-right:10px;
			float:right;
		}
		#evaluate_choose2{
			width:600px;
			border:2px grey solid;
			margin-left:250px;
			text-align:center;
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
		a{
		text-decoration:underline;
		}
		#blank{
			width:600px;
			height:30px;
		}
		#eva_delete:hover{
			cursor:pointer;
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
	<div id="right_QueryProInf" style="overflow-y:scroll;overflow-x:scroll;">
	  	<h3 align="center">商品评价</h3>
	 	<img src="img/bt_bottom.png" width="100%">
	 	<div id="product_evaluate_middle3">
			  	<% 
			  	List<ProductEvaluate> list=(List)request.getSession().getAttribute("admin_pes_session");
			  	if(list.size()==0){
			  	%>
				<div class="evaluate_detail" >
				<br>
				&nbsp;&nbsp;暂无评价！！！
				</div>
				<%
				}else{
				%>
				<div id="blank"></div>
				<s:iterator value="#session.admin_pes_session">
					<div class="evaluate_detail2">
						<img src="images/customer_eva.png" style="width:30px;height:30px;margin-left:5px;margin-top:5px;">
						<span>
							顾客：<s:property value="customerID3.userName"/>	
							<img src="images/delete2.png" id="eva_delete" name="delete" onclick="deleteEva('<s:property value="id"/>')">
							<br><br>
							评价：<s:property value="evaluate"/>
							<br><br>
							时间：<s:property value="date"/>
						</span>
					</div>
				</s:iterator>	
				<%
				}
				%>
			</div>
			
			<%if(list.size()==0){}else{ %>
			<div id="evaluate_choose2">
				<a href="queryEvaAdmin?id=<s:property value="#session.now_pid.id"/>&pageNo=1">[首页]</a>
				<a href="queryEvaAdmin?id=<s:property value="#session.now_pid.id"/>&pageNo=${currentPage-1}">[上一页]</a>
				<a href="queryEvaAdmin?id=<s:property value="#session.now_pid.id"/>&pageNo=${currentPage+1}">[下一页]</a>
				<a href="queryEvaAdmin?id=<s:property value="#session.now_pid.id"/>&pageNo=${totalPage}">[尾页]</a>
				（当前第${currentPage}/${totalPage}页）
			</div>
			<%} %>
 	</div>
  </body>
</html>
