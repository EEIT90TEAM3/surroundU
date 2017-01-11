<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">       
<link rel="stylesheet" href="<c:url value="/css/lightbox.css"/>">
<title>檢舉功能</title>
<style type="text/css">
 textarea{resize: none;}
</style>
</head>
<body>
<form method="GET" action ="<c:url value="/accuse.controller"/>">
 <table class="table table-bordered table-striped table-hover">
	<tr>
		<td>檢舉主題： </td>
		<td>${param.together_topic}</td>
		<input type="hidden" name="accusetopic" value="${param.together_topic}">
	</tr>
	
	<tr>
		<td>檢舉約團名稱： </td>
		<td>${param.together_name}</td>
	</tr>
	
	<tr>
		<td>主約人：</td>
		<td>${param.member_no}</td>
		
	</tr>
	<tr>
		<td>開始時間：</td>
		<td>${param.together_when}</td>
	</tr>
	<tr>
		<td>結束時間：</td>
		<td>${param.together_when_end}</td>
	</tr>
				
		<input type="hidden" name="memberno" value="${sessionScope.user.member_no}">
		<input type="hidden" name="saleno" value="${param.sale_no}">
		<input type="hidden" name="groupno" value="${param.together_no}">
		
	
	<tr>
		<td>檢舉原因 : </td>
		<td><textarea cols="60" rows="10" name="accusetype" value="${param.accusetype}"></textarea></td>
    </tr>
    <tr>
		<td></td>
		<td align="right"><input type="submit" value="確認"></td>
	</tr>
  </table>

</form>
</body>
</html>