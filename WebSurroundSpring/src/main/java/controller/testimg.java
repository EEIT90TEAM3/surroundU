package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.omg.CORBA.portable.OutputStream;

@MultipartConfig
@WebServlet("/testimg")
public class testimg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public testimg() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Part part=request.getPart("photo");
		String header=part.getHeader("Content-Disposition");
		String filename=header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
		InputStream in=part.getInputStream();
		FileOutputStream out=new FileOutputStream("C:/EEIT/jpg/"+filename);
		byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
	}

}
