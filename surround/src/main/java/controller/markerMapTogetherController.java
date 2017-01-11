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
		path={"/markerMapTogether.controller"},
		method={RequestMethod.GET, RequestMethod.POST}
)
public class markerMapTogetherController {
	@Autowired
	@Resource(name="togetherService")
	private TogetherService togetherService;
	
	@RequestMapping
	public String service(String lat,String lng,Model model, HttpSession session){
		System.out.println(lng+"==============lag================");
		System.out.println(lat+"==============lat================");
		if(lat!=null&&lng!=null){
			String together_lat=lng.trim();
			String together_lng=lat.trim();
			List<TogetherBean> togetherBean=togetherService.markerMapTogether(together_lng, together_lat);
			if(togetherBean!=null){
                 for(TogetherBean u:togetherBean){
					System.out.println(u.getTogether_no()+"MARKER");
					System.out.println(u.getTogether_name()+"MARKER");
					
				}
				model.addAttribute("selectMarker", togetherBean);
				
			}
		}
			return "markerMapTogether.success";
}
}
