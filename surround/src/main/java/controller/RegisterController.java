package controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import misc.CustomPrimitiveNumberEditor;
import model.MemberBean;
import model.MemberService;

@Controller
@RequestMapping(path = { "/pages/reg.controller" }, method = { RequestMethod.GET, RequestMethod.POST })
public class RegisterController {
	@Autowired
	private SimpleDateFormat sdFormat = null;
	@Autowired
	@Resource(name = "memberBean")
	private MemberBean bean;
	@InitBinder
	 public void init(WebDataBinder webDataBinder) {
	 webDataBinder.registerCustomEditor(int.class, new
	 CustomPrimitiveNumberEditor(java.lang.Integer.class, true));
	 webDataBinder.registerCustomEditor(double.class, new
	 CustomPrimitiveNumberEditor(java.lang.Double.class, true));
	 webDataBinder.registerCustomEditor(java.util.Date.class, new
	 CustomDateEditor(sdFormat, true));
	 }

	@Autowired
	@Resource(name = "memberService")
	private MemberService memberService;

	@RequestMapping
	public String service( String prodaction, String account, String pwd, String name, String nickname, String hobby,
			String account_email,Model model) {
		// 接收資料
		
		// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		if (account != null && account.length() != 0) {
			bean.setAccount(account);
			
		} else {
			errors.put("account", "帳號不能為空");
		}
		if (pwd != null && pwd.length() != 0) {
			bean.setPwd(pwd);
		} else {
			errors.put("pwd", "請輸入密碼");
		}
		if (name != null && name.length() != 0) {
			bean.setName(name);
		} else {
			errors.put("name", "請輸入姓名");
		}
		if (nickname != null && nickname.length() != 0) {
			bean.setNickname(nickname);
		} else {
			errors.put("nickname", "請輸入暱稱");
		}
		if (account_email != null && account_email.length() != 0) {
			bean.setAccount_email(account_email);
		} else {
			errors.put("account_email", "請輸入Email");
		}

		 //轉換資料
//		 if(bindingResult!=null) {
//		 if(bindingResult.getFieldError("account")!=null) {
//		 errors.put("account", "ID must be an integer");
//		 }
//		 if(bindingResult.getFieldError("pwd")!=null) {
//		 System.out.println(bindingResult.getFieldError("pwd"));
//		 errors.put("pwd", "Price must be a number");
//		 }
//		 if(bindingResult.getFieldError("nickname")!=null) {
//		 errors.put("nickname", "Make must be a date of YYYY-MM-DD");
//		 }
//		 if(bindingResult.getFieldError("email")!=null) {
//		 errors.put("email", "Expire must be an integer");
//		 }
//		 }
		
		 if(errors!=null && !errors.isEmpty()) {
		 return "reg.error";
		 }

		// 呼叫Model
		// 根據Model的執行結果，顯示View
		if ("選擇".equals(prodaction)) {
			List<MemberBean> result = memberService.select(bean);
			model.addAttribute("select", result);
			return "reg.select";
		} else if ("送出".equals(prodaction)) {

			MemberBean result = memberService.insert(bean);

			if (result == null) {

				errors.put("action", "Insert fail");
			} else {

				model.addAttribute("insert", result);

			}
			return "reg.error";
		} else if ("更新".equals(prodaction)) {
			MemberBean result = memberService.update(bean);
			if (result == null) {
				errors.put("action", "Update fail");
			} else {
				model.addAttribute("update", result);
			}
			return "reg.error";
		} else if ("刪除".equals(prodaction)) {
			boolean result = memberService.delete(bean);
			if (!result) {
				model.addAttribute("delete", 0);
			} else {
				model.addAttribute("delete", 1);
			}
			return "reg.error";
		} else {
			errors.put("action", "Unknown Action:" + prodaction);
			return "reg.error";
		}
	}

}
