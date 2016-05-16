package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.Flight;
import entity.User;
import entity.UserFlight;

@Remote
public interface MyFacadeBeanRemote {
	public String add(int i1, int i2);
	public List<User> getAllUsers();
	public User isRegistered(String login, String pw);
	public Flight isFlight(String date, String from, String to, String fnum);
	public List<UserFlight> getAllUserFlight();
}
