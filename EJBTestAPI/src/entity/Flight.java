package entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "let")
@NamedQueries(
		{@NamedQuery(name = "Flight.findAll", 
				query = "select f from Flight f")})

public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date flyDate;
	private String airportFrom;
	private String airportTo;
	private String flightNumber;
	private String message;
	@ManyToMany
	private List<User> users;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDate() {
		return flyDate;
	}
	
	public void setDate(Date date) {
		this.flyDate = date;
	}
	
	public String getAirportFrom() {
		return airportFrom;
	}
	
	public void setAirportFrom(String airportFrom) {
		this.airportFrom = airportFrom;
	}
	
	public String getAirportTo() {
		return airportTo;
	}
	
	public void setAirportTo(String airportTo) {
		this.airportTo = airportTo;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
