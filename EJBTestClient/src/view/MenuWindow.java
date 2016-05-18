package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MenuWindow extends JFrame {
	
	private JButton btn_showFlight, btn_logoff, btn_add_flight, btn_weather;
	private JLabel lbl_myflights;
	private JTable table;
	public MenuWindow() {
		setSize(661,301);
		setIconImage(new javax.swing.ImageIcon("etc\\img\\plane (1).png").getImage());
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		
		lbl_myflights = new JLabel("My flights");
		lbl_myflights.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 14));
		lbl_myflights.setBounds(211, 11, 100, 30);
		getContentPane().add(lbl_myflights);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 47, 405, 144);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btn_showFlight = new JButton("Show flight detail");
		btn_showFlight.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463423120_takeoff.png"));
		btn_showFlight.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		btn_showFlight.setBounds(412, 202, 205, 49);
		btn_showFlight.setBorder(BorderFactory.createEmptyBorder());
		btn_showFlight.setContentAreaFilled(false);
		getContentPane().add(btn_showFlight);
		
		btn_logoff = new JButton("Log out");
		btn_logoff.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		btn_logoff.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463422654_free-29.png"));
		btn_logoff.setBounds(10, 202, 149, 49);
		btn_logoff.setBorder(BorderFactory.createEmptyBorder());
		btn_logoff.setContentAreaFilled(false);
		getContentPane().add(btn_logoff);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\plane (1).png"));
		label_1.setBounds(10, 11, 160, 80);
		getContentPane().add(label_1);
		
		btn_add_flight = new JButton("Add new trip");
		btn_add_flight.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		btn_add_flight.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463432542_Paper-Plane.png"));
		btn_add_flight.setBounds(10, 118, 192, 73);
		btn_add_flight.setBorder(BorderFactory.createEmptyBorder());
		btn_add_flight.setContentAreaFilled(false);
		getContentPane().add(btn_add_flight);
		
		btn_weather = new JButton("See a weather");
		btn_weather.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		btn_weather.setHorizontalAlignment(SwingConstants.LEFT);
		btn_weather.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463523980_Weather.png"));
		btn_weather.setBounds(211, 202, 180, 49);
		btn_weather.setBorder(BorderFactory.createEmptyBorder());
		btn_weather.setContentAreaFilled(false);
		getContentPane().add(btn_weather);
	}
	
	public void setLanguage(ResourceBundle rb) {
		lbl_myflights.setText(rb.getString("lbl_myflights"));
		
		btn_logoff.setText(rb.getString("btn_logoff"));
		btn_showFlight.setText(rb.getString("btn_showFlight"));
	}
	
	public void setTable(DefaultTableModel tm) {
		table.setModel(tm);
	}
	
	public int getSelectedRow() {
		return table.getSelectedRow();
	}
	
	public void setListeners(ActionListener addFlight, ActionListener showFlight, ActionListener logoff, ActionListener weather) {
		btn_add_flight.addActionListener(addFlight);
		btn_logoff.addActionListener(logoff);
		btn_showFlight.addActionListener(showFlight);
		btn_weather.addActionListener(weather);
	}
}
