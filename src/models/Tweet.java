package models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tweet {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	private String message;
	
	@ManyToOne
	private User user;
	
	private int numLikes;
	private int numRetweets;
	
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
