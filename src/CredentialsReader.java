import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class CredentialsReader {

	public final static String credentialsPath = "data\\usercredentials.txt";
	
	public static HashMap<String, String> loadCredentials() throws FileNotFoundException {
		HashMap<String, String> credentials = new HashMap<>();
		
		File file = new File(credentialsPath);
		if (!file.exists()) throw new FileNotFoundException("ERR: file does not exist or invalid file path.");
		Scanner fileScanner = new Scanner(file);
		
		while (fileScanner.hasNextLine()) {
			
			String[] parts = parseCredentials(fileScanner.nextLine());
			
			credentials.put(parts[0], parts[1]);
		}
		
		fileScanner.close();
		return credentials;
	}

	private static String[] parseCredentials(String line) {
		String[] lineArray = line.split(" ");
		return lineArray;
	}
	
	public static void saveCredentials() throws IOException {
		FileWriter writer = new FileWriter(credentialsPath);
		
		for (Map.Entry<String, String> entry : User.credentials.entrySet()) {
			writer.write(entry.getKey() + " " + entry.getValue() + "\n");
		}
		
		writer.close();
	}
}