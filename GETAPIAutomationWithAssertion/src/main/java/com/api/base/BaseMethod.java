package com.api.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseMethod {
	public int Rest_Api_Status_Code_200 = 200;
	public	int Rest_Api_Status_Code_500 = 500;
	public	int Rest_Api_Status_Code_400 = 400;

	public Properties prop;
	
	public BaseMethod() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\nehaashokj\\GETAPIAutomationWithAssertion\\src\\main\\java\\com\\api\\configuartion\\config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
