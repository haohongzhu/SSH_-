<%@ page language="java" import="java.util.*,com.product.models.*" pageEncoding="UTF-8"%>
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
				location.href="deleteEva?id="+id;
				alert("删除成功！！！！！");
			}
		}
	</script>
  </head>

  <body>
  	<div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    <div id="product_evaluate_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 查看评价</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="evaluate_right2">
	    	<div id="product_top3">
	    		<img src="images/evaluate.png" style="width:26px;height:27px;margin-top:3px;">
	    		<span id="evaluate_s2">您的商品评价</span>
	    	</div>
	    	
	    	<div id="product_evaluate_middle3">
			  	<% 
			  	List<ProductEvaluate> list=(List)request.getSession().getAttribute("pes_session");
			  	if(list.size()==0){
			  	%>
				<div class="evaluate_detail" style="width:800px;">
				<br>
				&nbsp;&nbsp;暂无评价！！！
				</div>
				<%
				}else{
				%>
				<s:iterator value="#session.pes_session">
					<div class="evaluate_detail2">
						<img src="images/customer_eva.png" style="width:30px;height:30px;margin-left:5px;margin-top:5px;">
						<span>
							顾客：<s:property value="customerID3.userName"/>	
							<img src="images/delete2.png" id="eva_delete" name="delete" onclick="deleteEva('<s:property value="id"/>')">
							<div id="blank2"></div><br>
							商品：<a href="queryProductById?id=<s:property value="productID2.id"/>"><s:property value="productID2.productName"/>→</a>
							<div id="blank2"></div><br>
							评价：<s:property value="evaluate"/>
							<div id="blank2"></div><br>
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
				<a href="queryProductEvaluate?pageNo=1">[首页]</a>
				<a href="queryProductEvaluate?pageNo=${currentPage-1}">[上一页]</a>
				<a href="queryProductEvaluate?pageNo=${currentPage+1}">[下一页]</a>
				<a href="queryProductEvaluate?pageNo=${totalPage}">[尾页]</a>
				（当前第${currentPage}/${totalPage}页）
			</div>
			<%} %>
		</div>
	</div>
	
	<div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
