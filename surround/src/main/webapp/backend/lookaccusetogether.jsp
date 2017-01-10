<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看約團文章</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">       
<link rel="stylesheet" href="<c:url value="/css/lightbox.css"/>">   
</head>
<body>
	<table class="table table-bordered table-striped table-hover">
      
      <tr>
        <th>編號</th>
        <th>${lookaccusetogether.together_no}</th>
      </tr>
      <tr>
        <th>會員</th>
        <th>${lookaccusetogether.member_no.account}</th>
      </tr>
      <tr>
        <th>約團分類</th>
        <th>${lookaccusetogether.together_topic}</th>
      </tr>
      <tr>
        <th>約團標題</th>
        <th>${lookaccusetogether.together_name}</th>
      </tr>
      <tr>
        <th>約團地點</th>
        <th>${lookaccusetogether.together_locate}</th>
      </tr>
      <tr>
        <th>約團開始時間</th>
        <th>${lookaccusetogether.together_when}</th>
      </tr>
       <tr>
        <th>約團結束時間</th>
        <th>${lookaccusetogether.together_when_end}</th>
      </tr>
       <tr>
        <th>約團人數上限</th>
        <th>${lookaccusetogether.together_people}</th>
      </tr>
       <tr>
        <th>約團備註</th>
        <th>${lookaccusetogether.together_memo}</th>
      </tr>
   </table>
   
      <!-- http://lokeshdhakar.com/projects/lightbox2/ -->
	<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>  
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>   
	<script src="<c:url value="/js/lightbox.js"/>"></script>     
	

</body>
</html>