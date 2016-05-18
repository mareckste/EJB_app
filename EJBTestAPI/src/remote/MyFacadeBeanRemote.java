package remote;

import java.util.List;

import javax.ejb.Remote;

import entity.Flight;
import entity.User;
import entity.UserFlight;
import entity.Weather;

@Remote
public interface MyFacadeBeanRemote {
	public List<User> getAllUsers();
	public User isRegistered(String login, String pw);
	public Flight isFlight(String date, String from, String to, String fnum);
	public List<UserFlight> getMyFlights(int id, int flag);
	public boolean isAvailableLogin(String login);
	public Weather getWeather(String cityName);
}
