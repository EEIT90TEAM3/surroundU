<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
	<!-- jQuery -->

	<script src="src/jquery211.js" type="text/javascript"></script>
	<!-- SmartMenus jQuery plugin -->
	<script src="src/smartmenus/jquery.smartmenus.min.js" type="text/javascript"></script>
	<!-- SmartMenus core CSS (required) -->
	<link rel="stylesheet" href="src/smartmenus/sm-core-css.css">
	<!-- "sm-blue" menu theme (optional, you can use your own CSS, too) -->
	<link rel="stylesheet" href="src/smartmenus/sm-blue.css">
	<script src="src/lay/layer.js" type="text/javascript"></script>
	<link rel="stylesheet" href="src/lay/layer.css">


	<style type="text/css">
  html { height: 100% }
  body { height: 100%; margin: 0; padding: 0 }
  #map-canvas { height: 100% }
</style>
	<script type="text/javascript"
	      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBe9zjwjOCUo0vxapnoT6zuIcBDQuuPlGk">
	</script>
<!-- GOOGLEMap初始化 -->
	<script type="text/javascript">
      function initialize() {
        var mapOptions = {
          center: { lat: 25.033889, lng: 121.543590},
          zoom: 12
        };
        var map = new google.maps.Map(
            document.getElementById('map-canvas'),
            mapOptions);
      }
      google.maps.event.addDomListener(
          window, 'load', initialize);
    </script>
<script>
layer.alert('歡迎進入Srround YOU', {icon: 6});
// menu初始化 
$(document).ready(function() {
  $('.sm').smartmenus({
    showFunction: function($ul, complete) {
      $ul.slideDown(250, complete);
    },
    hideFunction: function($ul, complete) {
     $ul.slideUp(250, complete); 
    }
  });
}); // end ready
</script>
</head>
<body>
<div class="content">
    <div class="main">
      <ul class="sm sm-blue">
        <li><a href="#">Home</a></li>
        <li><a href="#">我的資料 </a>
          <ul>
            <li><a href="<c:url value='secure/login.jsp' />">修改會員資料</a></li>
            <li><a href="#">回報管理者</a></li>
            <li><a href="#">登出</a></li>
          </ul>
        </li>
        <li><a href="#">我的活動</a>
          <ul>
            <li><a href="#">我的約團</a>
             <!-- <ul>
                <li><a href="#">Gizmo Basic</a></li>
                <li><a href="#">Gizmo Standard</a></li>
                <li><a href="#">Gizmo Supreme</a></li>
              </ul>
            </li>-->
            <li><a href="#">我的擺攤</a>
              <!--<ul>
                <li><a href="w">Gadget Basic</a></li>
                <li><a href="#">Gadget Standard</a></li>
                <li><a href="#">Gadget Supreme</a>
                  <ul>
                    <li><a href="#">Gadget Supreme A</a></li>
                    <li><a href="#">Gadget Supreme B</a></li>
                  </ul>
                </li>
              </ul>-->
            </li>
            <li><a href="#">Time Machines</a></li>
          </ul>
          <li><a href="#">我的好友</a>
          <li><a href="#">文章列表</a>
        </li>
      </ul>
      
    </div>
  </div>
  <div id="map-canvas"></div>
</body>
</html>