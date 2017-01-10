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
  	
/*   	 table { */
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
					<a href="<c:url value=""/>" class="list-group-item">登出</a>
				</div>
			</div>
			<div class="col-md-9">
				<div class="jumbotron">
					<div class="page-header">
						<h6>Hello~ ${user.account}  歡迎來到管理者介面</h6>
					</div>
					<!-- 每頁不同的內容從這裡開始 -->
					
				<form method="GET" action ="<c:url value="/backend.controller"/>">
					  <table >
					    <tr>
							<td align="left"><input type="submit" name="backendaction" value="會員建議及回報列表-全部" class="btn btn-info"></td>
							
							<td align="left"><input type="submit" name="backendaction" value="會員建議及回報列表-未處理" class="btn btn-info"></td>
				           
							<td align="left"><input type="submit" name="backendaction" value="會員建議及回報列表-已處理" class="btn btn-info"></td>
						</tr>
					 
				      </table>
				</form>
				<br>
				<form method="GET" action ="<c:url value="/dealreport.controller"/>">
		<%-- 		  mothed="get" action="<c:url value="/doaccuse.controller?report_no=${param.report_no}"/>" --%>
				   <table  class="table table-bordered table-striped table-hover">		
		<%-- 		    <c:url value="location.href='<c:url value="/doaccuse.controller"/>'" var="path"> --%>
		<%-- 				<c:param name="accuse_no" value="${param.report_no}" /> --%>
		<%-- 				<c:param name="account" value="${param.account}" /> --%>
		<%-- 				<c:param name="accuse_topic" value="${param.report_memo}" /> --%>
		<%-- 				<c:param name="accuse_type" value="${param.report_time}" /> --%>
		<%-- 				<c:param name="accuse_post_time" value="${param.report_status}" /> --%>
		<%-- 				<c:param name="accuse_deal_memo" value="${param.accuse_deal_memo}" /> --%>
		<%-- 			</c:url> --%>
						<tr>
							<th>編號</th>
							<th>${param.report_no}</th>
							<input type="hidden" name="report_no" value="${param.report_no}">
		
						<tr>
							<th>會員帳號</th>
							<th>${param.account}</th>
							<input type="hidden" name="account" value="${param.account}">
						</tr>
						<tr>
							<th>回報及建議內容</th>
							<th>${param.report_memo}</th>
							<input type="hidden" name="report_memo" value="${param.report_memo}">
						</tr>
						<tr>
							<th>回報及建議時間</th>
							<th>${param.report_time}</th>
							<input type="hidden" name="report_time" value="${param.report_time}">
					    </tr>
						<tr>
							<th>處理狀態</th>
							<c:if test="${param.report_status==0}">
								<td>未處理</td>
							</c:if>
							<c:if test="${param.report_status!=0}">
                                <td>已處理</td>
							</c:if>
						</tr>
						<tr> 
							<th>處理備註</th> 
							<th>${param.report_memo}</th>
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