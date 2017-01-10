<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>後台</title>

<style>
        
		table {
			font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
			font-size: 12px;
			margin: 45px;
			width: 800px;
			text-align: left;
			border-collapse: collapse;
 			position: relative; 
			left: 50px; 
		}
		
		.table1 {
			font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
			font-size: 12px;
			margin: 45px;
			width: 900px;
			text-align: left;
			border-collapse: collapse;
 			position: relative; 
			left: 50px; 
		}
		
		th {
			font-size: 13px;
			font-weight: normal;
			padding: 8px;
			background: #b9c9fe;
			border-top: 4px solid #aabcfe;
			border-bottom: 1px solid #fff;
			color: #039;
		}
		
		td {
			padding: 8px;
			background: #e8edff; 
			border-bottom: 1px solid #fff;
			color: #669;
			border-top: 1px solid transparent;
		}
		
		tr:hover td {
			background: #d0dafd;
			color: #339;
		}
		
		.button1{
		    width:170px;
		}

		

</style>
</head>
<body>

<div>
	 <form method="GET" action ="<c:url value="/backend.controller"/>">
	  <table >
	    <tr>
			<td align="left"><input type="submit" name="backendaction" value="檢舉列表-全部" class="button1"></td>
			<td align="left"><input type="submit" name="backendaction" value="會員建議及回報列表-全部" class="button1"></td>
			<td align="left"><input type="submit" name="backendaction" value="會員列表-全部" class="button1"></td>
		</tr>
		<tr>	
		    <td align="left"><input type="submit" name="backendaction" value="檢舉列表-未處理" class="button1"></td>
			<td align="left"><input type="submit" name="backendaction" value="會員建議及回報列表-未處理" class="button1"></td>
            <td align="left"><input type="submit" name="backendaction" value="會員列表-管理者" class="button1"></td>
		</tr>
		<tr>
		    <td align="left"><input type="submit" name="backendaction" value="檢舉列表-已處理" class="button1"></td>
			<td align="left"><input type="submit" name="backendaction" value="會員建議及回報列表-已處理" class="button1"></td>
		</tr>
	 
      </table>
     </form>
</div>

<div class=".div2">
  <!-- 檢舉文章列表 -->
  <c:if test="${not empty selectaccuse}">
	<table>
		<thead>
		<tr>
			<th>編號</th>
			<th>檢舉人會員帳號</th>
			<th>檢舉文章主題</th>
			<th>檢舉原因</th>
			<th>檢舉時間</th>
			<th>處理備註</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="element" items="${selectaccuse}">
			<c:url value="/backend/doaccuseview.jsp" var="path">
				<c:param name="accuse_no" value="${element.accuse_no}" />
				<c:param name="account" value="${element.member_no.account}" />
				<c:param name="accuse_topic" value="${element.accuse_topic}" />
				<c:param name="accuse_type" value="${element.accuse_type}" />
				<c:param name="accuse_post_time" value="${element.accuse_post_time}" />
				<c:param name="accuse_deal_memo" value="${element.accuse_deal_memo}" />
			</c:url>
			
			<tr>
				<td>${element.accuse_no}</td>
				<td>${element.member_no.account}</td>
				<td>${element.accuse_topic}</td>
				<td>${element.accuse_type}</td>
				<td>${element.accuse_post_time}</td>
				<td>${element.accuse_deal_memo}</td>
				<td><a href="${path}"><input type="button" name="doaccuseaction" value="處理"/></a></td> 
	 
			</tr>
            
		</c:forEach>
		</tbody>
	</table>
  </c:if>
  
  <!-- 會員建議及回報列表  -->
  <c:if test="${not empty selectreport}">
	<table>
		<thead>
		<tr>
			<th>編號</th>
			<th>會員帳號</th>
			<th>回報及建議內容</th>
			<th>回報及建議時間</th>
			<th>處理狀態</th>
			<th>處理備註</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="element" items="${selectreport}">
			<c:url value="/backend/doreportview.jsp" var="path">
				<c:param name="report_no" value="${element.report_no}" />
				<c:param name="account" value="${element.member_no.account}" />
				<c:param name="report_memo" value="${element.report_memo}" />
				<c:param name="report_time" value="${element.report_time}" />
				<c:param name="report_status" value="${element.report_status}" />
				<c:param name="report_status" value="${element.report_deal_memo}" />
			</c:url>
			<tr>
				<td>${element.report_no}</td>
				<td>${element.member_no.account}</td>
				<td>${element.report_memo}</td>
				<td>${element.report_time}</td>
				<td>${element.report_status}</td>
				<td>${element.report_deal_memo}</td>
				<td><a href="${path}"><input type="button" name="doaccuseaction" value="處理" onclick="location.href='<c:url value="/doaccuse.controller"/>'"/></a></td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
  </c:if>
  
  <!-- 會員列表 -->
  <c:if test="${not empty selectmember}">
	<table class="table1">
		<thead>
		<tr>
			<th>編號</th>
			<th>會員帳號</th>
			<th>暱稱</th>
			<th>生日</th>
			<th>興趣</th>
			<th>性別</th>
			<th>帳號狀態</th>
			<th>電子郵件</th>
			<th>帳號權限</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="element" items="${selectmember}">
			<c:url value="/backend/doaccuseview.jsp" var="path">
				<c:param name="member_no" value="${element.member_no}" />
				<c:param name="accoount" value="${element.account}" />
				<c:param name="nickname" value="${element.nickname}" />
				<c:param name="birth" value="${element.birth}" />
				<c:param name="hobby" value="${element.hobby}" />
				<c:param name="gender" value="${element.gender}" />
				<c:param name="account_status" value="${element.account_status}" />
				<c:param name="account_email" value="${element.account_email}" />
				<c:param name="member_status" value="${element.member_status}" />
			</c:url>
			<tr>
				<td>${element.member_no}</td>
				<td>${element.account}</td>
				<td>${element.nickname}</td>
				<td>${element.birth}</td>
				<td>${element.hobby}</td>
				<td>${element.gender}</td>
				<td>${element.account_status}</td>
				<td>${element.account_email}</td>
				<td>${element.member_status}</td>
				<td><a href="${path}"><input type="button" name="doaccuseaction" value="處理" onclick="location.href='<c:url value="/doaccuse.controller"/>'"/></a></td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
  </c:if>
</div>
  

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>

</body>
</html>