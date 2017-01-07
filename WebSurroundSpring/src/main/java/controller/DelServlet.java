package controller;

import java.io.IOException;

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
 * Servlet implementation class DelServlet
 */
@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SaleService saleService;
	
    public DelServlet() {
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
		String id = request.getParameter("id");
		System.out.println(id);
		int intId=Integer.parseInt(id);
		SaleBean bean=new SaleBean();
		bean.setSale_no(intId);
		bean.setSale_status(0);
		SaleBean result = saleService.update(bean);
		request.getRequestDispatcher(
				"/Sale/delete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
