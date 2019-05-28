package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JSONparser {
	private ObjectMapper objectMapper;
	private Logger logger = LogManager.getLogger(JSONparser.class);

	public JSONparser() {
		this.objectMapper = new ObjectMapper();
	}

	public UserModel[] getData(File jsonFile) {
		UserModel[] data = new UserModel[0];
		try {
			data = objectMapper.readValue(jsonFile, UserModel[].class);
		} catch (IOException e) {
			logger.error(e.getClass());
			e.printStackTrace();
		}
		return data;
	}
}
