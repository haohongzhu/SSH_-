<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_right_AddProduct.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
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
  
  <script type="text/javascript"  charset="utf-8">
		function queryProByName(){
			var obj = encodeURI(document.getElementById("groupId").value);
			obj = encodeURI(obj);
			var obj1=document.getElementById("groupId");
			var index = obj1.selectedIndex;
			var value = obj1.options[index].value;
			location.href="adminQueryTypeName?obj="+obj;  
		}
  </script>
  
  <body style="overflow-y:hidden;overflow-x:hidden;">
  <div id="top">
		<jsp:include page="Main_top.jsp" flush="true"/>    
  </div>
  <div id="left">
  		<jsp:include page="Main_left.jsp" flush="true"/> 
  </div>
  <div id="right_AddProduct" style="overflow-y:scroll;overflow-x:scroll;">
  	<h3 align="center">添加商品</h3>
 	<img src="img/bt_bottom.png" width="100%">
 	<div id="right_mid_AddProduct">
 	<!--<s:action name="adminQueryProType" executeResult="false" namespace="/" />-->
 		<form action="adminAddProduct.action" method="post" class="layui-form"> 
 		 <div class="layui-form-item">
		    <label class="layui-form-label">请先选择分类：</label>
		    <div class="layui-input-block">
		      <select name="groupId" id="groupId" lay-filter="groupId">
					<option  value="${typemethod}" selected>
						${typemethod}
					</option>
					<s:iterator value="#session.productTypes1" var="productTypes1">
							<option value="<s:property value="productTypes1"/>">
      							<s:property value="productTypes1"/>
							</option>
					</s:iterator>
				</select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">请先选择子类：</label>
		    <div class="layui-input-block">
		      <select name="groupId1">
					<s:iterator value="#session.typeName" var="typeName">
							<option value="<s:property value="typeName"/>">
      							<s:property value="typeName"/>
							</option>
					</s:iterator>
				</select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">产品名字:</label>
		    <div class="layui-input-block">
		      <input type="text" name="product.productName" required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">产品描述:</label>
		    <div class="layui-input-block">
		      <textarea name="product.description" placeholder="请输入内容" class="layui-textarea"></textarea>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">产品价格:</label>
		    <div class="layui-input-block">
		      <input type="text" name="product.price" required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">产品价格:</label>
		    <div class="layui-input-block">
		      <input type="text" name="product.monthSale" required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" vaule="0">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">产品状态:</label>
		    <div class="layui-input-block">
		      <input type="radio" name="product.productState" value="在售 " checked />在售 &nbsp;&nbsp;&nbsp;&nbsp;
   			  <input type="radio" name="product.productState" value="不在售" />不在售
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">请选择产品图片:</label>
		    <div class="layui-input-block">
				<input type="file" name="upload" id="myFile1"/>		    
			</div>
		  </div>
		  <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
		      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		  </div>
 			<!--<table>
 			<tr>
				<td><span class="right_th">请先选择分类：</span></td>
				<td>
				<select name="groupId" id="groupId" onchange="queryProByName()">
					<option  value="${typemethod}" selected>
						${typemethod}
					</option>
					<s:iterator value="#session.productTypes1" var="productTypes1">
							<option value="<s:property value="productTypes1"/>">
      							<s:property value="productTypes1"/>
							</option>
					</s:iterator>
				</select>
				</td>
				</tr>
				<tr>
				<td><span class="right_th">请先选择子类：</span></td>
				<td>
				<select name="groupId1">
					<s:iterator value="#session.typeName" var="typeName">
							<option value="<s:property value="typeName"/>">
      							<s:property value="typeName"/>
							</option>
					</s:iterator>
				</select>
				</td>
				</tr>
 				<tr>
 					<td><span class="right_th">产品名字:</span></td>
 					<td><input type="text" name="product.productName"></td>
 				</tr>
 				<tr>
 					<td><span class="right_th">产品描述:</span></td>
 					<td><textarea name="product.description" id="" rows="6" cols="50"></textarea></td>
 				</tr>
 				<tr>
 					<td><span class="right_th">产品价格:</span></td>
 					<td><input type="text" name="product.price"></td>
 				</tr>
 				<tr>
 					<td><span class="right_th">月售:</span></td>
 					<td><input type="text" name="product.monthSale" value="0" readonly></td>
 				</tr>
 				<tr>
 				<tr>
					<td><span class="right_th">产品状态:</span></td>
					<td>
						<input type="radio" name="product.productState" value="在售 " checked />在售 &nbsp;&nbsp;&nbsp;&nbsp;
   						<input type="radio" name="product.productState" value="不在售" />不在售
   					</td>
				</tr>
 				<tr>
 					<td><span class="right_th">请选择产品图片:</span></td>
 					<td><input type="file" name="upload" id="myFile1"/></td>
 					
 				</tr>
 				<tr>
 					<td><input type="submit" value="提交"/></td>
 				</tr>
 				<s:hidden name="product.id" />
 			</table>
 		-->
 		</form>
 	</div>
 	<%request.getSession().removeAttribute("typemethod"); %>
 	<%request.getSession().removeAttribute("typeName"); %>
 	
 	
 	<script>
 		layui.use(['layer', 'form', 'element'], function(){
  			var layer = layui.layer
		  ,form = layui.form
		  ,element = layui.element;
		  form.render();
		  form.on('select(groupId)', function(data){
		    var obj = encodeURI(document.getElementById("groupId").value);
			obj = encodeURI(obj);
			var obj1=document.getElementById("groupId");
			var index = obj1.selectedIndex;
			var value = obj1.options[index].value;
			location.href="adminQueryTypeName?obj="+obj;  
		  });
		});
 	</script>
 </div>
  </body>
</html>
