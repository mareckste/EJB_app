package controll;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;

public class JsTest {

	public static void main(String[] args) throws IOException, JSONException {
		
		String cityName = "Hladovka";
		URL url = new URL("https://api.apixu.com/v1/current.json?key=01c0481181b54ae49c6211840161605&q=" + cityName);
		URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String input=in.readLine();
        JSONObject jsonResult = new JSONObject(input);
        
       // URL urll = new URL("https:" + jsonResult.getJSONObject("current").getString("temp_c"));
	//	BufferedImage image = ImageIO.read(urll);
		//Image image1=image.getScaledInstance(412, 728, Image.SCALE_REPLICATE);
	//	tests t = new tests();
	//	t.getLabel().setIcon(new ImageIcon(image));
		
        
        System.out.println(input);
        
//        
  //      System.out.println(jsonResult.get("location"));
//        
         String s = jsonResult.getJSONObject("current").getString("temp_c");
         System.out.println(s);
        
	}

}
