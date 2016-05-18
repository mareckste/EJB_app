package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class WeatherWindow extends JFrame{
	private JTextField text_city;
	private JButton btn_search;
	private JLabel lbl_location, lbl_temp, lbl_weather_icon, lbl_condition;
	private JLabel lbl_weather_city;
	private JButton btn_close;
	public WeatherWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		setSize(461,359);
		setIconImage(new javax.swing.ImageIcon("etc\\img\\plane (1).png").getImage());
		JLabel lblcity = new JLabel("");
		lblcity.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463424949_location.png"));
		lblcity.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		lblcity.setBounds(27, 26, 53, 48);
		getContentPane().add(lblcity);
		
		JLabel lbltemp = new JLabel("");
		lbltemp.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463547989_Fire.png"));
		lbltemp.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		lbltemp.setBounds(27, 98, 53, 48);
		getContentPane().add(lbltemp);
		
		JLabel lblCondition = new JLabel("");
		lblCondition.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463548003_Info.png"));
		lblCondition.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		lblCondition.setBounds(27, 174, 53, 48);
		getContentPane().add(lblCondition);
		
		lbl_weather_icon = new JLabel("");
		lbl_weather_icon.setBounds(230, 61, 128, 140);
		getContentPane().add(lbl_weather_icon);
		
		lbl_location = new JLabel("");
		lbl_location.setBounds(83, 26, 221, 48);
		getContentPane().add(lbl_location);
		
		lbl_temp = new JLabel("");
		lbl_temp.setBounds(83, 98, 128, 48);
		getContentPane().add(lbl_temp);
		
		lbl_condition = new JLabel("");
		lbl_condition.setBounds(83, 174, 128, 48);
		getContentPane().add(lbl_condition);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\plane.png"));
		label.setBounds(345, 11, 76, 58);
		getContentPane().add(label);
		
		text_city = new JTextField();
		text_city.setBounds(27, 274, 146, 20);
		getContentPane().add(text_city);
		text_city.setColumns(10);
		
		btn_search = new JButton("Search weather");
		btn_search.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		btn_search.setHorizontalAlignment(SwingConstants.LEFT);
		btn_search.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\right-arrow.png"));
		btn_search.setBorder(BorderFactory.createEmptyBorder());
		btn_search.setContentAreaFilled(false);
		btn_search.setBounds(183, 262, 139, 46);
		getContentPane().add(btn_search);
		
		lbl_weather_city = new JLabel("Insert city name:");
		lbl_weather_city.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		lbl_weather_city.setBounds(27, 250, 104, 14);
		getContentPane().add(lbl_weather_city);
		
		btn_close = new JButton("Close");
		btn_close.setHorizontalAlignment(SwingConstants.LEFT);
		btn_close.setFont(new Font("Microsoft Tai Le", Font.ITALIC, 14));
		btn_close.setIcon(new ImageIcon("C:\\Users\\MareCK\\ws_vava\\EJBTestClient\\etc\\img\\1463425331_Cancel.png"));
		btn_close.setBounds(332, 262, 101, 46);
		btn_close.setBorder(BorderFactory.createEmptyBorder());
		btn_close.setContentAreaFilled(false);
		getContentPane().add(btn_close);
	}
	
	
	public void setListeners(ActionListener search, ActionListener close) {
		btn_search.addActionListener(search);
		btn_close.addActionListener(close);
	}
	
	public void setWeather(String temp, String location, String cond) {
		lbl_condition.setText(cond);
		lbl_location.setText(location);
		lbl_temp.setText(temp);
	}
	
	public void setIcon(ImageIcon icon) {
		lbl_weather_icon.setIcon(icon);
	}
	
	public String getCity() {
		return text_city.getText();
	}
}
