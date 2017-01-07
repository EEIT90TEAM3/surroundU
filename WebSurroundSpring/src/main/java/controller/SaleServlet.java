package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.MemberBean;
import model.ProductBean;
import model.SaleBean;
import model.SaleService;

@MultipartConfig
@WebServlet("/SaleIndex/SaleServlet")
public class SaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SaleService saleService;
	private SimpleDateFormat sdFormat = null;
	String filename=null;
	@Override
	public void init() throws ServletException {
		sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ServletContext application = this.getServletContext();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		saleService = (SaleService) context.getBean("saleService");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收資料
		request.setCharacterEncoding("UTF-8");
				String sale = request.getParameter("sale");
				String sale_topic = request.getParameter("sale_topic");
				String sale_name = request.getParameter("sale_name");
				String sale_locate = request.getParameter("sale_locate");
				String sale_time = request.getParameter("sale_time");
				String sale_memo = request.getParameter("sale_memo");
				Part part=request.getPart("photo");//圖片
				String product_name = request.getParameter("product_name");
				String price = request.getParameter("product_price");
				String product_memo = request.getParameter("product_memo");
				String lat = request.getParameter("lat");
				String lng = request.getParameter("lng");
				System.out.println(lat);
				System.out.println(lng);
				
				
//				MemberBean mem=null;
//				HttpSession session=request.getSession(false);
//				if(session!=null){
//					mem=(MemberBean)session.getAttribute("user");
//				}
//					
//					System.out.println(mem.getMember_no());
				
		//驗證資料
				Map<String, String> errors = new HashMap<String, String>();
				request.setAttribute("errors", errors);

				
					if(sale_topic==null || sale_topic.length()==0) {
						errors.put("sale_topic", "請輸入擺攤標題");
				}
					if(sale_name==null || sale_name.length()==0) {
						errors.put("sale_name", "請輸入擺攤名稱");
				}
					if(sale_locate==null || sale_locate.length()==0) {
						errors.put("sale_locate", "請輸入擺攤地點");
				}
					if(sale_time==null || sale_time.length()==0) {
						errors.put("sale_time", "請輸入擺攤時間");
				}
					if(product_name==null || product_name.length()==0) {
						errors.put("product_name", "請輸入賣品名稱");
				}
					if(price==null || price.length()==0) {
						errors.put("product_price", "請輸入賣品價格");
				}
					if(product_memo==null || product_memo.length()==0) {
						errors.put("product_memo", "請輸入賣品描述");
				}
					
					try {
						//圖片
						if (part == null) {
							errors.put("photo", "請上傳圖片");
						} else {
							String header = part.getHeader("Content-Disposition");
							String filename = header.substring(header.indexOf("filename=\"") + 10,
									header.lastIndexOf("\""));
							this.filename=filename;
							InputStream in = part.getInputStream();
							FileOutputStream out = new FileOutputStream("C:/EEIT/EEIT90Project/repository/WebSurroundSpring/src/main/webapp/img/" + filename);
							byte[] buffer = new byte[1024];
							int length = -1;
							while ((length = in.read(buffer)) != -1) {
								out.write(buffer, 0, length);
							}
							in.close();
							out.close();
						} 
					} catch (Exception e) {
						errors.put("photo", "請上傳圖片");
					}
					if(sale_memo==null || sale_memo.length()==0) {
						errors.put("sale_memo", "請輸入擺攤內容");
				}
				
					
		//轉換資料
					int product_price = 0;
					if(price!=null && price.length()!=0) {
						try {
							product_price = Integer.parseInt(price);
						} catch (NumberFormatException e) {
							e.printStackTrace();
							errors.put("product_price", "請輸入數字格式");
						}
					}
					
					java.util.Date date= null;
					if (sale_time!=null && sale_time.length()!=0) {
						try {
							date = sdFormat.parse(sale_time);
						} catch (ParseException e) {
							e.printStackTrace();
							errors.put("sale_time", "請輸入 yyyy-MM-dd HH:mm");
						} 
					}
					
					if(errors!=null && !errors.isEmpty()) {
						
						request.getRequestDispatcher(
								"/Sale/SaleIndex.jsp").forward(request, response);
						return;
					}
					
					
		//呼叫Model
					System.out.println(filename);
					MemberBean mem=null;
					HttpSession session=request.getSession(false);
					if(session!=null){
						mem=(MemberBean)session.getAttribute("user");
					}
					SaleBean bean = new SaleBean();
					Set<ProductBean> product = new HashSet<ProductBean>();
					ProductBean productup = new ProductBean();
					productup.setSale_no(bean);
					productup.setProduct_pic("/img/"+filename);
					productup.setProduct_name(product_name);
					productup.setProduct_price(product_price);
					productup.setProduct_memo(product_memo);			
					product.add(productup);
		
//					bean.setSale_no(1);
					bean.setMember_no(mem);
					bean.setSale_topic(sale_topic);
					bean.setSale_name(sale_name);
					bean.setSale_locate(sale_locate);
					bean.setSale_time(date);
					bean.setSale_lng(lat);
					bean.setSale_lat(lng);
					bean.setSale_memo(sale_memo);
					bean.setSale_status(1);//讓擺攤狀態存在
					bean.setProductBean(product);
		//根據Model的執行結果，顯示View
					
					if("新增".equals(sale)) {
						System.out.println("insert");
						SaleBean result = saleService.insert(bean);
						if(result==null) {
							errors.put("action", "Insert fail");
						} 
						request.getRequestDispatcher(
								"/Sale/sucess.jsp").forward(request, response);
					}
					
	}

}
