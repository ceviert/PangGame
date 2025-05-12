import javax.swing.JOptionPane;

public class TestMain {

	public static void main(String[] args)  {

		String string = JOptionPane.showInputDialog("your balls will exlplode");
		JOptionPane.showMessageDialog(null, "you have no where to run, no option", string, JOptionPane.NO_OPTION);
		
		
	}
	
}