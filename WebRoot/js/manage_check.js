function MethodCheck(){
var element = document.getElementById("typeMethod");
	if(element.value==null || element.value.trim().length==0){
	alert("填写大类不能空！");
	element.focus();
	return false;
	}else{
	return true;
	}
}
//添加子类验证
function TypeNameCheck(){
var element1 = document.getElementById("type");
var element2 = document.getElementById("typeName");
	if(element1.value==null || element1.value.trim().length==0){
	alert("请选择大类！");
	element1.focus();
	return false;
	}
	if(element2.value==null || element2.value.trim().length==0){
	alert("填写子类不能空！");
	element2.focus();
	return false;
	}
	else{
	return true;
	}
}
//根据id删除用户
function deleteProduct(id){
	if(confirm("你确定删除该用户吗?")){
		location.href="adminDeleteProduct?id="+id;
	}
}
//根据id删除产品类别
function deleteProductType(id){
	if(confirm("你确定删除该产品吗?")){
		location.href="deleteProductType?id="+id;
	}
}
//修改
function queryUserDetails(id){
	location.href="adminQueryProById?id="+id;
}
//修改订单状态
function adminUpdateStatus(OrderId,nextStatus){  
	location.href="adminUpdateStatus?orderid="+OrderId+"&nextStatus="+nextStatus;
}