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

@Controller
@RequestMapping(path={"/dealreport.controller"},
		method={RequestMethod.GET, RequestMethod.POST})
public class DealReportController {
    @Autowired
	private BackendService backendService;
	
	@RequestMapping
	public String service(  
			                @RequestParam(name="reportyesorno") String report_status,
			                @RequestParam(name="report_no") String report_no,
						    @RequestParam(name="report_deal_memo") String report_deal_memo,
			               Model model, HttpSession session)

	{      
		 System.out.println("accuse_no:"+report_no);
		 System.out.println("accuse_deal_memo:"+report_deal_memo);
		 System.out.println("accuse_status:"+report_status);
		
		  //驗證資料
		   
			Map<String, String> errors = new HashMap<String, String>();
			model.addAttribute("errors", errors);
		    
			
			if (report_deal_memo!=null) {
				if (report_deal_memo == null || report_deal_memo.length() == 0) {
					errors.put("accusetype", "備註必須輸入");
				} 
				if (report_deal_memo.length() > 250) {
					errors.put("accusetype", "輸入字元不可超逾250字");
				} 
			}
			
			
			if(errors!=null && !errors.isEmpty()) {
				
				return "doaccuse.error";
			}
	       
	        //轉換資料
			int creport_status = 0;  // accuse_status轉為int
			try {
				creport_status = Integer.parseInt(report_status);
				
	//			System.out.println("cmemberno:"+accuse_status);
			} catch (Exception e) {
				System.out.println("memberno轉換錯誤");
				e.printStackTrace();
			}
			
			int creport_no = 0;    // caccuse_no轉為int
			
			try {
				creport_no = Integer.parseInt(report_no);
	//			System.out.println("csaleno:" + accuse_no);
			} catch (Exception e) {
					System.out.println("saleno轉換錯誤");
					e.printStackTrace();
			} 
			//呼叫Model
			Boolean rs = backendService.dealReport(creport_no, creport_status, report_deal_memo);
			
			//根據Model傳回值,顯示View
			if(rs){
				
				return "report.display";
			
			}
			
			return "";
		    
		   
		
		    
	}
}
