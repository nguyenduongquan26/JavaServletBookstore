package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberRepository;

@WebServlet("/auth/logon.html")
public class AuthLogonController extends Controller {
	MemberRepository repository = new MemberRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		render("auth/logon", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		Member obj = new Member(user, pass);
		if(repository.LogOn(obj)>0) {
			HttpSession session = req.getSession();
			session.setAttribute("userLogin", obj);
			redirect("home.html", req, resp);
		}
		else {
			req.setAttribute("msg", "Dang nhap sai");
			doGet(req, resp);
		}
	}
	
}
