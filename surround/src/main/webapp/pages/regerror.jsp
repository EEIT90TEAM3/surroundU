<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>11111111111111</h1>
	<%
		List<String> errors = (List<String>) request.getAttribute("errors");
		if (errors != null) {
	%>
	<h1>新增會員失敗</h1>
	<ul style='color: rgb(255, 0, 0);'>
		<%
			for (String error : errors) {
		%>
		<li><%=error%></li>
		<%
			}
		%>
	</ul>
	<br>
	<%
		}
	%>
</body>
</html>