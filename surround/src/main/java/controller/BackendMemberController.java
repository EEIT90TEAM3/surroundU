package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.AccuseBean;
import model.BackendService;
import model.MemberBean;

@Controller
@RequestMapping(path={"/backendMember.controller"},
		method={RequestMethod.GET, RequestMethod.POST})
public class BackendMemberController {
    
	@Autowired
	BackendService backendService;
	
	@RequestMapping
	public String service( 
			@RequestParam(name="member_no") String member_no,
			@RequestParam(name="account") String account,
			@RequestParam(name="backendaction") String backendaction,
			               Model model, HttpSession session)
	{ 
		        //驗證資料
		
				//轉換資料
					int cmemberno = 0;
					try {
						cmemberno = Integer.parseInt(member_no);
						
						System.out.println("cmemberno:"+cmemberno);
					} catch (Exception e) {
						System.out.println("memberno轉換錯誤");
						e.printStackTrace();
					}
				//呼叫model
					if("停權".equals(backendaction)){  //如果是按"停權"的submit
						
						MemberBean bean = backendService.switchAccountStatus(account, 1);
						
						if(bean!=null){
							return "member.display";
						}
						
					}
					
					if("解除停權".equals(backendaction)){   //如果是按"解除停權"的submit
						
						MemberBean bean = backendService.switchAccountStatus(account, 0);
						
						if(bean!=null){
							return "member.display";
						}
					}
					
				    if("給予管理員權限".equals(backendaction)){   //如果是按"給予管理員權限"的submit
						
	                    MemberBean bean = backendService.switchAccountStatus(account, 99);
						
						if(bean!=null){
							return "member.display";
						}
					}
				    
                    if("解除管理員權限".equals(backendaction)){   //如果是按"解除管理員權限"的submit
						
	                    MemberBean bean = backendService.switchAccountStatus(account, 0);
						
						if(bean!=null){
							return "member.display";
						}
					}
				 
				 
					
					
				//根據model傳回的值,顯示view
		
		
		
		return null;
	}
}
