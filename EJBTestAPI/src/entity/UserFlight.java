package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "pouzivatel_let")

@NamedQueries(
		{@NamedQuery(name = "UserFlight.findAll", 
				query = "select u from UserFlight u"),
			
		@NamedQuery(name = "UserFlight.findFlights",
				query = "select u from UserFlight u inner join u.userko")}
		)
public class UserFlight implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String message;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userko_u_id")
	private User userko;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "flight_f_id")
	private Flight flight;

	
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public User getUser() {
		return userko;
	}

	public void setUser(User user) {
		this.userko = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
