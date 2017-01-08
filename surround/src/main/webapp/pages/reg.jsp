<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員系統</title>
<style type="text/css">
    div{
    	border-bottom: 1px solid #efefef;
    	margin:10px;
    	padding-bottom: 10px;
    	width: 460px;
    	margin:0px auto; }
    .title{
    	float: left;
    	width: 100px;
   		text-align: right;
    	padding-right: 10px; }
    .radio-buttons label {
    	float: none;}
    .submit {
    	width:550px;
    	text-align:right;
    	margin: 20px;}
    .error{
        width:550px;
    	text-align:right;
    	margin: 20px;
    	color:red;}
    
</style>
<script type="text/javascript">
	function clearForm() {
		var inputs = document.getElementsByTagName("input");
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "text") {
				inputs[i].value = "";
			}
		}
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "password") {
				inputs[i].value = "";
			}
		}
	}
	function checkpwd(){
		  var p1=document.form1.pwd.value;//獲取密碼的值
		  var p2=document.form1.pwd2.value;//再次輸入密碼的值
		  if(p1==""){
		   alert("請輸入密碼！");//檢查密碼為空 提醒輸入//
		   document.form1.pwd1.focus();//焦點在密碼框
		   return false;
		  }
		  
		  if(p1!=p2){//判断两次输入的值是否一致，不一致则显示错误信息
		   document.getElementById("msg").innerHTML="密碼不一致，請重新輸入";//在div顯示錯誤
		   return false;
		  }else{
		   //密码一致，可以继续下一步操作 
		  }
</script>
</head>
<body>
	<h1 align="center">SurroundYou</h1>
	<hr>
	<form name="form1" action=<c:url value="/pages/reg.controller" /> method="post">
		
				
				<div>
					<label for="account" class="title">帳號：</label>
					<input type="text" id="account" name="account" value="${param.account}" placeholder="請輸入帳號" />
					<label for="error" class="error">${errors.account}</label>
				</div>
				<div>
					<label for="pwd" class="title">密碼：</label>
					<input type="password" id="pwd" name="pwd" required="required" maxlength="12" size="14" 
						placeholder="6~12英數字組合" value="${param.pwd}" />
					<label for="error" class="error">${errors.pwd}</label>
				</div>	
				<div>
					<label for="pwd2" class="title">確認密碼：</label>
					<input type="password" id="pwd2" name="pwd2" required="required" maxlength="12" size="14" 
						placeholder="6~12英數字組合" value="${param.pwd}" onchange="checkpwd()" />
					<label for="error" class="error">${errors.pwd}</label>
				</div>
				<div id="msg" style="color:red;"></div>
				<div>
					<label for="name" class="title">姓名：</label>
					<input type="text" id="name" name="name" value="${param.name}" />
					<label for="error" class="error">${errors.name}</label>
				</div>
				<div>
					<span  class="title">性別：</span>
					<input type="radio" id="male" name="gender" value="M" />
					<label for="male">男</label>
					<input type="radio" id="female" name="gender" value="F" />
					<label for="female">女</label>
					<label for="error" class="error">${errors.gender}</label>
				</div>	
				<div>
					<label for="nickname" class="title">暱稱：</label>
					<input type="text" id="nickname" name="nickname" value="${param.nickname}" />
					<label for="error" class="error">${errors.nickname}</label>
				</div>
				<div>
					<label for="birth" class="title">生日：</label> 
					<input type="date" id="birth" name="birth" placeholder="2014-09-18"> 
					<label for="error" class="error">${errors.birth}</label>
				</div>
				<div>
					<label for="hobby" class="title">興趣:</label>
					<input type="text" id="hobby" name="hobby" value="${param.hobby}" />
					<label for="error" class="error">${errors.hobby}</label>
				</div>
				<div>
					<label for="account_email" class="title">E-Mail:</label>
					<input type="text" id="account_email" name="account_email" value="${param.account_email}" />
					<label for="error" class="error">${errors.account_email}</label>
				</div>
			<div class="submit">
			        <input type="submit"  name="prodaction" value="送出">
					
					<input type="button" value="清除" onclick="clearForm()">
			</div>
				
	</form>
	<c:if test="${not empty insert}">
<h3>Insert Product Table Success</h3>
</c:if>
</body>
</html>