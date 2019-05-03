//管理员修改订单状态
function adminUpdateStatus(OrderId,nextStatus){  
	location.href="adminUpdateStatus?orderid="+OrderId+"&nextStatus="+nextStatus;
}

//下拉菜单栏js
$(document).ready(function(){
	$("#problem_right_common h4.menu_head").click(function(){
		$(this).addClass("current").next("div.menu_nva").slideToggle(200).siblings("div.menu_nva").slideUp("slow");
		$(this).addClass("color");
		$(this).siblings().removeClass("current");
		$(this).siblings().removeClass("color");
	});
	$("#secondpane .menu_nva:eq(0)").show();
	$("#secondpane h4.menu_head").mouseover(function(){
		$(this).addClass("current").next("div.menu_nva").slideDown(400).siblings("div.menu_nva").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
});

//删除收货地址js
function deleteConInf(id){
	if(confirm("确定删除该收货地址吗?")){
		location.href="deleteConInfAction?id="+id;
	}
}

//编辑收货地址js
function queryConById(id){
	location.href="queryConInfAction2?id="+id;
}

//页面跳转js
function getTime(){  
	document.getElementById('num').innerHTML="<font color='red'>"+i+"</font>";  
	i-=1;  
	var x=setTimeout('getTime()',1000)//1000毫秒=1秒  
	if(i<=0){  
	clearTimeout(x);  
	}  
}  

//查询商品详细信息js
function queryProById(id){
	location.href="queryProductById?id="+id;
}

//改变图片地址和DIV颜色js
function changeSrc(){
	document.getElementById("good").src="images/good.png";
	document.getElementById("description_right_good").style.color="#727272";
	}
	
function changeSrc2(){
	document.getElementById("good").src="images/good2.png";
	document.getElementById("description_right_good").style.color="#CDCDCD";
	}
	
function changeSrc3(){
	document.getElementById("pay").src="images/pay2.png";
	document.getElementById("description_right_pay").style.color="#727272";
	}
	
function changeSrc4(){
	document.getElementById("pay").src="images/pay.png";
	document.getElementById("description_right_pay").style.color="#CDCDCD";
	}

function changeSrc5(){
	document.getElementById("collect").src="images/collect2.png";
	document.getElementById("description_right_collect").style.color="#727272";
	}
	
function changeSrc6(){
	document.getElementById("collect").src="images/collect.png";
	document.getElementById("description_right_collect").style.color="#CDCDCD";
	}

function changeSrc7(){
	document.getElementById("hasCollect").src="images/collect.png";
	document.getElementById("description_right_hasCollect").style.color="#CDCDCD";
	}
	
function changeSrc8(){
	document.getElementById("hasCollect").src="images/collect2.png";
	document.getElementById("description_right_hasCollect").style.color="#727272";
	}

//更新Product表js
function updatePraise(){
	location.href="updateProduct1";
}

//添加商品评价
function addProductEvaluate(){
	location.href="addProductEvaluate";
}

//添加商品收藏
function addProductCollect(){
	location.href="addProductCollect";
}

//取消商品收藏
function deleteCollect(){
	location.href="deleteProductCollect";
}

//查找指定类型的所有商品
function queryProductByType(tid){
	location.href="queryByType?tid="+tid;
}

//将商品加入购物车
function BuyProduct(){
	location.href="shoppingCart";
}