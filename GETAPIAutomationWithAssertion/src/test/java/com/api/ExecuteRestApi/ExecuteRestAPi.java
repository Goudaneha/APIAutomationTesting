package com.api.ExecuteRestApi;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.base.BaseMethod;
import com.api.restapitest.RestApiProvider;
import com.api.utility.ApiUtility;

public class ExecuteRestAPi extends BaseMethod{
	BaseMethod baseMethod;
	String URL;
	String ServiceUrl;
	String ApiUrl;
	RestApiProvider restapiProvider;
	CloseableHttpResponse closeablehttpresponse;
	
	@BeforeMethod
	public void setup() {
		baseMethod = new BaseMethod();
		ServiceUrl = prop.getProperty("URL");
		ApiUrl = prop.getProperty("Serviceurl");
		
		URL = ServiceUrl + ApiUrl;
	}

	@Test
	public void getapiresponse() throws ClientProtocolException, IOException {
		restapiProvider = new RestApiProvider();
		closeablehttpresponse = restapiProvider.getApiResponse(URL);
		
		//status code:
	int statuscode = closeablehttpresponse.getStatusLine().getStatusCode();
	System.out.println("Status code>> " +statuscode);
	Assert.assertEquals(statuscode, Rest_Api_Status_Code_200, "Wrong status code");
	
	//json string
	String jsonresponse = EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
	JSONObject jsonobject = new JSONObject(jsonresponse);
	System.out.println("JSON String Response>>" +jsonresponse);
	System.out.println("*****************************************************");
	//json object
	String per_page = ApiUtility.getValueByJPath(jsonobject, "/per_page");
	System.out.println("Per page json object>> " +per_page);
	Assert.assertEquals(Integer.parseInt(per_page), 6);
	
	String total_pages = ApiUtility.getValueByJPath(jsonobject, "total_pages");
	System.out.println("Total pages in json object>> " +total_pages);
	Assert.assertEquals(Integer.parseInt(total_pages), 2);
		//Json array
	String jsonarrayid = ApiUtility.getValueByJPath(jsonobject, "data[0]/id");
	String jsonarrayemail = ApiUtility.getValueByJPath(jsonobject, "data[0]/email");
	String jsonarrayfirstname = ApiUtility.getValueByJPath(jsonobject, "data[0]/first_name");
	String jsonarraylastname = ApiUtility.getValueByJPath(jsonobject, "data[0]/last_name");
	String jsonarrayavatar = ApiUtility.getValueByJPath(jsonobject, "data[0]/avatar");
	
	System.out.println("JSON Array id>> " +jsonarrayid);
	System.out.println("JSON Array email>> " +jsonarrayemail);
	System.out.println("JSON Array first name>> " +jsonarrayfirstname);
	System.out.println("JSON Array last name>> " +jsonarraylastname);
	System.out.println("JSON Array avatar>> " +jsonarrayavatar);
		
	}
}
