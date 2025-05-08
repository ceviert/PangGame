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
}