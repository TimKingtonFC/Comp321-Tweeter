package controllers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.UserDB;
import models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "login.jsp";
		
		String username = request.getParameter("username");
		
		User u = UserDB.getByName(username);
		if (u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			nextPage = "feed";
		}
		
		response.sendRedirect(nextPage);
	}
}
