package controller;

import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.TogetherBean;
import model.TogetherService;

@Controller
@RequestMapping(
		path={"TogetherTotal.controller"},
		method={RequestMethod.GET, RequestMethod.POST}
)
public class TogetherTotalController {
	@Autowired
	@Resource(name="togetherService")
	private TogetherService togetherService;
	
	@RequestMapping
	public String service(
			Model model, HttpSession session) {
		
		List<TogetherBean> togetherBean=togetherService.togetherSelectStatus();
		for(TogetherBean i : togetherBean){
			System.out.println(i.getTogether_no()+"約團文章編號");
			System.out.println(i.getMember_no());
		}
		model.addAttribute("selectStatis", togetherBean);
		
		return "together.success";
		
	}
}
