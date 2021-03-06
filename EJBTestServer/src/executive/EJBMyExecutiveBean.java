package executive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;



import org.json.JSONObject;



import entity.UserFlight;
import entity.Weather;

/**
 * Session Bean implementation class EJB2Bean
 */
@Stateless
@LocalBean
public class EJBMyExecutiveBean {

	public List<UserFlight> getMyFlights(List<UserFlight> uf, int id, int flag) {
		ArrayList<UserFlight> tmp = new ArrayList<UserFlight>();
		switch (flag) {
		case 1:
			for (UserFlight curr : uf) {
				if (curr.getUser().getId() == id)
					tmp.add(curr);
			}
			break;

		case 2:
			for (UserFlight curr : uf) {
				if (curr.getFlight().getId() == id)
					tmp.add(curr);
			}
			break;

		default:
			break;
		}
		return tmp;
	}
	
	public Weather getWeather(String cityName) {
		try {
			URL url = new URL("https://api.apixu.com/v1/current.json?key=01c0481181b54ae49c6211840161605&q=" + cityName);
			URLConnection connection = url.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String input=in.readLine();
	        JSONObject jsonResult = new JSONObject(input);
	        
	        String country = jsonResult.getJSONObject("location").getString("country");
	        String city = jsonResult.getJSONObject("location").getString("name");
	        
	        String temperature = jsonResult.getJSONObject("current").get("temp_c").toString();
	        
	        String condition = jsonResult.getJSONObject("current").getJSONObject("condition").getString("text");
	        String imgUrl = "https:" + jsonResult.getJSONObject("current").getJSONObject("condition").getString("icon");
	        
	        Weather w = new Weather();
	        w.setCity(city);
	        w.setCountry(country);
	        w.setConditionText(condition);
	        w.setTemperature(temperature);
	        w.setImageUrl(imgUrl);
		
		    return w;
		
		
		
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException ex) {
			
			ex.printStackTrace();
		}
		return null;
		
		
	}
}
