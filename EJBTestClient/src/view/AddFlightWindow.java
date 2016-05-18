package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AddFlightWindow extends JFrame{
	private JTextField text_from;
	private JTextField text_to;
	private JTextField text_flightNO;
	private JTextField text_date;
	private JButton btn_add, btn_cancel;
	private JLabel lbl_from, lbl_to, lbl_flightNO, lbl_date, lbl_motivate;
	private JTextArea text_motivate;
	private JLabel label;
	private JLabel lbl_add_flight;
	
	public AddFlightWindow() {
		setTitle("New flight");
		setSize(499, 342);
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		setIconImage(new javax.swing.ImageIcon("etc\\img\\plane (1).png").getImage());
		lbl_from = new JLabel("From (City, Airport):");
		lbl_from.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
		lbl_from.setBounds(23, 47, 145, 14);
		getContentPane().add(lbl_from);
		
		lbl_to = new JLabel("To (City, Airport):");
		lbl_to.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
		lbl_to.setBounds(251, 47, 145, 14);
		getContentPane().add(lbl_to);
		
		lbl_flightNO = new JLabel("Flight number:");
		lbl_flightNO.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
		lbl_flightNO.setBounds(23, 104, 145, 14);
		getContentPane().add(lbl_flightNO);
		
		lbl_date = new JLabel("Date of flight:");
		lbl_date.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
		lbl_date.setBounds(251, 105, 145, 14);
		getContentPane().add(lbl_date);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 178, 435, 45);
		getContentPane().add(scrollPane);
		
		text_motivate = new JTextArea();
		text_motivate.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		scrollPane.setViewportView(text_motivate);
		text_motivate.setWrapStyleWord(true);
		
		text_from = new JTextField();
		text_from.setBounds(23, 61, 207, 20);
		getContentPane().add(text_from);
		text_from.setColumns(10);
		
		text_to = new JTextField();
		text_to.setColumns(10);
		text_to.setBounds(251, 61, 207, 20);
		getContentPane().add(text_to);
		
		text_flightNO = new JTextField();
		text_flightNO.setColumns(10);
		text_flightNO.setBounds(23, 118, 207, 20);
		getContentPane().add(text_flightNO);
		
		text_date = new JTextField();
		text_date.setColumns(10);
		text_date.setBounds(251, 118, 207, 20);
		getContentPane().add(text_date);
		
		lbl_motivate = new JLabel("Partner requirements:");
		lbl_motivate.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
		lbl_motivate.setBounds(23, 164, 145, 14);
		getContentPane().add(lbl_motivate);
		
		btn_add = new JButton("Add flight");
		btn_add.setHorizontalAlignment(SwingConstants.LEFT);
		btn_add.setFont(new Font("Microsoft New Tai Lue", Font.ITALIC, 14));
		btn_add.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463424816_check.png"));
		btn_add.setBounds(338, 234, 120, 58);
		btn_add.setBorder(BorderFactory.createEmptyBorder());
		btn_add.setContentAreaFilled(false);
		
		getContentPane().add(btn_add);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setHorizontalAlignment(SwingConstants.LEFT);
		
		btn_cancel.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463425324_Cancel.png"));
		btn_cancel.setFont(new Font("Microsoft New Tai Lue", Font.ITALIC, 14));
		btn_cancel.setBounds(23, 234, 140, 58);
		btn_cancel.setBorder(BorderFactory.createEmptyBorder());
		btn_cancel.setContentAreaFilled(false);
		getContentPane().add(btn_cancel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\plane.png"));
		label.setBounds(155, 11, 146, 36);
		getContentPane().add(label);
		
		lbl_add_flight = new JLabel("Add new trip:");
		lbl_add_flight.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		lbl_add_flight.setBounds(23, 22, 145, 14);
		getContentPane().add(lbl_add_flight);
	}
	
	public String getTextFrom() {
		return text_from.getText();
	}
	
	public String getTextTo() {
		return text_to.getText();
	}
	
	public String getTextFlightNO() {
		return text_flightNO.getText();
	}
	
	public String getTextDate() {
		return text_date.getText();
	}
	
	public String getTextMessageMoti() {
		return text_motivate.getText();
	}
	
	public void setListeners(ActionListener next, ActionListener cancel) {
		btn_cancel.addActionListener(cancel);
		btn_add.addActionListener(next);
	}
	
	
	public void setLanguage(ResourceBundle rb) {
		lbl_date.setText(rb.getString("lbl_date"));
		lbl_from.setText(rb.getString("lbl_from"));
		lbl_to.setText(rb.getString("lbl_to"));
		lbl_motivate.setText(rb.getString("lbl_motivate"));
		lbl_flightNO.setText(rb.getString("lbl_flightNO"));
		lbl_add_flight.setText(rb.getString("btn_add_flight"));
		
		btn_cancel.setText(rb.getString("btn_cancel"));
		btn_add.setText(rb.getString("btn_add"));
	}
}
