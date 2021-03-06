package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.User;
import entity.UserFlight;

public class UserDAO {
	
	public List<User> getAllUsers(EntityManager em) {
		TypedQuery<User> q = em.createNamedQuery("User.findAll", User.class);
		return q.getResultList();
	}
	
	public User isRegistered(EntityManager em, String login, String pass) {
	    ArrayList<UserFlight> tmp=null;
		
		TypedQuery<User> q = em.createNamedQuery("User.checkLogin", User.class);
		q.setParameter("in_login", login);
		q.setParameter("in_pass", pass);
		
		List<User> users = q.getResultList();
		
		if (users.size() > 0) {
			User u = users.get(0);
			u.setFlights(tmp);
				em.detach(u);
				return u;
			}
		return null;
	}
	
	public boolean isAvailableLogin(EntityManager em, String login) {
		TypedQuery<User> q = em.createNamedQuery("User.checkLoginAvailable", User.class);
		q.setParameter("in_login", login);
		
		List<User> users = q.getResultList();
		
		if (users.size() > 0) return false;
		return true;
		
 	}
}
