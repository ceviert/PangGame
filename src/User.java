import java.util.HashMap;

public class User {

	private String username;
	private String password;
	
	public static HashMap<String, String> credentials = new HashMap<>();
	
	// about game
	private int time;
	private Date date;
	private int score;
	private int hp;
	
	private User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User register(String username, String password) throws UsernameAlreadyExistsException {
		for (String key : credentials.keySet()) {
			if (key.equals(username)) throw new UsernameAlreadyExistsException("ERR: this username is taken, please try another.");
		}
		
		return new User(username, password);
	}
}