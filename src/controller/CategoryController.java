package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.CategoryRepository;


@WebServlet("/CategoryController")
public class CategoryController extends Controller {
	CategoryRepository reposity = new CategoryRepository();
@Override
 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 		List<Category> list = reposity.getCategories();
	 		req.setAttribute("list", list);
	 		render("category/index",req,res);
	}

}
