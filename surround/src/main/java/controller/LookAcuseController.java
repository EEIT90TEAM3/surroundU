package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.BackendService;
import model.SaleBean;
import model.TogetherBean;

@Controller
@RequestMapping(path={"/lookAccuse.controller"},
		method={RequestMethod.GET, RequestMethod.POST})
public class LookAcuseController {
    
	@Autowired
	BackendService backendService;
	
	@RequestMapping
	public String service(
			               @RequestParam(name="accuse_topic") String accuse_topic,
			               @RequestParam(name="accuse_no") String accuse_no,
			  Model model, HttpSession session)
	{
		
		
		System.out.println("accuse_no:"+accuse_no);
		System.out.println(accuse_topic);
		
		
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
	    
		
		

	    //驗證資料 
		
		//轉換資料
		
		int caccuseno = 0;
		try {
			caccuseno = Integer.parseInt(accuse_no);
			System.out.println("轉換資料");
		//	System.out.println("cmemberno:"+accuse_no);
		} catch (Exception e) {
			System.out.println("accuse_no轉換錯誤");
			e.printStackTrace();
		}
		
		
		//呼叫Model
	    if(!accuse_topic.isEmpty()){
	    	if("擺攤".equals(accuse_topic)){
	    	   
	    		System.out.println("呼叫擺攤Model");
	    		SaleBean bean = backendService.lookAccuseOfSale(caccuseno);
	    	    System.out.println(bean);
	    	   
	    	}
	    	
            if("約團".equals(accuse_topic)){
                System.out.println("呼叫約團Model");
            	TogetherBean bean = backendService.lookAccuseOfTogether(caccuseno);
            	System.out.println(bean);
	    	}
	    	
	    	
	    	
	    }
		
		
		
		
		return null;
	}

	
}
