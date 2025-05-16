import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {

	private static JPanel mainPanel;
	private JPanel userPanel;
	private JPanel passPanel;
	private JPanel buttonPanel;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton loginButton;
	private JButton registerButton;
	
	public LoginDialog() {
		
		setTitle("Login to PangGame");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(350, 140);
		setLocationRelativeTo(null);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		userPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		usernameLabel = new JLabel("Username: ");
		usernameField = new JTextField(10);
		userPanel.add(usernameLabel);
		userPanel.add(usernameField);
		
		passPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		passwordLabel = new JLabel("Password: ");
		passwordField = new JPasswordField(10);
		passPanel.add(passwordLabel);
		passPanel.add(passwordField);
		
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		loginButton = new JButton("Login");
		registerButton = new JButton("Register");
		buttonPanel.add(loginButton);
		buttonPanel.add(registerButton);
		
		mainPanel.add(userPanel);
		mainPanel.add(passPanel);
		mainPanel.add(buttonPanel);
		
		add(mainPanel);
		
		LoginHandler handler = new LoginHandler();
		usernameField.addActionListener(handler);
		passwordField.addActionListener(handler);
		loginButton.addActionListener(handler);
		registerButton.addActionListener(handler);
	}
	
	public static void init() {
		LoginDialog dialog = new LoginDialog();
		dialog.setVisible(true);
	}
	
	private class LoginHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			Object source = event.getSource();
			
			if (source == loginButton || source == usernameField || source == passwordField ) {
				try {
					User.login(usernameField.getText(), passwordField.getPassword());
					Popup.init(LoginDialog.this, Popup.LOGIN_SUCCESS);
					dispose();
				} catch (NullPointerException | InvalidUsernameException error) {
					System.out.println(error.getMessage());
					Popup.init(LoginDialog.this, Popup.LOGIN_USERNAME_ERROR);
				} catch (InvalidPasswordException error) {
					System.out.println(error.getMessage());
					Popup.init(LoginDialog.this, Popup.PASSWORD_ERROR);
				}
			}
			else if (source == registerButton) {
				try {
					User.register(usernameField.getText(), passwordField.getPassword());
					Popup.init(LoginDialog.this, Popup.REGISTER_SUCCESS);
				} catch (UsernameAlreadyExistsException error) {
					System.out.println(error.getMessage());
					Popup.init(LoginDialog.this, Popup.REGISTER_USERNAME_ERROR);
				} catch (InvalidPasswordException error) {
					System.out.println(error.getMessage());
					Popup.init(LoginDialog.this, Popup.PASSWORD_ERROR);
				}
			}
			
		}
		
	}
	
}