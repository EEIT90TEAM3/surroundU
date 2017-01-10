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

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.SaleBean;
import model.SaleService;

/**
 * Servlet implementation class SaleUpdateDelServlet
 */
@WebServlet("/mysale/SaleUpdateDelServlet")
public class SaleUpdateDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SaleService saleService;
    public SaleUpdateDelServlet() {
        super();
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
		String id = request.getParameter("id");
		System.out.println(id);
		int intId=Integer.parseInt(id);
		SaleBean result = saleService.select(intId);
		HttpSession session = request.getSession();
		session.setAttribute("update", result);
		request.getRequestDispatcher(
				"/Sale/updateView.jsp").forward(request, response);
		
		
		//轉去更新網頁
//		if("修改".equals(update)) {
//		request.getRequestDispatcher(
//				"/Sale/delete.jsp").forward(request, response);
//		}
//		//轉去刪除網頁
//		if("刪除".equals(update)) {
//			request.getRequestDispatcher(
//					"/Sale/sucess.jsp").forward(request, response);
//			}
	
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("ppp");
		 request.getRequestDispatcher(
					"/Sale/sucess.jsp").forward(request, response);
	}

}
