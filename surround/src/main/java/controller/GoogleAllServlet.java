package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.ProductBean;
import model.SaleBean;
import model.SaleService;

/**
 * Servlet implementation class GoogleAllServlet
 */
@WebServlet("/GoogleAllServlet.ajax")
public class GoogleAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SaleService saleService; 
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		saleService = (SaleService) context.getBean("saleService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		SaleBean bean = new SaleBean();
		bean.setSale_no(1);
		List<SaleBean> result = saleService.select();
//		System.out.println("fff");
//		System.out.println(result);
		for(SaleBean bb:result){
		System.out.print(bb.getSale_name()+",");
		System.out.print(bb.getSale_locate()+",");
		System.out.println(bb.getSale_memo());
			for(ProductBean aa:bb.getProductBean()){
				System.out.println(aa.getProduct_name());
				System.out.println(aa.getProduct_memo());
				System.out.println(aa.getProduct_price());
				
			}
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonStr = gson.toJson(result);
//		  final GsonBuilder builder = new GsonBuilder();
//		    builder.excludeFieldsWithoutExposeAnnotation();
//		    final Gson gson = builder.create();
//		    String jsonStr = gson.toJson(result);
		    System.out.println(jsonStr);
		response.getWriter().write(jsonStr);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
