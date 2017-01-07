<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回報功能</title>
<link rel="stylesheet" href="<c:url value="/css/jquery-ui.min.css"/>">
</head>
<body>

<form method="GET" action ="<c:url value="/reportpost.controller"/>">
 <table>
	
	<tr>
		<td>回報會員編號 : </td>
		<td><input type="text" name="memberno" value="${param.memberno}"></td>
		<td>${errors.memberno}</td>  
    </tr>
	<tr>
		<td>回報內容或建議： </td>
		<td><input type="text" name="reportmemo" value="${param.reportmemo}"></td>
		<td>${errors.reportmemo}</td>
	</tr>
    <tr>
		<td></td>
		<td align="right"><input type="submit" value="確認"></td>
	</tr>
  </table>

</form>

	<div id="postover" title="回報及建議超過次數">
	  <p>會員您好,謝謝您的建議及回報,因應網站規定,會員回報及反映待辦事項為五項,請您稍晚再給予我們寶貴的意見及回饋</p>
	</div>
	
	<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>  
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>   
	<script src="<c:url value="/js/lightbox.js"/>"></script>   

</body>
</html>