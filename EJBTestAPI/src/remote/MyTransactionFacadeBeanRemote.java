package remote;

import javax.ejb.Remote;

import entity.Flight;
import entity.User;

@Remote
public interface MyTransactionFacadeBeanRemote {
	public boolean createOrUpdateUser(User u);
	public void addFlight(Flight f, User u);
}
