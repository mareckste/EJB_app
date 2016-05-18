package controll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

public class Properties {
	private static final Logger log = Logger.getLogger(Properties.class);
	public static InputStream getProperties() {
	    String fileName = "properties\\config.properties";

	    try {
	    	InputStream is = new FileInputStream(fileName);
			return is;
		} catch (IOException e) {
			log.error(e,e);
		}
	    return null;
	}
}
