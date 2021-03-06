package controllers;


import java.io.IOException;
import java.util.Date;

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
		
		request.setAttribute("user", u);
		request.setAttribute("tweets", TweetDB.getAll());
		
		getServletContext().getRequestDispatcher("/feed.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String message = request.getParameter("message");
		Tweet tweet = new Tweet();
		tweet.setMessage(message);
		tweet.setUser(user);
		tweet.setTimestamp(new Date());
		
		TweetDB.insert(tweet);
		response.sendRedirect("feed");
	}

}
