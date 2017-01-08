<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${request.contextPath}Sale/layoutit/src/css/bootstrap.min.css" rel="stylesheet">
    <link href="${request.contextPath}Sale/layoutit/src/css/style.css" rel="stylesheet">
</head>
<body>
<c:if test="${not empty select}">
<c:forEach var="element" items="${select}">
<table>
<thead>
	<tr>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
	</tr>
</thead>
<tbody>
<tr><td>${element.sale_topic}</td></tr>
<tr><td>${element.sale_locate}</td></tr>
<tr><td>${element.sale_time}</td></tr>

</tbody>
</table>
</c:forEach>
</c:if>
<c:if test="${empty select}">
<h1>查無擺攤</h1>
</c:if>
<c:if test="${not empty select}">
	<c:forEach var="element" items="${select}">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="list-group">
						 <a href="#" class="list-group-item active">擺攤主題:${element.sale_topic}	</a>
						<div class="list-group-item">
							攤位名稱:${element.sale_name}					
						</div>
						<div class="list-group-item">
							<h4 class="list-group-item-heading">
								<c:forEach var="PP" items="${element.productBean}">
								<table>
								<thead></thead>
								<tbody>
								<tr><td><img src="<c:url value="${PP.product_pic}" />"><td><tr>
								<tr><td>賣品名稱:${PP.product_name}<td><tr>
								<tr><td>賣品價格:${PP.product_price}<td><tr>
								<tr><td>賣品描述${PP.product_memo}<td><tr>
								
								<tbody>
								</table>
								</c:forEach>
							</h4>
							<p class="list-group-item-text">
							
							</p>
						</div>
						<div class="list-group-item">
							地點:${element.sale_locate}
						</div>
						<div class="list-group-item">
							時間:${element.sale_time}
						</div>
						<div class="list-group-item">
							擺攤描述:${element.sale_memo}
						</div>
						<div class="list-group-item">
						</div> 
						<a class="list-group-item active">

					<a href="<c:url value="/mysale/SaleUpdateDelServlet?id=${element.sale_no}" />" >修改</a>
					<a href="<c:url value="/DelServlet?id=${element.sale_no}" />" >刪除</a>	
						</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
		
</c:if>

	<script src="${request.contextPath}Sale/layoutit/src/js/jquery.min.js"></script>
    <script src="${request.contextPath}Sale/layoutit/src/js/bootstrap.min.js"></script>
    <script src="${request.contextPath}Sale/layoutit/src/js/scripts.js"></script>
</body>
</html>