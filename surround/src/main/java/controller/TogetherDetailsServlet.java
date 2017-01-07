package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import model.MemberService;
import model.TogetherBean;
import model.TogetherService;

@WebServlet("/TogetherDetailsServlet")
public class TogetherDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
    private TogetherService togetherService;
    public TogetherDetailsServlet() {
        super();
    }
    @Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(application);
		memberService = (MemberService) context.getBean("memberService");
		togetherService = (TogetherService) context.getBean("togetherService");
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		MemberBean memberBean=null;
		if(session!=null){
			memberBean=(MemberBean)session.getAttribute("user");
			
		}
			
		if(memberBean!=null) {
			MemberBean result = memberService.login(memberBean.getAccount(),memberBean.getPwd());
//			Set<TogetherBean> togetherBean=result.getTogetherBean();
//			Calendar date = Calendar.getInstance();
//			Date today = date.getTime();
//			for(TogetherBean i : togetherBean){
//				if(i.getTogether_status()==0){
//				    if(i.getTogether_when_end().before(today)){
//					    i.setTogether_status(1);
//				     }
//				}
//			}
			List<TogetherBean> togetherBean=togetherService.togetherStatusChange(result);
//			for(TogetherBean ccc : togetherBean){
//				System.out.println(ccc.getTogether_when_end());
//				System.out.println(ccc.getTogether_status());
//			}
			
			if(result==null) {
				;
			} 
			request.setAttribute("select", togetherBean);
			
			request.getRequestDispatcher(
					"/pages/myTogether.jsp").forward(request, response);
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}