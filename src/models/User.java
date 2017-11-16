package models;
import java.util.HashMap;
import java.util.Map;

public class User {
	private String name;
	private String username;
	private String avatarUrl;
	
	public static Map<Integer, User> users = new HashMap<>();
	static {
		users.put(1, new User("Darth Vader", "@sithlord", "swvader.png"));
		users.put(2, new User("Han Solo", "@nerfherder", "swhan.png"));
		users.put(3, new User("Chewy", "@chewy", "swchewy.png"));
		users.put(4, new User("Rey", "@rey", "swrey.png"));	
	};
	
	public User() {
	}
	
	public User(String name, String username, String avatarUrl) {
		super();
		this.name = name;
		this.username = username;
		this.avatarUrl = avatarUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
}
