import java.util.Date;

public class Tweet {
	private Date timestamp;
	private String message;
	private User user;
	
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
}
