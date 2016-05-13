package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame{
	private JTextField text_login;
	private JPasswordField text_password;
	private JLabel lbl_login, lbl_password;
	private JButton btn_login, btn_register;
	private JButton btn_close;
	public LoginWindow() {
		setSize(322, 248);
		getContentPane().setBackground(new Color(245, 222, 179));
		getContentPane().setLayout(null);
		
		lbl_login = new JLabel("");
		lbl_login.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_login.setBounds(10, 25, 46, 33);
		getContentPane().add(lbl_login);
		
		lbl_password = new JLabel("");
		lbl_password.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_password.setBounds(10, 69, 60, 14);
		getContentPane().add(lbl_password);
		
		text_login = new JTextField();
		text_login.setBackground(Color.WHITE);
		text_login.setBounds(89, 31, 142, 20);
		getContentPane().add(text_login);
		text_login.setColumns(10);
		
		text_password = new JPasswordField();
		text_password.setBounds(89, 65, 142, 22);
		getContentPane().add(text_password);
		
		btn_login = new JButton("");
		btn_login.setBackground(Color.WHITE);
		
		
		btn_login.setBounds(205, 140, 91, 22);
		getContentPane().add(btn_login);
		
		btn_register = new JButton("");
		btn_register.setBounds(205, 173, 91, 23);
		getContentPane().add(btn_register);
		
		btn_close = new JButton("New button");
		btn_close.setBounds(10, 173, 89, 23);
		getContentPane().add(btn_close);
	}
	
	public void setLanguage(ResourceBundle rb) {
		lbl_login.setText(rb.getString("lbl_login"));
		lbl_password.setText(rb.getString("lbl_password"));
		
		btn_close.setText(rb.getString("btn_close"));
		btn_login.setText(rb.getString("btn_login"));
		btn_register.setText(rb.getString("btn_register"));
	}
	
	public void setListeners(ActionListener login, ActionListener register, ActionListener close) {
		btn_login.addActionListener(login);
		btn_register.addActionListener(register);
		btn_close.addActionListener(close);
	}
}
