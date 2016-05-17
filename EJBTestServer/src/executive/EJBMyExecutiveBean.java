package executive;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import entity.UserFlight;

/**
 * Session Bean implementation class EJB2Bean
 */
@Stateless
@LocalBean
public class EJBMyExecutiveBean {

	public List<UserFlight> getMyFlights(List<UserFlight> uf, int id, int flag) {
		ArrayList<UserFlight> tmp = new ArrayList<UserFlight>();
		switch (flag) {
		case 1:
			for (UserFlight curr : uf) {
				if (curr.getUser().getId() == id)
					tmp.add(curr);
			}
			break;

		case 2:
			for (UserFlight curr : uf) {
				if (curr.getFlight().getId() == id)
					tmp.add(curr);
			}
			break;

		default:
			break;
		}
		return tmp;
	}
}
