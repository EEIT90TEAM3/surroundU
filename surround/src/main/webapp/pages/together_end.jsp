<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<!-- jQuery -->
	<script src="<c:url value="/src/jquery211.js"/>" type="text/javascript"></script>
	<!-- SmartMenus jQuery plugin -->
	<script src="<c:url value="/src/smartmenus/jquery.smartmenus.min.js"/>" type="text/javascript"></script>
	<!-- SmartMenus core CSS (required) -->
	<link rel="stylesheet" href="<c:url value="/src/smartmenus/sm-core-css.css"/>">
	<!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
	<link rel="stylesheet" href="<c:url value="/src/smartmenus/sm-blue.css"/>">
	<script src="<c:url value="/src/lay/layer.js"/>" type="text/javascript"></script>
	<link rel="stylesheet" href="<c:url value="/src/lay/layer.css"/>">


<style type="text/css">
  html { height: 100% }
  body { height: 100%; margin: 0; padding: 0 }
  #map-canvas { height: 100% }
</style>
	<script type="text/javascript"
	      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKiN8uhTaEWQbe-8MVHbzpEEn0KO0-HGI">
	</script>
	
	<script>
var togetherType ="${togetherType}";
var index = parent.layer.getFrameIndex(window.name);
var timein=2*1000;
switch(togetherType){
case "togetherJoinOkay":layer.alert('你已成功申請', {icon: 6});break;
case "togetherJoinerror" :layer.alert('您加入過了', {icon: 6});break;
case "togetherOkay" :layer.alert('揪團編輯完成', {icon: 6});break;
case "togetherDelete" :layer.alert('揪團刪除成功', {icon: 6});break;
case "together" :layer.alert('揪團成功',{time:timein} ,{icon: 6});
break;
case "member_no_error" :layer.alert('此團您是主揪，不用在加入', {icon: 6});break;
case "no_MemDetails_error" :layer.alert('尚未有任何成員', {icon: 6});break;
case "Nottogether" :layer.alert('尚未有任何您的約團', {icon: 6});break;
case "togetherJoinOver" :layer.alert('此揪團人數已超過上限', {icon: 6});break;
case "searchNoData" :layer.alert('查無資料', {icon: 6});break;
case "noSearch" :layer.alert('請輸入查詢字串(非空白)', {icon: 6});break;
default:layer.alert('歡迎進入Srround YOU', {icon: 6});

}
window.onload = function ()
{
	setTimeout("parent.layer.close(index);", 3*1000);
	
}
</script>
</head>
<body>

</body>
</html>