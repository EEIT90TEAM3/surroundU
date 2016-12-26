<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">登入頁面</h1>
	<hr>
	<form action="login_check.jsp" method="post">

		<table align="center">
			<tr>
				<td>
					<p>
						<label>帳號:<input type="text" name="user"
							required="required" placeholder="請輸入帳號" autofocus></label>

					</p>
					<p>
						<label>密碼:<input type="password" id="pwd" name="password"
							maxlength="12" size="14" placeholder="6~12英數字組合" required
							pattern="(?=^[A-Za-z0-9]{6,12}$)((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]))^.*$"
							title="密碼：6~12英數字組合，至少有一個大寫、小寫英文字母及數字，如 A12Rd6"></label>
					</p>
				</td>
			</tr>
			<tr>
				<td><label><input type="submit" name="button"
						id="button" value="登入"> </label> 
						<label><input
						type="button" name="button" id="button2" value="註冊"></label></td>
			</tr>


		</table>

	</form>
</body>
</html>