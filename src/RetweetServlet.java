

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetweetServlet
 */
@WebServlet("/retweet")
public class RetweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tweet.theTweet.setNumRetweets(Tweet.theTweet.getNumRetweets() + 1);
		
		getServletContext().getRequestDispatcher("/feed")
				.forward(request, response);
	}
}
