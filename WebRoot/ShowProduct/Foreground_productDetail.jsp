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
    
    <title>商品详细信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Foreground_customer.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_common.css">
	<link rel="stylesheet" type="text/css" href="css/Foreground_product.css">
	<script src="js/Foreground.js"></script>
	<script type="text/javascript">
		function BuyProduct(){
			alert("加入购物车成功！！！");
			location.href="shoppingCart";
		}
	</script>
  </head>
  
  <body>
    <div id="common_header">
    	<jsp:include page="../Foreground_header.jsp"></jsp:include>
    </div>
    
    <div id="product_detail_main">
    	<div id="common_top">
    		<h5>您的位置：首页 > 所有商品 > " <s:property value="product.productName"/>"详细信息</h5>
    	</div>
    	
    	<div id="common_top_menu">
    		<jsp:include page="Foreground_topMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="common_left_menu">
    		<jsp:include page="Foreground_leftMenu.jsp"></jsp:include>
    	</div>
    	
    	<div id="product_detail">
    		<div id="product_detail_main_top">
    			<img src="images/detail.png" style="width:26px;height:26px;margin-top:3px;">
    			<span id="detail_s1">商品详情</span>
    		</div>
    		
    		<div id="product_detail_main_middle">
    			<img src="img/product/<s:property value="product.img"/>" id="product_bigImg">
    			<font id="detail_name" class="detail">
    				名称：<s:property value="product.productName"/><br><br>
    				类别：<font id="typeName">
    					<%
    					Set type=(Set)request.getSession().getAttribute("type");
    					for(Iterator iter=type.iterator();iter.hasNext();){
    						ProductType pd=(ProductType)iter.next();
    						request.getSession().setAttribute("typeName",pd.getTypeName());
    					%>
    					
    						<s:property value="#session.typeName"/>
    					<% 
    						request.removeAttribute("typeName");
    						}
    					 %>
    					 </font>
    			</font>
    			<br><br>
    			<font id="detail_othber" class="detail">
    				月售：<s:property value="product.monthSale"/>
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				赞：<s:property value="product.praise"/>
    			</font>
    			<br><br>
    			<font id="detail_price" class="detail">价格：¥<s:property value="product.price"/></font>
				<br>
				
				<div id="description">
					<div id="description_left">
						<font id="detail_description" class="detail">商品描述：<s:property value="product.description"/></font>
 					</div>
 					<div id="description_right">
 						<%
	 						ProductCollect pc=(ProductCollect)request.getSession().getAttribute("productCollect");
	 						Product p=(Product)request.getSession().getAttribute("nowProduct");
	 						if(pc!=null && (p.getId()==pc.getProductID3().getId())){
 					 	%>
 					 		<div id="description_right_hasCollect" onclick="deleteCollect()" onmouseover="changeSrc7()" onmouseout="changeSrc8()">
	 					 		<img src="images/collect2.png" id="hasCollect">
	 					 		<span id="hasCollect_s">已收藏</span>
 					 		</div>
 						<%}else{%>
	 						<div id="description_right_collect" onclick="addProductCollect()" onmouseover="changeSrc5()" onmouseout="changeSrc6()" style="color:#CDCDCD;">
	 							<img src="images/collect.png" id="collect">
	 							<span id="collect_s">收藏</span>
	 						</div>
 						<%} %>
 						<div id="description_right_good" onmouseover="changeSrc()" onmouseout="changeSrc2()" onclick="updatePraise()" style="color:#CDCDCD;">
		 					<img src="images/good2.png" id="good">
		 					<span id="good_s">点赞</span>
		 				</div>
		 				
		 				<div id="description_right_pay"  onmouseover="changeSrc3()" onmouseout="changeSrc4()" onclick="BuyProduct()" style="color:#CDCDCD;">
	 						<img src="images/pay.png" id="pay">
	 						<span id="pay_s">购买</span>
	 					</div>
 					</div>
 				</div>
    		</div>
    	</div>
    	
    	<div id="product_top2">
	    	<img src="images/evaluate.png" style="width:26px;height:27px;margin-top:3px;">
	    	<span id="evaluate_s1">所有评价</span>
	    </div>
	    	
	    <div id="product_evaluate_middle2">
			 <% 
			  List<ProductEvaluate> list=(List)request.getSession().getAttribute("pes_session");
			  if(list.size()==0){
			  %>
			<div class="evaluate_detail">
			<br>
			&nbsp;&nbsp;暂无评价！！！
			</div>
			<%
			}else{
			%>
			<s:iterator value="#session.pes_session">
				<div class="evaluate_detail">
					<img src="images/customer_eva.png" style="width:30px;height:30px;margin-left:5px;margin-top:5px;">
					<span>
						顾客：<s:property value="customerID3.userName"/>
						<font style="display:block;float:right;margin-right:10px;"><s:property value="date"/></font>
						<br>
						<div id="blank"></div>
						评价：<s:property value="evaluate"/>
					</span>
				</div>
			</s:iterator>	
			<%
			}
			%>
		</div>
		
		<%if(list.size()==0){}else{ %>
			<div id="evaluate_choose" style="margin-left:650px;">
				<a href="queryProductById?pageNo=1&id=<s:property value="#session.nowProduct.id"/>">[首页]</a>
				<a href="queryProductById?pageNo=${currentPage-1}&id=<s:property value="#session.nowProduct.id"/>">[上一页]</a>
				<a href="queryProductById?pageNo=${currentPage+1}&id=<s:property value="#session.nowProduct.id"/>">[下一页]</a>
				<a href="queryProductById?pageNo=${totalPage}&id=<s:property value="#session.nowProduct.id"/>">[尾页]</a>
				（当前第${currentPage}/${totalPage}页）
			</div>
			<%} %>
			
    	<div id="product_evaluate">
    		<div id="product_evaluate_top">
    			<img src="images/evaluate.png" style="width:26px;height:27px;margin-top:3px;">
    			<span id="detail_s1">您的评价</span>
    		</div>
    		<div id="product_evaluate_middle">
				<div id="your_evaluate">
					<s:form method="post" action="addProductEvaluate" theme="simple">
						您的评价：<s:textarea name="pe.evaluate" id="evaluate_ta" placeholder="  请留下您对此商品的评价"/>
						<s:reset value="重 置" cssClass="evaluate_b"/>
						<s:submit value="提 交" cssClass="evaluate_b1"/>
					</s:form>
				</div>
    		</div>
    	</div>
    	
    </div>
    
    <div id="common_footer">
    	<jsp:include page="../Foreground_footer.jsp"></jsp:include>
    </div>
  </body>
</html>
