package com.api.testrestapi;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.api.restclient.RestClient;
import com.api.test.TestBase;

public class RestAPI extends TestBase {
	TestBase tb;
	String serviceurl;
	String apiurl;
	String url;
	RestClient rc;
	
	@BeforeMethod
	public void setup() {
		tb = new TestBase();
	    serviceurl = prop.getProperty("URL");
	    apiurl = prop.getProperty("ServiceUrl");
	
	    url = serviceurl + apiurl;
	}
	@Test
	public void getApiTest() throws ClientProtocolException, IOException {
		rc = new RestClient();
		rc.get(url);
	}
}
