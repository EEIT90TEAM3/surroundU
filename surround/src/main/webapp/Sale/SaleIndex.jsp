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
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css" rel="stylesheet">
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
	<script src="${request.contextPath}src/date/jquery-ui-sliderAccess.js" type="text/javascript"></script>
	<script src="${request.contextPath}src/date/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${request.contextPath}src/date/jquery-ui-timepicker-addon.css">
	<script src="${request.contextPath}src/jquery/bootstrap.min.js"></script>
	<link href="${request.contextPath}boot/bootstrap.min.css" rel="stylesheet">
<style>
    
    body {font: 62.5% "Trebuchet MS", sans-serif; margin: 20px;}
    .thumb {
            height: 75px;
            margin: 5px;
        }
</style>
</head>
<body>


<form enctype="multipart/form-data" method="POST" action="<c:url value="/SaleIndex/SaleServlet" />">
	
	 
	  <div class="form-group form-group-sm">
	    <label class="col-sm-2 control-label" for="formGroupInputSmall">擺攤類別：</label>
	    <div class="col-sm-10">
	      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="" name="sale_topic" value="${param.sale_topic}">
	   <font size="-1" color="#FF0000">${errors.sale_topic}</font>
	    </div>
	    
	    <div class="form-group form-group-sm">
	    <label class="col-sm-2 control-label" for="formGroupInputSmall">擺攤名稱：</label>
	    <div class="col-sm-10">
	      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="" name="sale_name" value="${param.sale_name}">
	   <font size="-1" color="#FF0000">${errors.sale_name}</font>
	    </div>
	    
	    <div class="form-group form-group-sm">
	    <label class="col-sm-2 control-label" for="formGroupInputSmall">地點：</label>
	    <div class="col-sm-10">
	      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="" name="sale_locate" value="${param.add}">
	   <font size="-1" color="#FF0000">${errors.sale_locate}</font>
	    </div>
	    
	    <div class="form-group form-group-sm">
	    <label class="col-sm-2 control-label" for="formGroupInputSmall">時間：</label>
	    <div class="col-sm-10">
	      <input class="form-control" type="text" id="datetimepicker1" placeholder="" name="sale_time" value="${param.sale_time}">
	   <font size="-1" color="#FF0000">${errors.sale_time}</font>
	    </div>
      
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
		<div class="form-group form-group-sm">
	    <label class="col-sm-2 control-label" for="formGroupInputSmall">描述：</label>
	    <div class="col-sm-10">
	      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="" name="sale_memo" value="${param.sale_memo}">
	   <font size="-1" color="#FF0000">${errors.sale_memo}</font>
	    </div>
	    
	    <div class="form-group form-group-sm">
	    <label class="col-sm-2 control-label" for="formGroupInputSmall">賣品名稱：</label>
	    <div class="col-sm-10">
	      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="" name="product_name" value="${param.product_name}">
	   <font size="-1" color="#FF0000">${errors.product_name}</font>
	    </div>
      
      
      <label class="fontSize" >照片：</label>
      <div id="dropZone"></div>
      <input Type="file" id="file1" size="40" class="fieldWidth" style="width: 480px;"  name="photo" onchange="fileViewer()"><BR>
      <font color="red" size="-1">${errors.photo}</font>
      <br/>
      
    <div id="dropZone"></div>
      
      <div class="form-group form-group-sm">
	    <label class="col-sm-2 control-label" for="formGroupInputSmall">賣品價格：</label>
	    <div class="col-sm-10">
	      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="" name="product_price" value="${param.product_price}">
	   <font size="-1" color="#FF0000">${errors.product_price}</font>
	    </div>
      
       <div class="form-group form-group-sm">
	    <label class="col-sm-2 control-label" for="formGroupInputSmall">賣品描述：</label>
	    <div class="col-sm-10">
	      <input class="form-control" type="text" id="formGroupInputSmall" placeholder="" name="product_memo" value="${param.product_memo}">
	   <font size="-1" color="#FF0000">${errors.product_memo}</font>
	    </div>
	    

      <input type=hidden name="lat" value="${param.lat}"  class="fieldWidth" style="width: 320px;">
      <input type=hidden name="lng" value="${param.lng}"  class="fieldWidth" style="width: 320px;">
      <div id="btnArea" align="center">
         <input class="btn btn-default" type="submit" name="sale" id="submit" value="新增">
         <input class="btn btn-default" type="reset" id="cancel" value="取消">
      </div>
      <br/>
</form>
${errors.action}
	<script>
            function fileViewer(){
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