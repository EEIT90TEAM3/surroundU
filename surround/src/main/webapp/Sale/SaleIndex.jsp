<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery -->

	
	<script src="<c:url value="/src/jquery111.js"/>" type="text/javascript"></script>  
	<script src="<c:url value="/src/lay/layer.js"/>" type="text/javascript"></script>
	<link rel="stylesheet" href="<c:url value="/src/lay/skin/default/layer.css"/>">
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css" rel="stylesheet">
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
	<script src="<c:url value="/Sale/src/date/jquery-ui-sliderAccess.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/Sale/src/date/jquery-ui-timepicker-addon.js"/>" type="text/javascript"></script>
	<link rel="stylesheet" href="<c:url value="/Sale/src/date/jquery-ui-timepicker-addon.css"/>">
<style>
    
    body {font: 62.5% "Trebuchet MS", sans-serif; margin: 20px;}
</style>
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
      <input type="text" name="sale_time" id="datetimepicker1" value="${param.sale_time}"  class="fieldWidth" style="width: 180px;">
      <script language="JavaScript">
              $(document).ready(function(){ 
            	  var opt={
            		        //以下為日期選擇器部分
            		        dayNames:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
            		        dayNamesMin:["日","一","二","三","四","五","六"],
            		        monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
            		        monthNamesShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
            		        prevText:"上月",
            		        nextText:"次月",
            		        weekHeader:"週",
            		        showMonthAfterYear:true,
            		        dateFormat:"yy-mm-dd",
            		        //以下為時間選擇器部分
            		        timeOnlyTitle:"選擇時分秒",
            		        timeText:"時間",
            		        hourText:"時",
            		        minuteText:"分",
            		        secondText:"秒",
            		        millisecText:"毫秒",
            		        timezoneText:"時區",
            		        currentText:"現在時間",
            		        closeText:"確定",
            		        amNames:["上午","AM","A"],
            		        pmNames:["下午","PM","P"],
            			  //showSecond:true,
            		        timeFormat:"HH:mm",
            		      //stepMinute:5,   //分鐘間隔
            	            stepSecond:10,
            	            dafaultDate: new Date(),
                            minDate: "0", maxDate: "60",
            	            addSliderAccess:true, 
                            sliderAccessArgs:{touchonly:false} 
            		        };
            		      $("#datetimepicker1").datetimepicker(opt);
            		  
            		      
              });
                </script>

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