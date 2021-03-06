package controller;

import java.io.BufferedReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;

import model.LogupdateBean;
import model.MemberBean;
import model.MemberService;



import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class LoginServlet {
	
	private static final long serialVersionUID = 1L;
	String account_facebook;
    String Name;
    String email;
    String pic;
    String graph = null;
    String fbApi = "https://graph.facebook.com/me?";
    String fields = "fields=id,name,picture.height(400),email&";
    String access_token=null;
	@Autowired
	private MemberService memberService;
	@Autowired
	private SimpleDateFormat sdFormat = null;
	
	@InitBinder
	public void init(WebDataBinder webDataBinder) {
	//	webDataBinder.registerCustomEditor(int.class, new CustomPrimitiveNumberEditor(java.lang.Integer.class, true));
	//	webDataBinder.registerCustomEditor(double.class, new CustomPrimitiveNumberEditor(java.lang.Double.class, true));
		webDataBinder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdFormat, true));
	}
	
	@RequestMapping(
			path={"/secure/login.controller"},
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String service(String prodaction, MemberBean bean, BindingResult bindingResult, Model model, HttpSession session) {
		//接收資料
		//驗證資料
				System.out.println("ss");
				
				Map<String, String> errors = new HashMap<String, String>();
				model.addAttribute("errors", errors);
				String account = bean.getAccount();		
				String pwd = bean.getPwd();
			    int account_status = bean.getAccount_status(); 
			    
			    System.out.println("account_status:"+account_status);
			    
			    if(account_status==1||account_status==2){
			    	errors.put("account", "your account is  ");
			    }
			    			    
				if(account==null || account.length()==0) {
					errors.put("account", "ID is required ");
				}
				if(pwd==null || pwd.length()==0) {
					errors.put("pwd", "PWD is required ");
				}
				if(errors!=null && !errors.isEmpty()) {
					return "login.error";
				}
				//呼叫Model
				MemberBean result = memberService.login(account,pwd);
				

				
				MemberBean result1 = memberService.login(account,pwd);

				if(result1==null) {
					
					errors.put("pwd", "Login fail, please try again.");
					return "login.error";
				} else {
					session.setAttribute("user", result1);		
					return "login.success";
				}
				
				
		
	
	}
	@RequestMapping(
			path={"/secure/fblogin.controller"},
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String fbservice(String prodaction, MemberBean bean, BindingResult bindingResult, Model model, HttpSession session,HttpServletRequest request) {
		System.out.println("cc");
				 String code = request.getParameter("code");

		 String token = null;
		 try {
			    //拿到一個長授權
	            String g = "https://graph.facebook.com/v2.8/oauth/access_token?client_id=275346536213447&redirect_uri=http://surroundu.southeastasia.cloudapp.azure.com:8080/surround/secure/fblogin.controller&client_secret=aaa57fedfe73c488731999c3f028b3cf&code=" + code;
	            URL u = new URL(g);
	            URLConnection c = u.openConnection();
	            System.out.println(c);
	            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
	            String inputLine;
	            StringBuffer b = new StringBuffer();
	            while ((inputLine = in.readLine()) != null)
	                b.append(inputLine + "\n");            
	            in.close();
	            token = b.toString();     
	            JSONObject json = new JSONObject(token);
	            access_token = json.getString("access_token").toString();
	            System.out.println("token:"+token);
	            System.out.println("access_token:"+access_token);
	            if (token.startsWith("{"))
	                throw new Exception("error on requesting token: " + token + " with code: " + code);
	        } catch (Exception e) {
	                // an error occurred, handle this
	        }
		
		 
		 try {
			 //拿到自己想要的資料
	            String g = fbApi+ fields +"access_token="+ access_token;
	            URL u = new URL(g);
	            HttpURLConnection c = (HttpURLConnection) u.openConnection();
		        c.setRequestMethod("GET");
		        c.setDoOutput(true);
		        c.setDoInput(true);
		        c.setRequestProperty("Content-type", "application/json");
		        c.setRequestProperty("Content-Language", "zh-TW");
	            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
	            String inputLine;
	            StringBuffer b = new StringBuffer();
	            while ((inputLine = in.readLine()) != null)
	                b.append(inputLine + "\n");            
	            in.close();
	            graph = b.toString();
	            System.out.println(graph);
	            System.out.println("dd");
	        } catch (Exception e) {
	                // an error occurred, handle this
	        }
		 System.out.println(graph);
//轉換json
		 		InputStream b=null;
		 		byte[] img=null;
	        	JSONObject json = new JSONObject(graph);
	        	account_facebook = json.getString("id");
	            Name = json.getString("name"); 
	            email = json.getString("email");
	           // pic = json.get("picture").toString();
	            pic=new JSONObject(new JSONObject(json.get("picture").toString()).get("data").toString()).get("url").toString();
	            try {
					URL u = new URL(pic);
					HttpURLConnection c = (HttpURLConnection) u.openConnection();
					b=c.getInputStream();
					img=inputStreamConvertByteArray(b);
					System.out.println("IMG"+img.toString());
				} catch (Exception e) {
					
				}
				System.out.println(account_facebook);
	            System.out.println(Name);
	            System.out.println(email);
	            System.out.println(pic);
	            bean.setAccount_facebook(account_facebook);
	            bean.setAccount(Name);
	            bean.setName(Name);
	            bean.setNickname(Name);
	            bean.setAccount_email(email);
	            bean.setMember_photo(img);
	            MemberBean result = memberService.fblogin(bean);  
	            if(result!=null){
	            session.setAttribute("user", result);	
	            return "Fblogin.success";
	            }else{
	            	return "login.error";
	            }
	}
	//照片轉byte
	public byte[] inputStreamConvertByteArray(InputStream inputStream) throws Exception {
		  ByteArrayOutputStream baos = new ByteArrayOutputStream(); // 使用ByteArrayOutputStream類別
		  byte[] buffer = new byte[1024];
		  int len = 0;
		  while ((len = inputStream.read(buffer)) != -1) { // 將輸入串流寫入ByteArrayOutputStream
		   baos.write(buffer, 0, len);
		  }
		  byte[] data = baos.toByteArray(); // 將ByteArrayOutputStream轉為byte陣列
		  inputStream.close();
		  return data;
		 }
	
	
	@RequestMapping(
			path={"/secure/updateMember.controller"},
			method={RequestMethod.GET, RequestMethod.POST}
	)
	
	public String updateMember(LogupdateBean logbean,BindingResult bindingResult,MemberBean bean, Model model,HttpSession session,HttpServletRequest request,@RequestParam ( "file" ) MultipartFile file){
		System.out.println("OKKK:"+logbean.getProdaction());
		String prodaction=logbean.getProdaction();
		session=request.getSession(false);
		System.out.println(logbean.getBirth());
		if("更新".equals(prodaction)) {
			
				MemberBean beansession=(MemberBean)session.getAttribute("user");
				byte[] b=null;
			
			Map<String, String> errors = new HashMap<String, String>();
			model.addAttribute("errors", errors);
			System.out.println(bindingResult);
			if(bindingResult!=null) {
				if(bindingResult.getFieldError(logbean.getBirth())!=null) {
				 System.out.println("fuck");
					errors.put("birth", "Make must be a date of YYYY-MM-DD");
					}
			}
			
			if(errors!=null && !errors.isEmpty()) {
				return "upsatemem";
			}
			if  (!file.isEmpty()) {  
				try {
					b = file.getBytes();
					System.out.println(b);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("beansession"+beansession.getAccount());
			System.out.println("beansession"+beansession.getAccount_facebook());
			System.out.println("beansession"+beansession.getName());

			beansession.setName(bean.getName());
			beansession.setBirth(bean.getBirth());//日期錯誤
			System.out.println("bean.getBirth"+bean.getBirth());
			beansession.setAccount_email(bean.getAccount_email());
			//如果沒上傳圖片就不設定
			if(b!=null){
			beansession.setMember_photo(b);
			};
			memberService.update(beansession);
			//request.setAttribute("sale", "AAA");
			model.addAttribute("sale", "aaa");
	//		session.setAttribute("user", beansession);
		}


		return "upsatemem";
	}
}
	