package com.api.PostAPiTest;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.Base.TestBase;
import com.api.data.UserData;
import com.api.postclient.PostClient;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostApiTest extends TestBase{

	TestBase testBase;
	PostClient postclient;
	CloseableHttpResponse posthttpresponse;
	String serviceurl;
	String apiurl;
	String url;
	
	@BeforeMethod
	public void setup() {
		testBase = new TestBase();
		serviceurl = properties.getProperty("URL");
		apiurl = properties.getProperty("ServiceURL");
		//https://reqres.in/api/users
		
		url = serviceurl + apiurl;
	}
	@Test
	public void postApi() throws JsonGenerationException, JsonMappingException, IOException {
		postclient = new PostClient();
		
				//jackson API:
				ObjectMapper mapper = new ObjectMapper();
				UserData userdata = new UserData("morpheus", "leader"); //expected users obejct
				
				//object to json file:
				mapper.writeValue(new File("C://Users//nehaashokj//PostApiTesting//src//main//java//com//api//data//PostResponse.json"), userdata);
				
				//java object to json in String:
				String usersJsonString = mapper.writeValueAsString(userdata);
				System.out.println(usersJsonString);
				
				posthttpresponse = postclient.postApiTest(url, usersJsonString);
		
			//validate response from API:
			//1. status code:
			int statusCode = posthttpresponse.getStatusLine().getStatusCode();
			Assert.assertEquals(statusCode, testBase.Rest_Api_Status_Code_201);
			
			//2. JsonString:
			String responseString = EntityUtils.toString(posthttpresponse.getEntity(), "UTF-8");
			
			JSONObject responseJson = new JSONObject(responseString);
			System.out.println("The response from API is:"+ responseJson);
			
			//json to java object:
			UserData userdataRespObj = mapper.readValue(responseString, UserData.class); //actual users object
			System.out.println(userdataRespObj);
			
			System.out.println(userdata.getName());
			System.out.println(userdataRespObj.getName());
			//System.out.println(userdata.getName().equals(userdataRespObj.getName()));
//			Assert.assertTrue(userdata.getName().equals(userdataRespObj.getName()));
//			Assert.assertTrue(userdata.getJob().equals(userdataRespObj.getJob()));
			
			System.out.println(userdataRespObj.getId());
			System.out.println(userdataRespObj.getCreatedAt());
		
	}
}
