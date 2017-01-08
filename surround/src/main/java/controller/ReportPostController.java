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

import model.AccuseService;
import model.MemberBean;
import model.ReportService;

@Controller
@RequestMapping(path={"/reportpost.controller"},
		method={RequestMethod.GET, RequestMethod.POST})
public class ReportPostController {
    @Autowired
    @Resource(name = "reportService")
	private ReportService reportService;
    @Autowired
    private MemberBean memberBean;
	
	@RequestMapping
	public String service(
		    @RequestParam(name="reportmemo") String reportmemo,
             Model model, HttpSession session)
	{          
		        MemberBean memberBean = (MemberBean)session.getAttribute("user");
		        
		     
		        int member_no = memberBean.getMember_no();   //從session取得登入的會員資料
		        System.out.println("member_no"+member_no);
		//驗證資料
				Map<String, String> errors = new HashMap<String, String>();
				model.addAttribute("errors", errors);
			    
				if(reportmemo==null||reportmemo.length()==0){
					errors.put("reportmemo", "必須輸入您的建議");
			    }
				
				if(reportmemo.length()>250){
					errors.put("reportmemo", "輸入字元不可超逾250字");
			    }
				
				if(errors!=null && !errors.isEmpty()) {
					System.out.println("postreport.error");
					return "postreport.error";
				}
				
			//轉換資料
				
//				int cmemberno = 0;
//				try {
//					cmemberno = Integer.parseInt(memberno);
//					
//					System.out.println("cmemberno:"+cmemberno);
//				} catch (Exception e) {
//					System.out.println("memberno轉換錯誤");
//					e.printStackTrace();
//				}
//				
		    //呼叫model
	         memberBean.setMember_no(member_no);
	         
	         Boolean rs = reportService.postReport(memberBean, reportmemo, new java.util.Date(), 0,null);
		    //根據model傳回的值,顯示view
	         
	         System.out.println("boolean:"+rs);
	         if(rs){
	        	 return "postreport.success";
	         }
	        	 
	         return "postreport.exceed";
	         
	         
	         
	         
		
		
	}
}
