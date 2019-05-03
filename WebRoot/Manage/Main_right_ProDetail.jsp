<%@ page language="java" import="java.util.*,com.product.models.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main_right_ProDetail.jsp' starting page</title>
    
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
			location.href="adminQueryTypeName0?addPro_obj="+obj;  
		}
  </script>
  <body style="overflow-y:hidden;overflow-x:hidden;">
  	<s:action name="adminQueryProType0" executeResult="false" namespace="/" />
	<div id="top">
		<jsp:include page="Main_top.jsp" flush="true"/>    
	</div>
	<div id="left">
  		<jsp:include page="Main_left.jsp" flush="true"/> 
	</div>
	<div id="right_ProDetail" style="overflow-y:scroll;overflow-x:scroll;">
  	<h3 align="center">修改商品信息</h3>
 	<img src="img/bt_bottom.png" width="100%">
 	<div id="right_mid_ProDetail">
 		<form action="updateAdminProduct.action" method="post"  enctype="multipart/form-data"  class="layui-form">
 		<center>
 		<s:hidden name="product.id" />
 			<table class="layui-table" lay-skin="line">
 				<tr>
				<td><span>请先选择分类：</span></td>
				<td>
				<div class="layui-form-item">			  
				    <div class="layui-input-block">
						<select name="typeMethod1" id="groupId" lay-filter="groupId">
							<option  value="${typemethod}" selected>
								${typemethod}
							</option>
							<s:iterator value="#session.productTypes3" var="productTypes3">
									<option value="<s:property value="productTypes3"/>">
		      							<s:property value="productTypes3"/>
									</option>
							</s:iterator>
						</select>
					</div>
				</div>
				</td>
				<td  class="errormsg"><s:property value="errors.ErrorTypeMethod[0]"/></td>
				</tr>
				<tr>
				<td>请先选择子类：</td>
				<td>
				<div class="layui-form-item">			  
				    <div class="layui-input-block">
						<select name="typeName1">
							<s:iterator value="#session.typeName" var="typeName">
									<option value="<s:property value="typeName"/>">
		      							<s:property value="typeName"/>
									</option>
							</s:iterator>
						</select>
					</div>
				</div>
				</td>
				<td></td>
				</tr>
 				<s:iterator value="#session.nowproductClass" status="num"> 
 				<s:set name="index" value="#num.getIndex()"/>
 				<tr>
 				<td><span>商品大类：</span></td>
				<td>
				<div class="layui-form-item">
					<div class="layui-input-block">
					    ${nowproductClass.get(index).getTypeName2().typeMethod}
					</div>
				</div>
				</td>
				<td></td>
				</tr>
				<tr>
				<td>商品子类：</td>
				<td>
				<div class="layui-form-item">
					<div class="layui-input-block">
					    ${nowproductClass.get(index).getTypeName2().typeName}
					</div>
				</div>
				</td>
				<td></td>
				</tr>
				</s:iterator>			
 				<tr>
 					<td>商品名称</td>
 					<td>
 					<div class="layui-form-item">
					    <div class="layui-input-block">
					    <input type="text" name="product.productName" required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" value="<s:property value="product.productName" />">
	 					</div>
 					</div>
 					</td>
 					<td class="errormsg"><s:property value="errors.ErrorProName[0]"/></td>
 				</tr>
 				<tr>
 					<td>商品详情</td>
 					<td>
 					<div class="layui-form-item layui-form-text">
					    <div class="layui-input-block">
					      <textarea name="product.description" class="layui-textarea"><s:property value="product.description" /></textarea>
					    </div>
					</div>
 					</td>
 					<td class="errormsg"><s:property value="errors.ErrorProDescription[0]"/></td>
 				</tr>
 				<tr>
 					<td>商品价格</td>
 					<td>
 					<div class="layui-form-item">
					    <div class="layui-input-block">
	 						<input type="text" name="product.price" id="" value="<s:property value="product.price" />" class="layui-input">
	 					</div>
 					</div>
 					</td>
 					<td class="errormsg"><s:property value="errors.ErrorProPrice[0]"/></td>
 				</tr>
 				<tr>
					<td><span class="left_bt">商品状态:</span></td>
					<td>
						<div class="layui-form-item">
						    <div class="layui-input-block">
								<s:if test="#session.productid.productState.trim()=='在售'">
								<input type="radio" name="product.productState" value="在售" checked />在售
								&nbsp;&nbsp;&nbsp;&nbsp;
		   						<input type="radio" name="product.productState" value="不在售" />不在售
								</s:if>   											
		   						<s:if test="#session.productid.productState.trim()=='不在售'">
		   						<input type="radio" name="product.productState" value="在售" />在售
								&nbsp;&nbsp;&nbsp;&nbsp;
		   						<input type="radio" name="product.productState" value="不在售" checked />不在售
		   						</s:if>
	   						</div>
   						</div>
   					</td>
   					<td></td>
				</tr>
 				<tr>
 					<td><span class="right_th">请选择产品图片:</span></td>
 					<td>
 					<div class="layui-form-item">
					    <div class="layui-input-block">
	 						<input type="file" name="upload" id="myFile1"/>
	 					</div>
 					</div>
 					</td>
 					<td><img src="img/product/<s:property value="#session.productid.img"/>" width="230" height="180"></td>							
 				</tr>
 				<tr>
 					<td>
 					<div class="layui-form-item">
					    <div class="layui-input-block">
					      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
					    </div>
				    </div>
 					</td>
 					<td></td>
 					<td></td>
 				</tr>
 			</table>
 		</center>
 		</form>
 	</div>
 	<%request.getSession().removeAttribute("typemethod"); %>
 	<%request.getSession().removeAttribute("typeName"); %>
 	</div>
 	<script src="layui/layui.js"></script>
 	<script>
 		layui.use(['layer', 'form', 'element','table'], function(){
  			var layer = layui.layer
		  ,form = layui.form
		  ,element = layui.element
		  ,table = layui.table;

		  form.render();
		  form.on('select(groupId)', function(data){
		  alert("111");
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
