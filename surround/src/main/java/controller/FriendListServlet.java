package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.FriendBean;
import model.FriendService;
import model.MemberBean;
import model.MemberService;
import model.ProductBean;
import model.SaleBean;
import model.SaleService;

/**
 * Servlet implementation class GoogleAllServlet
 */
@WebServlet("/FriendListServlet.ajax")
public class FriendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendService friendService; 
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		friendService = (FriendService) context.getBean("friendService");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String loginNo = request.getParameter("loginNo");
		String type =request.getParameter("type");
		System.out.println("FriendList=============="+type);
		List<FriendBean> result=null;
		if(type.equals("FriendList")){
			result = friendService.friendList(Integer.parseInt(loginNo));
		}else{
			result = friendService.inviteList(Integer.parseInt(loginNo));
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonStr = gson.toJson(result);
		    System.out.println(jsonStr);
		response.getWriter().write(jsonStr);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
