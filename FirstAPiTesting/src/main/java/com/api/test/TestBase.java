package com.api.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public Properties prop;
	
	public TestBase() {
	
	try {
		prop=new Properties();
		FileInputStream ip = new FileInputStream("C://Users//nehaashokj//eclipse-workspace//FirstAPiTesting//config//Config.properties");
		prop.load(ip);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}
}
