package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthorRepository;
import model.CategoryRepository;
import model.Product;
import model.ProductRepository;
import model.PublisherRepository;
@MultipartConfig
@WebServlet("/product/add.html")
public class ProductAddController extends Controller{
	CategoryRepository catRepository = new CategoryRepository();
	PublisherRepository pubRepository = new PublisherRepository();
	AuthorRepository autRepository = new AuthorRepository();
	ProductRepository proRepository = new ProductRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("categories", catRepository.getCategories());
		req.setAttribute("publisher", pubRepository.getPublisher());
		req.setAttribute("authors", autRepository.getAuthors());
		render("product/add", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		int publisherId = Integer.parseInt(req.getParameter("publisherId"));
		int authorId = Integer.parseInt(req.getParameter("authorId"));
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		short pages = Short.parseShort(req.getParameter("pages"));
		short year = Short.parseShort(req.getParameter("year"));
		String weight = req.getParameter("weight");
		String size = req.getParameter("size");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		int price = Integer.parseInt(req.getParameter("price"));
		String imageUrl = upload(req.getPart("image"), root(req, "/upload/"));
		
		Product obj = new Product(0, categoryId, authorId, publisherId, isbn, title, pages, year, weight, size, content, imageUrl, description, price);
	
		if(proRepository.add(obj)>0) {
			redirect("product.html", req, resp);
		}else {
			req.setAttribute("msg", "Loi");
			doGet(req, resp);
		}
	}
}
