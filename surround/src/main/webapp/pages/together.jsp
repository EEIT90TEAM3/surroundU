<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css" rel="stylesheet">
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
  
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">       
<link rel="stylesheet" href="<c:url value="/css/lightbox.css"/>">
<link href='../css/jquery-ui-timepicker-addon.css' rel='stylesheet'>
  <script type="text/javascript" src="../js/jquery-ui-timepicker-addon.js"></script>
  <script type='text/javascript' src='../js/jquery-ui-sliderAccess.js'></script>
<title>揪團</title>

<style>
    article,aside,figure,figcaption,footer,header,hgroup,menu,nav,section {display:block;}
    body {font: 62.5% "Trebuchet MS", sans-serif; margin: 20px;}
</style>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
</head>
<body>

<form action="<c:url value="/pages/together.controller" />" method="get">

<table class="table table-bordered table-striped table-hover" style="font-size: 13px">
<thead>
	<tr>
		<th style="color: black; " colspan="3">開團資料</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td Width="100"	>主題 : </td>
		
		<td width="1px">
		<div >
		<select id="selectedMap" name="together_topic" class="form-control">
								<option value="運動" ${param.together_topic == '運動' ? 'selected' : ''}>運動</option>
								<option value="唱歌" ${param.together_topic == '唱歌' ? 'selected' : ''}>唱歌</option>
								<option value="看電影" ${param.together_topic == '看電影' ? 'selected' : ''}>看電影</option>
								<option value="玩桌遊" ${param.together_topic == '玩桌遊' ? 'selected' : ''}>玩桌遊</option>
								<option value="嘗美食" ${param.together_topic == '嘗美食' ? 'selected' : ''}>嘗美食</option>
								<option value="爬山" ${param.together_topic == '爬山' ? 'selected' : ''}>爬山</option>
								<option>--自行輸入--</option>
							</select>	
		</div>
		</td>
		<td>${errors.together_topic}</td>
	</tr>
	<tr>
		<td >名稱 : </td>
		<td ><input type="text" name="together_name" size="45"  style="border-color: white;" value="${param.together_name}"></td>
		<td>${errors.together_name}</td>
	</tr>

	<tr>
		<td>地點 : </td>
		<td ><input type="text" name="together_locate" size="45"  style="border-color: white;"" value="${param.together_locate}"></td>
		<td>${errors.together_locate}</td>
	</tr>
	<tr>
		<td>活動時間 : </td>
		<td ><input type="text" id="datetimepicker1" size="45"  style="border-color: white;"" name="together_when" value="${param.together_when}"></td>
		<td>${errors.together_when}</td>
	</tr>	
		
	<tr>
	    <td><span>活動結束時間:</span></td>
		<td ><input type="text" id="datetimepicker2" size="45"  style="border-color: white;"" name="together_when_end" value="${param.together_when_end}"></td>
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
            		      $("#datetimepicker2").datetimepicker(opt);
            		      

              });
                </script>

	</tr>
	
	<tr>
		<td>限制人數 : </td>
		<td style="color: red;"><input type="text" name="together_people" size="20"  style="border-color: white;" value="${param.together_people}">新增後，人數將無法修改</td>
		<td>${errors.together_people}</td>
	</tr>
	<tr>
		<td>備註 : </td>
		<td><input type="text" name="together_memo" size="45"  style="border-color: white;" value="${param.together_memo}"></td>
		<td>${errors.together_memo}</td>
	</tr>
	<input type=hidden name="lat" value="${param.lat}"  class="fieldWidth" style="width: 320px;">
      <input type=hidden name="lng" value="${param.lng}"  class="fieldWidth" style="width: 320px;">
	<tr>
	<td></td>
	<td>
			<input type="button" value="清除所有欄位資料" size="45"   onclick="clearForm()">
		</td>
		<td>
			<input type="submit" id="closeIframe" size="45"   name="prodaction" value="送出">
		</td>
		
		
	</tr>
	</tbody>
</table>

<h3><span class="error">${errors.action}</span></h3>
</form>

</body>
</html>