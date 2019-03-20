package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publisher;
import model.PublisherRepository;


@WebServlet("/PublisherAddController")
public class PublisherAddController extends HttpServlet {
	PublisherRepository repository = new PublisherRepository();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/publisher/add.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Publisher obj = new Publisher(0, request.getParameter("name"));
		repository.add(obj);
		response.sendRedirect("/MVC/PublisherController");
		//doGet(request, response);
	}

}
