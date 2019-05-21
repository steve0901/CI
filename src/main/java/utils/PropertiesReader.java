package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	private FileInputStream inputStream;
	private String propertyValue;
	private Logger logger = LogManager.getLogger(PropertiesReader.class);


	public String getPropValues(String value) {
		try {
			Properties prop = new Properties();
			inputStream =  new FileInputStream("src/main/resources/configuration.properties");
			prop.load(inputStream);

			// get the property value
			propertyValue = prop.getProperty(value);

		} catch (Exception e) {
			logger.error("Exception: " + e.getClass());
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				logger.error("Exception: " + e.getClass());
			}
		}
		return propertyValue;
	}

}