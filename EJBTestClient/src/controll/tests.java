package controll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class tests extends JFrame{
	private JLabel lbl_test;
	public tests() {
		getContentPane().setLayout(null);
		
		lbl_test = new JLabel("");
		lbl_test.setBounds(34, 32, 164, 134);
		getContentPane().add(lbl_test);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public JLabel getLabel() {
		return this.lbl_test;
	}
}