package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import entity.Flight;
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
	private List<UserFlight> ul;
	private List<UserFlight> myPartners;
	private Context ctx;
	private MyFacadeBeanRemote rm;
	private MyTransactionFacadeBeanRemote rmT;

	public Controller() {
		showLogin();
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
			loginWindow.dispose();
			registerWindow = new RegisterWindow();
			registerWindow.setListeners(new ConfirmRegistrationListener(), new LogOffListener());
			registerWindow.setVisible(true);
			windowFlag = 1;
		}

	}
	
	/*
	 * Po potvrdeni zadanych dat skusim nahrat pouzivatela do DB
	 */
	class ConfirmRegistrationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			List<String> regForm = new ArrayList<>();
			
		regForm.add(registerWindow.getTextName()); //0
		regForm.add(registerWindow.getTextSurname()); //1
		regForm.add(registerWindow.getTextBirth()); //2
		regForm.add(registerWindow.getTextPhone()); //3
		regForm.add(registerWindow.getTextLogin()); //4 
		regForm.add(registerWindow.getTextPassword()); //5
		regForm.add(registerWindow.getTextSocial()); //6
		
		if (isEmtpyField(regForm) == true) {
			JOptionPane.showMessageDialog(null, "Musite vyplnit vsetky udaje");
		}
		else {
			try {
				ctx = new InitialContext();
				rmT = (MyTransactionFacadeBeanRemote)ctx.lookup(remoteTrans);
				rm = (MyFacadeBeanRemote)ctx.lookup(remote);
				if (rm.isAvailableLogin(regForm.get(5)) == false) 
					JOptionPane.showMessageDialog(null, "Zvoleny login uz existuje");
				else {
					rmT.addUser(createUser(regForm));
					JOptionPane.showMessageDialog(null, "Boli ste uspesne zaregistrovani, mozete sa prihlasit");
					registerWindow.dispose();
					showLogin();
				}
				
				
				
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		}
		
	}

	/*
	 * K letu mam pouzivatelov, otvori sa detail okno pre pouzivatel a zobrazim
	 * jeho udaje.
	 */
	class UserDetailListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selected = flightWindow.getSelectedRow();
			
			if (myPartners.size() > 0 && selected > -1) {
				windowFlag = 2;
				String message = myPartners.get(selected).getMessage();
				User u = myPartners.get(selected).getUser();
				userDetailWindow = new UserDetailWindow();
				userDetailWindow.setTextFields(u.getName(), u.getSurname(), u.getBirthDate(), u.getPhone()
						, u.getFacebook(), message);
				userDetailWindow.setListeners(new CloseFormListener());
				userDetailWindow.setVisible(true);
			}
			else { JOptionPane.showMessageDialog(null, "Chyba pri volbe partnera");}
		}
	}

	/*
	 * Po vybere jedneho z mojich letov, zobrazim detail okno kde nacucam
	 * pouzivatelov, ktori takisto tymto letom letia a info o lete.
	 */
	class ShowFlightListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			showFlight();
		}

	}

	/*
	 * po stlaceni tohto tlacidla v menu letov sa uzivatel odhlasi, zostane
	 * bezat zasa login pass okno.
	 */
	class LogOffListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (menuWindow != null) menuWindow.dispose();
			if (registerWindow != null) registerWindow.dispose();
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
			case 1: showMenu(); break;
			case 2: userDetailWindow.dispose(); windowFlag = 1; break;
			}
		//	menuWindow.setVisible(true);
		}
		
	}
	
	public void checkLogin() {
		try {
			ctx = new InitialContext();
			rm = (MyFacadeBeanRemote)ctx.lookup(remote);
			user = rm.isRegistered(loginWindow.getLogin(), loginWindow.getPW());
			ctx.close();
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
	
	public void showLogin() {
		loginWindow = new LoginWindow();
		loginWindow.setListeners(new LoginListener(), new RegisterListener(), new CloseListener());
		loginWindow.setVisible(true);
	}
	
	public void showMenu() {
		try {
			ctx = new InitialContext();
			rm = (MyFacadeBeanRemote)ctx.lookup(remote);
			ul = rm.getMyFlights(loggedID, 1);
			
			disposeCheck();
			menuWindow = new MenuWindow();
			menuWindow.setListeners(new AddFlightListener(), new ShowFlightListener(), new LogOffListener());
			menuWindow.setTable(getModelFlights(ul));
			menuWindow.setVisible(true);
			ctx.close();
			
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
	
	public void showFlight() {
		int selected = menuWindow.getSelectedRow();
		
		if (selected != -1) {
			try {
				ctx = new InitialContext();
				rm = (MyFacadeBeanRemote)ctx.lookup(remote);
				myPartners = sortLoggedID(rm.getMyFlights(ul.get(selected).getFlight().getId(), 2), loggedID);
				flightWindow = new FlightDetailWindow();
				windowFlag = 1;
				flightWindow.setListeners(new CloseFormListener(), new UserDetailListener());
				flightWindow.setTable(getModelUsers(myPartners));
				
				Flight f = ul.get(selected).getFlight();
				flightWindow.setFields(f.getDate(), f.getAirportFrom(), f.getAirportTo(), f.getFlightNumber());
				
				
				
				flightWindow.setVisible(true);
				menuWindow.dispose();
				
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			
			
		}
	}
	
	
	public DefaultTableModel getModelFlights(List<UserFlight> uf) {
		String []columns = {"�tart", "Cie�", "��slo letu", "D�tum letu"};
		DefaultTableModel tm = new DefaultTableModel(null, columns);
		
		for (UserFlight currUF: uf) {
			ArrayList<String> tmp = new ArrayList<>();
			tmp.add(currUF.getFlight().getAirportFrom());
			tmp.add(currUF.getFlight().getAirportTo());
			tmp.add(currUF.getFlight().getFlightNumber());
			tmp.add(currUF.getFlight().getDate());
			tm.addRow(tmp.toArray());
		}
		
		
		return tm;
	}
	
	public DefaultTableModel getModelUsers(List<UserFlight> uf) {
		String []columns = {"Meno", "Priezvisko"};
		DefaultTableModel tm = new DefaultTableModel(null, columns);
		
		for (UserFlight currUF: uf) {
			ArrayList<String> tmp = new ArrayList<>();
			tmp.add(currUF.getUser().getName());
			tmp.add(currUF.getUser().getSurname());
			tm.addRow(tmp.toArray());
		}
		return tm;
	}
	
	public List<UserFlight> sortLoggedID(List<UserFlight> uf, int loggedID) {
		List <UserFlight> tmp = new ArrayList<>();
		
		for (UserFlight curr : uf) {
			if (curr.getUser().getId() != loggedID) {
				tmp.add(curr);
			}
		}
		return tmp;
	}
	
	public void disposeCheck() {
		if (flightWindow != null) 
			flightWindow.dispose(); flightWindow = null;
	    if (userDetailWindow != null ) { userDetailWindow.dispose(); userDetailWindow = null;}
	    if (loginWindow != null ) { loginWindow.dispose(); loginWindow = null;}
		
	}
	
	private boolean isEmtpyField(List<String> list) {
		for (String CurrS : list) {
			if (CurrS.equals("")) return true;
		}
		return false;
	}
	
	private User createUser(List<String> list) {
		User u = new User();
		
		u.setName(list.get(0));
		u.setSurname(list.get(1));
		u.setBirthDate(list.get(2));
		u.setPhone(list.get(3));
		u.setLogin_name(list.get(4));
		u.setLogin_pass(list.get(5));
		u.setFacebook(list.get(6));
		
		return u;
	}
}
