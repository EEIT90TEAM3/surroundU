package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path={"/logout.controller"},
method={RequestMethod.GET, RequestMethod.POST})
public class LogoutController {

	@RequestMapping
	public String service(
						Model model, HttpSession session) {
			 
				if(session!=null){
					 session.removeAttribute("user");
				
					 return "logout.display";
				 
				 
				 }
			 
			    return null;
			}
			 
		
	
}
