package Tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginWebsite {

	@Test
	public void LoginAPISucess() {
		
		Map<String,String> header = new HashMap<String, String>();
		
	header.put("x-auth-id","347");
	header.put("x-auth-token","705cb7883bcbe7e039d4ba0fde9c8ac6");
		header.put("Content-Type", "application/json");
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobile","6268151912");
	    map.put("action","signup"); 
		
	    Response response = RestAssured.given()
						.baseUri("https://webtest.credenc.com/otplogin")
                        
						.headers(header)
						.body(map)
						.post();
		Assert.assertEquals(response.jsonPath().get("type"), "success");
	}
	
	@Test
	public void LoginAPIError() {
		
		Map<String,String> header = new HashMap<String, String>();
		
	header.put("x-auth-id","347");
	header.put("x-auth-token","705cb7883bcbe7e039d4ba0fde9c8ac6");
		header.put("Content-Type", "application/json");
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobile","6268151912");
	    map.put("action","signup"); 
		
	    Response response = RestAssured.given()
						.baseUri("https://webtest.credenc.com/otplogin")
                        
						.headers(header)
						.body(map)
						.post();
		Assert.assertEquals(response.jsonPath().get("type"), "success");
	}
	
}
