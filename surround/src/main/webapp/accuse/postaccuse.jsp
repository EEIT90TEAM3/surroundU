<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>檢舉功能</title>
</head>
<body>
<form method="GET" action ="<c:url value="/accuse.controller"/>">
 <table>
	<tr>
		<td>檢舉主題： </td>
		<td><input type="text" name="accusetopic" value="${param.accusetopic}"></td>
		<td>${errors.accusetopic}</td>
	</tr>	
	<tr>
		<td>檢舉人會員編號： </td>
		<td><input type="text" name="memberno" value="${param.memberno}"></td>
		<td>${errors.memberno}</td>
	</tr>
	<tr>
		<td>檢舉擺攤文章編號： </td>
		<td><input type="text" name="saleno" value="${param.saleno}"></td>
		<td>${errors.saleno}</td>
	</tr>
		<tr>
		<td>檢舉約團文章編號： </td>
		<td><input type="text" name="groupno" value="${param.groupno}"></td>
		<td>${errors.groupno}</td>
	</tr>
		<tr>
		<td>檢舉原因 : </td>
		<td><textarea cols="80" rows="10" name="accusetype" value="${param.accusetype}"></textarea></td>
		<td>${errors.accusetype}</td> 
    </tr>
    <tr>
		<td></td>
		<td align="right"><input type="submit" value="確認"></td>
	</tr>
  </table>

</form>
</body>
</html>