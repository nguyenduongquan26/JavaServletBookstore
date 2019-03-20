package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryRepository;
import model.ProductRepository;

@WebServlet("/home/browser.html")
public class HomeBrowserController extends Controller {
	ProductRepository repository = new ProductRepository();
	CategoryRepository carepository = new CategoryRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("o", carepository.getCategories(id));
		req.setAttribute("list", repository.getProducts(id));
		render("home/browser", req, resp);
	}
}
