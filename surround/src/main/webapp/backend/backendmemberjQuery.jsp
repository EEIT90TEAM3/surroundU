<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SurrounU管理系統</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">       
<link rel="stylesheet" href="<c:url value="/css/lightbox.css"/>">   

     <!-- jQuery -->
	<script src="<c:url value="/src/jquery211.js"/>" type="text/javascript"></script>
	<!-- SmartMenus jQuery plugin -->
	<script src="<c:url value="/src/smartmenus/jquery.smartmenus.min.js"/>" type="text/javascript"></script>
	<!-- SmartMenus core CSS (required) -->
	<link rel="stylesheet" href="<c:url value="/src/smartmenus/sm-core-css.css"/>">
	<!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
	<link rel="stylesheet" href="<c:url value="/src/smartmenus/sm-blue.css"/>">
	<script src="<c:url value="/src/lay/layer.js"/>" type="text/javascript"></script>
	<link rel="stylesheet" href="<c:url value="/src/lay/layer.css"/>">
<style>
  .thumb{width:120px}
  
   textarea{resize: none;}
  
/*   table { */
/* 			font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif; */
/* 			font-size: 12px; */
/* 			margin: 10px; */
/* 			width: 750px; */
/* 			text-align: left; */
/* 			border-collapse: collapse;  */
/* 			left: 10px;  */
/* 		} */
		
		
/* 	th { */
/* 			font-size: 13px; */
/* 			font-weight: normal; */
/* 			padding: 8px; */
/* 			background: #b9c9fe; */
/* 			border-top: 4px solid #aabcfe; */
/* 			border-bottom: 1px solid #fff; */
/* 			color: #039; */
/* 		} */
		
/* 	td { */
/* 			padding: 8px; */
/* 			background: #e8edff;  */
/* 			border-bottom: 1px solid #fff; */
/* 			color: #669; */
/* 			border-top: 1px solid transparent; */
/* 		} */
		
/* 	tr:hover td { */
/* 			background: #d0dafd; */
/* 			color: #339; */
/* 		}   */
</style>


<!-- 狀態處以alert -->
<c:if test="${not empty memberstatus}">
<script>


layer.alert('已變更帳號狀態', {icon: 6});

</script>
</c:if>

<c:if test="${not empty managerstatus}">
<script>


layer.alert('已變更管理者權限', {icon: 6});

</script>
</c:if>

</head>



<body>
   <div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">SurroundU管理員介面</a>
				</div>


			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="list-group">
					<a href="<c:url value="/backend/backendaccusejQuery.jsp"/>" class="list-group-item">檢舉文章</a>
					<a href="<c:url value="/backend/backendreportjQuery.jsp"/>" class="list-group-item">建議及回報</a>
					<a href="<c:url value="/backend/backendmemberjQuery.jsp"/>" class="list-group-item">會員列表</a>
					<a href="<c:url value="/backend/backendchangepwdjQuery.jsp"/>" class="list-group-item">更改密碼</a>
					<a href="<c:url value="/backendlogout.controller"/>" class="list-group-item">登出</a>
				</div>
			</div>
			<div class="col-md-9">
				<div class="jumbotron">
					<div class="page-header">
						<h6>Hello~ ${manager.account}  歡迎來到管理者介面</h6>
					</div>
					<!-- 每頁不同的內容從這裡開始 -->

				<form method="GET" action ="<c:url value="/backend.controller"/>">

					  <table >
					    <tr>
							<td align="left"><input type="submit" name="backendaction" value="會員列表-全部" class="btn btn-info"></td>
						     <td>&nbsp;&nbsp;</td>
				            <td align="left"><input type="submit" name="backendaction" value="會員列表-管理者" class="btn btn-info"></td>
				            <td>&nbsp;&nbsp;</td>
				            <td align="left"><input type="submit" name="backendaction" value="會員列表-停權會員" class="btn btn-info"></td>
						</tr>
					 
					
				      </table>
			   </form>
			   <br>
					<c:if test="${not empty selectmember}">
						<table class="table table-bordered table-striped table-hover">
							<thead>
							<tr>
								<th>編號</th>
								<th>會員帳號</th>
								<th>暱稱</th>
								<th>電子郵件</th>
								<th>帳號狀態</th>
								<th></th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="element" items="${selectmember}">
								<c:url value="/backend/dealmemberviewjQuery.jsp" var="path">
									<c:param name="member_no" value="${element.member_no}" />
									<c:param name="account" value="${element.account}" />
									<c:param name="nickname" value="${element.nickname}" />
									<c:param name="birth" value="${element.birth}" />
									<c:param name="hobby" value="${element.hobby}" />
									<c:param name="gender" value="${element.gender}" />
									<c:param name="member_status" value="${element.member_status}" />
									<c:param name="account_email" value="${element.account_email}" />
									<c:param name="account_status" value="${element.account_status}" />
								</c:url>
								<tr>
									<td>${element.member_no}</td>
									<td>${element.account}</td>
									<td>${element.nickname}</td>
									

																		
									<td>${element.account_email}</td>
									
									
									<c:if test="${element.account_status==0}">
									<td>正常</td>
									</c:if>
									<c:if test="${element.account_status==1}">
									<td>停權</td>
									</c:if>
									<c:if test="${element.account_status==2}">
									<td>停權</td>
									</c:if>
									<c:if test="${element.account_status==99}">
									<td>管理者</td>
									</c:if>
									
									<td><a href="${path}"><input type="button" name="doaccuseaction" value="管理" class="btn btn-primary"/></a></td>
									
								</tr>
							</c:forEach>
							</tbody>
						</table>
					  </c:if>
					

					<!-- 每頁不同的內容到這裡結束 -->
				</div>
			</div>
		</div>

		


	</div>
	<!-- /container -->

   <!-- http://lokeshdhakar.com/projects/lightbox2/ -->
	<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>  
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>   
	<script src="<c:url value="/js/lightbox.js"/>"></script>    
	
	<footer> 
<div id="id_footer" class="panel-footer" style="margin-top:30px;background-color:white">
<div class="container-fluid" >
<div class="row">
<div class="col-lg-3 col-sm-3 text-center">
<h4 style="margin:15px 0 20px 0"></h4>
<p><a href="<c:url value='/index.jsp'/>"></a></p>
<p><a href="<c:url value='/index.jsp'/>"></a></p>
</div>
<div class="col-lg-3 col-sm-3 text-center">
<h4 style="margin:15px 0 20px 0"></h4>
<div>
<p><a href="<c:url value='/index.jsp'/>"></a></p>
<p><a href="<c:url value='/index.jsp'/>"></a></p>
</div>
</div>
<div class="col-lg-3 col-sm-3 text-center">
<h4 style="margin:15px 0 20px 0"></h4>
</div>
</div>
</div>
</div>
<div class="panel-footer" style="background-color:#DDDDDD;height:60px;">
<div class="container">
<div class="pull-left">
Copyright 2017 © 
<strong>SurroundU</strong>
</div>
<div class="pull-right">
</div>
</div>
</div>
</footer> 
	
</body>
</html>