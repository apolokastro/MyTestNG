package utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class TestFileReader {
	
	public static final Properties property = new Properties();

	private TestFileReader() {
	}

	static {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/TestConfig.properties";

		try (FileInputStream file = new FileInputStream(filePath)) {
			property.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String prop) throws Exception {
		String value = "";
		if (Objects.isNull(prop)) {
			throw new Exception("Key is null...");
		}

		value = property.getProperty(prop);

		if (Objects.isNull(prop)) {
			throw new Exception("Property " + prop + "not found");
		}

		return value;
	}
}
