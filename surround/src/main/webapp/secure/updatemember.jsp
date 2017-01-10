<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${root}src/jquery211.js" type="text/javascript"></script>
	<script src="${root}boot/bootstrap.min.js"></script>
	<link href="${root}boot/bootstrap.min.css" rel="stylesheet">
	<script src="${root}src/lay/layer.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${root}src/lay/skin/default/layer.css">
<style type="text/css">
        .thumb {
            height: 75px;
            margin: 5px;
        }
    </style>
</head>
<body>
<form  enctype="multipart/form-data" method="post" action="<c:url value="/secure/updateMember.controller" />">
  <!-- 		 <label class="fontSize" >帳號：</label>
      <input type="text" name="account" value="${user.account}" class="fieldWidth" style="width: 180px;">
      <font size="-1" color="#FF0000">${errors.account}</font>-->
      <br/>
 		 <label class="fontSize" >姓名</label>
      <input type="text" name="name" value="${user.name}" class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${errors.sale_name}</font>      
      <br/>
     <fmt:formatDate value="${user.birth}" var="formattedDate" 
                type="date" pattern="yyyy-MM-dd" />

      <label class="fontSize" >生日</label>
      <input type="text" name="birth" value="${formattedDate}" class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${errors.birth}</font>      
      <br/>
      <img id="img" height='100x' width='80px'
					src="<c:url value='${request.contextPath}/secure/logWeb.controller?id=${user.account_facebook}&type=MEMBER'/>"></a></li>
      <br/>
      <div id="dropZone"></div>
      <Input Type="file" id="file1" size="40" class="fieldWidth" style="width: 480px;"  name="file" onchange="fileViewer()"><BR>
      <font color="red" size="-1">${errors.photo}</font>
      <br/>
      <label class="fontSize" >信箱</label>
      <input type="text" name="account_email" value="${user.account_email}" class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${errors.account_email}</font>      
      <br/>
       <input type="submit" name="prodaction" id="submit" value="更新"/>
       
</form>
<script>
            function fileViewer(){
  
            	var sbtitle = document.getElementById('img');
            	sbtitle.style.display = 'none';
                var theFiles = document.getElementById("file1").files;
                for (var i = 0; i < theFiles.length; i++) {
                    var reader = new FileReader();
                    reader.readAsDataURL(theFiles[i]);

                    reader.onload = function (e) {
                        //alert(e.target.result);
                        var fileContent = e.target.result;
                        var imgObj = document.createElement("img");  //<img>
                        imgObj.setAttribute("src", fileContent);  //<img src="...
                        imgObj.setAttribute("class", "thumb"); //<img src=".. class="....
                        document.getElementById("dropZone").appendChild(imgObj);
                    }
                }
            }
            

    </script>
</body>
</html>