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

import model.MemberBean;
import model.MemberService;

@Controller
@RequestMapping(
		path={"/secure/login.controller"},
		method={RequestMethod.GET, RequestMethod.POST}
)
public class LoginController {
	@Autowired
	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping
	public String service(
			@RequestParam(name="account") String account,
			@RequestParam(name="pwd") String pwd,
			Model model, HttpSession session) {
//接收資料
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		if(account==null || account.length()==0) {
			errors.put("account", "ID is required ");
		}
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd", "PWD is required ");
		}
		if(errors!=null && !errors.isEmpty()) {
			return "login.error";
		}	
		
//呼叫Model
		MemberBean bean = memberService.login(account, pwd);
		
//根據Model的執行結果，顯示View
		if(bean==null) {
			errors.put("password", "Login fail, please try again.");
			return "login.error";
		} else {
			session.setAttribute("user", bean);
			
			return "login.success";
		}
		
	}
}