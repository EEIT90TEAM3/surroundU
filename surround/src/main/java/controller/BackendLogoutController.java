package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path={"/backendlogout.controller"},
		method={RequestMethod.GET, RequestMethod.POST})
public class BackendLogoutController {
    
	 @RequestMapping
		public String service(
					Model model, HttpSession session) {
		 
		 if(session!=null){
			 session.removeAttribute("manager");
		 }
		 
		 
		 
		 return "logout.display";
	 }
	
}
