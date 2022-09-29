package Tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OverviewGetApi {

	@Test
	public void SessionExpire() {
		
		Map<String,String> header = new HashMap<String, String>();
		
	header.put("x-auth-id","1021");
	header.put("x-auth-token","c70779bf4dee3c740cecd6f2205b8e32");
		header.put("Content-Type", "application/json");
		Map<String, String> map = new HashMap<String, String>();
		map.put("message","Session Expire.");
	    map.put("status","false"); 
		
	    Response response = RestAssured.given()
						.baseUri("https://crmtest.credenc.com/credenc-crm/api/public/overviewdata/LEAD-202829")
						.headers(header)
						.body(map)
						.post();
	    System.out.println("Response should be passed"+response.jsonPath().get("message"));
		Assert.assertEquals(response.jsonPath().get("message"), "Session Expire.");
	}
	@Test
	public void NameMatch() {
		
		Map<String,String> header = new HashMap<String, String>();
		
	header.put("x-auth-id","1021");
	header.put("x-auth-token","804c745b5a68508f78f08742d16f07ba");
		header.put("Content-Type", "application/json");
		Map<String, String> map = new HashMap<String, String>();
		map.put("firstName","priya");
		map.put("message","Success");
	     
		
	    Response response = RestAssured.given()
						.baseUri("https://crmtest.credenc.com/credenc-crm/api/public/overviewdata/LEAD-202829")
						.headers(header)
						.body(map)
						.post();
	    System.out.println("Response should be passed"+response.jsonPath().get("message"));
		Assert.assertEquals(response.jsonPath().get("message"), "Success");
	}
	
	@Test
	public void Success() {
		
		Map<String,String> header = new HashMap<String, String>();
		
	header.put("x-auth-id","1021");
	header.put("x-auth-token","804c745b5a68508f78f08742d16f07ba");
		header.put("Content-Type", "application/json");
		//Map<String, String> map = new HashMap<String, String>();
		//map.put("mobile","6333333377");
		//map.put("message","Success");
	     
		
	    Response response = RestAssured.given()
						.baseUri("https://crmtest.credenc.com/credenc-crm/api/public/overviewdata/LEAD-202829")
						.headers(header)
						//.body(map)
						.post();
	    System.out.println("Response should be passed"+response.jsonPath().get("message"));
		Assert.assertEquals(response.jsonPath().get("message"), "Success");
	}
	
	
}
