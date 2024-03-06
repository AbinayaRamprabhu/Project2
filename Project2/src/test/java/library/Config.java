package library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	 public static String loadProperty(String propertyName) throws IOException {

	        FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
	        Properties properties = new Properties();
	        properties.load(inputStream);
	        return properties.getProperty(propertyName);
	    }
}
