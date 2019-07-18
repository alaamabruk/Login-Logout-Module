package com.log;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CheckDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		CheckDao dao =new CheckDao();
		
		if(dao.check(name, pass)) {
			HttpSession session =request.getSession();
			session.setAttribute("name", name);
			response.sendRedirect("welcome.jsp");
		}else {
		
			response.sendRedirect("index.jsp");
		}
		
		
		
	}

}
