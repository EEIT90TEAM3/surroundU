<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${request.contextPath}src/jquery111.js" type="text/javascript"></script>
<script src="${request.contextPath}src/jquery/bootstrap.min.js"></script>
	<link href="${request.contextPath}src/boot/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form method="POST" action="<c:url value="/SaleSearchServlet" />">
<h1>更新成功</h1>
<input class="btn btn-default" type="submit" name="sale" id="submit" value="回到上一頁">
</form>
</body>
</html>