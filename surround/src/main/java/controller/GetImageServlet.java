package controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.MemberBean;
import model.MemberService;

@Controller
public class GetImageServlet{
	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberService memberService; 
	@RequestMapping(
			path={"/secure/logWeb.controller"},
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public void service( Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String account_facebook=request.getParameter("id");
		byte[] ba = null;
		MemberBean bean=new MemberBean();
		bean.setAccount_facebook(account_facebook);
		MemberBean mb = memberService.fblogin(bean);
		System.out.println(mb.getAccount_facebook());
		ba = mb.getMember_photo();
		response.setContentType("image/jpeg");
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(ba);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
