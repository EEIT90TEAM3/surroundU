<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Surround You</title>
<!-- jQuery -->

	<script src="<c:url value="/src/jquery211.js"/>" type="text/javascript"></script>   
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/src/lay/layer.js"/>" type="text/javascript"></script>
	<link rel="stylesheet" href="<c:url value="/src/lay/skin/default/layer.css"/>">
	<!-- menu -->                                         
	<script src="<c:url value="/src/smartmenus/jquery.smartmenus.min.js"/>" type="text/javascript"></script>
	<link rel="stylesheet" href="<c:url value="/src/smartmenus/sm-core-css.css"/>">
	<link rel="stylesheet" href="<c:url value="/src/smartmenus/sm-blue.css"/>">
		<link rel="stylesheet" href="<c:url value="/chat/css/reset.css"/>"> <!-- CSS reset -->
	<link rel="stylesheet" href="<c:url value="/chat/css/style.css"/>"> <!-- Resource style -->
    <link type="text/css" href="<c:url value="/chat/css/jquery.ui.chatbox.css"/>" rel="stylesheet" />
    <link rel="stylesheet" href="<c:url value="/chat/css/jquery-ui-1.8.2.custom.css"/>" type="text/css" media="screen" />
    <script type="text/javascript" src="<c:url value="/chat/js/jquery-ui-1.8.2.custom.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/chat/js/chatboxManager.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/chat/js/jquery.ui.chatbox.js"/>"></script>

	<link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.css"/>">
	<link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap-theme.min.css"/>">
	<link rel="stylesheet" href=" <c:url value="/chat/css/chats.css"/>">

	<script type="text/javascript" src=" <c:url value="/bootstrap/js/npm.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/chat/js/chats.js"/>"></script>
 <style>
/*資訊視窗CSS*/
#iw-container .iw-title {
    font-family: 'Open Sans Condensed', sans-serif;
    font-size: 15px;
    font-weight: 400;
    padding: 6px;
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
<div class="container">
    <div class="row chat-window col-xs-5 col-md-3" id="chat_window_1" style="position:fixed;margin-left:-45px;">
        <div class="col-xs-12 col-md-12">
        	<div class="panel panel-default">
                <div class="panel-heading top-bar">
                    <div class="col-md-8 col-xs-8">
                        <h3 class="panel-title"><span class="glyphicon glyphicon-comment"></span> 在線人數:<span id="onlinecount"></span></h3>
                    </div>
                    <div class="col-md-4 col-xs-4" style="text-align: right;">
                        <a href="#"><span id="minim_chat_window" class="glyphicon glyphicon-minus icon_minim"></span></a>
                    </div>
                </div>
                <div class="panel-body msg_container_base" id="chatext" style="height:449px;">
                    <div class="row msg_container base_sent" >
                        <div class="col-md-10 col-xs-10" style="width: 100%">
                            <div class="messages msg_sent" >
                                <p>歡迎進入聊天室</p>
                            </div>
                        </div>
                    </div>
                 </div>
                <div class="panel-footer">
                    <div class="input-group">
                        <input id="btn-input" type="text" class="form-control input-sm chat_input" placeholder="Write your message here..." />
                        <span class="input-group-btn">
                        <button class="btn btn-primary btn-sm" id="btn-chat">Send</button>
                        </span>
                    </div>
                </div>
    		</div>
        </div>
    </div>
</div>


<div class="content">
    <div class="main">
      <ul class="sm sm-blue">

  <!--        <li><a href="#"><img height='30px' width='30px'
					src="<c:url value='${request.contextPath}/secure/logWeb.controller?id=${user.account_facebook}&type=MEMBER'/>"></a></li>
        -->
        <li><a href="#">會員專區</a>

         
          
          <ul>
            <li><a id="updatemen">修改會員資料</a></li>
            <li><a id="postreport">回報管理者</a></li>
            <li><a href="#">登出</a></li>
          </ul>
        </li>
        <li><a href="#">我的活動</a>
          <ul>
          
            <!--  together-->
            <li ><a id="mytogether">我的約團</a>
            <!--  together-->
            
            <li ><a id="mysale">我的擺攤</a>
            </li>
            <!--  together-->
            <li><a id="myJoinTogether">已申請的約團</a></li>
            <!--  together-->
            
          </ul>
          
          <li><a href="#">文章列表</a>
           <ul>
          <!--  together-->
            <li ><a id="togetherTotal">約團列表</a>
            <!--  together-->
          </ul>
        </li>
      </ul>
      
    </div>
  </div>
 <div id="map"></div>
  <div class="cd-cart-container empty">
	<a href="#0" class="cd-cart-trigger">
		Cart

	</a>

	<div class="cd-cart">
		<div class="wrapper">
			<header>
				<h2 id="chatname"></h2>

			</header>
			
			<div class="body">
				<ul>
					<!-- products added to the cart will be inserted here using JavaScript -->
				</ul>
			</div>

			<footer>
				<span class="checkout btn"><span style="color:#ffffff">搜尋會員</span><input type="text" id="searchID" maxlength="15" style="width:110px;height:25px" >
				<button type="button" id="searchMem" style="vertical-align:middle;"><img src="img/search.png" style="width:30px;height:30px"></button></span>			
			</footer>
		</div>
		
	</div> <!-- .cd-cart -->
	
</div> <!-- cd-cart-container -->
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
	//together------------------------------
	var itemTogetherArray=[];
	var markerTogetherArray=[];
	//together------------------------------
	// 地圖初始化
    	function initMap() {
    		  var myLatLng = {lat: 25.045744, lng: 121.543626};

    		  var map = new google.maps.Map(document.getElementById('map'), {
    		    zoom: 12,
    		    center: myLatLng
    		  });
    		  
    	//	  setMarkers(map);
    		  
    		  
    //	移動地圖即時變更物品	  
    		  map.addListener('tilesloaded', mapajax);
    				  function mapajax() {
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
			var aItem = [item.sale_topic, item.sale_name, item.sale_lng, item.sale_lat ,item.sale_locate,item.sale_memo,item.productBean,item.member_no.name,item.sale_time];
			itemArray.push(aItem);
			count++;
		});
		for(var i = 0; i < itemArray.length; i++){
			
			var sale_topic = itemArray[i][0];
			var sale_name = itemArray[i][1];
			var latitude = itemArray[i][2];//經度
			var longitude = itemArray[i][3];//緯度
			var sale_locate = itemArray[i][4];
			var sale_memo = itemArray[i][5];
			var productBean = itemArray[i][6];
			var name = itemArray[i][7];
			var sale_time = itemArray[i][8];
		for(var o1 in productBean){
			var itemLatLng = new google.maps.LatLng(latitude, longitude);
			
			var marker = new google.maps.Marker({
				title: sale_topic,
				position: itemLatLng,
				map: map,

				icon: "<c:url value="/img/mapicon/sale.png"/>"

			});
			
			//裝載maker準備delete用
			markerArray.push(marker);
		//資訊視窗
		
		if (o1==0){
			var contentString = '<div id="iw-container">' +
			'<link href="${root}src/boot/bootstrap.min.css" rel="stylesheet">'+
            '<div class="iw-title">'+'攤位標題:'+sale_topic+'</div>' +
            '<div class="iw-content">' +
//              '<div class="iw-subTitle">'+' 攤位名稱:'+sale_name+'</div>' +
              '<div class="iw-subTitle">'+'賣家:'+name+'</div>' +
              '<p>'+'攤位地點:'+sale_locate+'</p>' +
              '<p>'+'攤位時間:'+sale_time+'</p>' +
//              '<p>'+'攤位說明:'+sale_memo+'</p>' +
//              '<p><br><br>'+
				'<div id="pro">'+
              '<p id="pp">'+'拍賣品名稱:'+productBean[o1]['product_name']+'</p>' +
              '<img src="'+'/surround'+productBean[o1]['product_pic']+'" alt="Porcelain Factory of Vista Alegre" height="100" width="80">' +
              '<p>'+'拍賣品價格:'+productBean[o1]['product_price']+'</p>' +
              '</div>'+

              '<p><button class="btn btn-default" type="submit">詳細資料</button></p>'+
  //            '<p>'+'拍賣品明細:'+productBean[o1]['product_memo']+'</p>' +
            '</div>' +
          '</div>';
          
          }else{
        	  $("#pro").append("<b>Hello world!</b>");
        
          }
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
         //         var input2=document.getElementById("pp").innerText
      	//		 alert(input2);
              });   

         	 }
		 }
		}
		
  		

  	});
  	
//together--------------------------------------------
  	$.getJSON("GoogleTogetherServlet.ajax", {
  	  	//	"swLat": sw.lat(),
  		//	"swLng": sw.lng(),
  		//	"neLat": ne.lat(),
  		//	"neLng": ne.lng()
  		}, function(data1){
  			var count = 1;
  			$.each(data1, function(index, item){
  					// 製作物品經緯度陣列
  				var bItem = [item.together_topic, item.together_name, item.together_lng, item.together_lat ,item.together_locate,item.together_when,item.together_when_end,item.member_no.name,item.together_people,item.together_memo,item.together_no];
  				itemTogetherArray.push(bItem);
  				count++;
  			});
  			for(var i = 0; i < itemTogetherArray.length; i++){
  				
  				var together_topic = itemTogetherArray[i][0];
  				var together_name = itemTogetherArray[i][1];
  				var latitude = itemTogetherArray[i][2];//經度
  				var longitude = itemTogetherArray[i][3];//緯度
  				var together_locate = itemTogetherArray[i][4];
  				var together_when = itemTogetherArray[i][5];
  				var together_when_end = itemTogetherArray[i][6];
  				var name = itemTogetherArray[i][7];
  				var together_people = itemTogetherArray[i][8];
  				var together_memo = itemTogetherArray[i][9]; 
  				var together_no=itemTogetherArray[i][10]; 

  				
  				var itemLatLng = new google.maps.LatLng(latitude, longitude);
  				
  				var marker = new google.maps.Marker({
  					title: together_topic,
  					position: itemLatLng,
  					map: map,
  					icon: "<c:url value="/img/mapicon/together.png"/>"
  			//		icon: "${root}category-icon/" + class_name + ".png"
  				});
  				
  				//裝載maker準備delete用
  				markerTogetherArray.push(marker);
  			//資訊視窗
  				var contentString1 = '<div id="iw-container">' +
  				'<link href="${root}src/boot/bootstrap.min.css" rel="stylesheet">'+
  	            '<div class="iw-title">'+'約團主題:'+together_topic+'</div>' +
  	            '<div class="iw-content">' +
  	              '<div class="iw-subTitle">'+' 約團名稱:'+together_name+'</div>' +
  	            '<p>'+'主揪人:'+name+'</p>' +
  	              '<p>'+'地點:'+together_locate+'</p>' +
//  	              '<p>'+'活動時間:'+together_when+'</p>' +
//  	            '<p>'+'活動結束時間:'+together_when_end+'</p>' +
//  	          '<p>'+'限制人數:'+together_people+'</p>' +
//  	              '<p>'+'備註:'+together_memo+'</p>' +
//  	              '<p><br>'+

  	              '<p><button class="btn btn-default" id="togetherMap" type="submit">詳細資料</button></p>'+

  	            '</div>' +
  	          '</div>';
  	          addInfoWindow(marker, contentString1);
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
 //together---------------------------------------------------------------------------

    			  
    		  }
    		  google.maps.event.addListener(map, "rightclick", function (e) {

    //得到當前點擊經緯度
      		    var latLng = e.latLng;
      		  var maplat=latLng.lat();
      		  var maplng=latLng.lng();
      		  var adlot=null;
	      		var geocoder = new google.maps.Geocoder();
	     	      geocoder.geocode({ 'location': latLng }, function(results, status) {
	      	      if (status === google.maps.GeocoderStatus.OK) {
	      	      if (results[0]) {

	      	       adlot = results[0].formatted_address;
//      	       alert(adlot);
	      	      } 
	      	     }
	      	   });

//      		  alert(maplat);
//      		  alert(maplng);


      		  layer.open({
      			  type: 1,
      			  title: false,
      			  closeBtn: 0,
      			  shadeClose: true,
   		          shade: false,
   		      	  id: 'sale',
      			  skin: 'yourclass',
      			  content: '<link href="${root}src/boot/bootstrap.min.css" rel="stylesheet"><button class="btn btn-default" id="sale" type="submit">擺攤</button></br><button class="btn btn-default" id="together" type="submit">約團</button>'
      			});
  //點擊開啟彈層
      		  $("#sale").click(function(){
      			layer.closeAll('page');
      		//	alert(latLng);
      			layer.open({
      		        type: 2,
      		        title: '新增擺攤',
      		        id: 'popup',
      		        shadeClose: true,
      		        shade: false,
      		        maxmin: true, //开启最大化最小化按钮
      		        area: ['500px', '600px'],
  //傳入經緯度參數iFrame
      		        content: ['/surround/Sale/SaleIndex.jsp?lat='+maplat+'&lng='+maplng+'&add='+adlot]
      		     
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
        		        area: ['600px', '460px'],
    //傳入經緯度參數iFrame
        		        content: ['/surround/pages/together.jsp?lat='+maplat+'&lng='+maplng+'&together_locate='+adlot]
        		     
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
		//我的擺攤彈層
		 $("#mysale").click(function(){
    			layer.closeAll('page');
    			layer.open({
    		        type: 2,
    		        title: '擺攤',
    		        id: 'popup',
    		        shadeClose: true,
    		        shade: false,
    		        maxmin: true, //开启最大化最小化按钮
    		        area: ['500px', '500px'],
    		        content: ['<c:url value="/SaleSearchServlet"/>']
    		     //
    			});
    		});
		 $("#updatemen").click(function(){
 			layer.closeAll('page');
 			layer.open({
 		        type: 2,
 		        title: '更新會員資料',
 		        id: 'popup',
 		        shadeClose: true,
 		        shade: false,
 		        maxmin: true, //开启最大化最小化按钮
 		        area: ['500px', '500px'],
 		        content: ['<c:url value="/secure/updatemember.jsp"/>']
 		     //
 			});
 		});



		 
		//together------------------------------------------------------------
		 $("#mytogether").click(function(){
 			layer.closeAll('page');
 			layer.open({
 		        type: 2,
 		        title: '約團',
 		        id: 'popup',
 		        shadeClose: true,
 		        shade: false,
 		        maxmin: true, //开启最大化最小化按钮
 		        area: ['600px', '460px'],
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
 		$("#togetherTotal").click(function(){
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

//postreport--------------------begin---------------------------------
         $("#postreport").click(function(){
 			layer.closeAll('page');
 			layer.open({
 		        type: 2,
 		        title: '回報管理者',
 		        id: 'popup',
 		        shadeClose: true,
 		        shade: false,
 		        maxmin: true, //开启最大化最小化按钮
 		        area: ['450px', '270px'],
 		        content: '<c:url value="/report/postreport.jsp"/>'
 			});
 		});
//postreport--------------------end-----------------------------------

// ======================瑞豪=======================	
	var ws;
var loginName = "${sessionScope.user.account}";
var loginNo = "${sessionScope.user.member_no}";
var memName = "${sessionScope.user.name}";
var cartWrapper = $('.cd-cart-container');

		//product id - you don't need a counter in your real project but you can use your real product id
var productId = 0;
$("#chatname").text(memName);
		var cartBody = cartWrapper.find('.body');
		var cartList = cartBody.find('ul').eq(0);
		var cartTotal = cartWrapper.find('.checkout').find('span');
		var cartTrigger = cartWrapper.children('.cd-cart-trigger');
		var addToCartBtn = $('.cd-add-to-cart');
		var undo = cartWrapper.find('.undo');
		var undoTimeoutId;

			addToCart(addToCartBtn);
			$('#searchMem').on('click', function(event){
	     		cartList.find('.product').remove();
				var productAdded = $('<li class="product"><div class="product-details"><h3><a href="#0">無此會員</a></h3><div class="actions"></div></div></div></li>');
				cartList.prepend(productAdded);
				ws.send(JSON.stringify({
			        nickname : $("#searchID").val(),
			        type : "searchID"
			    }));                  		
			});
			//open/close cart
			cartTrigger.on('click', function(event){
				event.preventDefault();
				toggleCart();
			});

			//close cart when clicking on the .cd-cart-container::before (bg layer)
			cartWrapper.on('click', function(event){
				if( $(event.target).is($(this)) ) toggleCart(true);
			});

			//delete an item from the cart
			cartList.on('click', '.delete-item', function(event){
				event.preventDefault();
				removeProduct($(event.target).parents('.product'));
			});

		

		function toggleCart(bool) {
			var cartIsOpen = ( typeof bool === 'undefined' ) ? cartWrapper.hasClass('cart-open') : bool;
			
			if( cartIsOpen ) {
				
				cartWrapper.removeClass('cart-open');
				//reset undo
				clearInterval(undoTimeoutId);
				undo.removeClass('visible');
				cartList.find('.deleted').remove();
				cartList.find('.product').remove();
				$("#searchID").val("");


			} else {
				
				var inviteArray=[];
				friendArray = [];
				$.getJSON("FriendListServlet.ajax",{"loginNo":loginNo,"type":"FriendList"}, function(data){

		  			var count = 1;
		  			$.each(data, function(index, item){
		  					// 製作物品經緯度陣列
		  				var aItem = [item.buddy_no.name,item.buddy_no.account,item.friend_status,item.buddy_no.member_photo_chat];
		  				friendArray.push(aItem);
		  				count++;
		  			});
		  			for(var i = 0; i < friendArray.length; i++){
	  				
		  				var Name = friendArray[i][0];
		  				var Account = friendArray[i][1];
	 	 				var status = friendArray[i][2];;
		  				var himg = friendArray[i][3];
		 				if(himg==""){
	 						himg="product-preview";
	 					}
	 	 				if(status==1){
	 	 					var productAdded = $('<li class="product"><div class="product-image"><a href="#0"><img src="img/'+himg+'.png" alt="placeholder"></a></div><div class="product-details"><h3><a href="#0">'+Name+'</a></h3><span class=&nbsp;</span><div class="actions"><a href="#0" class="delete-item" onclick="delfriend(\''+Account+'\');">刪除</a><div class="quantity"><a href="#0" class="privateTalk" onclick="openbox(\''+Account+'\',\''+Name+'\',\'friend\');">私訊</a></label></div></div></div></li>');
	 	 				}else{
	 	 					var productAdded = $('<li class="product"><div class="product-image"><a href="#0"><img src="img/'+himg+'.png" alt="placeholder"></a></div><div class="product-details"><h3><a href="#0">'+Name+'</a></h3><span class=&nbsp;</span><div class="actions"><span>邀請中</span><div class="quantity"></label></div></div></div></li>');						
	 	 				}
	 					cartList.prepend(productAdded);
		  			}	
				});
				$.getJSON("FriendListServlet.ajax",{"loginNo":loginNo,"type":"InviteList"}, function(data){

		  			var count = 1;
		  			$.each(data, function(index, item){
		  				var aItem = [item.member_no.name,item.member_no.account,item.member_no.member_photo_chat];
		  				inviteArray.push(aItem);
		  				count++;
		  			});
			  			for(var i = 0; i < inviteArray.length; i++){
		  				
			  				var Name = inviteArray[i][0];
			  				var Account = inviteArray[i][1];

			  				var himg = inviteArray[i][2];
			 				if(himg==""){
		 						himg="product-preview";
		 					}
		 	 				var productAdded = $('<li class="product"><div class="product-image"><a href="#0"><img src="img/'+himg+'.png" alt="placeholder"></a></div><div class="product-details"><h3><a href="#0">'+Name+'</a></h3><span class="price">&nbsp;&nbsp;</span><div class="actions"><a href="#0" class="delete-item" onclick="delinvite(\''+Account+'\');">拒絕</a><div class="quantity"><a href="#0" class="privateTalk" onclick="accpetinvite(\''+Account+'\');">接受好友</a></label></div></div></div></li>');
			  				cartList.prepend(productAdded);
			  			}			
 				cartWrapper.addClass('cart-open');
				});
			}
		}

		function addToCart(trigger) {
			var cartIsEmpty = cartWrapper.hasClass('empty');
//			addProduct();
			cartWrapper.removeClass('empty');
		}



		function removeProduct(product) {
			clearInterval(undoTimeoutId);
			cartList.find('.deleted').remove();
			
			var topPosition = product.offset().top - cartBody.children('ul').offset().top ,
				productQuantity = Number(product.find('.quantity').find('select').val()),
				productTotPrice = Number(product.find('.price').text().replace('$', '')) * productQuantity;
			
			product.css('top', topPosition+'px').addClass('deleted');

			updateCartTotal(productTotPrice, false);
			undo.addClass('visible');

			undoTimeoutId = setTimeout(function(){
				undo.removeClass('visible');
				cartList.find('.deleted').remove();
			}, 8000);
		}


			$("#btn-chat").click(function(){
				if($("#btn-input").val()==""){
					return;
				}
				ws.send(JSON.stringify({
					img:"${sessionScope.user.member_photo_chat}",
					content : $("#btn-input").val(),
			        nickname : loginName,
			        Name : memName,
			        type : "all"
		   	    }));
				$("#btn-input").val("");
 			})
			$("#btn-input").keypress(function(event){
				if ( event.which == 13 || event.keyCode == 13 ){
					if($("#btn-input").val()==""){
						return;
					}
					ws.send(JSON.stringify({
						img:"${sessionScope.user.member_photo_chat}",
						content : $("#btn-input").val(),
				        nickname : loginName,
				        Name : memName,
				        type : "all"
			   	    }));
					$("#btn-input").val("");
				}
 			});
 			$('#searchID').on('keypress', function(event){
				if ( event.which == 13 || event.keyCode == 13 ) {
		     		cartList.find('.product').remove();
					var productAdded = $('<li class="product"><div class="product-details"><h3><a href="#0">無此會員</a></h3><div class="actions"></div></div></div></li>');
					cartList.prepend(productAdded);
					ws.send(JSON.stringify({
				        nickname : $("#searchID").val(),
				        type : "searchID"
				    })); 
				}
			});
		function connect(){
			ws= new WebSocket('ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/websocket/'+loginName);

			//var socket = new WebSocket('ws://http://localhost:8080/webSocket/websocket');
			ws.onopen=onopen;
//			ws.onerror=onerror;
			ws.onmessage=onmessage;
//			ws.onclose=onclose;
		}
		function onopen(){
			;
		}
		function onmessage(e){
			e = JSON.parse(e.data);
			if(e.type=="all"){

				if(e.nickname==loginName){
					$("#chatext").append('<div class="row msg_container base_sent">'
                    +'<div class="col-md-10 col-xs-10 ">'
                    +'<div class="messages msg_sent">'
                    +'<p>'+e.content+'</p>'
                    +'</div>'
                    +'</div>'
                    +'<div class="col-md-2 col-xs-2 avatar">'
                    +'</div>'
                    +'</div>');
				}else{
					var himg = e.img;
					if(himg==""){
						himg="product-preview";
					}
					$("#chatext").append('<div class="row msg_container base_receive">'
					  +'<div class="col-md-2 col-xs-2 avatar">'
                      +'<img src="img/'+himg+'.png" class=" img-responsive ">'
					  +'</div>'
					  +'<div class="col-md-10 col-xs-10">'
					  +'<div class="messages msg_receive">'
					  +'<p>'+e.content+'</p>'
					  +'<time datetime="2009-11-13T20:00">'+e.Name+'<a style="color:#46A3FF;float:right" onclick="addfriend(\''+e.nickname+'\',\'chat\')">加好友</a><span style="float:right">&nbsp &nbsp</span><a style="color:#46A3FF;float:right" onclick="openbox(\''+e.nickname+'\',\''+e.Name+'\',\'chat\')">私訊</a></time>'
					  +'</div></div></div>');
				}

				$("#chatext").scrollTop($("#chatext")[0].scrollHeight);
			}else if(e.type=="private"){

			        chatboxManager.addBox(e.name, 
			                {dest:"dest", // not used in demo
			                 title:e.name,
			                 first_name:e.name,
			                 last_name:""
			                 //you can add your own options too
			                });
			        $("#"+e.name).chatbox("option", "boxManager").addMsg(e.name, e.content);

			}else if(e.type=="searchID"){

				cartList.find('.product').remove();
				var himg ="";
				if(e.himg==""){
					himg="product-preview";
				}

				if(friendArray.length>0){
					
					for(var i = 0; i < friendArray.length; i++){
		  				
		  				var Name = friendArray[i][0];
		  				var Account = friendArray[i][1];
	 	 				var status = friendArray[i][2];;
		  				var himg = friendArray[i][3];
						if(Name==e.nickname){
							var productAdded = $('<li class="product"><div class="product-image"><a href="#0"><img src="img/'+e.himg+'.png" alt="placeholder"></a></div><div class="product-details"><h3><a href="#0">'+e.nickname+'</a></h3><span class=&nbsp;</span><div class="actions"><a href="#0" class="delete-item" onclick="delfriend(\''+e.name+'\');">刪除</a><div class="quantity"><a href="#0" class="privateTalk" onclick="openbox(\''+e.name+'\',\''+e.nickname+'\',\'friend\');">私訊</a></label></div></div></div></li>');
							cartList.prepend(productAdded);
							return;							
						}
	 				}				
// 					<c:forEach var="selectfriend"  items="${sessionScope.selectfriend }">
// 						var account = "${selectfriend.buddy_no.name}";
// 						alert(account+"==="+e.nickname);
// 						if(account==e.nickname){
// 							var productAdded = $('<li class="product"><div class="product-image"><a href="#0"><img src="img/'+e.himg+'.png" alt="placeholder"></a></div><div class="product-details"><h3><a href="#0">'+e.nickname+'</a></h3><span class=&nbsp;</span><div class="actions"><a href="#0" class="delete-item" onclick="delfriend(\''+e.name+'\');">刪除</a><div class="quantity"><a href="#0" class="privateTalk" onclick="openbox(\''+e.name+'\',\''+e.nickname+'\',\'friend\');">私訊</a></label></div></div></div></li>');
// 							cartList.prepend(productAdded);
// 							return;
// 						}
// 					</c:forEach>
				}
				var productAdded = $('<li class="product"><div class="product-image"><a href="#0"><img src="img/'+e.himg+'.png" alt="placeholder"></a></div><div class="product-details"><h3><a href="#0">'+e.nickname+'</a></h3><span class=&nbsp;</span><div class="actions"><a href="#0" onclick="addfriend(\''+e.name+'\')">新增好友</a><div class="quantity"></div></div></div></li>');
				cartList.prepend(productAdded);				
			}else if(e.type=="addfriend"){

				$("#chatext").append('<div class="row msg_container base_sent" >'
						  +'<div class="col-md-10 col-xs-10" style="width: 100%">'
						  +'<div class="messages msg_sent" >'
						  +'<p style="color:#FF3030">系統提示:收到好友邀請</p>'
						  +'</div></div></div>');				
			}else if(e.type=="nums"){
				$("#onlinecount").text(e.num);
			}
		}
		window.onbeforeunload = function(){
		    ws.close();
		}
		$(function(){
			connect();
		});




		    var box = null;
		    var counter = 0;
		    var idList = new Array();

		// 私訊發話

		    var broadcastMessageCallback = function(from, msg) {
		            $("#" + from).chatbox("option", "boxManager").addMsg(memName, msg);
		    		ws.send(JSON.stringify({
		    	        content : msg,
		    	        nickname : loginName,
		    	        name : memName,
		    	        to : from,
		    	        type : "private"
		    	    }));
		    }
		    chatboxManager.init({messageSent : broadcastMessageCallback});
		//開啟密語		    
	    function openbox(boxaccount,boxname,type){
	    	
	        chatboxManager.addBox(boxname, 
	                                {dest:"dest", // not used in demo
	                                 title:boxname,
	                                 first_name:boxname,
	                                 last_name:""
	                                 //you can add your own options too
	                                });
			if(type!="chat")
		        toggleCart();
	        event.preventDefault();
	    }
	    function addfriend(account,chat){
    		ws.send(JSON.stringify({
    	        nickname : loginName,
    	        to : account,
    	        type : "addfriend"
    	    }));
    		if(chat!="chat"){
    			toggleCart();
    		}
			$("#chatext").append('<div class="row msg_container base_sent" >'
					  +'<div class="col-md-10 col-xs-10" style="width: 100%">'
					  +'<div class="messages msg_sent" >'
					  +'<p style="color:#FF3030">系統提示:好友邀請已送出</p>'
					  +'</div></div></div>');
    		event.preventDefault();
	    }
	    function delfriend(account){
    		ws.send(JSON.stringify({
    	        nickname : loginName,
    	        to : account,
    	        type : "delfriend"
    	    }));
    		event.preventDefault();
	    }
	    function delinvite(account){
    		ws.send(JSON.stringify({
    	        nickname : loginName,
    	        to : account,
    	        type : "delinvite"
    	    }));
    		event.preventDefault();
	    }
	    function accpetinvite(account){
    		ws.send(JSON.stringify({
    	        nickname : loginName,
    	        to : account,
    	        type : "accpetinvite"
    	    }));
    		toggleCart();
	        event.preventDefault();
	    }
  </script>
 
  <script 
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA-Inouuyem3ufRkt0dseRmzUCHtqyhgds&callback=initMap">
    </script>
</body>
</html>