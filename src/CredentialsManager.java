import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CredentialsManager {

	public final static String credentialsPath = "data\\usercredentials.txt";
	
	public static List<User> loadCredentials() throws FileNotFoundException {
		List<User> users = new ArrayList<>();
		
		File file = new File(credentialsPath);
		if (!file.exists()) throw new FileNotFoundException("ERR: file does not exist or invalid file path.");
		Scanner fileScanner = new Scanner(file);
		
		while (fileScanner.hasNextLine()) {
			
			String[] parts = parseCredentials(fileScanner.nextLine());
			
			User user = new User(parts[0], parts[1]);
			users.add(user);
		}
		
		fileScanner.close();
		return users;
	}

	private static String[] parseCredentials(String line) {
		String[] lineArray = line.split(" ");
		return lineArray;
	}
	
	public static boolean isPasswordValid(String password) {
		if (password.contains(" ") || password.length() < 5) return false;
		return true;
	}
	
	public static void saveCredentials() {
		try {
			FileWriter writer = new FileWriter(credentialsPath);
			
			for (User user : User.users) {
				writer.write(user.getUsername() + " " + user.getPassword() + "\n");
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Source: "Implementing Secure Password Hashing with SHA-256 in Java."
	public static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = md.digest(input.getBytes());

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