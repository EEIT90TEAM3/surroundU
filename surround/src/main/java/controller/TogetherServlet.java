package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@WebServlet(urlPatterns={"/pages/together.controller"})
public class TogetherServlet extends HttpServlet{
	private SimpleDateFormat sdFormat = null;
	private TogetherService togetherService;
	//驗證時間
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	//驗證時間
	public TogetherServlet() {
        super();
    }
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(application);
		togetherService =(TogetherService) context.getBean("togetherService");
		
		sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		//驗證時間
		memberService = (MemberService) context.getBean("memberService");
		//togetherService = (TogetherService) context.getBean("togetherService");
		
	}
//	public String getDateTime(){
//		Date date = new Date();
//		String strDate = sdFormat.format(date);
//		return strDate;
//		}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//接收資料(新增約團)
	    String together_topic = request.getParameter("together_topic");
	    String together_name =request.getParameter("together_name");
	    String together_locate =request.getParameter("together_locate");
	    String together_memo =request.getParameter("together_memo");
		String temp1 = request.getParameter("together_when");
		String temp2 = request.getParameter("together_when_end");
		String temp3 = request.getParameter("together_people");
		String choose = request.getParameter("prodaction");
	//接收資料(修改約團)	
		String temp4 =request.getParameter("together_no");
		String temp5 = request.getParameter("together_post_time");
		String temp6 = request.getParameter("together_delete_time");
		String temp7 = request.getParameter("together_modify_time");
		String temp8 = request.getParameter("together_status");
		String together_lat = request.getParameter("lat");
		String together_lng = request.getParameter("lng");
		System.out.println("choose="+choose);
		System.out.println(together_lng);
		System.out.println(together_lat);
	//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		
		if(together_topic==null || together_topic.length()==0) {
			errors.put("together_topic", "請輸入開團主題");
	}
		if(together_name==null || together_name.length()==0) {
			errors.put("together_name", "請輸入名稱");
	}
		if(together_locate==null || together_locate.length()==0) {
			errors.put("together_locate", "請輸入地點");
	}
		if(together_memo==null || together_memo.length()==0) {
			errors.put("together_memo", "請簡短敘述");
	}
		if(temp1==null || temp1.length()==0) {
			errors.put("together_when", "請輸入活動時間");
			
	}
		if(temp2==null || temp2.length()==0) {
			errors.put("together_when_end", "請輸入活動結束時間");
	}
		if(temp3==null || temp3.length()==0) {
			errors.put("together_people", "請輸入人數");
	}
		
		
	//轉換資料
		String prodaction=null;
		switch(choose){
		case "送出": prodaction="Insert";break;
		case "儲存": prodaction="Update";break;
		case "刪除": prodaction="Delete";break;
		}
		System.out.println("prodaction="+prodaction);
		
		
		int together_people=0;
		if(temp3!=null && temp3.length()!=0){
			try{
				together_people=Integer.parseInt(temp3);
			}catch (NumberFormatException e) {
				e.printStackTrace();
				errors.put("together_people", "請輸入數字");
			}
		}
		
		java.util.Date together_when =null;
		if(temp1!=null && temp1.length()!=0) {
			try {
				together_when=sdFormat.parse(temp1);
				Date today=Calendar.getInstance().getTime();
				System.out.println(today);
				if(together_when.before(today)){
					errors.put("together_when", "請輸入晚於現在的時間");
				}
			} catch (ParseException e) {
				e.printStackTrace();
				errors.put("together_when", "請依照此格式「yyyy-MM-dd HH:mm」輸入");
			} 
		}
		
		java.util.Date together_when_end =null;
		if(temp2!=null && temp2.length()!=0) {
			try {
				together_when_end=sdFormat.parse(temp2);
				if(together_when!=null){
				   if(together_when.after(together_when_end)){
					  errors.put("together_when_end", "活動結束時間需晚於活動時間");
				   }
				}
			} catch (ParseException e) {
				e.printStackTrace();
				errors.put("together_when_end", "請依照此格式「yyyy-MM-dd HH:mm」輸入");
			} 
		}
		
		java.util.Date together_post_time =null;
		if(temp5!=null && temp5.length()!=0) {
			try {
				together_post_time=sdFormat.parse(temp5);
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("修改約團_發文時間有誤");
			} 
		}
		java.util.Date together_modify_time =null;
		if(temp7!=null && temp7.length()!=0) {
			try {
				together_modify_time=sdFormat.parse(temp7);
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("約團_修改時間有誤");
			} 
		}
		
		int together_status=0;
		if(temp8!=null && temp8.length()!=0){
			try{
				together_status=Integer.parseInt(temp8);
			}catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("文章狀態號碼有誤");
			}
		}
		
	
		
		//驗證時間
		        HttpSession session=request.getSession(false);
		        if("Insert".equals(prodaction)){
		        MemberBean memberBean=null;
				if(session!=null){
					memberBean=(MemberBean)session.getAttribute("user");
					
				}if(together_when!=null||together_when_end!=null){
				   if(memberBean!=null) {
					MemberBean result = memberService.login(memberBean.getAccount(),memberBean.getPwd());
					List<TogetherBean> togetherBean=togetherService.togetherStatusChange(result);
				    for(TogetherBean tobean:togetherBean){
				    	System.out.println("1");
				    	System.out.println(tobean.getTogether_when());//1
				    	System.out.println(tobean.getTogether_when_end());//2
				    	System.out.println(together_when);//3
				    	System.out.println(together_when_end);//4
				    	if(tobean.getTogether_status()==0){
				    		System.out.println(tobean.getTogether_status());
				    	if((together_when.before(tobean.getTogether_when())&& together_when_end.before(tobean.getTogether_when()))
				    		|| (tobean.getTogether_when_end().before(together_when)&& tobean.getTogether_when_end().before(together_when))	
				    		){}else{
				    		System.out.println("2");	
				    		errors.put("together_when", "您想開團的時間範圍,已有您的其他團");
				    		System.out.println("=========================");	
				    	}
				    }
				    }
				}
				}
				}
		
//		if("Insert".equals(prodaction)){
//			try {
//				together_post_time=sdFormat.parse(temp4);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			together_delete_time=null;
//			together_modify_time=null;
//		}else if("Update".equals(prodaction)){
//			try {
//				together_delete_time=sdFormat.parse(temp4);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}else if("Delete".equals(prodaction)){
//			try {
//				together_modify_time=sdFormat.parse(temp4);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
		
		
		
		if(errors!=null && !errors.isEmpty()) {
			if("Insert".equals(prodaction)){
			request.getRequestDispatcher(
					"/pages/together.jsp").forward(request, response);
			return;
			}else if("Update".equals(prodaction)){
				request.getRequestDispatcher(
						"/pages/togetherUpdate.jsp").forward(request, response);
			}
		}	 
		
		
		//呼叫model
		MemberBean mem=null;
		//HttpSession session=request.getSession(false);
		if(session!=null){
			mem=(MemberBean)session.getAttribute("user");
		}
		TogetherBean bean=new TogetherBean();
		bean.setMember_no(mem);
		bean.setTogether_topic(together_topic);
		bean.setTogether_name(together_name);
		bean.setTogether_locate(together_locate);
		bean.setTogether_when(together_when);
		bean.setTogether_when_end(together_when_end);
		bean.setTogether_people(together_people);
		bean.setTogether_memo(together_memo);
		bean.setTogether_status(0);
		bean.setTogether_lat(together_lng);
		bean.setTogether_lng(together_lat);
		//bean.setTogether_post_time(new java.util.Date());
		//	request.getRequestDispatcher(
		//			"/index.jsp").forward(request, response);
	//呼叫model 顯示veiw
		if("Insert".equals(prodaction)) {
			TogetherBean result = togetherService.insert(bean);
			if(result==null) {
				
				errors.put("action", "Insert fail");
			} else {
				request.setAttribute("insert", result);
			}
			request.setAttribute("togetherType","together");
			request.getRequestDispatcher(
					"/pages/together_end.jsp").forward(request, response);
			
		} else if("Update".equals(prodaction)) {
			int together_no=0;
			if(temp4!=null && temp4.length()!=0){
				try{
					System.out.println("1");
					together_no=Integer.parseInt(temp4.trim());
				}catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("文章編號有誤");
				}
			}
			bean.setTogether_no(together_no);
			bean.setTogether_post_time(together_post_time);
			bean.setTogether_delete_time(null);
			bean.setTogether_status(together_status);
			bean.setTogether_lat(together_lat);
			bean.setTogether_lng(together_lng);	
			TogetherBean result = togetherService.update(bean);
			if(result==null) {
				errors.put("action", "Update fail");
			} else {
				request.setAttribute("update", result);
				request.setAttribute("togetherType","togetherOkay");
			}
			request.getRequestDispatcher(
					"/pages/together_end.jsp").forward(request, response);
		} else if("Delete".equals(prodaction)) {
			int together_no=0;
			if(temp4!=null && temp4.length()!=0){
				try{
					System.out.println("1");
					together_no=Integer.parseInt(temp4.trim());
				}catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("文章編號有誤");
				}
			}
			bean.setTogether_no(together_no);
			bean.setTogether_post_time(together_post_time);
			bean.setTogether_modify_time(together_modify_time);
			bean.setTogether_delete_time(null);
			bean.setTogether_status(together_status);
			bean.setTogether_lat(together_lat);
			bean.setTogether_lng(together_lng);	
			TogetherBean result = togetherService.togetherStatusDelete(bean);
			if(result==null) {
				request.setAttribute("delete", 0);
			} else {
				request.setAttribute("delete", 1);
			}
			request.setAttribute("togetherType","togetherDelete");
			request.getRequestDispatcher(
					"/pages/together_end.jsp").forward(request, response);
			
			
		} else  {
			errors.put("action", "Unknown Action:"+prodaction);
			request.getRequestDispatcher(
					"/pages/together1.jsp").forward(request, response);
		}
		}

		
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		super.doPost(req, resp);
	}
	

}