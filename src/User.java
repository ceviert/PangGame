import java.util.List;

public class User {

	private String username;
	private String password;
	
	public static List<User> users;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public User register(String username, String password) throws UsernameAlreadyExistsException {
		for (User user: users){
			if (user.username.equals(username)) throw new UsernameAlreadyExistsException("ERR: this username is taken, please try another.");
		}
		
		return new User(username, password);
	}
}