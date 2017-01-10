<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>後台</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">       
<link rel="stylesheet" href="<c:url value="/css/lightbox.css"/>">     
<style>
  .thumb{width:120px}
   
    textarea{resize: none;}
  		
</style>
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
						<span class="sr-only">Toggle navigation</span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span>
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
					<form method="post" action="<c:url value="/backendchangepwd.controller"/>" > 
					  <table  class="table table-bordered table-striped table-hover">		
						<tr>
							<th>原密碼</th>
							<th><input type="password" name="oldpwd" value="">${errors.pwd}</th>
						</tr>	
						<tr>
							<th>新設定密碼</th>
							<th><input type="password" name="newpwd1" value="">${errors.pwd1}</th>
						</tr>
						<tr>
							<th>請重複輸入新密碼</th>
							<th><input type="password" name="newpwd2" value="">${errors.pwdnotequal}${errors.pwd2}</th>
						</tr>
						<tr>
							<th><input type="submit" value="更改管理者密碼" name="backendaction"></th>
							<th></th>
						</tr>

					   </table>
					</form>
					
					<!-- 每頁不同的內容到這裡結束 -->
				</div>
			</div>
		</div>

		

		<!-- Site footer -->
		<footer class="footer">
			<p>&copy; SurroundU</p>
		</footer>

	</div>
	<!-- /container -->

   <!-- http://lokeshdhakar.com/projects/lightbox2/ -->
	<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>  
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>   
	<script src="<c:url value="/js/lightbox.js"/>"></script>   
	
</body>
</html>