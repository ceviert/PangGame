import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CredentialsManager {

	private final static String CREDENTIALS_PATH = "data\\usercredentials.txt";
	private final static String CREDENTIALS_SPLITTER = " ";
	
	
	public static List<User> loadCredentials() throws FileNotFoundException {
		List<User> users = new ArrayList<>();
		
		File file = new File(CREDENTIALS_PATH);
		if (!file.exists()) throw new FileNotFoundException("ERR: file does not exist or invalid file path.");
		Scanner fileScanner = new Scanner(file);
		
		while (fileScanner.hasNextLine()) {
			
			String[] parts = fileScanner.nextLine().split(CREDENTIALS_SPLITTER);
			
			User user = new User(parts[0], parts[1]);
			users.add(user);
		}
		
		fileScanner.close();
		return users;
	}
	
	public static boolean isPasswordValid(char[] password) {
	    if (password.length < 5) return false;

	    for (char c : password) {
	        if (c == ' ') return false;
	    }

	    return true;
	}

	
	public static void saveCredentials() {
		try {
			FileWriter writer = new FileWriter(CREDENTIALS_PATH);
			
			for (User user : User.users) {
				writer.write(user.getUsername() + " " + user.getPassword() + "\n");
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Source: "Implementing Secure Password Hashing with SHA-256 in Java."
	public static String hash(char[] password) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");

	        byte[] passwordBytes = new String(password).getBytes(StandardCharsets.UTF_8);

	        byte[] hashBytes = md.digest(passwordBytes);

	        StringBuilder hexString = new StringBuilder();
	        for (byte b : hashBytes) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();

	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException("SHA-256 algorithm not found!", e);
	    }
	}
}