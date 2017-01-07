<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
	<script src="${request.contextPath}src/jquery111.js" type="text/javascript"></script>
	<script src="${request.contextPath}src/lay/layer.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${request.contextPath}src/lay/skin/default/layer.css">
</head>
<body>


<form enctype="multipart/form-data" method="POST" action="<c:url value="/SaleIndex/SaleServlet" />">

      <label class="fontSize" >擺攤類別：</label>
      <input type="text" name="sale_topic" value="${param.sale_topic}" class="fieldWidth" style="width: 180px;">
      <font size="-1" color="#FF0000">${errors.sale_topic}</font>
      <br/>
      
      <label class="fontSize" >擺攤名稱：</label>
      <input type="text" name="sale_name" value="${param.sale_name}" class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${errors.sale_name}</font>      
      <br/>
      
      <label class="fontSize" >地點：</label>
      <input type="text" name="sale_locate" value="${param.add}"   class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${errors.sale_locate}</font>            
      <br/>
      
      <label class="fontSize" >時間：</label>
      <input type="text" name="sale_time" value="${param.sale_time}"  class="fieldWidth" style="width: 180px;">
      <font color="red" size="-1">${errors.sale_time}</font>
      <br/>
      
      <label class="fontSize" >描述：</label>
      <input type="text" name="sale_memo" value="${param.sale_memo}"  class="fieldWidth" style="width: 320px;">
      <font color="red" size="-1">${errors.sale_memo}</font>
      <br/>
      
      <label class="fontSize" >賣品名稱：</label>
      <input type="text" name="product_name" value="${param.product_name}"  class="fieldWidth" style="width: 320px;">
      <font color="red" size="-1">${errors.product_name}</font>
      <br/>
      
      <label class="fontSize" >照片：</label>
      <Input Type="file" size="40" class="fieldWidth" style="width: 480px;"  name="photo"><BR>
      <font color="red" size="-1">${errors.photo}</font>
      <br/>
      
      <label class="fontSize" >賣品價格：</label>
      <input type="text" name="product_price" value="${param.product_price}"  class="fieldWidth" style="width: 320px;">
      <font color="red" size="-1">${errors.product_price}</font>
      <br/>
      
      <label class="fontSize" >賣品描述：</label>
      <input type="text" name="product_memo" value="${param.product_memo}"  class="fieldWidth" style="width: 320px;">
      <font color="red" size="-1">${errors.product_memo}</font>
      <br/>
      <input type=hidden name="lat" value="${param.lat}"  class="fieldWidth" style="width: 320px;">
      <input type=hidden name="lng" value="${param.lng}"  class="fieldWidth" style="width: 320px;">
      <div id="btnArea" align="center">
         <input type="submit" name="sale" id="submit" value="新增"/>
         <input type="reset" name="cancel" id="cancel" value="cancel">
      </div>
      <br/>
</form>
${errors.action}
</body>
</html>