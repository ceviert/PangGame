import java.io.FileNotFoundException;

public class TestMain {

	public static void main(String[] args) throws FileNotFoundException {

		User.users = CredentialsManager.loadCredentials();
		LoginDialog.init();
			
	}

}