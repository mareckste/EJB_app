package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.User;

public class UserDAO {
	
	public List<User> getAllUsers(EntityManager em) {
		TypedQuery<User> q = em.createNamedQuery("User.findAll", User.class);
		return q.getResultList();
	}
}
