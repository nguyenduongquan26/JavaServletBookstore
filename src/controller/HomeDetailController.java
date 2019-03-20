package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductRepository;


@WebServlet("/home/detail")
public class HomeDetailController extends Controller {
	ProductRepository repository = new ProductRepository();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("o", repository.getProduct(id));
		render("home/detail",request,response);
	}

}


