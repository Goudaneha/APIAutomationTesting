package com.api.restapitest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestApiProvider {

	public CloseableHttpResponse getApiResponse(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
	    CloseableHttpResponse httpresponse = httpclient.execute(httpget);
	    
	    return httpresponse;
 	}
}