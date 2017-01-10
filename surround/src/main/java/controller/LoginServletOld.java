package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import model.MemberService;
import model.SaleBean;
import model.SaleService;
import model.TogetherBean;
import model.TogetherService;

@Controller
@RequestMapping(path={"/loginOld.controller"},
		method={RequestMethod.GET, RequestMethod.POST})
public class LoginServletOld{
	/**
	 * 
	 */

    @Autowired
	private MemberService memberService;
    @Autowired
    private SaleService saleService;
    @Autowired
    private TogetherService togetherService;
    

    @RequestMapping
	public String service(@RequestParam(name="account") String account,
				          @RequestParam(name="pwd") String pwd,
				Model model, HttpSession session) {
    	//接收資料

		
    	//驗證資料
    			Map<String, String> errors = new HashMap<String, String>();
    			model.addAttribute("errors", errors);

    			if(account==null || account.length()==0) {
    				errors.put("account", "ID is required");
    			}
    			if(pwd==null || pwd.length()==0) {
    				errors.put("pwd", "PWD is required");
    			}
    			
    			if(errors!=null && !errors.isEmpty()) {
    				
    				return "login.error";
    			}
    	//呼叫Model
    			MemberBean bean = memberService.login(account, pwd); //比對帳號密碼
    			
    			List<SaleBean> listSale = saleService.selectMap(); //取得擺攤資料
    			
    			List<TogetherBean> listTogether = togetherService.selectMap();   //取得約團資料
    			
    			
    	//根據Model的執行結果，顯示View
    			if(bean==null) {
    				errors.put("pwd", "Login fail, please try again.");
    				
    				return "login.error";
    			} else {
    				
    				session.setAttribute("user", bean);
    				session.setAttribute("selectsale", listSale);
    				session.setAttribute("selecttogether", listTogether);
    				System.out.println(listSale); 
    				System.out.println(listTogether);
    				
    				return "login.success";
    			}
    		
	}
	
}
