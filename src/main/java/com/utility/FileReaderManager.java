package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {

	private static FileInputStream fileInputStream;
	private static Properties properties;

	private static void setUpProperty() {

		File file = new File("C:\\Users\\PC\\eclipse-workspace\\Adactin_TestNg\\src\\main\\resources\\TestData.properties");
		try {
			fileInputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInputStream);

		}catch (FileNotFoundException e) {
			Assert.fail("ERROR : OCCURE DURING FILE LOADING");
		}catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING FILE READING");
		}
	}
	public static String getDataproperty(String value) {
		setUpProperty();
		String data = properties.getProperty(value);
		return data;
	}
	public static void main(String[] args) {
		System.out.println(getDataproperty("broswer"));
	}

}
