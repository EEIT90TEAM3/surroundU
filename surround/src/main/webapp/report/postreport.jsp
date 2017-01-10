<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回報功能</title>
<link rel="stylesheet" href="<c:url value="/css/jquery-ui.min.css"/>">



 
<style>
  textarea{resize: none; }
</style>
</head>
<body>
<div>
<form method="GET" action ="<c:url value="/reportpost.controller"/>">
 <table>
<!-- 	<tr>回報會員編號 :  </tr> -->
<!-- 	<tr> -->
<%-- 		<td><input type="text" name="memberno" value="${param.memberno}"></td> --%>
<%-- 		<td>${errors.memberno}</td>   --%>
<!--     </tr> -->
 	<tr>回報內容或建議：</tr>
	<tr>

		<td><textarea name="reportmemo" value="${param.reportmemo}" cols="60" rows="10" ></textarea></td>
		
	</tr>
    <tr>
		<td><input type="submit" value="確認" class="btn btn-info"></td>
		
	</tr>
	<tr>
	    <td>${errors.reportmemo}</td>
	</tr>
  </table>

</form>
</div>

	
	<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>  
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>   
	<script src="<c:url value="/js/lightbox.js"/>"></script>   

</body>
</html>