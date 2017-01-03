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
							<td align="left"><input type="submit" name="backendaction" value="檢舉列表-全部" class="btn btn-info"></td>
							
							<td align="left"><input type="submit" name="backendaction" value="檢舉列表-未處理" class="btn btn-info"></td>
							
							<td align="left"><input type="submit" name="backendaction" value="檢舉列表-已處理" class="btn btn-info"></td>
							
						</tr>
					</table>
				 </form>
			<form mothed="get" action="<c:url value="/dealaccuse.controller"/>" >
				   <table class="table table-bordered table-striped table-hover">		
						
						<tr>
							<th>編號</th>
							<th>${param.accuse_no}</th>
			                <input type="hidden" name="accuse_no" value="${param.accuse_no}">
						<tr>
							<th>檢舉人會員帳號</th>
							<th>${param.account}</th>
							<input type="hidden" name="account" value="${param.account}">
						</tr>
						<tr>
							<th>檢舉文章主題</th>
							<th>${param.accuse_topic}</th>
							<input type="hidden" name="accuse_topic" value="${param.accuse_topic}">
						</tr>
						<tr>
							<th>檢舉原因</th>
							<th>${param.accuse_type}</th>
							<input type="hidden" name="accuse_type" value="${param.accuse_type}">
					    </tr>
						<tr>
							<th>檢舉時間</th>
							<th>${param.accuse_post_time}</th>
							<input type="hidden" name="accuse_post_time" value="${param.accuse_post_time}">
						</tr>
						<tr>
						
							<th>文章連結</th>
							<th><input type="button"  value="觀看文章內容" id="buttonLook"></th>
							
						<!-- <th><input type="button"  value="觀看文章內容" id="buttonLook"></th> -->	
						</tr>
						<tr>
						   <th>處理結果</th>
						   <th><input type="radio" name="accuseyesorno" value="2" > 檢舉成立<br>
				  		       <input type="radio" name="accuseyesorno" value="1"> 檢舉不成立<br>
				  		     </th>
				  		     <h6>${error.accuse_status}</h6>
				        </tr>
						<tr> 
							<th>處理備註</th> 
							<th>
							<textarea cols="60" rows="10" id="memo" name="accuse_deal_memo"></textarea>
							${error.dealaccuse.error}</th>
							
				 	    </tr> 
						<tr>
							<th><input id="buttonGet" type="submit" name="dealaccuseaction" value="確定" /></th>
				<!-- 		<input type="submit"  value="確認" >
				            <a href="${path}"><input type="button" name="doaccuseaction" value="確定" /></a>	 -->
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
	<script>

 	$(function() {

// 		$('#buttonGet').click(function(){
			
			
			
// 			$.get("<c:url value="/dealaccuse.controller"/>",{"accuse_no":"${param.accuse_no}","accuse_deal_memo":$('#memo').val(),
// 				  "accuseyesorno":$(':radio:checked').val()}
// 			);

// 		});
		
		
	$('#buttonLook').click(function(){
				
			$.get("<c:url value="/lookAccuse.controller"/>",{"accuse_no":"${param.accuse_no}","accuse_topic":"${param.accuse_topic}"},window.open("index.jsp","_blank","top=50,left=100,width=500,height=500")
			);

		});

		
		
	});

	
	</script>
	
	
</body>
</html>