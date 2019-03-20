package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Invoice;
import model.InvoiceDetail;
import model.InvoiceRepository;
@WebServlet("/cart/checkout.html")

public class CartCheckoutController extends Controller {
	InvoiceRepository repository = new InvoiceRepository();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//HttpSession session = req.getSession();
	//Map<Integer, Cart> map = (Map<Integer, Cart>) session.getAttribute("cart");
	Map<Integer, Cart> map = getCart(req, resp);
	req.setAttribute("list", map.values());
	render("cart/checkout",req,resp);
	
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random rd = new Random();
		Long id = rd.nextLong();
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");
		Invoice obj = new Invoice(id, null, email, tel, address, (short)1);
		List<InvoiceDetail> list = new LinkedList<>();
		HttpSession session = req.getSession();
		Map<Integer, Cart> map = (Map<Integer, Cart>) session.getAttribute("cart");
		
		for(Cart o : map.values()) {
			InvoiceDetail detail = new InvoiceDetail(id, o.getProductId(), o.getPrice(), o.getQuantity());
			list.add(detail);
		}
		
		obj.setDetails(list);
		if(repository.add(obj)>0) {
			redirect("order/detail.html?id="+id,req,resp);
		}
		else {
			req.setAttribute("msg", "Check Out failed");
			doGet(req, resp);
		}
 	}
}
