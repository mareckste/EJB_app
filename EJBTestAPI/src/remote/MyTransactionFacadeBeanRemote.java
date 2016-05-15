package remote;

import javax.ejb.Remote;

import entity.Flight;
import entity.User;
import entity.UserFlight;

@Remote
public interface MyTransactionFacadeBeanRemote {
	public boolean createOrUpdateUser(User u);
	public void addFlight(UserFlight uf, Flight f, User u);
	public void addRec(int userID, Flight f);
}
