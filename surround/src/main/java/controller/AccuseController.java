package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.AccuseBean;
import model.AccuseService;
import model.MemberBean;

@Controller
@RequestMapping(path={"/accuse.controller"},
		method={RequestMethod.GET, RequestMethod.POST})
public class AccuseController {
    @Autowired
    @Resource(name = "accuseService")
	private AccuseService accuseService;
    @Autowired
    private MemberBean memberBean;
//接收資料
	@RequestMapping
	public String service(@RequestParam(name="accusetype") String accusetype,
			              @RequestParam(name="accusetopic") String accusetopic,
			              @RequestParam(name="memberno") String memberno,
			              @RequestParam(name="saleno") String saleno,
			              @RequestParam(name="groupno") String groupno,
			               Model model, HttpSession session)
	{   
//	   System.out.println("accusetype:"+accusetype);
//	   System.out.println("accusetopic:"+accusetopic);
//	   System.out.println("memberno:"+memberno);
//	   System.out.println("saleno:"+saleno);
//	   System.out.println("groupno:"+groupno);
		
		
		
	//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
	    
		
		if (accusetype!=null) {
			if (accusetype == null || accusetype.length() == 0) {
				errors.put("accusetype", "原因必須輸入");
			} 
			if (accusetype.length() > 250) {
				errors.put("accusetype", "輸入字元不可超逾250字");
			} 
		}
		
		
		if(errors!=null && !errors.isEmpty()) {
			
			return "postaccuse.error";
		}
		
	//轉換資料
		int cmemberno = 0;
		try {
			cmemberno = Integer.parseInt(memberno);
			
			System.out.println("cmemberno:"+cmemberno);
		} catch (Exception e) {
			System.out.println("memberno轉換錯誤");
			e.printStackTrace();
		}
		
		int csaleno = 0;   
		if (!saleno.isEmpty()) {  //如果saleno不是空字串=為sale文章
			try {
				csaleno = Integer.parseInt(saleno);
				System.out.println("csaleno:" + csaleno);
			} catch (Exception e) {
				System.out.println("saleno轉換錯誤");
				e.printStackTrace();
			} 
		}else{
			csaleno = 0;
		}
		
		
		int cgroupno = 0;
		if (!groupno.isEmpty()) {
			try {
				cgroupno = Integer.parseInt(groupno);
				System.out.println("cgroupno:" + cgroupno);
			} catch (Exception e) {
				System.out.println("groupno轉換錯誤");
				e.printStackTrace();
			} 
		}else{
			cgroupno = 0;
		}
		//呼叫model
		memberBean.setMember_no(cmemberno);
//		System.out.println("memberBean:"+memberBean);
//		System.out.println("memberBean.getno:"+memberBean.getMember_no());
//	    System.out.println("Controller");
	    
	    
		Boolean result=  accuseService.postAccuse(memberBean, accusetype, accusetopic, new java.util.Date(), 
	           0, null, csaleno, cgroupno,null);
    //根據model傳回的值,顯示view
        if(result){
        	return "postaccuse.success";
        	
        }else{
        	
        	return "postaccuse.already";
        	
        }
			
	    
		
	

	
	}

	
}
