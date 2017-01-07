package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

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
import model.SaleBean;
import model.SaleService;

/**
 * Servlet implementation class SaleSearchServlet
 */
@WebServlet("/SaleSearchServlet")
public class SaleSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SaleService saleService;
	private MemberService memberService;

    public SaleSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		saleService = (SaleService) context.getBean("saleService");
//		memberService = (MemberService) context.getBean("memberService");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		MemberBean men=null; 
		List<SaleBean> result=null;
		if(session!=null){
			men=(MemberBean)session.getAttribute("user");
			System.out.println("sss");
		}
			SaleBean bean = new SaleBean();
			bean.setMember_no(men);
			if(bean!=null) {
				try {
					result = saleService.select(bean);
					System.out.println("ttt");
				} catch (Exception e) {
					request.setAttribute("select", "無擺攤內容");
					System.out.println("bbb");
					request.getRequestDispatcher(
							"/Sale/mysale.jsp").forward(request, response);
				}
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/Sale/mysale.jsp").forward(request, response);
		}
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
