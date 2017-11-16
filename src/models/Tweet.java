package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tweet {
	private int id;
	private Date timestamp;
	private String message;
	private User user;
	private int numLikes;
	private int numRetweets;
	
	private static int nextTweetId;
	public static List<Tweet> tweets = new ArrayList<Tweet>();
	public static Map<Integer, Tweet> tweetsById = new HashMap<>();
	
	static {
		String msg = "I find your lack of faith disturbing.  Really long long long long long long long long long long sentence.";
		tweets.add(new Tweet(1, new Date(), msg, User.users.get(1)));
		msg = "I've got a bad feeling about this.";
		tweets.add(new Tweet(2, new Date(), msg, User.users.get(2)));
		msg = "Auuuureghhhhhheggghh!";
		tweets.add(new Tweet(3, new Date(), msg, User.users.get(3)));
		
		for (Tweet t : tweets) {
			tweetsById.put(t.getId(), t);
		}
		
		nextTweetId = 4;
	}
	
	public static void addTweet(User user, String message) {
		Tweet t = new Tweet(Tweet.nextTweetId++, new Date(), 
				message, user);
		Tweet.tweets.add(0, t);
		Tweet.tweetsById.put(t.getId(), t);
	}
	
	public Tweet() {
	}
	
	public Tweet(int id, Date timestamp, String message, User user) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.message = message;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
