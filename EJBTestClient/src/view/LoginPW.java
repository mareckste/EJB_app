package view;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginPW extends JFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	public LoginPW() {
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		JLabel lbl_login = new JLabel("Login");
		lbl_login.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_login.setBounds(10, 25, 46, 33);
		getContentPane().add(lbl_login);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_password.setBounds(10, 69, 60, 14);
		getContentPane().add(lbl_password);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(89, 31, 142, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(89, 65, 142, 22);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MareCK\\Desktop\\Apps-Dialog-Logout-icon (1).png"));
		
		
		btnNewButton.setBounds(205, 140, 91, 22);
		getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(205, 173, 91, 23);
		getContentPane().add(btnRegister);
	}
}
