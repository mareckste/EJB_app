package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class FlightDetailWindow extends JFrame {
	private JTextField text_from;
	private JTextField text_to;
	private JTextField text_flightNO;
	private JTextField text_date;
	private JTable table;
	private JLabel lbl_from, lbl_to, lbl_date, lbl_flightNO, lbl_partners;
	private JButton btn_close, btn_showPartner;
	
	
	public FlightDetailWindow() {
		getContentPane().setLayout(null);
		
		lbl_from = new JLabel("New label");
		lbl_from.setBounds(29, 23, 46, 14);
		getContentPane().add(lbl_from);
		
		lbl_to = new JLabel("New label");
		lbl_to.setBounds(29, 70, 46, 14);
		getContentPane().add(lbl_to);
		
		lbl_flightNO = new JLabel("New label");
		lbl_flightNO.setBounds(29, 119, 46, 14);
		getContentPane().add(lbl_flightNO);
		
		lbl_date = new JLabel("New label");
		lbl_date.setBounds(29, 170, 46, 14);
		getContentPane().add(lbl_date);
		
		text_from = new JTextField();
		text_from.setEditable(false);
		text_from.setEnabled(false);
		text_from.setBounds(105, 20, 137, 20);
		getContentPane().add(text_from);
		text_from.setColumns(10);
		
		text_to = new JTextField();
		text_to.setEditable(false);
		text_to.setEnabled(false);
		text_to.setColumns(10);
		text_to.setBounds(105, 67, 137, 20);
		getContentPane().add(text_to);
		
		text_flightNO = new JTextField();
		text_flightNO.setEditable(false);
		text_flightNO.setEnabled(false);
		text_flightNO.setColumns(10);
		text_flightNO.setBounds(105, 116, 137, 20);
		getContentPane().add(text_flightNO);
		
		text_date = new JTextField();
		text_date.setEditable(false);
		text_date.setEnabled(false);
		text_date.setColumns(10);
		text_date.setBounds(105, 167, 137, 20);
		getContentPane().add(text_date);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 41, 307, 143);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lbl_partners = new JLabel("New label");
		lbl_partners.setBounds(288, 23, 46, 14);
		getContentPane().add(lbl_partners);
	
		btn_showPartner = new JButton("New button");
		btn_showPartner.setBounds(506, 218, 89, 23);
		getContentPane().add(btn_showPartner);
		
		btn_close = new JButton("New button");
		btn_close.setBounds(29, 218, 89, 23);
		getContentPane().add(btn_close);
	}
	
	public void setLanguage(ResourceBundle rb) {
		lbl_date.setText(rb.getString("lbl_date"));
		lbl_from.setText(rb.getString("lbl_from"));
		lbl_to.setText(rb.getString("lbl_to"));
		lbl_flightNO.setText(rb.getString("lbl_flightNO"));
		lbl_partners.setText(rb.getString("lbl_partners"));
		
		btn_close.setText(rb.getString("btn_cancel"));
		btn_showPartner.setText(rb.getString("btn_showPartner"));
	}
	
	public void setListeners(ActionListener close, ActionListener showPartner) {
		btn_close.addActionListener(close);
		btn_showPartner.addActionListener(showPartner);
	}
	
	public void setFields(String date, String from, String to, String flightNO) {
		text_date.setText(date);
		text_flightNO.setText(flightNO);
		text_from.setText(from);
		text_to.setText(to);
	}
}
