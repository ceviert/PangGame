import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CredentialsReader extends Reader {

	private String path;
	
	public CredentialsReader(String path) {
		this.path = path;
	}
	
	public HashMap<String, String> loadCredentials() throws FileNotFoundException {
		HashMap<String, String> credentials = new HashMap<>();
		
		
		File file = new File(path);
		if (!file.exists()) throw  new FileNotFoundException("ERR: file does not exist or invalid file path.");
		Scanner fileScanner = new Scanner(file);
		
		while (fileScanner.hasNextLine()) {
			
			String[] parts = parseCredentials(fileScanner.nextLine());
			
			credentials.put(parts[0], parts[1]);
		}
		
		fileScanner.close();
		return credentials;
	}

	private String[] parseCredentials(String line) {
		String[] lineArray = line.split(" ");
		return lineArray;
	}
	
	public void saveCredentials() {
		
	}
}