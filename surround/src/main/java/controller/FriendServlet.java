package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.FriendBean;
import model.FriendService;
import model.MemberBean;
import model.MemberService;
import model.SaleService;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendService friendService;   
	private MemberService memberService;
    public FriendServlet() {
        super();
    }
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		friendService = (FriendService) context.getBean("friendService");
		memberService = (MemberService) context.getBean("memberService");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("name");
		String join = request.getParameter("join");
//封鎖or解除好友
		FriendBean bean=new FriendBean();
		bean.setBuddy_no(memberService.select("1"));
		bean.setFriend_status(1);
		bean.setMember_no(memberService.select("3"));
		friendService.update(bean);
//新增好友
//		FriendBean bean=new FriendBean();
//		bean.setBuddy_no(memberService.select(join));
//		bean.setFriend_status(0);
//		bean.setMember_no(memberService.select(id));
//		friendService.addFriend(bean);
//好友列表
//		List<FriendBean> bean= friendService.friendList(Integer.parseInt(id));
//		for (FriendBean fbean :bean){
//			System.out.println(fbean.getMember_no().getAccount()+",");
//			System.out.println(fbean.getBuddy_no().getAccount());
//			System.out.println("-----------------------");
//		}
//搜尋會員
//		memberService.select("id");
//接受好友
//刪除好友
		request.setAttribute("select", "bean");
		request.getRequestDispatcher("indexf.jsp").forward(request, response);
	}
	

}
