package com.api.postclient;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class PostClient {

	public CloseableHttpResponse postApiTest(String url,String entity) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();//Establish connection
		HttpPost httppost = new HttpPost(url);//hit post url
		httppost.setEntity(new StringEntity(entity));//payload
		
	CloseableHttpResponse httpresponse = httpClient.execute(httppost);
	return httpresponse;
	}
}