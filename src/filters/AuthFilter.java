package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {	
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;

		HttpSession session = httpRequest.getSession();
		User user = (User)session.getAttribute("user");
		
		String path = httpRequest.getRequestURI()
				.substring(httpRequest.getContextPath().length())
				.replaceAll("[/]+$", "");
		
		if (user == null && !path.startsWith("/login")) {
			httpResponse.sendRedirect("login.jsp");
		}
		else {
			chain.doFilter(request, response);
		}
	}

}
