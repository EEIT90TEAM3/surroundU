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

import model.AccuseService;
import model.BackendService;

@Controller
@RequestMapping(path={"/dealaccuse.controller"},
		method={RequestMethod.GET, RequestMethod.POST})
public class DealAccuseController {
    
	@Autowired
	private AccuseService accuseService;
	@Autowired
	private BackendService backendService;
	
	
	@RequestMapping
	public String service(  @RequestParam(name="accuseyesorno") String accuse_status,
			                @RequestParam(name="accuse_no") String accuse_no,
						    @RequestParam(name="accuse_deal_memo") String accuse_deal_memo,
			               Model model, HttpSession session)

	{      		    
		    System.out.println("accuse_status:"+accuse_status);
		    System.out.println("accuse_no:"+accuse_no);
		    System.out.println("accuse_deal_memo:"+accuse_deal_memo);
		    
		    //驗證資料
		   
			Map<String, String> errors = new HashMap<String, String>();
			model.addAttribute("errors", errors);
		    
			
			if (accuse_deal_memo!=null) {
				if (accuse_deal_memo == null || accuse_deal_memo.length() == 0) {
					errors.put("accuse_deal_memo", "備註必須輸入");
				} 
				if (accuse_deal_memo.length() > 250) {
					errors.put("accuse_deal_memo", "輸入字元不可超逾250字");
				} 
			}
			
			if(accuse_status.isEmpty()){
				   errors.put("accuse_status", "請選擇處理結果");
				
			}
			
			
			if(errors!=null && !errors.isEmpty()) {
				
				return "dealaccuse.error";
			}
			
	        //轉換資料
			int caccuse_status = 0;  // accuse_status轉為int
			try {
				caccuse_status = Integer.parseInt(accuse_status);
				
	//			System.out.println("cmemberno:"+accuse_status);
			} catch (Exception e) {
				System.out.println("memberno轉換錯誤");
				e.printStackTrace();
			}
			
			int caccuse_no = 0;    // caccuse_no轉為int
			
			try {
				caccuse_no = Integer.parseInt(accuse_no);
	//			System.out.println("csaleno:" + accuse_no);
			} catch (Exception e) {
					System.out.println("saleno轉換錯誤");
					e.printStackTrace();
			} 
		
	 //呼叫Model
		    Boolean rs = backendService.dealAccuse(caccuse_no, caccuse_status, accuse_deal_memo);
			
	 //依據Model傳回結果,顯示view  
		 
		   
		
		return "backendlogin.success";
	}
}
