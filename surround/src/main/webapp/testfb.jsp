<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.net.URLEncoder" %>
<%
    String fbURL = "https://www.facebook.com/v2.8/dialog/oauth?client_id=275346536213447&redirect_uri=http://localhost:8080/WebSurroundSpring/fbServlet&scope=email";
%>

<a href="<%= fbURL %>"><img src="img/1.png" border="0" /></a>

</body>
</html>