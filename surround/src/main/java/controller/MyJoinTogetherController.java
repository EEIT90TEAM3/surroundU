package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.MemberBean;
import model.TogetherBean;
import model.TogetherMemBean;
import model.TogetherMemService;


@Controller
@RequestMapping(
	    path={"/MyJoinTogether.controller"},
		method={RequestMethod.GET, RequestMethod.POST}
)
public class MyJoinTogetherController {
	@Autowired
	@Resource(name="togetherMemService")
	private TogetherMemService togetherMemService;
	
	@RequestMapping
	public String service(
			Model model, HttpSession session) {
		MemberBean mem=null;
		if(session!=null){
			mem=(MemberBean)session.getAttribute("user");
		}
		List<TogetherMemBean> togetherMemBean=togetherMemService.selectMyTogetherMemDetails(mem);
		if(togetherMemBean!=null && togetherMemBean.size()!=0){
			//return "MytogetherMem.success";
			for(TogetherMemBean i :togetherMemBean){
				System.out.println("===============MytogetherMemBean=================");
				System.out.println(i.getTogethermem_no());
				System.out.println(i.getTogethermem_status());
				System.out.println("===============MyMemberBean=================");
			System.out.println(i.getMember_no());
			System.out.println(i.getTogether_no().getMember_no().getNickname());
			System.out.println(i.getTogethermem_status());
			System.out.println(i.getMember_no().getNickname());
			System.out.println(i.getMember_no().getName());
			    System.out.println("===============MyMemberBean=================");
			    System.out.println("===============MyTogetherBean=================");
			System.out.println(i.getTogether_no());
			System.out.println(i.getTogether_no().getTogether_no());
			System.out.println(i.getTogether_no().getTogether_people());
			System.out.println(i.getTogether_no().getTogether_topic());
			System.out.println(i.getTogether_no().getTogether_memo());
			    System.out.println("===============MyTogetherBean=================");
			    System.out.println("===============MytogetherMemBean=================");
			}
			model.addAttribute("selecttogetherMemBean", togetherMemBean);
			return "MytogetherMem.success";
		}
		
//		List<TogetherBean> togetherBean=togetherService.togetherStatusChangeAll();
//		System.out.println("==================11111111111============================");
//		for(TogetherBean i : togetherBean){
//			System.out.println(i.getTogether_no()+"約團文章編號");
//			System.out.println(i.getMember_no());
//		}
//		model.addAttribute("selectStatis", togetherBean);
//		
		return "login.success";
		
		
	}
}