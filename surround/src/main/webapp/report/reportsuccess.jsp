<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">       
<link rel="stylesheet" href="<c:url value="/css/lightbox.css"/>">   

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
<title>回報成功</title>


<script>

var index = parent.layer.getFrameIndex(window.name);

layer.alert('回報成功', {icon: 6});

window.onload = function ()
{
	setTimeout("parent.layer.close(index);", 5*1000);
	
}
</script>

</head>
<body>

</body>
</html>