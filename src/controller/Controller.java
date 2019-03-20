package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import jdk.internal.dynalink.support.ClassLoaderGetterContextProvider;
import model.Cart;


public class Controller extends HttpServlet {
	
	
	protected Map<Integer, Cart> getCart(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");
		if(obj != null) {
			return (Map<Integer, Cart>)obj;
		}
		return new HashMap<>();
	}
	
	protected static List<String> upload(Collection<Part> parts,String root) throws IOException{
		List<String> list = new LinkedList<>();
		for(Part part: parts) {
			list.add(upload(part, root));
		}
		return list;
	}
	
	
	protected static String upload(Part part,String root) throws IOException {
		
		InputStream is = part.getInputStream();
		FileOutputStream op = new FileOutputStream(new File(root+part.getSubmittedFileName()));
		byte[] bytes = new byte[1024];
		int len;
		while((len = is.read(bytes,0 ,1024))>0) {
			op.write(bytes, 0, len);
		}
		op.close();
		is.close();
		return part.getSubmittedFileName();
	}
	
	
	protected static String root(HttpServletRequest request,String name) {
		return request.getServletContext().getRealPath(name);
	}
	
	
	protected void render(String view,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/"+ view + ".jsp").forward(request, response);
	}
	
	
	protected void redirect(String location,HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath()+"/"+location);
	}
}
