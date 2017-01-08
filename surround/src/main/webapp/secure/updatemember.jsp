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
<form enctype="multipart/form-data" method="POST" action="<c:url value="/secure/updateMember.controller" />">
 		 <label class="fontSize" >帳號：</label>
      <input type="text" name="account" value="${user.account}" class="fieldWidth" style="width: 180px;">
      <font size="-1" color="#FF0000">${errors.account}</font>
      <br/>
 		 <label class="fontSize" >姓名</label>
      <input type="text" name="sale_name" value="${user.name}" class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${errors.sale_name}</font>      
      <br/>
      <label class="fontSize" >生日</label>
      <input type="text" name="sale_name" value="${user.birth}" class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${errors.sale_name}</font>      
      <br/>
      <img height='100x' width='80px'
					src="<c:url value='${request.contextPath}/secure/logWeb.controller?id=${user.account_facebook}&type=MEMBER'/>"></a></li>
      <br>
      <label class="fontSize" >信箱</label>
      <input type="text" name="sale_name" value="${user.account_email}" class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${errors.sale_name}</font>      
      <br/>
       <input type="submit" name="prodaction" id="submit" value="新增"/>
</form>
</body>
</html>