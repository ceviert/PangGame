import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class TestMain {

	public static void main(String[] args) throws FileNotFoundException {

		User.users = CredentialsManager.loadCredentials();
		LoginDialog.init();
			
	}

}