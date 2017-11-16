

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedServlet")
public class FeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User("Darth Vader", "@sithlord", "swvader.png");
		String msg = "I find your lack of faith disturbing.  Really long long long long long long long long long long sentence.";
		Tweet t = new Tweet(new Date(), msg, u);

		request.setAttribute("tweet", t);
		
		getServletContext().getRequestDispatcher("/feed.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("message"));
	}

}
