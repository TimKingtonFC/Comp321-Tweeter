package tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import models.Tweet;

public class TweetsTag extends BodyTagSupport {
	private static final long serialVersionUID = 1L;

	private List<Tweet> tweets;
	private Iterator<Tweet> iter;
	private Tweet tweet;
	
	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		tweets = (List<Tweet>)pageContext.getRequest().getAttribute("tweets");
		
		if (tweets.size() == 0) {
			return SKIP_BODY;
		}
		
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public void doInitBody() throws JspException {
		iter = tweets.iterator();
		tweet = iter.next();
		pageContext.setAttribute("tweet", tweet);
	}

	@Override
	public int doAfterBody() throws JspException {
		if (iter.hasNext()) {
			tweet = iter.next();
			pageContext.setAttribute("tweet", tweet);
			return EVAL_BODY_AGAIN;
		}
		
		try {
			JspWriter out = bodyContent.getEnclosingWriter();
			bodyContent.writeOut(out);
			return SKIP_BODY;
		}
		catch (IOException e) {
			return SKIP_BODY;
		}
	}
	
}
