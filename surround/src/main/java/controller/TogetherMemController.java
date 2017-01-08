package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.MemberBean;
import model.MemberDAO;
import model.TogetherBean;
import model.TogetherDAO;
import model.TogetherMemBean;
import model.TogetherMemDAO;
import model.TogetherMemService;


@Controller
@RequestMapping(
	    path={"/togethermem.controller"},
		method={RequestMethod.GET, RequestMethod.POST}
)
public class TogetherMemController {
	@Autowired
	private SimpleDateFormat sdFormatTogether = null;
	
	@Autowired
	@Resource(name="togetherMemService")
	private TogetherMemService togetherMemService;
	@Autowired
	@Resource(name="togetherMemBean")
	private TogetherMemBean togetherMemBean;
	@Autowired
	@Resource(name="togetherBean")
	private TogetherBean togetherBean;
	@Autowired
	@Resource(name="togetherDao")
	private TogetherDAO togetherDao;
	@Autowired
	@Resource(name="memberBean")
	private MemberBean memberBean;
	@Autowired
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;
	@RequestMapping
	public String service(String prodaction,String together_no,String together_topic,String together_when,String together_when_end,
			String together_people,String member_no, String together_name,String together_locate,String together_memo,
			String togethermem_no,String togethermem_status,String togethermem_time,String togethermem_time_okay,
			Model model,HttpSession session) {
		//接收資料

		
		MemberBean mem=null;
		if(session!=null){
			mem=(MemberBean)session.getAttribute("user");
		}
		System.out.println("=======controller===========");
		System.out.println(prodaction);
		System.out.println(togethermem_no);
		System.out.println(together_no);
		System.out.println(member_no);
		System.out.println(togethermem_status);
		System.out.println(togethermem_time);
		//System.out.println(togethermem_time.getClass());
		System.out.println(togethermem_time_okay);
		System.out.println("=======controller===========");
		switch (prodaction) {
		case "加入":prodaction="join";System.out.println(prodaction);
			 break;
		case "約團成員表":prodaction="mytogetherMemDetails";System.out.println(prodaction);
		     break;
		case "確定加入":prodaction="joinDefine";System.out.println(prodaction);
		      break;
		case "拒絕":prodaction="reject";System.out.println(prodaction);
	      break;
		case "取消申請":prodaction="cancel";System.out.println(prodaction);
	      break;
		default:
			break;
		}
		//驗證資料	
		//轉換資料
		int together_no_c=0;
		if(together_no!=null && together_no.length()!=0){
			try{
				together_no_c=Integer.parseInt(together_no.trim());
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		int together_people_c=0;
		if(together_people!=null && together_people.length()!=0){
			try{
				together_people_c=Integer.parseInt(together_people);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		int member_no_c=0;
		if(member_no!=null && member_no.length()!=0){
			try{
				member_no_c=Integer.parseInt(member_no.trim());
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		int togethermem_no_c=0;
		if(togethermem_no!=null && togethermem_no.length()!=0){
			try{System.out.println(togethermem_no+"=togethermem_no");
				togethermem_no_c=Integer.parseInt(togethermem_no.trim());
				System.out.println(togethermem_no_c+"=togethermem_no_c");
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		int togethermem_status_c=0;
		if(togethermem_status!=null && togethermem_status.length()!=0){
			try{
				togethermem_status_c=Integer.parseInt(togethermem_status);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		java.util.Date togethermem_time_c =null;
		if(togethermem_time!=null && togethermem_time.length()!=0) {
			try {
				togethermem_time_c=sdFormatTogether.parse(togethermem_time);
			} catch (ParseException e) {
				e.printStackTrace();
				
			} 
		}
		if(togethermem_time_c==null){
			if(togethermem_time!=null && togethermem_time.length()!=0) {
			Date date=null;
			try {
				date = (Date) sdf.parse(togethermem_time);
			} catch (ParseException e) {
				e.printStackTrace();
			}if(date!=null){
				String time="";
				time=sdFormatTogether.format(date);
				try {
					togethermem_time_c=sdFormatTogether.parse(time);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		}System.out.println(togethermem_time_c);
		//呼叫Model
		togetherBean.setTogether_no(together_no_c);
		togetherMemBean.setTogether_no(togetherBean);
		//TogetherBean togetherbean=togetherDao.select(together_no_c);
		//根據Model的執行結果，顯示View
		if("join".equals(prodaction)){
			togetherMemBean.setMember_no(mem);
			System.out.println("=======加入約團=======");
			System.out.println(member_no_c+"jsp傳來");
			System.out.println(mem.getMember_no());
			if(together_no_c>0 && together_people_c>0){
				System.out.println("==================join=================");
				if(member_no_c!=mem.getMember_no()){
			int result=-1;
			//0=正常加入  1=人數超過  2=已加入過  3=其他
			result=togetherMemService.togetherMemPeopleVerify(togetherMemBean,together_people_c);
			System.out.println(result+"有沒有超過人數");
			    if(result==0){
			       togetherMemBean.setTogethermem_status(0);
			       togetherMemBean.setTogethermem_time(null);
			       togetherMemBean.setTogethermem_time_okay(null);
			       System.out.println("instert no"+togetherMemBean.getMember_no());
				   TogetherMemBean beanokay=togetherMemService.instert(togetherMemBean);
				  // model.addAttribute("joinOkay",beanokay);
				   System.out.println(beanokay);
				   System.out.println("========beanokay==========");
				   model.addAttribute("togetherType","togetherJoinOkay");
				   return "together_end.success";
				   //return"togethermem.success";
			    }else if(result==1){
			    	model.addAttribute("togetherType","togetherJoinOver");
			    	return"together_end.success";
			    }else if(result==2){
			    	model.addAttribute("togetherType","togetherJoinerror");
		    	return"together_end.success";
			    }
		    }else{
		    	model.addAttribute("togetherType","member_no_error");
		    	return"together_end.success";
		    }
			}
		}else if("mytogetherMemDetails".equals(prodaction)){
			togetherMemBean.setMember_no(mem);
			System.out.println("11111111111111111");
			if(together_no_c>0){
				System.out.println("2222222222222222222");
			    List<TogetherMemBean> beanokay=togetherMemService.selectTogetherMemDetails(togetherBean);
			    System.out.println(beanokay);
			    TogetherBean tobn=togetherDao.select(together_no_c);
			    if(beanokay!=null &&beanokay.size()!=0 && tobn!=null){
			    	System.out.println("3333333333333333333333333");
			    model.addAttribute("selectTogetherMemDetails",beanokay);
			    model.addAttribute("togetherbean",tobn);
			    return "togetherMem.success";
			    }else{
			    	model.addAttribute("togetherType","no_MemDetails_error");
			    	return"together_end.success";
			    }
			}
		}else if("joinDefine".equals(prodaction)|| "reject".equals(prodaction)){
			if(together_no_c>0){
				System.out.println("==================joinDefine=================");
				   MemberBean memBean=memberDAO.selectMember_no(member_no_c);
				   togetherMemBean.setMember_no(memBean);
				   togetherMemBean.setTogethermem_no(togethermem_no_c);
				   if("joinDefine".equals(prodaction)){
					   togetherMemBean.setTogethermem_status(1);
				   }else if("reject".equals(prodaction)){
					   togetherMemBean.setTogethermem_status(2);
				   }
			       togetherMemBean.setTogethermem_time(togethermem_time_c);
			       togetherMemBean.setTogethermem_time_okay(null);
			       //0=尚未審核加入  1=已加入  2=拒絕  -1=selectMemberStatus有問題 3=隱藏(刪除) 99=資料庫沒資料
			       int result = togetherMemService.selectTogetherMemStatus(togetherBean,memBean);
			       System.out.println("確認揪團明細表申請狀態="+result);
			       if(result==0){  
				   TogetherMemBean bean=togetherMemService.update(togetherMemBean);
				   if(bean!=null){
					   System.out.println("============togetherMemService============");
					 List<TogetherMemBean> beanokay=togetherMemService.selectTogetherMemDetails(togetherBean);
					 TogetherBean tobn=togetherDao.select(together_no_c);
					 if(beanokay!=null &&beanokay.size()!=0 && tobn!=null){
					   //System.out.println(tobn);
				         model.addAttribute("selectTogetherMemDetails",beanokay);
				         model.addAttribute("togetherbean",tobn);
				       //  model.addAttribute("togetherType","togetherJoinDefine");
				         return "togetherMem.success";
					   } 
				   }
			       }else if(result==1){
			    	   if("joinDefine".equals(prodaction)){
			    		   List<TogetherMemBean> beanokay=togetherMemService.selectTogetherMemDetails(togetherBean);
							 TogetherBean tobn=togetherDao.select(together_no_c);
							 if(beanokay!=null &&beanokay.size()!=0 && tobn!=null){
						         model.addAttribute("selectTogetherMemDetails",beanokay);
						         model.addAttribute("togetherbean",tobn);
						         return "togetherMem.success";
							   }
			    	   }else if("reject".equals(prodaction)){
			    		   TogetherMemBean bean=togetherMemService.update(togetherMemBean);
						   if(bean!=null){
							   System.out.println("============togetherMemService============");
							 List<TogetherMemBean> beanokay=togetherMemService.selectTogetherMemDetails(togetherBean);
							 TogetherBean tobn=togetherDao.select(together_no_c);
							 if(beanokay!=null &&beanokay.size()!=0 && tobn!=null){
						         model.addAttribute("selectTogetherMemDetails",beanokay);
						         model.addAttribute("togetherbean",tobn);
						         return "togetherMem.success";
							   } 
						   }
			    	   }
			       }else if(result==2){
                       if("joinDefine".equals(prodaction)){
                    	   TogetherMemBean bean=togetherMemService.update(togetherMemBean);
        				   if(bean!=null){
        					   System.out.println("============togetherMemService============");
        					 List<TogetherMemBean> beanokay=togetherMemService.selectTogetherMemDetails(togetherBean);
        					 TogetherBean tobn=togetherDao.select(together_no_c);
        					 if(beanokay!=null &&beanokay.size()!=0 && tobn!=null){
        				         model.addAttribute("selectTogetherMemDetails",beanokay);
        				         model.addAttribute("togetherbean",tobn);
        				         return "togetherMem.success";
        					   } 
        				   }
			    	   }else if("reject".equals(prodaction)){
			    		   List<TogetherMemBean> beanokay=togetherMemService.selectTogetherMemDetails(togetherBean);
							 TogetherBean tobn=togetherDao.select(together_no_c);
							 if(beanokay!=null &&beanokay.size()!=0 && tobn!=null){
						         model.addAttribute("selectTogetherMemDetails",beanokay);
						         model.addAttribute("togetherbean",tobn);
						         return "togetherMem.success";
							   }
			    	   } 
			       }else{
			    	   System.out.println("selectTogetherMemService_selectMemberStatus有問題");
			       }
				   //return"togethermem.success";
				   System.out.println("==================joinDefine=================");
			    }else{
			    model.addAttribute("togetherType","togetherJoinerror");
			    	return"together_end.success";
			}
		}else if("cancel".equals(prodaction)){
			MemberBean memBean=memberDAO.selectMember_no(member_no_c);
			togetherMemBean.setMember_no(memBean);
			togetherMemBean.setTogethermem_no(togethermem_no_c);
			togetherMemBean.setTogethermem_status(3);
		    togetherMemBean.setTogethermem_time(togethermem_time_c);
		    togetherMemBean.setTogethermem_time_okay(null);
		  //0=尚未審核加入  1=已加入  2=拒絕  -1=selectMemberStatus有問題 3=隱藏(刪除) 99=資料庫沒資料
		       int result = togetherMemService.selectTogetherMemStatus(togetherBean,memBean);
		       System.out.println("確認揪團明細表申請狀態="+result);
		       if(result>=0 && result<3){  
			   TogetherMemBean bean=togetherMemService.update(togetherMemBean);
			   if(bean!=null){
				   System.out.println("============togetherMemService============");
				   
				   List<TogetherMemBean> togetherMemBean=togetherMemService.selectMyTogetherMemDetails(mem);
					if(togetherMemBean!=null && togetherMemBean.size()!=0){
						model.addAttribute("selecttogetherMemBean", togetherMemBean);
						return "MytogetherMem.success";
					}
			         return "togetherMem.success";
				   } 
			   }
		       }
//			TogetherMemBean togemem=togetherMemService.select(togetherMemBean);
//			if(togemem!=null){
//			boolean result = togetherMemService.delete(togetherMemBean);
//                 if(result){
//                	      List<TogetherMemBean> beanokay=togetherMemService.selectTogetherMemDetails(togetherBean);
//					      TogetherBean tobn=togetherDao.select(together_no_c);
//					      if(beanokay!=null &&beanokay.size()!=0 && tobn!=null){
//				               model.addAttribute("selectTogetherMemDetails",beanokay);
//				               model.addAttribute("togetherbean",tobn);
//				               return "togetherMem.success";
//					   } 
//			      }else{
//			    	  return"login.success";
//			      }
//			}
			
		
		
	
		return "together_end.success";
	}
	}
