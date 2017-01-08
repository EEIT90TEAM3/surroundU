<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="src/jquery211.js" type="text/javascript"></script>
	<script src="src/jquery/bootstrap.min.js"></script>
	<script src="src/lay/layer.js" type="text/javascript"></script>
	<link rel="stylesheet" href="src/lay/skin/default/layer.css">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/table.css"/>" />


<title>Insert title here</title>
</head>
<body>

<!-- 
   <form action="<c:url value="/pages/together.controller" />" method="get">
  -->
  
<div>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>主題</th>
		<th>約團名稱</th>
		<th>地點</th>
		<th>活動時間</th>
		<th>活動結束時間</th>
		<th>限定人數</th>
		<th>備註</th>
		<th>約團申請成員</th>
		<th></th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="element" items="${select}">
	     <c:url value="/pages/togetherUpdate.jsp" var="path">
	        <c:param name="together_no" value=" ${element.together_no}" />
			<c:param name="together_topic" value="${element.together_topic}" />
			<c:param name="together_name" value="${element.together_name}" />
			<c:param name="together_locate" value="${element.together_locate}" />
			<c:param name="together_when" value="${element.together_when}" />
			<c:param name="together_when_end" value="${element.together_when_end}" />
			<c:param name="together_people" value="${element.together_people}" />
			<c:param name="together_memo" value="${element.together_memo}" />
			<c:param name="together_post_time" value="${element.together_post_time}" />
			<c:param name="together_delete_time" value="${element.together_delete_time}" />
			<c:param name="together_modify_time" value="${element.together_modify_time}" />
			<c:param name="together_status" value="${element.together_status}" />
			<c:param name="together_lng" value="${element.together_lng}" />
			<c:param name="together_lat" value="${element.together_lat}" />
		</c:url>
		<c:url value="/pages/togetherDelete.jsp" var="path1">
	        <c:param name="together_no" value=" ${element.together_no}" />
			<c:param name="together_topic" value="${element.together_topic}" />
			<c:param name="together_name" value="${element.together_name}" />
			<c:param name="together_locate" value="${element.together_locate}" />
			<c:param name="together_when" value="${element.together_when}" />
			<c:param name="together_when_end" value="${element.together_when_end}" />
			<c:param name="together_people" value="${element.together_people}" />
			<c:param name="together_memo" value="${element.together_memo}" />
			<c:param name="together_post_time" value="${element.together_post_time}" />
			<c:param name="together_delete_time" value="${element.together_delete_time}" />
			<c:param name="together_modify_time" value="${element.together_modify_time}" />
			<c:param name="together_status" value="${element.together_status}" />
			<c:param name="together_lng" value="${element.together_lng}" />
			<c:param name="together_lat" value="${element.together_lat}" />
		</c:url>
		<c:url value="/togethermem.controller" var="path2">
	        <c:param name="together_no" value=" ${element.together_no}" />
			<c:param name="together_topic" value="${element.together_topic}" />
			<c:param name="together_name" value="${element.together_name}" />
			<c:param name="together_locate" value="${element.together_locate}" />
			<c:param name="together_when" value="${element.together_when}" />
			<c:param name="together_when_end" value="${element.together_when_end}" />
			<c:param name="together_people" value="${element.together_people}" />
			<c:param name="together_memo" value="${element.together_memo}" />
			<c:param name="together_post_time" value="${element.together_post_time}" />
			<c:param name="together_delete_time" value="${element.together_delete_time}" />
			<c:param name="together_modify_time" value="${element.together_modify_time}" />
			<c:param name="together_status" value="${element.together_status}" />
			<c:param name="together_lng" value="${element.together_lng}" />
			<c:param name="together_lat" value="${element.together_lat}" />
			<c:param name="prodaction" value="約團成員表" />
		</c:url>
	<tr>
		<td>${element.together_topic}</td>
		<td>${element.together_name}</td>
		<td>${element.together_locate}</td>
		<td>${fn:substring(element.together_when,0,19)}</td>
		<td>${fn:substring(element.together_when_end,0,19)}</td>
		<td>${element.together_people}</td>
		<td>${element.together_memo}</td>
		<td><a href="${path2}" ><input type="submit" name="prodaction" value="約團成員表"></td>
		<td><a href="${path}" ><input type="submit" name="prodaction" value="編輯"></a></td>
		<td><a href="${path1}" ><input type="submit" name="prodaction" value="刪除"></a></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</c:if>
</div>  	 

<input type="submit" id="closeIframe" value="回首頁">
<script>
var index = parent.layer.getFrameIndex(window.name);
$('#closeIframe').click(function(){
	
    parent.layer.close(index);
});
</script>


</body>
</html>