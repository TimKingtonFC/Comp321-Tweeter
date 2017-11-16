
public class User {
	private String name;
	private String username;
	private String avatarUrl;
	
	public static User [] users = new User[] {
		new User("Darth Vader", "@sithlord", "swvader.png"),
		new User("Han Solo", "@nerfherder", "swhan.png")	
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
