package controllers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.TweetDB;
import models.Tweet;
import models.User;

@WebServlet("/feed")
public class FeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		if (u == null) {
			response.sendRedirect("login.jsp");
			return;
		}
	
		request.setAttribute("user", u);
		request.setAttribute("tweets", TweetDB.getAll());
		
		getServletContext().getRequestDispatcher("/feed.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		String message = request.getParameter("message");
		Tweet tweet = new Tweet();
		tweet.setMessage(message);
		tweet.setUser(user);
		
		TweetDB.insert(tweet);
		response.sendRedirect("feed");
	}

}
