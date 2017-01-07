<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看擺攤文章</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">       
<link rel="stylesheet" href="<c:url value="/css/lightbox.css"/>">   
</head>
<body>
<!-- 擺攤表 -->
<c:if test="${not empty lookaccusesale}">     
   <table class="table table-bordered table-striped table-hover">
      <tr>
        <th>編號</th>
        <th>${lookaccusesale.sale_no}</th>
      </tr>
      <tr>
        <th>會員</th>
        <th>${lookaccusesale.member_no.member_no}</th>
      </tr>
      <tr>
        <th>擺攤分類</th>
        <th>${lookaccusesale.sale_topic}</th>
      </tr>
      <tr>
        <th>擺攤標題</th>
        <th>${lookaccusesale.sale_name}</th>
      </tr>
      <tr>
        <th>擺攤地點</th>
        <th>${lookaccusesale.sale_locate}</th>
      </tr>
      <tr>
        <th>擺攤備註</th>
        <th>${lookaccusesale.sale_memo}</th>
      </tr>
   </table>
 </c:if>   
                     <!-- 物品表 -->
                      <c:if test="${not empty lookaccuseproduct}">
						<table class="table table-bordered table-striped table-hover">
							<thead>
							<tr>
								<th>編號</th>
								<th>物品名稱</th>
								<th>物品備註</th>
								<th>物品價格</th>
								<th>物品圖片</th>
								
							</tr>
							</thead>
							<tbody>
							<c:forEach var="element" items="${lookaccuseproduct}">

								<tr>
									<td>${element.product_no}</td>
									<td>${element.product_name}</td>
									<td>${element.product_memo}</td>
									<td>${element.product_price}</td>
									<td><img src="<c:url value="${element.product_pic}"/>" style="width:200px;height:150px;"></a></td>
							
									
								</tr>
							</c:forEach>
							</tbody>
						</table>
					  </c:if>	
   
      <!-- http://lokeshdhakar.com/projects/lightbox2/ -->
	<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>  
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>   
	<script src="<c:url value="/js/lightbox.js"/>"></script>     
	

</body>
</html>