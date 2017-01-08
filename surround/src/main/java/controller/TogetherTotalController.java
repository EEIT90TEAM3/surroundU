package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		
		List<TogetherBean> togetherBean=togetherService.togetherStatusChangeAll();
		System.out.println("==================11111111111============================");
//		System.out.println(togetherBean[0].getTogether_no()+"約團文章編號");
        ArrayList list =new ArrayList();
        Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println(togetherBean.size());
		for(TogetherBean i : togetherBean){
			System.out.println("======222========");
//			for(int no=0;no<togetherBean.size();no++){
//				list.add(no, );
//			}
			System.out.println(i.getTogether_no());
			System.out.println("======333========");
			for(TogetherMemBean a :i.getTogetherBeanMem()){
				TogetherBean together_no=a.getTogether_no();
				int no=together_no.getTogether_no();
				System.out.println("no="+no);
				
				int togetherMemStatus=togetherMemService.selectTogetherMemStatus(together_no,mem);
				
				if(togetherMemStatus==0){
					map.put(no,"已申請");
				}else if(togetherMemStatus==1){
					map.put(no,"已加入");
				}else if(togetherMemStatus==2){
					map.put(no,"加入失敗");
				}else if(togetherMemStatus==99){
					map.put(no,"尚未申請加入");
				}else{
					System.out.println("selectTogetherMemStatus有ERROR");
				}System.out.println("1111111="+map.size());
				
//				switch (togetherMemStatus) {
//				case 0:list.add(no,"已申請");
//					break;
//				case 1:list.add(no,"已加入");
//					break;
//				case 2:list.add(no,"加入失敗");
//					break;
//				case 99: list.add(no,"尚未申請加入");
//				break;
//				default:list.add(no,"");
//					break;
//				}
				}System.out.println("22222="+map.size());
		    }
		System.out.println("33333="+map.size());
		System.out.println("ILOVEU");
		for (Object key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }System.out.println("ILOVEU");
        model.addAttribute("map",map);
		model.addAttribute("selectStatis", togetherBean);
		
		
		return "together.success";
		
	}
}
