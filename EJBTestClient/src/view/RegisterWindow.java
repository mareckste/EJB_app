package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class RegisterWindow extends JFrame{
	private JLabel lbl_name, lbl_surname, lbl_birth, lbl_phone, lbl_socialMedia;
	private JButton btn_next;
	private JTextField text_name;
	private JTextField text_surname;
	private JTextField text_birth;
	private JTextField text_phone;
	private JTextField text_socialMedia;
	private JButton btn_cancel;
	private JLabel label;
	private JLabel lblRegistration;
	private JLabel label_1;
	
	public RegisterWindow() {
		getContentPane().setBackground(new Color(240, 248, 255));
		setTitle("Register");
		getContentPane().setLayout(null);
		
		lbl_name = new JLabel("Name:");
		lbl_name.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lbl_name.setBounds(158, 24, 77, 14);
		getContentPane().add(lbl_name);
		
		lbl_surname = new JLabel("Surname:");
		lbl_surname.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lbl_surname.setBounds(158, 58, 77, 14);
		getContentPane().add(lbl_surname);
		
		lbl_birth = new JLabel("Date of birth:");
		lbl_birth.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lbl_birth.setBounds(158, 89, 77, 14);
		getContentPane().add(lbl_birth);
		
		lbl_phone = new JLabel("Phone:");
		lbl_phone.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lbl_phone.setBounds(158, 147, 77, 14);
		getContentPane().add(lbl_phone);
		
		lbl_socialMedia = new JLabel("Facebook:");
		lbl_socialMedia.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lbl_socialMedia.setBounds(158, 178, 77, 14);
		getContentPane().add(lbl_socialMedia);
		
		text_name = new JTextField();
		text_name.setBounds(251, 21, 139, 20);
		getContentPane().add(text_name);
		text_name.setColumns(10);
		
		text_surname = new JTextField();
		text_surname.setColumns(10);
		text_surname.setBounds(251, 52, 139, 20);
		getContentPane().add(text_surname);
		
		text_birth = new JTextField();
		text_birth.setColumns(10);
		text_birth.setBounds(251, 83, 139, 20);
		getContentPane().add(text_birth);
		
		text_phone = new JTextField();
		text_phone.setColumns(10);
		text_phone.setBounds(251, 144, 139, 20);
		getContentPane().add(text_phone);
		
		text_socialMedia = new JTextField();
		text_socialMedia.setColumns(10);
		text_socialMedia.setBounds(251, 175, 139, 20);
		getContentPane().add(text_socialMedia);
		
		btn_next = new JButton("Confirm");
		btn_next.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		btn_next.setBounds(276, 213, 114, 40);
		getContentPane().add(btn_next);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		btn_cancel.setBounds(20, 213, 114, 40);
		getContentPane().add(btn_cancel);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\plane-icon.png"));
		label_1.setBounds(39, 11, 38, 60);
		getContentPane().add(label_1);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\tasks.png"));
		label.setBounds(20, 27, 128, 134);
		getContentPane().add(label);
		
		lblRegistration = new JLabel("Contact and social media:");
		lblRegistration.setFont(new Font("Microsoft JhengHei UI", Font.BOLD | Font.ITALIC, 13));
		lblRegistration.setBounds(158, 122, 181, 14);
		getContentPane().add(lblRegistration);
	}
	
	public String getTextName() {
		return text_name.getText();
	}
	
	public String getTextSurname() {
		return text_surname.getText();
	}
	
	public String getTextPhone() {
		return text_phone.getText();
	}
	
	public String getTextSocial() {
		return text_socialMedia.getText();
	}
	
	public void setLanguage(ResourceBundle rb) {
		lbl_birth.setText(rb.getString("lbl_birth"));
		lbl_name.setText(rb.getString("lbl_name"));
		lbl_phone.setText(rb.getString("lbl_phone"));
		lbl_socialMedia.setText(rb.getString("lbl_socialMedia"));
		lbl_surname.setText(rb.getString("lbl_surname"));
		
		btn_cancel.setText(rb.getString("btn_cancel"));
		btn_next.setText(rb.getString("btn_next"));
	}
	
	public void setListeners(ActionListener next, ActionListener cancel) {
		btn_next.addActionListener(next);
		btn_cancel.addActionListener(cancel);
	}
}
