package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductRepository;


@WebServlet("/home/search.html")
public class HomeSearchController extends Controller {
	ProductRepository repository = new ProductRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String q = req.getParameter("q");
		req.setAttribute("list", repository.searchProduct(q));
		render("home/search",req,resp);
	}

}
