package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class AddFlightWindow extends JFrame{
	private JTextField text_from;
	private JTextField text_to;
	private JTextField text_flightNO;
	private JTextField text_date;
	private JButton btn_next, btn_cancel;
	private JLabel lbl_from, lbl_to, lbl_flightNO, lbl_date, lbl_motivate;
	private JTextArea text_motivate;
	
	public AddFlightWindow() {
		getContentPane().setLayout(null);
		
		lbl_from = new JLabel("");
		lbl_from.setBounds(23, 23, 46, 14);
		getContentPane().add(lbl_from);
		
		lbl_to = new JLabel("");
		lbl_to.setBounds(23, 63, 46, 14);
		getContentPane().add(lbl_to);
		
		lbl_flightNO = new JLabel("");
		lbl_flightNO.setBounds(23, 104, 46, 14);
		getContentPane().add(lbl_flightNO);
		
		lbl_date = new JLabel("");
		lbl_date.setBounds(23, 138, 46, 14);
		getContentPane().add(lbl_date);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 245, 290, 62);
		getContentPane().add(scrollPane);
		
		text_motivate = new JTextArea();
		scrollPane.setViewportView(text_motivate);
		text_motivate.setWrapStyleWord(true);
		
		text_from = new JTextField();
		text_from.setBounds(90, 20, 207, 20);
		getContentPane().add(text_from);
		text_from.setColumns(10);
		
		text_to = new JTextField();
		text_to.setColumns(10);
		text_to.setBounds(90, 60, 207, 20);
		getContentPane().add(text_to);
		
		text_flightNO = new JTextField();
		text_flightNO.setColumns(10);
		text_flightNO.setBounds(90, 98, 207, 20);
		getContentPane().add(text_flightNO);
		
		text_date = new JTextField();
		text_date.setColumns(10);
		text_date.setBounds(90, 135, 207, 20);
		getContentPane().add(text_date);
		
		lbl_motivate = new JLabel("");
		lbl_motivate.setBounds(23, 220, 46, 14);
		getContentPane().add(lbl_motivate);
		
		btn_next = new JButton("");
		btn_next.setBounds(297, 323, 89, 23);
		getContentPane().add(btn_next);
		
		btn_cancel = new JButton("");
		btn_cancel.setBounds(198, 323, 89, 23);
		getContentPane().add(btn_cancel);
	}
	
	public void setListeners(ActionListener next, ActionListener cancel) {
		btn_cancel.addActionListener(cancel);
		btn_next.addActionListener(next);
	}
	
	public String getFrom() {
		return text_from.getText();
	}
	
	public String getTo() {
		return text_to.getText();
	}
	
	public String getFlightNO() {
		return text_flightNO.getText();
	}
	
	public String getDate() {
		return text_date.getText();
	}
	
	public String getMessageMoti() {
		return text_motivate.getText();
	}
	
	
	public void setLanguage(ResourceBundle rb) {
		lbl_date.setText(rb.getString("lbl_date"));
		lbl_from.setText(rb.getString("lbl_from"));
		lbl_to.setText(rb.getString("lbl_to"));
		lbl_motivate.setText(rb.getString("lbl_motivate"));
		lbl_flightNO.setText(rb.getString("lbl_flightNO"));
		
		btn_cancel.setText(rb.getString("btn_cancel"));
		btn_next.setText(rb.getString("btn_next"));
	}
}
