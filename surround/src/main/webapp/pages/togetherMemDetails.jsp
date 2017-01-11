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
<!-- 
<link rel="stylesheet" type="text/css" href="<c:url value="/css/table.css"/>" />
 -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">       
<link rel="stylesheet" href="<c:url value="/css/lightbox.css"/>">

<title>Insert title here</title>
</head>
<body>

<c:if test="${not empty togetherbean}">
<table class="table table-bordered table-striped table-hover">
	<thead>
	<tr>
		<th>主題</th>
		<th>約團名稱</th>
		<th>地點</th>
		<th>活動時間</th>
		<th>活動結束時間</th>
		<th>限定人數</th>
		<th>備註</th>
	</tr>
	</thead>
	<tbody>	    
	<tr>
		<td>${togetherbean.together_topic}</td>
		<td>${togetherbean.together_name}</td>
		<td>${togetherbean.together_locate}</td>
		<td>${fn:substring(together.together_when,0,19)}</td>
		<td>${fn:substring(togetherbean.together_when_end,0,19)}</td>
		<td>${togetherbean.together_people}</td>
		<td>${togetherbean.together_memo}</td>
	</tr>
	</tbody>
	</table>
	</c:if>

<c:if test="${not empty selectTogetherMemDetails}">
<table class="table table-bordered table-striped table-hover">
	<thead>
	<tr>
		<th>申請加入成員</th>
		<th>申請狀態</th>
		<th></th>
		<th></th>
	</tr>
	</thead>
	<tbody>
<c:forEach var="element" items="${selectTogetherMemDetails}">
        <c:url value="/togethermem.controller" var="path">
	        <c:param name="togethermem_no" value=" ${element.togethermem_no}" />
			<c:param name="together_no" value="${element.together_no.together_no}" />
			<c:param name="member_no" value="${element.member_no.member_no}" />
			<c:param name="togethermem_status" value="${element.togethermem_status}" />
			<c:param name="togethermem_time" value="${element.togethermem_time}" />
			<c:param name="togethermem_time_okay" value="${element.togethermem_time_okay}" />
			<c:param name="prodaction" value="確定加入"/>
		</c:url>
		 <c:url value="/togethermem.controller" var="path1">
	        <c:param name="togethermem_no" value=" ${element.togethermem_no}" />
			<c:param name="together_no" value="${element.together_no.together_no}" />
			<c:param name="member_no" value="${element.member_no.member_no}" />
			<c:param name="togethermem_status" value="${element.togethermem_status}" />
			<c:param name="togethermem_time" value="${element.togethermem_time}" />
			<c:param name="togethermem_time_okay" value="${element.togethermem_time_okay}" />
			<c:param name="prodaction" value="拒絕"/>
		</c:url>
	<tr>
		<td>${element.member_no.name}</td>
		<c:choose>
        <c:when test="${element.togethermem_status == 0}">
        <td style="color: red;">申請中，尚未加入</td>
        </c:when>
        <c:when test="${element.togethermem_status == 1}">
        <td style="color: blue;">已加入</td>
        </c:when>
        <c:when test="${element.togethermem_status == 2}">
        <td style="color: black;">拒絕加入</td>
        </c:when>
         <c:otherwise>
         </c:otherwise>
         </c:choose>
		<td><a href="${path}" ><input type="submit" name="prodaction" value="確定加入"></a></td>
		<td><a href="${path1}" ><input type="submit" name="prodaction" value="拒絕"></a></td>
    </tr>
	</c:forEach>
	</tbody>
	</table>
	</c:if>


<input type="submit" id="closeIframe" value="回首頁">
<script>
var index = parent.layer.getFrameIndex(window.name);
$('#closeIframe').click(function(){
	
    parent.layer.close(index);
});
</script>

</body>
</html>