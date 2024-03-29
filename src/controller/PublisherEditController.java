package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publisher;
import model.PublisherRepository;


@WebServlet("/publisher/edit.html")
public class PublisherEditController extends HttpServlet {
	PublisherRepository repository = new PublisherRepository();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	Publisher obj = repository.getPublisher(id);
	request.setAttribute("o", obj);
	request.getRequestDispatcher("/view/publisher/Edit.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Publisher obj = new Publisher(Integer.parseInt(request.getParameter("id")), request.getParameter("name"));
		if(repository.edit(obj)>0) {
			response.sendRedirect("/MVC/PublisherController");
		}
		else {
			request.setAttribute("msg","loi khong the cap nhat");
		doGet(request, response);
		}
	}
 
}
