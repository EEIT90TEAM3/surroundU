<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--
<link rel="stylesheet" type="text/css" href="<c:url value="/css/table.css"/>" />
-->
<script src="src/jquery211.js" type="text/javascript"></script>
	<script src="src/jquery/bootstrap.min.js"></script>
	<script src="src/lay/layer.js" type="text/javascript"></script>
	<link rel="stylesheet" href="src/lay/skin/default/layer.css">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">       
<link rel="stylesheet" href="<c:url value="/css/lightbox.css"/>">

<title>Insert title here</title>
</head>
<body>


<c:if test="${not empty selecttogetherMemBean}">
<table class="table table-bordered table-striped table-hover">
	<thead>
	<tr>
		<th>主題</th>
		<th>主揪者</th>
		<th>約團名稱</th>
		<th>地點</th>
		<th>活動時間</th>
		<th>活動結束時間</th>
		<th>限定人數</th>
		<th>備註</th>
		<th>申請狀態</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="element" items="${selecttogetherMemBean}">
	     <c:url value="/togethermem.controller" var="path">
	      <c:param name="togethermem_no" value=" ${element.togethermem_no}" />
	      <c:param name="together_no" value=" ${element.together_no.together_no}" />
	      <c:param name="member_no" value=" ${element.member_no.member_no}" />
			<c:param name="prodaction" value="取消申請" />
		</c:url>
		
		<c:if test="${element.together_no.together_status == 0}">
		<tr>
		<td>${element.together_no.together_topic}</td>
		<td>${element.together_no.member_no.name}</td>
		<td>${element.together_no.together_name}</td>
		<td>${element.together_no.together_locate}</td>
		<td>${fn:substring(element.together_no.together_when,0,19)}</td>
		<td>${fn:substring(element.together_no.together_when_end,0,19)}</td>
		<td>${element.together_no.together_people}</td>
		<td>${element.together_no.together_memo}</td>
				
		<c:choose>
        <c:when test="${element.togethermem_status == 0}">
        <td style="color: red;">申請中</td>
        <td><a href="${path}" ><input type="submit" name="prodaction" value="取消申請"></a></td>
        </c:when>
        <c:when test="${element.togethermem_status == 1}">
        <td style="color: blue;">已加入</td>
        <td><a href="${path}" ><input type="submit" name="prodaction" value="取消申請"></a></td>
        </c:when>
         <c:otherwise>
         <td style="color: black;">拒絕加入</td>
          <td></td>
         </c:otherwise>
         </c:choose>
         </tr>
	</c:if>
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