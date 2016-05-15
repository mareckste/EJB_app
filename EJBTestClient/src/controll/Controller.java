package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddFlightWindow;
import view.FlightDetailWindow;
import view.LoginWindow;
import view.MenuWindow;
import view.RegisterWindow;
import view.UserDetailWindow;

public class Controller {
	private LoginWindow loginWindow;
	private MenuWindow menuWindow;
	private FlightDetailWindow flightWindow;
	private AddFlightWindow addFlightWindow;
	private UserDetailWindow userDetailWindow;
	private RegisterWindow registerWindow;

	public Controller() {

	}

	/*
	 * Ked kliknem prihlasit, skontroluje, ci je meno a heslo v databaze a vrati
	 * pouzivatela.
	 */
	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

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

		}

	}
}
