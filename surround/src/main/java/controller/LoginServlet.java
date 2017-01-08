package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import model.MemberService;

@WebServlet(
		urlPatterns={"/secure/login.controller"}
)
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		memberService = (MemberService) context.getBean("memberService");
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//接收資料
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);

		if(account==null || account.length()==0) {
			errors.put("account", "ID is required");
		}
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd", "PWD is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/secure/logWeb.jsp").forward(request, response);
			return;
		}
//呼叫Model
		MemberBean bean = memberService.login(account, pwd);
//根據Model的執行結果，顯示View
		if(bean==null) {
			errors.put("pwd", "Login fail, please try again.");
			request.getRequestDispatcher(
					"/secure/logWeb.jsp").forward(request, response);
			
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			String path = request.getContextPath();
			response.sendRedirect(path+"/GoogleMap.jsp");
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
