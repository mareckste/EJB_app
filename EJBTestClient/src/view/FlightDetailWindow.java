package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FlightDetailWindow extends JFrame {
	private JTextField text_from;
	private JTextField text_to;
	private JTextField text_flightNO;
	private JTextField text_date;
	private JTable table;
	private JLabel lbl_from, lbl_to, lbl_date, lbl_flightNO, lbl_partners;
	private JButton btn_close, btn_showPartner;
	private JLabel label;
	private JLabel label_1;
	
	
	public FlightDetailWindow() {
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		lbl_from = new JLabel("From (City, Airport):");
		lbl_from.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		lbl_from.setBounds(29, 23, 123, 14);
		getContentPane().add(lbl_from);
		
		lbl_to = new JLabel("To (City, Airport):");
		lbl_to.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		lbl_to.setBounds(29, 70, 111, 14);
		getContentPane().add(lbl_to);
		
		lbl_flightNO = new JLabel("Flight number:");
		lbl_flightNO.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		lbl_flightNO.setBounds(29, 119, 111, 14);
		getContentPane().add(lbl_flightNO);
		
		lbl_date = new JLabel("Date of departure:");
		lbl_date.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		lbl_date.setBounds(29, 170, 111, 14);
		getContentPane().add(lbl_date);
		
		text_from = new JTextField();
		text_from.setEditable(false);
		text_from.setEnabled(false);
		text_from.setBounds(29, 39, 185, 20);
		getContentPane().add(text_from);
		text_from.setColumns(10);
		
		text_to = new JTextField();
		text_to.setEditable(false);
		text_to.setEnabled(false);
		text_to.setColumns(10);
		text_to.setBounds(29, 88, 185, 20);
		getContentPane().add(text_to);
		
		text_flightNO = new JTextField();
		text_flightNO.setEditable(false);
		text_flightNO.setEnabled(false);
		text_flightNO.setColumns(10);
		text_flightNO.setBounds(29, 139, 185, 20);
		getContentPane().add(text_flightNO);
		
		text_date = new JTextField();
		text_date.setEditable(false);
		text_date.setEnabled(false);
		text_date.setColumns(10);
		text_date.setBounds(29, 187, 185, 20);
		getContentPane().add(text_date);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(349, 51, 307, 166);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lbl_partners = new JLabel("You can fly with:");
		lbl_partners.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 14));
		lbl_partners.setBounds(349, 33, 159, 14);
		getContentPane().add(lbl_partners);
	
		btn_showPartner = new JButton("Show detail");
		btn_showPartner.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		btn_showPartner.setHorizontalAlignment(SwingConstants.LEFT);
		btn_showPartner.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463423120_takeoff.png"));
		btn_showPartner.setBorder(BorderFactory.createEmptyBorder());
		btn_showPartner.setContentAreaFilled(false);
		btn_showPartner.setBounds(520, 228, 151, 54);
		getContentPane().add(btn_showPartner);
		
		btn_close = new JButton("Close");
		btn_close.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		btn_close.setHorizontalAlignment(SwingConstants.LEFT);
		btn_close.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463425324_Cancel.png"));
		btn_close.setBounds(29, 218, 111, 64);
		btn_close.setBorder(BorderFactory.createEmptyBorder());
		btn_close.setContentAreaFilled(false);
		getContentPane().add(btn_close);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\conversation.png"));
		label.setBounds(211, 55, 126, 173);
		getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\plane.png"));
		label_1.setBounds(320, 0, 94, 40);
		getContentPane().add(label_1);
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
