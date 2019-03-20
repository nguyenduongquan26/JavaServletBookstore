package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Publisher;
import model.PublisherRepository;


@WebServlet("/PublisherController")
public class PublisherController extends Controller {

		PublisherRepository repository = new PublisherRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				List<Publisher> ret = repository.getPublisher();
				
				request.setAttribute("list",ret);
				render("publisher/index",request,response);
				//request.getRequestDispatcher("/view/publisher/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] arr = request.getParameterValues("del");
		List<Integer> list = new ArrayList<>(arr.length);
		for(String item:arr) {
			list.add(Integer.parseInt(item));
		}
		if(repository.delete(list)!=null) {
			redirect("PublisherController", request, response);
		//	response.sendRedirect("/MVC/PublisherController");
		}
		else {
		request.setAttribute("msg", "Loi khong the xoa");
		doGet(request, response);
	}
}
}
