import java.util.List;

public class User {

	private String username;
	private String password;

	public static List<User> users;
	public static User currentUser = null;

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

	public static void register(String username, char[] password)
			throws UsernameAlreadyExistsException, InvalidPasswordException {
		try {
			for (User user : users) {
				if (user.username.equals(username))
					throw new UsernameAlreadyExistsException("ERR: this username is taken, please try another.");
			}
			
			if (!CredentialsManager.isPasswordValid(password)) throw new InvalidPasswordException("ERR: Invalid password.");

			users.add(new User(username, CredentialsManager.hash(password)));
			CredentialsManager.saveCredentials();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public static void login(String username, char[] password) throws NullPointerException, InvalidUsernameException, InvalidPasswordException{
		if (users == null) throw new NullPointerException();
		for (User user : users) {
			if (user.username.equals(username)) {
				if (user.password.equals(CredentialsManager.hash(password))) {
					currentUser = user;
					return;
				}
				else throw new InvalidPasswordException("ERR: invalid password.");
			}
		}
		throw new InvalidUsernameException("ERR: invalid username.");
	}
}