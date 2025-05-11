import java.io.FileNotFoundException;
import java.util.Map;

public class TestMain {

	public static void main(String[] args)  {
		
		try {
			User.credentials = CredentialsReader.loadCredentials();
			
			for (Map.Entry<String, String> entry : User.credentials.entrySet()) {
				System.out.println(entry.getKey() + entry.getValue());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}