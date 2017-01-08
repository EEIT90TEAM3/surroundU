<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Surround You</title>
<!-- jQuery -->
	<script src="src/jquery211.js" type="text/javascript"></script>
	<script src="src/jquery/bootstrap.min.js"></script>
	<script src="src/lay/layer.js" type="text/javascript"></script>
	<link rel="stylesheet" href="src/lay/skin/default/layer.css">
	<!-- menu -->
	<script src="src/smartmenus/jquery.smartmenus.min.js" type="text/javascript"></script>
	<link rel="stylesheet" href="src/smartmenus/sm-core-css.css">
	<link rel="stylesheet" href="src/smartmenus/sm-blue.css">
 <style>
/*資訊視窗CSS*/
#iw-container .iw-title {
    font-family: 'Open Sans Condensed', sans-serif;
    font-size: 22px;
    font-weight: 400;
    padding: 10px;
    background-color: #48b5e9;
    color: white;
    margin: 0;
    border-radius: 2px 2px 0 0;
}




      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }

    </style>
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
          
          <!--  together-->
            <li ><a id="mytogether">我的約團</a>
            <!--  together-->
            
            </li>
            <li ><a id="mysale">我的擺攤</a>
            </li>
            <li><a href="#">Time Machines</a></li>
            
            <!--  together-->
            <li><a id="myJoinTogether">已申請的約團</a></li>
            <!--  together-->
            
          </ul>
          <li><a href="#">我的好友</a>
          <li><a href="#">文章列表</a>
          <ul>
          <!--  together-->
            <li ><a id="togetherTotalr">約團列表</a>
            <!--  together-->
          </ul>
        </li>
      </ul>
      
    </div>
  </div>
 <div id="map"></div>
  <script> 
  //menu js控制
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
    <script>
 
 	// 這裡開始是body
	var map;
	var itemArray = [];
	var markerArray = [];
	// 地圖初始化
    	function initMap() {
    		  var myLatLng = {lat: 25.045744, lng: 121.543626};

    		  var map = new google.maps.Map(document.getElementById('map'), {
    		    zoom: 12,
    		    center: myLatLng
    		  });
    		  
    	//	  setMarkers(map);
    		  
    		  
    //	移動地圖即時變更物品	  
    		  map.addListener('dragend', function() {
    			  deleteMarkers();
    //返回當前視角經緯度
    			var bounds = map.getBounds();
  				var sw = bounds.getSouthWest();
  				var ne = bounds.getNorthEast();
  	//	console.log(ne.lat(), ne.lng());
  	//	console.log(sw.lat(), sw.lng());
  				var boundsString = "lat: " + sw.lat() + " ~ " + ne.lat() + "<br>" +
				   "lng: " + sw.lng() + " ~ " + ne.lng();
  	//			console.log(boundsString);
  	$.getJSON("GoogleAllServlet.ajax", {
  	//	"swLat": sw.lat(),
	//	"swLng": sw.lng(),
	//	"neLat": ne.lat(),
	//	"neLng": ne.lng()
	}, function(data){
		var count = 1;
		$.each(data, function(index, item){
				// 製作物品經緯度陣列
			var aItem = [item.sale_topic, item.sale_name, item.sale_lng, item.sale_lat ,item.sale_locate,item.sale_memo,item.productBean,item.member_no.nickname];
			itemArray.push(aItem);
			count++;
		});
		for(var i = 0; i < itemArray.length; i++){
			
			var sale_topic = itemArray[i][0];
		
			var sale_name = itemArray[i][1];
			var latitude = itemArray[i][2];//經緯度
			var longitude = itemArray[i][3];//經緯度
			var sale_locate = itemArray[i][4];
			var sale_memo = itemArray[i][5];
			var productBean = itemArray[i][6];
			var nickname = itemArray[i][7];
			var itemLatLng = new google.maps.LatLng(latitude, longitude);
			
			var marker = new google.maps.Marker({
				title: sale_topic,
				position: itemLatLng,
				map: map,
		//		icon: "${root}category-icon/" + class_name + ".png"
			});
			//裝載maker準備delete用
			markerArray.push(marker);
		//資訊視窗
			var contentString = '<div id="iw-container">' +
            '<div class="iw-title">'+'攤位標題:'+sale_topic+'</div>' +
            '<div class="iw-content">' +
              '<div class="iw-subTitle">'+' 攤位名稱:'+sale_name+'</div>' +
              '<div class="iw-subTitle">'+'賣家:'+nickname+'</div>' +
              '<p>'+'攤位地點:'+sale_locate+'</p>' +
              '<p>'+'攤位說明:'+sale_memo+'</p>' +
              '<p><br><br>'+
              '<p>'+'拍賣品名稱:'+productBean[0].product_name+'</p>' +
              '<img src="'+'/WebSurroundSpring/'+productBean[0].product_pic+'" alt="Porcelain Factory of Vista Alegre" height="200" width="150">' +
              '<div class="iw-subTitle">Contacts</div>' +
              '<p>'+'拍賣品價格:'+productBean[0].product_price+'</p>' +
              '<p>'+'拍賣品明細:'+productBean[0].product_memo+'</p>' +
              '<br>sale_time<br>sale_memo</p>'+
            '</div>' +
            '<div class="iw-bottom-gradient"></div>' +
          '</div>';
          addInfoWindow(marker, contentString);
          function addInfoWindow(marker, message) {

              var infoWindow = new google.maps.InfoWindow({
                  content: message
              });
            //點擊關閉彈層
              google.maps.event.addListener(map, 'click', function() {
            	  infoWindow.close();
            	  layer.closeAll(); 
            	  });
              //點擊MAKER資訊視窗
              google.maps.event.addListener(marker, 'click', function () {
                  infoWindow.open(map, marker); 
              });   

         	 }
          
		}
		
  		
  	});
    			  
    		  });
    		  google.maps.event.addListener(map, "rightclick", function (e) {

    //得到當前點擊經緯度
      		    var latLng = e.latLng;
      		  var maplat=latLng.lat();
      		  var maplng=latLng.lng();
      		  alert(maplat);
      		  alert(maplng);
      		  layer.open({
      			  type: 1,
      			  title: false,
      			  closeBtn: 0,
      			  shadeClose: true,
   		          shade: false,
   		      	  id: 'sale',
      			  skin: 'yourclass',
      			  content: '<div style="background: rgba(0%,10%,20%,0.6);"><h1 id="sale">擺攤</><br><h2 id="together">約團</h2></div>'
      			});
  //點擊開啟彈層
      		  $("#sale").click(function(){
      			layer.closeAll('page');
      		//	alert(latLng);
      			layer.open({
      		        type: 2,
      		        title: '新增',
      		        id: 'popup',
      		        shadeClose: true,
      		        shade: false,
      		        maxmin: true, //开启最大化最小化按钮
      		        area: ['500px', '400px'],
  //傳入經緯度參數iFrame
      		        content: ['/surround/Sale/SaleIndex.jsp?lat='+maplat+'&lng='+maplng]
      		     
      			});
      		});   
 //  together-----------------------------------------------------------------
      		$("#together").click(function(){
      			layer.closeAll('page');
      		//	alert(latLng);
      			layer.open({
      		        type: 2,
      		        title: '新增',
      		        id: 'popup',
      		        shadeClose: true,
      		        shade: false,
      		        maxmin: true, //开启最大化最小化按钮
      		        area: ['500px', '400px'],
  //傳入經緯度參數iFrame
      		        content: ['/surround/pages/together.jsp?lat='+maplat+'&lng='+maplng]
      		     
      			});
      		});   
 
      		
//together------------------------------------------------------------------------------ 
      		});
    		  
    		}
    
    	
    	function setMarkers(map) {
    		
    	}
    	// 清除所有地圖標記
		function deleteMarkers() {
			clearMarkers();
			itemArray = [];
			markerArray = [];
		}
		function clearMarkers() {
			setMapOnAll(null);
		}
		function setMapOnAll(map) {
			for (var i = 0; i < markerArray.length; i++) {
				markerArray[i].setMap(map);
			}
		}
		 $("#mysale").click(function(){
    			layer.closeAll('page');
    			layer.open({
    		        type: 2,
    		        title: '新增',
    		        id: 'popup',
    		        shadeClose: true,
    		        shade: false,
    		        maxmin: true, //开启最大化最小化按钮
    		        area: ['500px', '400px'],
    		        content: ['<c:url value="/SaleSearchServlet"/>']
    		     
    			});
    		});
//together------------------------------------------------------------
		 $("#mytogether").click(function(){
 			layer.closeAll('page');
 			layer.open({
 		        type: 2,
 		        title: '新增',
 		        id: 'popup',
 		        shadeClose: true,
 		        shade: false,
 		        maxmin: true, //开启最大化最小化按钮
 		        area: ['700px', '400px'],
 		        content: '<c:url value="/TogetherDetailsServlet"/>'
 			});
 		});
		 $("#myJoinTogether").click(function(){
	 			layer.closeAll('page');
	 			layer.open({
	 		        type: 2,
	 		        title: '新增',
	 		        id: 'popup',
	 		        shadeClose: true,
	 		        shade: false,
	 		        maxmin: true, //开启最大化最小化按钮
	 		        area: ['700px', '400px'],
	 		        content: '<c:url value="/MyJoinTogether.controller"/>'
	 			});
	 		});
 		$("#togetherTotalr").click(function(){
 			layer.closeAll('page');
 			layer.open({
 		        type: 2,
 		        title: '新增',
 		        id: 'popup',
 		        shadeClose: true,
 		        shade: false,
 		        maxmin: true, //开启最大化最小化按钮
 		        area: ['700px', '400px'],
 		        content: '<c:url value="/TogetherTotal.controller"/>'
 			});
 		});
// together-----------------------------------------------------------
  </script>
  <script 
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA-Inouuyem3ufRkt0dseRmzUCHtqyhgds&callback=initMap">
    </script>
</body>
</html>