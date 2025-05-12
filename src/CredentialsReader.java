import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CredentialsReader {

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
}