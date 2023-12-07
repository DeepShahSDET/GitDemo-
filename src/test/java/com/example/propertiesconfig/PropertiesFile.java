package com.example.propertiesconfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
	public static Properties properties = new Properties();
	public static String projectPath = System.getProperty("user.dir");

	public static String getProperties(String key) {
		try {
			InputStream inputStream = new FileInputStream(
					projectPath + "/src/test/java/com/example/propertiesconfig/config.properties");
			properties.load(inputStream);
		} catch (Exception e) {
		}

		return properties.getProperty(key);
	}

	public static void setProperties(String key, String value) throws IOException {
		OutputStream outputStream = new FileOutputStream(
				projectPath + "/src/test/java/com/example/propertiesconfig/config.properties");
		properties.setProperty(key, value);
		properties.store(outputStream, null);
	}

}
