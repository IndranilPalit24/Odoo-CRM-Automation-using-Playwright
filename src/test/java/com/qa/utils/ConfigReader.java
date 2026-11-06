package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;
	
	static {
		loadProperties();
	}
	
	private static void loadProperties() {
		try {
			properties = new Properties();
			FileInputStream file = new FileInputStream(
					"src/test/resources/config.properties"
					);
			properties.load(file);
			System.out.println("Config File Loaded Successfully");
		
		}catch(IOException e) {
			throw new RuntimeException(
					"Config properties not found. " +
					"Check Path: src/test/resources/config.properties"
							);
		}

	}
	
	public static String get(String key) {
		String value = properties.getProperty(key);
		if(value==null) {
			throw new RuntimeException(
					"Propertey "+key+ "not found in config.properties");
			
		}
		
		return value.trim();
	}
	
	public static String getBaseURL() {
		try{
			return get("BaseURL");
		}catch(Exception e){
			throw new RuntimeException("BaseURL not found in config.properties");
		}
	}
	
	public static String getBrowser() {
		return get("browser");
	}
	public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static int getDefaultTimeout() {
        return Integer.parseInt(get("default.timeout"));
    }


}
