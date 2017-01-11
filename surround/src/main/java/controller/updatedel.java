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

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.ProductBean;
import model.SaleBean;
import model.SaleService;

@MultipartConfig
@WebServlet("/updatedel")
public class updatedel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SaleService saleService;
	private SimpleDateFormat sdFormat = null;  
	String filename=null;
	SaleBean salebean=null;
    public updatedel() {
        super();

    }
	@Override
	public void init() throws ServletException {
		sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		ServletContext application = this.getServletContext();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		saleService = (SaleService) context.getBean("saleService");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("joe");
		
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
							FileOutputStream out = new FileOutputStream("C:/EEIT/EEIT90Project/repository/surround/src/main/webapp/img/" + filename);
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
							errors.put("sale_time", "請輸入 YYYY-MM-DD");
						} 
					}
					
					if(errors!=null && !errors.isEmpty()) {
						
						request.getRequestDispatcher(
								"/Sale/updateView.jsp").forward(request, response);
						return;
					}

			HttpSession session=request.getSession(false);
				if(session!=null){
				salebean=(SaleBean)session.getAttribute("update");
				}
					Set<ProductBean> product = new HashSet<ProductBean>();
					
					for(ProductBean bean:salebean.getProductBean()){					
						bean.setProduct_pic("/img/"+filename);
						bean.setProduct_name(product_name);
						bean.setProduct_price(product_price);
						bean.setProduct_memo(product_memo);	
						System.out.println(bean.getProduct_memo());
						product.add(bean);
		
					}
					salebean.setSale_topic(sale_topic);
					salebean.setSale_name(sale_name);
					salebean.setSale_locate(sale_locate);
					salebean.setSale_time(date);
					salebean.setSale_memo(sale_memo);
					salebean.setSale_status(1);//讓擺攤狀態存在
					salebean.setProductBean(product);

				if("更新".equals(sale)) {
					System.out.println("");
					SaleBean result = saleService.update(salebean);
					if(result==null) {
						errors.put("action", "Update fail");
					} 
					request.getRequestDispatcher(
							"/Sale/update.jsp").forward(request, response);
				}
				if("刪除".equals(sale)) {
					
					SaleBean result = saleService.update(salebean);
				}
				
		
	}


}

