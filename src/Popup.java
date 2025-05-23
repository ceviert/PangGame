import java.awt.Component;
import javax.swing.JOptionPane;

public abstract class Popup {

	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_USERNAME_ERROR = 1;
	public static final int PASSWORD_ERROR = 2;
	public static final int REGISTER_SUCCESS= 3;
	public static final int REGISTER_USERNAME_ERROR = 4;
	
	public static void init(Component parent, int type) {
		switch (type) {
		case LOGIN_SUCCESS:
			JOptionPane.showMessageDialog(parent, "Login success! Welcome to Pang!", null, JOptionPane.PLAIN_MESSAGE);
			break;
		case LOGIN_USERNAME_ERROR:
			JOptionPane.showMessageDialog(parent, "Username doesn't exists!", null, JOptionPane.ERROR_MESSAGE);
			break;
		case PASSWORD_ERROR:
			JOptionPane.showMessageDialog(parent, "Invalid password!", null, JOptionPane.ERROR_MESSAGE);
			break;
		case REGISTER_SUCCESS:
			JOptionPane.showMessageDialog(parent, "Register success! Now you can login!", null, JOptionPane.PLAIN_MESSAGE);
			break;
		case REGISTER_USERNAME_ERROR:
			JOptionPane.showMessageDialog(parent, "This username is taken, try another one.", null, JOptionPane.WARNING_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(parent, "Unknown error.", null, JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
	
}