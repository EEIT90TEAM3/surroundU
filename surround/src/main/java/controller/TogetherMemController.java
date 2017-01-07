package controller;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.MemberBean;
import model.TogetherBean;
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
    private MemberBean memberBean;

	@RequestMapping
	public String service(String prodaction,String together_people,String member_no, Model model,HttpSession session) {
		//接收資料
		MemberBean mem=null;
		if(session!=null){
			mem=(MemberBean)session.getAttribute("user");
		}
		
		switch (prodaction) {
		case "加入":prodaction="join";
			break;

		default:
			break;
		}
		//驗證資料	
		
		//轉換資料
		
	
		
//		System.out.println("=======================");
//		System.out.println(prodaction);
//		System.out.println(together_people);
//		System.out.println(member_no);
//		System.out.println(togetherBean.getTogether_no()+"文章編號");
//		System.out.println(togetherBean.getTogether_topic()+"揪團主題");
//		System.out.println(togetherBean.getMember_no()+"主揪號碼");
//		System.out.println(togetherBean.getTogether_people()+"限制人數");
//		System.out.println(togetherBean.getTogether_locate()+"地點");
//		System.out.println("=======================");
//		System.out.println(memberBean);
//		System.out.println(mem.getMember_no()+"會員編號");
//		System.out.println(memberBean.getNickname()+"會員暱稱");
//		System.out.println(memberBean.getName()+"會員姓名");
//		System.out.println("=======================");
		//呼叫Model
		//根據Model的執行結果，顯示View
		
//				if("Select".equals(prodaction)) {
//					List<ProductBean> result = productService.select(bean);
//					model.addAttribute("select", result);
//					return "product.select";
//				} else if("Insert".equals(prodaction)) {
//					ProductBean result = productService.insert(bean);
//					if(result==null) {
//						errors.put("action", "Insert fail");
//					} else {
//						model.addAttribute("insert", result);
//					}
//					return "product.error";
//				} else if("Update".equals(prodaction)) {
//					ProductBean result = productService.update(bean);
//					if(result==null) {
//						errors.put("action", "Update fail");
//					} else {
//						model.addAttribute("update", result);
//					}
//					return "product.error";
//				} else if("Delete".equals(prodaction)) {
//					boolean result = productService.delete(bean);
//					if(!result) {
//						model.addAttribute("delete", 0);
//					} else {
//						model.addAttribute("delete", 1);
//					}
//					return "product.error";			
//				} else  {
//					errors.put("action", "Unknown Action:"+prodaction);
//					return "product.error";
//				}
//			
		return "login.success";
	}
	}
