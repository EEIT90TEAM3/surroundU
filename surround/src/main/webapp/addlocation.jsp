<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加入標示位置</title>
 <style type="text/css">
      html, body { height: 100%; margin: 0; padding: 0; } 
      #map { height: 80%; }
 </style>
 <style>
	.main-nav {
	  background: #3092c0;
	  background-image: -webkit-gradient(linear, to bottom, to top, color-stop(0%, #3298c8), color-stop(100%, #2e8cb8));
	  background-image: -webkit-linear-gradient(to bottom, #3298c8, #2e8cb8);
	  background-image: -moz-linear-gradient(to bottom, #3298c8, #2e8cb8);
	  background-image: -o-linear-gradient(to bottom, #3298c8, #2e8cb8);
	  background-image: linear-gradient(to bottom, #3298c8, #2e8cb8);
	  -webkit-border-radius: 8px;
	  -moz-border-radius: 8px;
	  -ms-border-radius: 8px;
	  -o-border-radius: 8px;
	  border-radius: 8px;
	  -webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
	  -moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
	  box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
	}
	
	.main-nav:after {
	  clear: both;
	  content: "\00a0";
	  display: block;
	  height: 0;
	  font: 0px/0 serif;
	  overflow: hidden;
	}
	
	.nav-brand {
	  float: left;
	  margin: 0;
	}
	
	.nav-brand a {
	  display: block;
	  padding: 10px 10px 10px 20px;
	  color: #fff;
	  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
	  font-size: 22px;
	  font-weight: normal;
	  line-height: 29px;
	  text-decoration: none;
	}
	
	#main-menu {
	  clear: both;
	  -webkit-box-shadow: none;
	  -moz-box-shadow: none;
	  box-shadow: none;
	}
	
	@media (min-width: 768px) {
	  #main-menu {
	    float: right;
	    clear: none;
	  }
	}
	
	
	/* Mobile menu top separator */
	
	#main-menu:before {
	  content: '';
	  display: block;
	  height: 1px;
	  font: 1px/1px sans-serif;
	  overflow: hidden;
	  background: #2e8cb8;
	}
	
	@media (min-width: 768px) {
	  #main-menu:before {
	    display: none;
	  }
	}
	
	
	/* Mobile menu toggle button */
	
	.main-menu-btn {
	  float: right;
	  margin: 10px;
	  position: relative;
	  display: inline-block;
	  width: 29px;
	  height: 29px;
	  text-indent: 29px;
	  white-space: nowrap;
	  overflow: hidden;
	  cursor: pointer;
	  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
	}
	
	
	/* hamburger icon */
	
	.main-menu-btn-icon,
	.main-menu-btn-icon:before,
	.main-menu-btn-icon:after {
	  position: absolute;
	  top: 50%;
	  left: 2px;
	  height: 2px;
	  width: 24px;
	  background: #fff;
	  -webkit-transition: all 0.25s;
	  transition: all 0.25s;
	}
	
	.main-menu-btn-icon:before {
	  content: '';
	  top: -7px;
	  left: 0;
	}
	
	.main-menu-btn-icon:after {
	  content: '';
	  top: 7px;
	  left: 0;
	}
	
	
	/* x icon */
	
	#main-menu-state:checked ~ .main-menu-btn .main-menu-btn-icon {
	  height: 0;
	  background: transparent;
	}
	
	#main-menu-state:checked ~ .main-menu-btn .main-menu-btn-icon:before {
	  top: 0;
	  -webkit-transform: rotate(-45deg);
	  transform: rotate(-45deg);
	}
	
	#main-menu-state:checked ~ .main-menu-btn .main-menu-btn-icon:after {
	  top: 0;
	  -webkit-transform: rotate(45deg);
	  transform: rotate(45deg);
	}
	
	
	/* hide menu state checkbox (keep it visible to screen readers) */
	
	#main-menu-state {
	  position: absolute;
	  width: 1px;
	  height: 1px;
	  margin: -1px;
	  border: 0;
	  padding: 0;
	  overflow: hidden;
	  clip: rect(1px, 1px, 1px, 1px);
	}
	
	
	/* hide the menu in mobile view */
	
	#main-menu-state:not(:checked) ~ #main-menu {
	  display: none;
	}
	
	#main-menu-state:checked ~ #main-menu {
	  display: block;
	}
	
	@media (min-width: 768px) {
	  /* hide the button in desktop view */
	  .main-menu-btn {
	    position: absolute;
	    top: -99999px;
	  }
	  /* always show the menu in desktop view */
	  #main-menu-state:not(:checked) ~ #main-menu {
	    display: block;
	  }
	}
	
	
	/* IGNORE: Unrelated generic demo styles */
	
	body {
	  margin: 8px;
	  background: #fff;
	  color: #aaa;
	  font: 16px/1.5em 'Helvetica Neue', Helvetica, Arial, sans-serif;
	}
	
	.demo-text {
	  margin: 3em 22px;
	}
	
	.demo-text p {
	  margin-bottom: 1em;
	}
	
	.demo-text a {
	  color: #999;
	}
 </style>

</head>


<body>
		   <nav class="main-nav" role="navigation">
		
		  <!-- Mobile menu toggle button (hamburger/x icon) -->
		  <input id="main-menu-state" type="checkbox" />
		  <label class="main-menu-btn" for="main-menu-state">
		    <span class="main-menu-btn-icon"></span> Toggle main menu visibility
		  </label>
		
		  <h2 class="nav-brand"><a href="#">Brand</a></h2>
		
		  <!-- Sample menu definition -->
		  <ul id="main-menu" class="sm sm-blue">
		    <li><a href="http://www.smartmenus.org/">Home</a></li>
		    <li><a href="http://www.smartmenus.org/about/">About</a>
		      <ul>
		        <li><a href="http://www.smartmenus.org/about/introduction-to-smartmenus-jquery/">Introduction to SmartMenus jQuery</a></li>
		        <li><a href="http://www.smartmenus.org/about/themes/">Demos + themes</a></li>
		        <li><a href="http://vadikom.com/about/#vasil-dinkov">The author</a></li>
		        <li><a href="http://www.smartmenus.org/about/vadikom/">The company</a>
		          <ul>
		            <li><a href="http://vadikom.com/about/">About Vadikom</a></li>
		            <li><a href="http://vadikom.com/projects/">Projects</a></li>
		            <li><a href="http://vadikom.com/services/">Services</a></li>
		            <li><a href="http://www.smartmenus.org/about/vadikom/privacy-policy/">Privacy policy</a></li>
		          </ul>
		        </li>
		      </ul>
		    </li>
		    <li><a href="http://www.smartmenus.org/download/">Download</a></li>
		    <li><a href="http://www.smartmenus.org/support/">Support</a>
		      <ul>
		        <li><a href="http://www.smartmenus.org/support/premium-support/">Premium support</a></li>
		        <li><a href="http://www.smartmenus.org/support/forums/">Forums</a></li>
		      </ul>
		    </li>
		    <li><a href="http://www.smartmenus.org/docs/">Docs</a></li>
		    <li><a href="#">Sub test</a>
		      <ul>
		        <li><a href="#">Dummy item</a></li>
		        <li><a href="#">Dummy item</a></li>
		        <li><a href="#" class="disabled">Disabled menu item</a></li>
		        <li><a href="#">Dummy item</a></li>
		        <li><a href="#">more...</a>
		          <ul>
		            <li><a href="#">A pretty long text to test the default subMenusMaxWidth:20em setting for the sub menus</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">more...</a>
		              <ul>
		                <li><a href="#">Dummy item</a></li>
		                <li><a href="#" class="current">A 'current' class item</a></li>
		                <li><a href="#">Dummy item</a></li>
		                <li><a href="#">more...</a>
		                  <ul>
		                    <li><a href="#">subMenusMinWidth</a></li>
		                    <li><a href="#">10em</a></li>
		                    <li><a href="#">forced.</a></li>
		                  </ul>
		                </li>
		                <li><a href="#">Dummy item</a></li>
		                <li><a href="#">Dummy item</a></li>
		              </ul>
		            </li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">A pretty long text to test the default subMenusMaxWidth:20em setting for the sub menus</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">A pretty long text to test the default subMenusMaxWidth:20em setting for the sub menus</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">A pretty long text to test the default subMenusMaxWidth:20em setting for the sub menus</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">A pretty long text to test the default subMenusMaxWidth:20em setting for the sub menus</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">A pretty long text to test the default subMenusMaxWidth:20em setting for the sub menus</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		            <li><a href="#">Dummy item</a></li>
		          </ul>
		        </li>
		      </ul>
		    </li>
		    <li><a href="http://www.smartmenus.org/contact/">Contact</a></li>
		  </ul>
		</nav>
		
		<div class="demo-text">
		  <p>Demonstrates a complete navbar including a mobile view menu toggle button (<a href="http://www.smartmenus.org/docs/#menu-toggle-button">related docs</a>).</p>
		</div>
		
		<script type="text/javascript">
		// SmartMenus init
		$(function() {
			  $('#main-menu').smartmenus({
			    subMenusSubOffsetX: 1,
			    subMenusSubOffsetY: -8
			  });
			});

			// SmartMenus mobile menu toggle button
			$(function() {
			  var $mainMenuState = $('#main-menu-state');
			  if ($mainMenuState.length) {
			    // animate mobile menu
			    $mainMenuState.change(function(e) {
			      var $menu = $('#main-menu');
			      if (this.checked) {
			        $menu.hide().slideDown(250, function() { $menu.css('display', ''); });
			      } else {
			        $menu.show().slideUp(250, function() { $menu.css('display', ''); });
			      }
			    });
			    // hide mobile menu beforeunload
			    $(window).bind('beforeunload unload', function() {
			      if ($mainMenuState[0].checked) {
			        $mainMenuState[0].click();
			      }
			    });
			  }
			});
			</script>
   <!-- google map -->
    <div id="map"></div>
    <script>
      function initMap() {
        var myLatLng = {lat: 25.033, lng: 121.543};
    	  
    	  
        var map = new google.maps.Map(document.getElementById('map'), {
          center: myLatLng,
          scrollwheel: false,
          zoom: 15
        });
        var image = 'images/location_icon.png';
        var marker = new google.maps.Marker({
            position: {lat: 25.033765, lng: 121.543400},
            map: map,
            title: '資策會',
            icon: image
          });
      }

    </script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKiN8uhTaEWQbe-8MVHbzpEEn0KO0-HGI&callback=initMap"></script>
 
  <select name="city">
	  <option value="taipei">台北市</option>
	  <option value="newtaipei">新北市</option>
  </select>
  <select name="district">
	  <option value="zhongshan">中山區</option>
	  <option value="daan">大安區</option>
  </select>
  <button type="submit">確定</button>
    
</body>
</html>

