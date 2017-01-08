<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="font-size: 30px ;color: orange;">加入揪團</p>

<form action="<c:url value="/togethermem.controller" />" method="post">


<table>
    <tr>
		<td>主揪人 : </td>
		<td>${param.nickname}</td>
	</tr>
	<tr>
		<td>主題 : </td>
		<td>${param.together_topic}</td>
		<input type="hidden" name="member_no" value="${param.member_no}"/>
		<input type="hidden" name="together_topic" value="${param.together_topic}">
		<input type="hidden" name="together_no" value="${param.together_no}"/>
		<input type="hidden" name="together_post_time" value="${param.together_post_time}" />
		<input type="hidden" name="together_delete_time" value="${param.together_delete_time}" />
		<input type="hidden" name="together_modify_time" value="${param.together_modify_time}" />
		<input type="hidden" name="together_status" value="${param.together_status}" />
		<input type="hidden" name="together_lng" value="${param.together_lng}" />
		<input type="hidden" name="together_lat" value="${param.together_lat}" />
		<input type="hidden" name="together_name" value="${param.together_name}"/>
		<input type="hidden" name="together_locate" value="${param.together_locate}"/>
		<input type="hidden" name="together_when" value="${param.together_when}"/>
		<input type="hidden" name="together_when_end" value="${param.together_when_end}"/>
		<input type="hidden" name="together_people" value="${param.together_people}"/>
		<input type="hidden" name="together_memo" value="${param.together_memo}"/>
	</tr>
	<tr>
		<td>名稱 : </td>
		<td>${param.together_name}</td>
	</tr>

	<tr>
		<td>地點 : </td>
		<td>${param.together_locate}</td>
	</tr>
	<tr>
		<td>活動時間 : </td>
		<td>${fn:substring(param.together_when,0,19)}</td>
	</tr>	
		
	<tr>
	    <td><span>活動結束時間:</span></td>
		<td>${fn:substring(param.together_when_end,0,19)}</td>
	</tr>
	
	<tr>
		<td>限制人數 : </td>
		<td>${param.together_people}</td>
	</tr>
	<tr>
		<td>備註 : </td>
		<td>${param.together_memo}</td>
	</tr>
	<tr>
	    <td>確定要加入?</td>
		<td>
		    <input type="submit" id="buttonGET" name="prodaction" value="加入">
		</td>
	</tr>
</table>
</form>
</body>
</html>