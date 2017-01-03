<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>處理檢舉</title>
	<style type="text/css">
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
			
			textarea{
			    resize: none; 
			}
	</style>
</head>
<body>
<h3>處理檢舉</h3>              
 <form mothed="get" action="<c:url value="/doaccuse.controller?accuse_no=${param.accuse_no}"/>" >
   <table>		
		
		<tr>
			<th>編號</th>
			<th>${param.accuse_no}</th>
<%-- 			<th><input type="text" name="report_no" value="${param.accuse_no}" readonly></th> --%>
		<tr>
			<th>檢舉人會員帳號</th>
			<th>${param.account}</th>
		</tr>
		<tr>
			<th>檢舉文章主題</th>
			<th>${param.accuse_topic}</th>
		</tr>
		<tr>
			<th>檢舉原因</th>
			<th>${param.accuse_type}</th>
	    </tr>
		<tr>
			<th>檢舉時間</th>
			<th>${param.accuse_post_time}</th>
		</tr>
		<tr>
			<th>文章連結</th>
			<th><input type="button"  value="觀看文章內容" ></th>
		</tr>
		<tr>
		   <th>處理結果</th>
		   <th><input type="radio" name="accuseyesorno" value="1" checked> 檢舉成立<br>
  		       <input type="radio" name="accuseyesorno" value="0"> 檢舉不成立<br>
  		   </th>
        </tr>
		<tr> 
			<th>處理備註</th> 
			<th>
			<textarea cols="80" rows="10" id="memo" name="accuse_deal_memo"></textarea>
			</th>
 	    </tr> 
		<tr>
			<th><input type="submit"  value="確認" ></th>
<!-- 		<a href="${path}"><input type="button" name="doaccuseaction" value="確定" /></a>	 -->
			<th></th>
		</tr>
<%-- 		 <c:url value="/doaccuse.controller" var="path"> --%>
<%-- 				<c:param name="accuse_no" value="${param.accuse_no}" /> --%>
<%-- 				<c:param name="account" value="${param.account}" /> --%>
<%-- 				<c:param name="accuse_topic" value="${param.accuse_topic}" /> --%>
<%-- 				<c:param name="accuse_type" value="${param.accuse_type}" /> --%>
<%-- 				<c:param name="accuse_post_time" value="${param.accuse_post_time}" /> --%>
<%-- 				<c:param name="accuse_deal_memo" value="${param.accuse_deal_memo}" /> --%>
<%-- 		</c:url> --%>
	</table>
    
 </form>

</body>
</html>