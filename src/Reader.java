import java.io.FileNotFoundException;
import java.util.HashMap;

public abstract class Reader {

	public final static String dataPath = "data\\userdata.txt";
	public final static String credentialsPath = "data\\usercredentials.txt";
	
	private void saveToFile() {
		
	}

	protected abstract HashMap<String, String> loadCredentials() throws FileNotFoundException;
	
}