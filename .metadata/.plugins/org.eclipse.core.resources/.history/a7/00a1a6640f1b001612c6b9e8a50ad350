package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class UserDetailWindow extends JFrame {
	private JTextField text_name;
	private JTextField text_surname;
	private JTextField text_phone;
	private JTextField text_birth;
	private JTextField text_socialMedia;
	private JLabel lbl_name, lbl_surname, lbl_phone, lbl_birth, lbl_socialMedia;
	private JButton btn_close;
	private JTextArea text_motivation;
	private JLabel lbl_motivate;
	public UserDetailWindow() {
		getContentPane().setLayout(null);
		
		lbl_name = new JLabel("New label");
		lbl_name.setBounds(32, 22, 106, 14);
		getContentPane().add(lbl_name);
		
		lbl_surname = new JLabel("New label");
		lbl_surname.setBounds(32, 72, 106, 14);
		getContentPane().add(lbl_surname);
		
		lbl_phone = new JLabel("New label");
		lbl_phone.setBounds(32, 128, 106, 14);
		getContentPane().add(lbl_phone);
		
		lbl_birth = new JLabel("New label");
		lbl_birth.setBounds(32, 178, 106, 14);
		getContentPane().add(lbl_birth);
		
		lbl_socialMedia = new JLabel("New label");
		lbl_socialMedia.setBounds(345, 22, 96, 14);
		getContentPane().add(lbl_socialMedia);
		
		lbl_motivate = new JLabel("New label");
		lbl_motivate.setBounds(32, 210, 106, 14);
		getContentPane().add(lbl_motivate);
		
		text_name = new JTextField();
		text_name.setBounds(165, 19, 140, 20);
		getContentPane().add(text_name);
		text_name.setColumns(10);
		
		text_surname = new JTextField();
		text_surname.setColumns(10);
		text_surname.setBounds(165, 69, 140, 20);
		getContentPane().add(text_surname);
		
		text_phone = new JTextField();
		text_phone.setColumns(10);
		text_phone.setBounds(165, 125, 140, 20);
		getContentPane().add(text_phone);
		
		text_birth = new JTextField();
		text_birth.setColumns(10);
		text_birth.setBounds(165, 175, 140, 20);
		getContentPane().add(text_birth);
		
		text_socialMedia = new JTextField();
		text_socialMedia.setColumns(10);
		text_socialMedia.setBounds(465, 19, 140, 20);
		getContentPane().add(text_socialMedia);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 235, 396, 41);
		getContentPane().add(scrollPane);
		
		text_motivation = new JTextArea();
		scrollPane.setViewportView(text_motivation);
		
		btn_close = new JButton("New button");
		btn_close.setBounds(516, 266, 89, 23);
		getContentPane().add(btn_close);
	}
	
	public void setLanguage(ResourceBundle rb) {
		lbl_birth.setText(rb.getString("lbl_birth"));
		lbl_name.setText(rb.getString("lbl_name"));
		lbl_phone.setText(rb.getString("lbl_phone"));
		lbl_socialMedia.setText(rb.getString("lbl_socialMedia"));
		lbl_surname.setText(rb.getString("lbl_surname"));
		lbl_motivate.setText(rb.getString("lbl_motivate"));
		
		btn_close.setText(rb.getString("btn_close"));
	}
	
	public void setListeners(ActionListener close) {
		btn_close.addActionListener(close);
	}
	
}
