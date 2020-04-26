package com.api.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	public int Rest_Api_Status_Code_200 = 200;
	public int Rest_Api_Status_Code_201 = 201;
	public	int Rest_Api_Status_Code_500 = 500;
	public	int Rest_Api_Status_Code_400 = 400;

	public Properties properties;
	
	public TestBase() {
		
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\nehaashokj\\PostApiTesting\\src\\main\\java\\com\\api\\config\\config.properties");
			properties.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
