package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.CategoryRepository;

@WebServlet("/CategoryAddController")
public class CategoryAddController extends Controller {
	CategoryRepository repository = new CategoryRepository();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setAttribute("parents", repository.getParents());
	render("category/add",req, resp);
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Category obj = new Category(0,req.getParameter("name"),Integer.parseInt(req.getParameter("parent")));
	
	if(repository.add(obj)>0) {
		redirect("CategoryController",req, resp);
	}
	else {
		req.setAttribute("msg", "Loi khong them duoc");
		doGet(req, resp);
	}
	
}
}
