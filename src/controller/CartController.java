package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.Cart;
import model.Product;
import model.ProductRepository;

@WebServlet("/cart.html")
public class CartController extends Controller{
	ProductRepository repository = new ProductRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<Integer, Cart> map = getCart(req, resp);
		
		
		req.setAttribute("list", map.values());
		render("cart/index",req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		short qty = Short.parseShort(req.getParameter("quantity"));
		Product obj =  repository.getProduct(id);
		
		
		//Cart cart = new Cart(id, qty, obj.getTitle(),obj.getPrice() , obj.getImageURL());
		//HttpSession session = req.getSession();
		//Map<Integer, Cart> map = null;
		
	//	if(session.getAttribute("cart")!=null) {
		//	map = (Map<Integer, Cart>)session.getAttribute("cart");
		//}
		//else {
		//map = new HashMap<>();
		//}
		Map<Integer, Cart> map = getCart(req, resp);
		if(map.containsKey(id)) {
			//tang so luong
			Cart p =  map.get(id);
			p.increaseQuantity(qty);
		}else {
			Cart cart = new Cart(id, qty, obj.getTitle(),obj.getPrice() , obj.getImageURL());
			//dua vao gio hang
			map.put(id, cart);
		}
		HttpSession session = req.getSession();
		session.setAttribute("cart", map);
		
		doGet(req, resp);
		
	}

}
