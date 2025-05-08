import java.io.FileNotFoundException;
import java.util.HashMap;

public class UserDataReader extends Reader {

	private String path;
	
	public UserDataReader(String path) {
		this.path = path;
	}

	@Override
	protected HashMap<String, String> loadCredentials() throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}