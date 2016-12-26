<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="model.*" %>
<%@ page import="model.dao.*" %>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%
WebApplicationContext context = (WebApplicationContext)
		WebApplicationContextUtils.getWebApplicationContext(application);
MemberDao dao = (MemberDao) context.getBean("memberDao"); 
MemberBean memb = dao.select("Nobi");
out.println(memb);

%>
</body>
</html>
