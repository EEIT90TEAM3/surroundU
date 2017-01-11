<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SurrounYou</title>
<script src="src/jquery180.js" type="text/javascript"></script>
 <link href="${root}boot/bootstrap.min.css" rel="stylesheet">
 <style>
  body {
 
}
.full {
  position: relative;
}
.log {
    float: left;
   position: absolute;
   left: 420px;
   top: 200px;
   z-index: 1000;
   padding: 5px;
   margin: auto;
    border: 1px solid #f2e3d2;
   background: #ffffff;
   background: -webkit-gradient(linear, left top, left bottom, from(#ffffff), to(#ffffff));
   background: -webkit-linear-gradient(top, #ffffff, #ffffff);
   background: -moz-linear-gradient(top, #ffffff, #ffffff);
   background: -ms-linear-gradient(top, #ffffff, #ffffff);
   background: -o-linear-gradient(top, #ffffff, #ffffff);
   background-image: -ms-linear-gradient(top, #ffffff 0%, #ffffff 100%);
   -webkit-border-radius: 8px;
   -moz-border-radius: 8px;
   border-radius: 8px;
   -webkit-box-shadow: rgba(000,000,000,0.9) 0 1px 2px, inset rgba(255,255,255,0.4) 0 0px 0;
   -moz-box-shadow: rgba(000,000,000,0.9) 0 1px 2px, inset rgba(255,255,255,0.4) 0 0px 0;
   box-shadow: rgba(000,000,000,0.9) 0 1px 2px, inset rgba(255,255,255,0.4) 0 0px 0;
   font-family: 'Helvetica Neue',Helvetica,sans-serif;
   text-decoration: none;
   vertical-align: middle;
   min-width:300px;
   padding:20px;
   width:300px;
}
<<<<<<< HEAD
.lower-block span{font-size:16px;}
.lower-block span{margin-left:5px}
.form-signin2{
	display:none;
}
.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 1000;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
  
   </style>
<style>
/* 影片css */
.homepage-hero-module {
    border-right: none;
    border-left: none;
    position: relative;
    
}
.no-video .video-container video,
.touch .video-container video {
    display: none;
}
.no-video .video-container .poster,
.touch .video-container .poster {
    display: block !important;
}
.video-container {
    position: relative;
    bottom: 0%;
    left: 0%;
    height: 100%;
    width: 100%;
    overflow: hidden;
    background: #000;
}
.video-container .poster img {
    width: 100%;
    bottom: 0;
    position: absolute;
}
.video-container .filter {
    z-index: 100;
    position: absolute;
    background: rgba(0, 0, 0, 0.4);
    width: 100%;
}
.video-container video {
    position: absolute;
    z-index: 0;
    bottom: 0;
}
.video-container video.fillWidth {
    width: 100%;
}
</style>
</head>
<body>

 <div class="full">

 	
	 	<div class="log">
	 	 <div> 
 	<%
    String fbURL = "https://www.facebook.com/v2.8/dialog/oauth?client_id=275346536213447&redirect_uri=http://localhost:8080/surround/secure/fblogin.controller&scope=email";
%>
 	<a href="<%= fbURL %>"><img src="img/fb.png" onmouseout="this.src='img/fb.png'" onmouseover="this.src='img/fbshow.png'" border="0"  width="260" /></a>
 	</div>
	 	
	      <form class="form-signin1" action="<c:url value="/secure/login.controller" />">
	        <h2 class="form-signin-heading" align="center">帳號登入</h2>
	        <label for="inputEmail" class="sr-only">Email address</label>
	        <input type="text" id="inputEmail" name="account" value="${param.account}" class="form-control" placeholder="帳號" required autofocus>
	        ${errors.account}
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input type="password" id="inputPassword" name="pwd" value="${param.pwd}" class="form-control" placeholder="密碼" required>
	        ${errors.pwd}
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" value="remember-me"> Remember me
	          </label>
	        </div>
	        <button class="btn btn-lg btn-primary btn-block" type="submit" name="prodaction" value="log">登入</button>
	        <div class="lower-block">還不是會員嗎？<span id="signup1"><a href="#";">立刻註冊新帳號</a></span></div>
	      </form>
	      
	      <form class="form-signin2"  action="<c:url value="" />">
	        <h2 class="form-signin-heading" align="center">註冊個人帳號</h2>
	        <label for="inputEmail" class="sr-only">Email address</label>
	        <input type="text" id="inputEmail" name="account" value="${param.account}" class="form-control" placeholder="帳號" required autofocus>
	        ${errors.account}
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input type="password" id="inputPassword" name="pwd" value="${param.pwd}" class="form-control" placeholder="密碼" required>
	        ${errors.pwd}
	         <label for="inputPassword" class="sr-only">Password</label>
	        <input type="email" id="account_email" name="account_email" value="${param.account_email}" class="form-control" placeholder="Email" required>
	     	 
	          <div style="font-size:11px;margin-top:10px;margin-bottom:10px;"> 按下註冊鈕的同時，表示您已詳閱我們的<a href="#";">資料使用政策與使用條款</a>，同意使用 Srround You所提供的服務。</div>
	          
	        <button class="btn btn-lg btn-primary btn-block" type="" name="prodaction" value="nolog">註冊</button>
	        <div class="lower-block">已經有帳號了？<span id="signup2"><a href="#">馬上登入</a></span></div>
	      </form>
	   </div>
		<div class="homepage-hero-module">
		    <div class="video-container">
		        <div class="filter"></div>
		        <video autoplay loop class="fillWidth">
		          <source src="car/MP4/Retro-Volks.mp4" type="video/mp4" />
			       <source src="car/WEBM/Retro-Volks.webm" type="video/webm" />
		        </video>
		        <div class="poster hidden">
		            
		        </div>
		    </div>
		</div>
</div>
</body>
<script>
//影片js
$( document ).ready(function() {
    scaleVideoContainer();
    initBannerVideoSize('.video-container .poster img');
    initBannerVideoSize('.video-container .filter');
    initBannerVideoSize('.video-container video');
    $(window).on('resize', function() {
        scaleVideoContainer();
        scaleBannerVideoSize('.video-container .poster img');
        scaleBannerVideoSize('.video-container .filter');
        scaleBannerVideoSize('.video-container video');
    });
});
function scaleVideoContainer() {
    var height = $(window).height() + 5;
    var unitHeight = parseInt(height) + 'px';
    $('.homepage-hero-module').css('height',unitHeight);
}
function initBannerVideoSize(element){
    $(element).each(function(){
        $(this).data('height', $(this).height());
        $(this).data('width', $(this).width());
    });
    scaleBannerVideoSize(element);
}
function scaleBannerVideoSize(element){
    var windowWidth = $(window).width(),
    windowHeight = $(window).height() + 5,
    videoWidth,
    videoHeight;
    console.log(windowHeight);
    $(element).each(function(){
        var videoAspectRatio = $(this).data('height')/$(this).data('width');
        $(this).width(windowWidth);
        if(windowWidth < 1000){
            videoHeight = windowHeight;
            videoWidth = videoHeight / videoAspectRatio;
            $(this).css({'margin-top' : 0, 'margin-left' : -(videoWidth - windowWidth) / 2 + 'px'});
            $(this).width(videoWidth).height(videoHeight);
        }
        $('.homepage-hero-module .video-container video').addClass('fadeIn animated');

    });
}
$('#signup1').click(function(){
	$('.form-signin1').hide();
	$('.form-signin2').show();
})
$('#signup2').click(function(){
	$('.form-signin2').hide();
	$('.form-signin1').show();
})
//影片js end
</script>
</html>