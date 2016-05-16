package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.UserFlight;

public class UserFlightDAO {
	public List<UserFlight> getAllUserF(EntityManager em) {
		TypedQuery<UserFlight> q = em.createNamedQuery("UserFlight.findAll", UserFlight.class);
		return q.getResultList();
	}
	
	
	public List<UserFlight> getFlights(EntityManager em) {
		TypedQuery<UserFlight> q = em.createNamedQuery("UserFlight.findFlights", UserFlight.class);
		//q.setParameter("in_id", 31);
		return q.getResultList();
	}
}
