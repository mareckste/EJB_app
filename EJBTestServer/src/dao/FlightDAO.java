package dao;




import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.Flight;
import entity.UserFlight;

public class FlightDAO {
	
	/*
	 * Metoda, ktora skontroluje, ci sa dany 
	 * let uz v databaze nenachadza
	 */
	public Flight isFlight(EntityManager em, String date, String from, String to, String fnum) {
		Flight f = null;
		
		TypedQuery<Flight> q = em.createNamedQuery("Flight.isFlight", Flight.class);
		q.setParameter("in_from", from);
		q.setParameter("in_to", to);
		q.setParameter("in_number", fnum);
		q.setParameter("in_date", date);
		
		try {
			 f = q.getSingleResult();
			 if (f != null ) f.setUsers(new ArrayList<UserFlight>());
			  
		}catch (Exception e) {
			return null;
		}
		
		return f;
	}
}
