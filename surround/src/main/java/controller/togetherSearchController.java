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
import model.TogetherDAO;
import model.TogetherService;

@Controller
@RequestMapping(
	    path={"/togetherSearch.controller"},
		method={RequestMethod.GET, RequestMethod.POST}
)
public class togetherSearchController {
	@Autowired
	@Resource(name="togetherBean")
	private TogetherBean togetherBean;
	@Autowired
	@Resource(name="togetherDao")
	private TogetherDAO togetherDao;
	@Autowired
	@Resource(name="togetherService")
	private TogetherService togetherService;
	
	@RequestMapping
	public String service(String search,Model model,HttpSession session) {
		
		System.out.println("===search====="+search);
		
		if(!search.trim().isEmpty()){
			String searchTogether=search.trim();
			System.out.println("===searchIn====="+search);
			System.out.println("=====searchTogether===="+searchTogether);
			List<TogetherBean> togetherBean=togetherService.searchTogether(searchTogether);
			if(!togetherBean.isEmpty()){
				model.addAttribute("selectStatis", togetherBean);
				return "together.success";
			}else{
				model.addAttribute("togetherType","searchNoData");
				System.out.println("查無資料");
				return "together_end.success";
			}
		}else{
			System.out.println("請輸入查詢字串(非空白)");
			model.addAttribute("togetherType","noSearch");
			return "together_end.success";
			
		}
		
	
	}
}
