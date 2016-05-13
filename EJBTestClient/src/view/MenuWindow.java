package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuWindow extends JFrame {
	
	private JButton btn_showFlight, btn_logoff;
	private JLabel lbl_myflights;
	private JTable table;
	public MenuWindow() {
		getContentPane().setLayout(null);
		
		lbl_myflights = new JLabel("New label");
		lbl_myflights.setBounds(10, 11, 46, 14);
		getContentPane().add(lbl_myflights);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 67, 386, 116);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btn_showFlight = new JButton("New button");
		btn_showFlight.setBounds(321, 202, 89, 23);
		getContentPane().add(btn_showFlight);
		
		btn_logoff = new JButton("New button");
		btn_logoff.setBounds(21, 202, 89, 23);
		getContentPane().add(btn_logoff);
	}
	
	
}