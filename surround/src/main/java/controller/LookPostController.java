package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path={"/lookPost.controller"},
		method={RequestMethod.GET, RequestMethod.POST})
public class LookPostController {

	
	@RequestMapping
	public String service(@RequestParam(name="accuse_no") String accuse_no,
			  Model model, HttpSession session)
	{
		
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
	    
		
		

	    //驗證資料 
		if (accuse_no!=null) {
            return null;
		}
		
		//轉換資料
		
		int caccuseno = 0;
		try {
			caccuseno = Integer.parseInt(accuse_no);
			
		//	System.out.println("cmemberno:"+accuse_no);
		} catch (Exception e) {
			System.out.println("accuse_no轉換錯誤");
			e.printStackTrace();
		}
		
		
		//呼叫Model
	    
		
		
		
		
		return null;
	}

	
}
