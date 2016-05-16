package facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.FlightDAO;
import dao.UserDAO;
import dao.UserFlightDAO;
import entity.Flight;
import entity.User;
import entity.UserFlight;
import executive.EJB2Bean;
import remote.MyFacadeBeanRemote;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
public class MyFacadeBean implements MyFacadeBeanRemote {
	@EJB
	private EJB2Bean bean2; 
	@PersistenceContext
	private EntityManager em;
	
    public String add(int i1, int i2) {
    	return bean2.getStr(i1 + i2);
    }
    
    public List<User> getAllUsers() {
    	UserDAO user = new UserDAO();
    	List<User> users = user.getAllUsers(em);
    	
    	for (User curr : users) {
    		em.detach(curr);
    	}
    	
    	
    	return users;
    }
    
    public List<UserFlight> getAllUserFlight() {
    	UserFlightDAO user = new UserFlightDAO();
    	List<UserFlight> users = user.getAllUserF(em);
    	
    	System.out.println("DetaCH");
    	
    	users=user.getFlights(em);
    	
    	for (UserFlight uf : users) {
    		uf.getUser().setFlights(null);
    		uf.getFlight().setUsers(null);
    		em.detach(uf);
    	}
    	
    	return users;
    }
    
    public User isRegistered(String id, String pw) {
    	UserDAO user = new UserDAO();
    	return user.isRegistered(em, id, pw);
  
    }
    
    public Flight isFlight(String date, String from, String to, String fnum) {
    	FlightDAO fdao = new FlightDAO();
    	return fdao.isFlight(em, date, from, to, fnum);
    }

}
