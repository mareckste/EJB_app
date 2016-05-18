package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import entity.Flight;
import entity.User;
import entity.UserFlight;
import entity.Weather;
import remote.MyFacadeBeanRemote;
import remote.MyTransactionFacadeBeanRemote;
import view.AddFlightWindow;
import view.FlightDetailWindow;
import view.LoginWindow;
import view.MenuWindow;
import view.RegisterWindow;
import view.UserDetailWindow;
import view.WeatherWindow;

public class Controller {
	private static final String remote = "ejb:EJBTestEAR/EJBTestServer//MyFacadeBean!remote.MyFacadeBeanRemote";
	private static final String remoteTrans = "ejb:EJBTestEAR/EJBTestServer//MyTransactionFacadeBean!remote.MyTransactionFacadeBeanRemote";
	private static final Logger log = Logger.getLogger(Controller.class);
	
	private int windowFlag;
	private LoginWindow loginWindow;
	private MenuWindow menuWindow;
	private FlightDetailWindow flightWindow;
	private AddFlightWindow addFlightWindow;
	private UserDetailWindow userDetailWindow;
	private RegisterWindow registerWindow;
	private WeatherWindow weatherWindow;
	private int loggedID;
	private User user;
	private List<UserFlight> ul;
	private List<UserFlight> myPartners;
	private Context ctx;
	private MyFacadeBeanRemote rm;
	private MyTransactionFacadeBeanRemote rmT;
	private ResourceBundle rb = ResourceBundle.getBundle("Location", Locale.getDefault());

	public Controller() {
		showLogin();
	}
	
	class LangListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Locale.ENGLISH == rb.getLocale()) {
				log.info("Clicked on slovak icon");
				rb = ResourceBundle.getBundle("Location", new Locale("sk"));
				loginWindow.setLanguage(rb);
			}
			else {
				log.info("Clicked on english icon");
				rb = ResourceBundle.getBundle("Location", new Locale("en"));
				loginWindow.setLanguage(rb);
			}
		}
		
	}

	/*
	 * Ked kliknem prihlasit, skontroluje, ci je meno a heslo v databaze a vrati
	 * pouzivatela.
	 */
	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			log.info("Clicked on login button");
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
			log.info("Opening register window.");
			loginWindow.dispose();
			registerWindow = new RegisterWindow();
			registerWindow.setListeners(new ConfirmRegistrationListener(), new LogOffListener());
			registerWindow.setVisible(true);
			registerWindow.setLanguage(rb);
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
			log.info("Confirming registration");
			regForm.add(registerWindow.getTextName()); //0
			regForm.add(registerWindow.getTextSurname()); //1
			regForm.add(registerWindow.getTextBirth()); //2
			regForm.add(registerWindow.getTextPhone()); //3
			regForm.add(registerWindow.getTextLogin()); //4 
			regForm.add(registerWindow.getTextPassword()); //5
			regForm.add(registerWindow.getTextSocial()); //6

			if (isEmtpyField(regForm) == true) {
				log.info("There is empty field");
				JOptionPane.showMessageDialog(null, rb.getString("msg_fill"));
			}
			else {
				try {
					ctx = new InitialContext();
					rmT = (MyTransactionFacadeBeanRemote)ctx.lookup(remoteTrans);
					rm = (MyFacadeBeanRemote)ctx.lookup(remote);
					if (rm.isAvailableLogin(regForm.get(5)) == false)  {
						log.info("Inserted login that already exists");
						JOptionPane.showMessageDialog(null, "msg_login_exist");
					}
					else {
						log.info("Adding new user");
						rmT.addUser(createUser(regForm));
						JOptionPane.showMessageDialog(null, rb.getString("msg_login_succ"));
						registerWindow.dispose();
						showLogin();
					}



				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					log.error(e1,e1);
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
			log.debug("Selected row: " + selected);
			if (myPartners.size() > 0 && selected > -1) {
				log.info("Opening user detail window");
				windowFlag = 2;
				String message = myPartners.get(selected).getMessage();
				User u = myPartners.get(selected).getUser();
				userDetailWindow = new UserDetailWindow();
				userDetailWindow.setTextFields(u.getName(), u.getSurname(), u.getBirthDate(), u.getPhone()
						, u.getFacebook(), message);
				userDetailWindow.setListeners(new CloseFormListener());
				userDetailWindow.setLanguage(rb);
				userDetailWindow.setVisible(true);
			}
			else {
				log.info("Not opening window"); log.debug("Size: " + myPartners.size());
				JOptionPane.showMessageDialog(null, rb.getString("msg_partner"));
			}
		}
	}

	/*
	 * Po vybere jedneho z mojich letov, zobrazim detail okno kde nacucam
	 * pouzivatelov, ktori takisto tymto letom letia a info o lete.
	 */
	class ShowFlightListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			log.info("Clicked on flight detail");
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
			if (menuWindow != null) { log.info("Logging of from menu");menuWindow.dispose();}
			if (registerWindow != null) { log.info("Logging off from register window");registerWindow.dispose();}
			
			log.info("Opening login window");
			loginWindow = new LoginWindow();
			loginWindow.setListeners(new LoginListener(), new RegisterListener(), new CloseListener(), new LangListener());
			loginWindow.setVisible(true);
			loginWindow.setLanguage(rb);
		}

	}
	
	
	class AddFlightListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			log.info("Closing menu window:");
			menuWindow.dispose();
			log.info("Opening add flight window");
			addFlightWindow = new AddFlightWindow();
			addFlightWindow.setListeners(new ConfirmFlightListener(), new CloseFormListener());
			addFlightWindow.setVisible(true);
			addFlightWindow.setLanguage(rb);
			windowFlag = 1;
		}
		
	}
	
	
	class ConfirmFlightListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			List<String> form = new ArrayList<>();
			log.info("Pressed confirm flight button");
			form.add(addFlightWindow.getTextFrom());
			form.add(addFlightWindow.getTextTo());
			form.add(addFlightWindow.getTextFlightNO());
			form.add(addFlightWindow.getTextDate());
			
			if (isEmtpyField(form) == true) {log.info("Empty field in form"); JOptionPane.showMessageDialog(null, rb.getString("msg_fill")); }
			else {
				try {
					ctx = new InitialContext();
					rm = (MyFacadeBeanRemote)ctx.lookup(remote);
					rmT = (MyTransactionFacadeBeanRemote)ctx.lookup(remoteTrans);
					
					log.info("Adding flight");
					Flight f = rm.isFlight(form.get(3), form.get(0), form.get(1), form.get(2));
					if (f != null) {
						log.info("Flight exist");
						rmT.addFlight(loggedID, f, addFlightWindow.getTextMessageMoti());
					}
					else {
						log.info("Flight does not exist");
						f = createFlight(form);
						rmT.addFlight(loggedID, f, addFlightWindow.getTextMessageMoti());
					}
					JOptionPane.showMessageDialog(null, rb.getString("msg_flight_add"));
					addFlightWindow.dispose();
					showMenu();
				} catch (NamingException e1) {
					log.error(e1, e1);
				}
				
			}
		}
		
	}
	
	class WeatherListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			log.info("Opening weather window");
			weatherWindow = new WeatherWindow();
			weatherWindow.setListeners(new SearchWeatherListener(), new CloseFormListener());
			weatherWindow.setLanguage(rb);
			weatherWindow.setVisible(true);
			log.info("Closing menu");
			menuWindow.dispose();
			windowFlag = 1;
		}
		
	}
	
	class SearchWeatherListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				log.info("Searching weather");
				ctx = new InitialContext();
				rm = (MyFacadeBeanRemote)ctx.lookup(remote);
				
				Weather w = rm.getWeather(weatherWindow.getCity());
				log.debug("Seeking forecast for location: " + weatherWindow.getCity());
				weatherWindow.setWeather(w.getTemperature() + " �C", w.getCountry() + ", " + w.getCity(), w.getConditionText());
				 URL url = new URL(w.getImageUrl());
				 BufferedImage image = ImageIO.read(url);
				 weatherWindow.setIcon(new ImageIcon(image));
				 
				
			} catch (NamingException | IOException e1) {
				// TODO Auto-generated catch block
				log.error(e1,e1);
			}
		}
		
	}
	
	class CloseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			log.info("Closing login window");
			loginWindow.dispose();
		}
		
	}
	
	class CloseFormListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (windowFlag) {
			case 1: showMenu(); break;
			case 2: log.info("Closing user detail window"); userDetailWindow.dispose(); windowFlag = 1; break;
			}
		//	menuWindow.setVisible(true);
		}
		
	}
	
	public void checkLogin() {
		try {
			log.info("Checking login");
			ctx = new InitialContext();
			rm = (MyFacadeBeanRemote)ctx.lookup(remote);
			user = rm.isRegistered(loginWindow.getLogin(), loginWindow.getPW());
			ctx.close();
			if (user == null) JOptionPane.showMessageDialog(null, rb.getString("msg_login_false"));
			else {
				JOptionPane.showMessageDialog(null, rb.getString("msg_login_ok"));
				loggedID = user.getId();
				showMenu();
			}
			
		} catch (NamingException e1) {
			log.error(e1, e1);
		}
	}
	
	public void showLogin() {
		log.info("Opening login window");
		loginWindow = new LoginWindow();
		loginWindow.setListeners(new LoginListener(), new RegisterListener(), new CloseListener(), new LangListener());
		loginWindow.setVisible(true);
		loginWindow.setLanguage(rb);
	}
	
	public void showMenu() {
		try {
			log.info("Opening menu window");
			ctx = new InitialContext();
			rm = (MyFacadeBeanRemote)ctx.lookup(remote);
			ul = rm.getMyFlights(loggedID, 1);
			
			disposeCheck();
			menuWindow = new MenuWindow();
			menuWindow.setListeners(new AddFlightListener(), new ShowFlightListener(), new LogOffListener(), new WeatherListener());
			menuWindow.setTable(getModelFlights(ul));
			menuWindow.setLanguage(rb);
			menuWindow.setVisible(true);
			ctx.close();
			
		} catch (NamingException e1) {
			log.error(e1,e1);
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
				flightWindow.setLanguage(rb);
				
				Flight f = ul.get(selected).getFlight();
				flightWindow.setFields(f.getDate(), f.getAirportFrom(), f.getAirportTo(), f.getFlightNumber());
				
				
				
				flightWindow.setVisible(true);
				menuWindow.dispose();
				
			} catch (NamingException e1) {
				log.error(e1,e1);
			}
			
			
		}
	}
	
	
	public DefaultTableModel getModelFlights(List<UserFlight> uf) {
		String []columns = {rb.getString("lbl_from"),rb.getString("lbl_to") , rb.getString("lbl_flightNO"), rb.getString("lbl_date")};
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
	    if (addFlightWindow != null) { addFlightWindow.dispose(); addFlightWindow = null; }
	    if(weatherWindow != null) { weatherWindow.dispose(); weatherWindow = null;}
		
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
	
	private Flight createFlight(List<String> list) {
		Flight f = new Flight();
		
		f.setAirportFrom(list.get(0));
		f.setAirportTo(list.get(1));
		f.setFlightNumber(list.get(2));
		f.setDate(list.get(3));
		
		return f;
	}
	
}
