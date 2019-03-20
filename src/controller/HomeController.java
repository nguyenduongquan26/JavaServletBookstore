package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategoryRepository;
import model.Member;
import model.ProductRepository;

@WebServlet("/home.html")
public class HomeController extends Controller {
	int pageSize = 6;
	ProductRepository repository = new ProductRepository();
	CategoryRepository categoryrepository = new CategoryRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = repository.count();
		int n = (int) Math.ceil(total/(double)pageSize);
		req.setAttribute("total", total);
		req.setAttribute("n", n);
		int p =1;
		if(req.getParameter("p")!=null) {
			p = Integer.parseInt(req.getParameter("p"));
		}
		int pageIndex = (p-1)*pageSize;
		
		HttpSession session = req.getSession();
		if(session.getAttribute("userLogin")!=null) {
		Member member = (Member) session.getAttribute("userLogin");
		req.setAttribute("user", member.getUsername());
		}
		req.setAttribute("categories", categoryrepository.getCategories2());
		req.setAttribute("list", repository.getProducts(pageIndex,pageSize));
		render("home/index",req,resp);
	}
}
