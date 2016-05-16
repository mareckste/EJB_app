package controll;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.UIManager;

import view.FlightDetailWindow;
import view.LoginWindow;
import view.UserDetailWindow;

public class testGUI {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserDetailWindow l = new UserDetailWindow();
		ResourceBundle rb = ResourceBundle.getBundle("Location", new Locale("en"));
		l.setLanguage(rb);
		l.setVisible(true);
	}

}
