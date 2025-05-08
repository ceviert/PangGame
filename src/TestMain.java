import java.io.FileNotFoundException;
import java.util.Map;

public class TestMain {

	public static void main(String[] args)  {
		
		Reader reader = new CredentialsReader(Reader.credentialsPath);
		
		try {
			User.credentials = reader.loadCredentials();
			
			for (Map.Entry<String, String> entry : User.credentials.entrySet()) {
				System.out.println(entry.getKey() + entry.getValue());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}