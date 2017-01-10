package controller;

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
	private TogetherService togetheService;
	
	@RequestMapping
	public String service(String search,Model model,HttpSession session) {
		
		
		
		return null;
	}
}
