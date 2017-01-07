package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


@WebServlet("/fbServlet")
public class fbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String facebookId;
     String Name;
     String email;
     String graph = null;
     String fbApi = "https://graph.facebook.com/me?";
     String fields = "fields=id,name,picture.height(400),email&";
     String access_token=null;
     
    public fbServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String code = request.getParameter("code");
		 System.out.println("fb request ok");
		 String token = null;
		 try {
			    //拿到一個web短授權
	            String g = "https://graph.facebook.com/v2.8/oauth/access_token?client_id=275346536213447&redirect_uri=http://localhost:8080/surround/fbServlet&client_secret=aaa57fedfe73c488731999c3f028b3cf&code=" + code;
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
		
	     
	        try {
	        	JSONObject json = new JSONObject(graph);
	            facebookId = json.getString("id");
	            Name = json.getString("name");
	            
	            email = json.getString("email");
	            System.out.println(facebookId);
	            System.out.println(Name);
	            System.out.println(email);
	        } catch (JSONException e) {
	             ;
	        }

	
}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
