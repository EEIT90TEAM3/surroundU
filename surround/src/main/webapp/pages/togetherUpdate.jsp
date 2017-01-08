<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css" rel="stylesheet">
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
  <link href='../css/jquery-ui-timepicker-addon.css' rel='stylesheet'>
  <script type="text/javascript" src="../js/jquery-ui-timepicker-addon.js"></script>
  <script type='text/javascript' src='../js/jquery-ui-sliderAccess.js'></script>


<title>編輯</title>

<style>
    article,aside,figure,figcaption,footer,header,hgroup,menu,nav,section {display:block;}
    body {font: 62.5% "Trebuchet MS", sans-serif; margin: 20px;}
</style>


</head>
<body>
<p style="font-size: 30px ;color: orange;">修改揪團資料</p>

<form action="<c:url value="/pages/together.controller" />" method="get">


<table>
	<tr>
		<td>主題 : </td>
		<td><input type="text" id="together_topic" name="together_topic" value="${param.together_topic}"></td>
		<td>${errors.together_topic}</td>
		<input type="hidden" name="together_no" value="${param.together_no}"/>
		<input type="hidden" name="together_post_time" value="${param.together_post_time}" />
		<input type="hidden" name="together_delete_time" value="${param.together_delete_time}" />
		<input type="hidden" name="together_modify_time" value="${param.together_modify_time}" />
		<input type="hidden" name="together_status" value="${param.together_status}" />
		<input type="hidden" name="together_lng" value="${param.together_lng}" />
		<input type="hidden" name="together_lat" value="${param.together_lat}" />
		<input type="hidden" name="together_people" value="${param.together_people}" />
	</tr>
	<tr>
		<td>名稱 : </td>
		<td><input type="text" id="together_name" name="together_name" value="${param.together_name}"></td>
		<td>${errors.together_name}</td>
	</tr>

	<tr>
		<td>地點 : </td>
		<td><input type="text" id="together_locate" name="together_locate" value="${param.together_locate}"></td>
		<td>${errors.together_locate}</td>
	</tr>
	<tr>
		<td>活動時間 :
		<td><input type="text" id="datetimepicker1" name="together_when" value="${fn:substring(param.together_when,0,16)}"></td>
		<td>${errors.together_when}</td>
	</tr>	
		
	<tr>
	    <td><span>活動結束時間:</span></td>
		<td><input type="text" id="datetimepicker2" name="together_when_end" value="${fn:substring(param.together_when_end,0,16)}"></td>
		<td>${errors.together_when_end}</td>
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
            		        //currentText:"現在時間",
            		        showButtonPanel: false, //出現現在時間
            		        closeText:"確定",
            		        amNames:["上午","AM","A"],
            		        pmNames:["下午","PM","P"],
            			  //showSecond:true, //出現秒數
            		        timeFormat:"HH:mm",
            		      //stepMinute:5,   //分鐘間隔
            	            stepSecond:10,
            	            dafaultDate: new Date(),
                            minDate: "0", maxDate: "60",
            	            addSliderAccess:true, 
                            sliderAccessArgs:{touchonly:false} 
            		        };
            		      $("#datetimepicker1").datetimepicker(opt);
            		      $("#datetimepicker2").datetimepicker(opt);
            		      

              });
                </script>

	</tr>
	
	<tr>
		<td>限制人數 (人數無法修改): </td>
		<td>${param.together_people}</td>
		<td></td>
	</tr>
	<tr>
		<td>備註 : </td>
		<td><input type="text" id="together_memo" name="together_memo" value="${param.together_memo}"></td>
		<td>${errors.together_memo}</td>
	</tr>
	<tr>
		<td>
			<input type="submit" id="buttonGET" name="prodaction" value="儲存">
		</td>
	</tr>
</table>


<h3><span class="error">${errors.action}</span></h3>
</form>


<!--  
<script type="text/javascript">
$(function(){
	$('#buttonGET').click(function(){
	$.get("<c:url value="/pages/together.controller" />",
			{"together_no":"${param.together_no}","together_post_time":"${param.together_post_time}","together_delete_time":"${param.together_delete_time}",
			"together_modify_time":"${param.together_modify_time}","together_status":"${param.together_status}","together_lng":"${param.together_lng}",
			"together_lat":"${param.together_lat}",
			"together_topic":$('#together_topic').val(),"together_name":$('#together_name').val(),"together_locate":$('#together_locate').val(),
			"together_when":$('#datetimepicker1').val(),"together_when_end":$('#datetimepicker2').val(),"together_people":$('#together_people').val(),
			"together_memo":$('#together_memo').val(),"prodaction":"儲存"
			},
	);
	});
});	
	
</script>
-->

</body>
</html>