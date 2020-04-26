package com.api.restclient;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	public void get(String url) throws ClientProtocolException, IOException {
		//1.Get Methods	
	CloseableHttpClient closeablehttpclient = HttpClients.createDefault();//Establish connection
	HttpGet httpget = new HttpGet(url); //Retrieve information from Get req
	CloseableHttpResponse closeablehttpresp = closeablehttpclient.execute(httpget);//hit url
	
	//2.Status code
	int statuscode = closeablehttpresp.getStatusLine().getStatusCode();
	System.out.println("The status code"+ statuscode);
	
	//3.Response
	String responseString = EntityUtils.toString(closeablehttpresp.getEntity(),"UTF-8");
	//String into JSON,create JSON obj
	JSONObject jsonobject = new JSONObject(responseString);
	System.out.println("The Response JSON from Api"+jsonobject);
	
	//4.Headers
	Header[] headerArray = closeablehttpresp.getAllHeaders();//list of array
	HashMap<String, String> allHeaders = new HashMap<String, String>();//iterate
	for(Header header : headerArray) {
		allHeaders.put(header.getName(),header.getValue());
			}
	System.out.println("Header"+allHeaders);
	
	}
}
