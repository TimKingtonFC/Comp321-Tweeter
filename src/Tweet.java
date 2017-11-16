import java.util.Date;

public class Tweet {
	private Date timestamp;
	private String message;
	private User user;
	private int numLikes;
	private int numRetweets;
	
	static Tweet theTweet;
	static {
		User u = new User("Darth Vader", "@sithlord", "swvader.png");
		String msg = "I find your lack of faith disturbing.  Really long long long long long long long long long long sentence.";
		theTweet = new Tweet(new Date(), msg, u);
	}
	
	public Tweet() {
	}
	
	public Tweet(Date timestamp, String message, User user) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.user = user;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public int getNumLikes() {
		return numLikes;
	}

	public void setNumLikes(int numLikes) {
		this.numLikes = numLikes;
	}

	public int getNumRetweets() {
		return numRetweets;
	}

	public void setNumRetweets(int numRetweets) {
		this.numRetweets = numRetweets;
	}
}
