package executive;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import entity.UserFlight;
import entity.User;
import entity.Flight;

/**
 * Session Bean implementation class EJB2Bean
 */
@Stateless
@LocalBean
public class EJBMyExecutiveBean {
	
	
	public List<UserFlight> getMyFlights(int id, flag) {
		ArrayList<UserFlight> tmp = new ArrayList<UserFlight>();
		switch (flag) {
		case 1:
			
		}
	}
}
