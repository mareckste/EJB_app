package remote;

import javax.ejb.Remote;

import entity.Flight;
import entity.User;

@Remote
public interface MyTransactionFacadeBeanRemote {
	public void addFlight(int userID, Flight f, String message);
	public void addUser(User u);
}
