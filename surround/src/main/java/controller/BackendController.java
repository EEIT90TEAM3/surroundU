package controller;

import java.util.HashMap;
import java.util.List;
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
import model.BackendService;
import model.MemberBean;
import model.ReportBean;
import model.ReportService;

@Controller
@RequestMapping
public class BackendController {
	@Autowired
	@Resource(name = "accuseService")
	private AccuseService accuseService;
	@Autowired
	private AccuseBean accuseBean;
	@Autowired
	private ReportService reportService;
	@Autowired
	private ReportBean reportBean;
	@Autowired
	private BackendService backendService;
	
	
	@RequestMapping(path={"/backend.controller"},
			method={RequestMethod.GET, RequestMethod.POST})
	public String service( @RequestParam(name="backendaction") String backendaction,
			               Model model, HttpSession session)
	{   
		//驗證資料
		
		//轉換資料
	    
		//呼叫model
		//根據model傳回的值,顯示view
		if(backendaction!=null){
			if("檢舉列表-全部".equals(backendaction)){   //如果是按"檢舉列表-全部"的submit
				List<AccuseBean> rs = backendService.selectAllAccuse();
			   System.out.println(rs);
//				System.out.println(rs);
//				List<AccuseBean> beanlist;
				
//				for(AccuseBean bean: rs){
//					bean.setMember_no(bean.getMember_no().getMember_no());
//					System.out.println(bean);
//					beanlist.add(bean);
//				}
//		
				
				
				model.addAttribute("selectaccuse", rs);
			    
			    return "accuse.display";
			}
			if("檢舉列表-未處理".equals(backendaction)){  //如果是按"檢舉列表-未處理"的submit
				List<AccuseBean> rs = backendService.selectNotProcessAccuse();
				
				model.addAttribute("selectaccuse", rs);
				
				return "accuse.display";
			}
			
			if("檢舉列表-已處理".equals(backendaction)){  //如果是按"檢舉列表-已處理"的submit
				List<AccuseBean> rs = backendService.selectProcessedAccuse();
				
				model.addAttribute("selectaccuse", rs);
				
				return "accuse.display";
			}
			
			if("會員列表-全部".equals(backendaction)){   //如果是按"會員列表"的submit
				
				List<MemberBean> rs = backendService.selectMember();
				
				model.addAttribute("selectmember",rs);
				
				
				return "member.display";
			}
			
		    if("會員列表-管理者".equals(backendaction)){   //如果是按"會員列表"的submit
				
				List<MemberBean> rs = backendService.selectManager();
				
				model.addAttribute("selectmember",rs);
				
				
				return "member.display";
			}
		    

		    if("會員列表-停權會員".equals(backendaction)){   //如果是按"會員列表"的submit
				
				List<MemberBean> rs = backendService.selectAccusedMember();

				
				model.addAttribute("selectmember",rs);
				
				
				return "member.display";
			}
			
			if("會員建議及回報列表-全部".equals(backendaction)){  //如果是按"會員建議及回報列表"的submit
			
				List<ReportBean> rs = backendService.selectAllReport();
				
				
				model.addAttribute("selectreport", rs);
				
				return "report.display";
			}
			
			if("會員建議及回報列表-未處理".equals(backendaction)){  //如果是按"會員建議及回報列表"的submit
				
				List<ReportBean> rs = backendService.selectNotProcessReport();
				
				
				model.addAttribute("selectreport", rs);
				
				return "report.display";
			}
			
			if("會員建議及回報列表-已處理".equals(backendaction)){  //如果是按"會員建議及回報列表"的submit
				
				List<ReportBean> rs = backendService.selectProcessedReport();
				
				
				model.addAttribute("selectreport", rs);
				
				return "report.display";
			}
			
//            if("更改管理者密碼".equals(backendaction)){  //如果是按"更改管理者密碼"的submit
//				
//				
//            	MemberBean bean = (MemberBean)session.getAttribute("user");
//            	
//            	System.out.println(bean);
//            	
//            	Boolean rs = backendService.changeManagerPwd();
//				
//				
//				model.addAttribute("selectreport", rs);
//				
//				return "report.display";
//			}
			
			
		}
		
		
		
		return null;
	}
	
	
	@RequestMapping(path={"/backendchangepwd.controller"},
			method={RequestMethod.GET, RequestMethod.POST})
	public String changpwd( 
			@RequestParam(name="oldpwd") String oldpwd,
			@RequestParam(name="newpwd1") String newpwd1,
		    @RequestParam(name="newpwd2") String newpwd2,
		    @RequestParam(name="backendaction") String backendaction,
			               Model model, HttpSession session)
	{   
		
		//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		
	
		
		
		MemberBean bean= (MemberBean)session.getAttribute("user");
		
		String pwd  = bean.getPwd();
		
		System.out.println("session.pwd:"+pwd);
		System.out.println("oldpwd:"+oldpwd);
		System.out.println("newpwd1:"+newpwd1);
		System.out.println("newpwd2:"+newpwd2);
		
		

		
		if(!pwd.equals(oldpwd)||oldpwd.length()==0||oldpwd==null){  
			System.out.println("舊密碼驗證");
			errors.put("pwd", "輸入之密碼錯誤,請重新輸入");		
			
		}	    
		if(newpwd1==null||newpwd1.length()==0){
			errors.put("pwd1", "請輸入新密碼");	
		}
		if(newpwd2==null||newpwd2.length()==0){
			errors.put("pwd2", "請重複新密碼");	
		}
		
		if(!newpwd2.equals(newpwd1)){
			System.out.println("新密碼驗證");
			errors.put("pwdnotequal", "輸入之新密碼兩次需相同,請重新輸入");		
			
		}		
		if(!errors.isEmpty()){
			return "backendpwdchange.error";
		}
		
		System.out.println("changepwd");
		
		
		backendService.changeManagerPwd(bean, newpwd1);
		
		
		return "backendlogin.success";
		
	}
	

}
