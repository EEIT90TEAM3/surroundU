<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入頁面</title>
</head>
<body>
	<h1 align="center">SurroundYou</h1>
	<hr>
	
	
	<form action=<c:url value="/secure/login.controller" /> method="post">
    
		<table align="center">
			<tr>

				<td>
					<p>
						<label>帳號:<input type="text" name="account"
							value="${param.account}" placeholder="請輸入帳號"
							autofocus></label>
					</p>
				</td>
				<td>${error.account}</td>
			</tr>
			<tr>
				<td><label>密碼:<input type="password" id="pwd"
						name="pwd" value="${param.pwd}" >
						</label></td>
				<td>${error.pwd}</td>
			</tr>
			<tr>
				<td><label><input type="submit" name="button"
						id="button" value="登入">
						</label> 
						<label><input
						type="button" name="button" id="button2" 
						onclick="javascript:location.href='<c:url value="/pages/reg.jsp" />'"
						value="註冊"></label></td>
						
			</tr>


		</table>

	 </form>
</body>
</html>