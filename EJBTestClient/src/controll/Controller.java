package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import entity.User;
import entity.UserFlight;
import remote.MyFacadeBeanRemote;
import remote.MyTransactionFacadeBeanRemote;
import view.AddFlightWindow;
import view.FlightDetailWindow;
import view.LoginWindow;
import view.MenuWindow;
import view.RegisterWindow;
import view.UserDetailWindow;

public class Controller {
	private static final String remote = "ejb:EJBTestEAR/EJBTestServer//MyFacadeBean!remote.MyFacadeBeanRemote";
	private static final String remoteTrans = "ejb:EJBTestEAR/EJBTestServer//MyTransactionFacadeBean!remote.MyTransactionFacadeBeanRemote";
	
	private int windowFlag;
	private LoginWindow loginWindow;
	private MenuWindow menuWindow;
	private FlightDetailWindow flightWindow;
	private AddFlightWindow addFlightWindow;
	private UserDetailWindow userDetailWindow;
	private RegisterWindow registerWindow;
	private int loggedID;
	private User user;
	private Context ctx;
	private MyFacadeBeanRemote rm;
	private MyTransactionFacadeBeanRemote rmT;

	public Controller() {
		loginWindow = new LoginWindow();
		loginWindow.setListeners(new LoginListener(), new RegisterListener(), new CloseListener());
		loginWindow.setVisible(true);
	}

	/*
	 * Ked kliknem prihlasit, skontroluje, ci je meno a heslo v databaze a vrati
	 * pouzivatela.
	 */
	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			checkLogin();
		}

	}

	/*
	 * Otvorim registracny formular, nahram pouzivatela, testujem unikatnost
	 * mena a hesla.
	 */
	class RegisterListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/*
	 * K letu mam pouzivatelov, otvori sa detail okno pre pouzivatel a zobrazim
	 * jeho udaje.
	 */
	class UserDetailListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

	/*
	 * Po vybere jedneho z mojich letov, zobrazim detail okno kde nacucam
	 * pouzivatelov, ktori takisto tymto letom letia a info o lete.
	 */
	class ShowFlightListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	/*
	 * po stlaceni tohto tlacidla v menu letov sa uzivatel odhlasi, zostane
	 * bezat zasa login pass okno.
	 */
	class LogOffListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			menuWindow.dispose();
			loginWindow = new LoginWindow();
			loginWindow.setListeners(new LoginListener(), new RegisterListener(), new CloseListener());
			loginWindow.setVisible(true);
		}

	}
	
	
	class AddFlightListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	
	
	
	
	
	class CloseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			loginWindow.dispose();
		}
		
	}
	
	class CloseFormListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (windowFlag) {
			case 1: flightWindow.dispose(); break;
			case 2: addFlightWindow.dispose(); break;
			}
			menuWindow.setVisible(true);
		}
		
	}
	
	public void checkLogin() {
		try {
			ctx = new InitialContext();
			rm = (MyFacadeBeanRemote)ctx.lookup(remote);
			user = rm.isRegistered(loginWindow.getLogin(), loginWindow.getPW());
			
			if (user == null) JOptionPane.showMessageDialog(null, "Zle prihlasovacie udaje");
			else {
				JOptionPane.showMessageDialog(null, "Prihlasenie prebehelo uspesne" + user.getName());
				loggedID = user.getId();
				showMenu();
			}
			
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
	
	public void showMenu() {
		loginWindow.dispose();
		menuWindow = new MenuWindow();
		menuWindow.setListeners(new AddFlightListener(), new ShowFlightListener(), new LogOffListener());
		menuWindow.setVisible(true);
		
		
		try {
			ctx = new InitialContext();
			rm = (MyFacadeBeanRemote)ctx.lookup(remote);
			List<UserFlight> ul = rm.getMyFlights(loggedID, 1);
			
			for (UserFlight curr : ul) {
				System.out.println(curr.getFlight().getAirportFrom());
			}
			
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}

	
}
