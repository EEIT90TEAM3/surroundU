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
            height: 100px;
            
           
        }
    </style>
    <script>
var sale ="${param.sale}";

var index = parent.layer.getFrameIndex(window.name);
var timein=2*1000;
switch(sale){
case "aaa":layer.alert('會員資料更新成功', {icon: 6});

break;


}

</script>
    
</head>
<body>
<form  enctype="multipart/form-data" method="post" action="<c:url value="/secure/updateMember.controller" />">
  <!-- 		 <label class="fontSize" >帳號：</label>
      <input type="text" name="account" value="${user.account}" class="fieldWidth" style="width: 180px;">
      <font size="-1" color="#FF0000">${errors.account}</font>-->

 
    <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" placeholder="name" name="name" value="${user.name}">
    <font color="red" size="-1">${errors.sale_name}</font>  
    </div>
 	
     <fmt:formatDate value="${user.birth}" var="formattedDate" 
                type="date" pattern="yyyy-MM-dd" />
	
	 <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">生日</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" placeholder="birth" name="birth" value="${formattedDate}">
 	 <font color="red" size="-1">${errors.birth}</font>  
    </div>
   <br/>
      
      <img id="img" height='100px' 
					src="<c:url value='${request.contextPath}/secure/logWeb.controller?id=${user.account_facebook}&type=MEMBER'/>"></a></li>
      <br/>
      <div id="dropZone"></div>
     <label for="exampleInputFile">更換大頭貼</label>
      <input Type="file" id="file1" size="40" class="fieldWidth" style="width: 480px;"  name="file" onchange="fileViewer()"><BR>
      <font color="red" size="-1">${errors.photo}</font>
      
      <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">信箱</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" placeholder="email" name="account_email" value="${user.account_email}">
 	 <font color="red" size="-1">${errors.account_email}</font>  
    </div>
    <div id="btnArea" align="center">
		<input class="btn btn-default" type="submit" name="prodaction" id="submit" value="更新">
	</div>
	<br/>
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