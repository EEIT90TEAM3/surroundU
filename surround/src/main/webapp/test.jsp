<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ page import="model.*" %>
<body>

<%
	WebApplicationContext context = (WebApplicationContext)
					WebApplicationContextUtils.getWebApplicationContext(application);
    MemberDAO dao = (MemberDAO) context.getBean("memberDAO");
    MemberBean select = dao.select("Nobi");
	out.print(select);
	
	
%>

</body>
</html>