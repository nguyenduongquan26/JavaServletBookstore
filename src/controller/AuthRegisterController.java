package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberRepository;
import util.Helper;

@WebServlet("/auth/register.html")
public class AuthRegisterController extends Controller {
	MemberRepository repository = new MemberRepository();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			render("auth/register", req, resp);
			
		}
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String user = req.getParameter("user");
			String pass = req.getParameter("pass");
			String email = req.getParameter("email");
			String fullname = req.getParameter("name");
			byte gender = Byte.parseByte(req.getParameter("gender"));
			Member obj = new Member(Helper.randomLong(), user, pass, email, fullname, gender);
			if(repository.add(obj)>0) {
				HttpSession session = req.getSession();
				session.setAttribute("userLogin", obj);
				redirect("/auth/logon.html", req, resp);
			}
			else {
				req.setAttribute("msg", "Dang ki khong thanh cong");
				doGet(req, resp);
			}
		}
}
