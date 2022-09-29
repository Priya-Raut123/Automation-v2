package Tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

//import apiCofigs.ApiEndPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OverviewApi {
	public class SessionExpire {
		//ApiEndPath endPath = new ApiEndPath();
		
		@Test
		public void LoginAPISucess() {
			
			Map<String,String> header = new HashMap<String, String>();
			
		header.put("x-auth-id","1021");
		header.put("x-auth-token","acd239b5bf10c729d46f658262651681");
			header.put("Content-Type", "application/json");
			Map<String, String> map = new HashMap<String, String>();
			map.put("borrowerUuid","6f6c96da-1749-11ed-8e6c-0aa99d118edc");
		    Response response = RestAssured.given()
							.baseUri("https://crmtest.credenc.com/credenc-crm/api/public/overviewdata/LEAD-202829")
							.headers(header)
							.body(map)
							.post();
		    System.out.println("Response should be passed"+response.jsonPath().get("message"));
			Assert.assertEquals(response.jsonPath().get("message"), "Session Expire.");
		}
		
			
			@Test
			public void Success() {
				
				Map<String,String> header = new HashMap<String, String>();
				
			header.put("x-auth-id","1021");
			header.put("x-auth-token","804c745b5a68508f78f08742d16f07ba");
				header.put("Content-Type", "application/json");
				Map<String, String> map = new HashMap<String, String>();
				map.put("borrowerUuid","6f6c96da-1749-11ed-8e6c-0aa99d118edc");
				map.put("mobile","6333333377");
				
			    Response response = RestAssured.given()
								.baseUri("https://crmtest.credenc.com/credenc-crm/api/public/overviewdata/LEAD-202829")
								.headers(header)
								.body(map)
								.post();
			    System.out.println("Response should be passed"+response.jsonPath().get("message"));
				Assert.assertEquals(response.jsonPath().get("message"), "Success");
			}
			
			@Test
			public void Success1() {
				
				Map<String,String> header = new HashMap<String, String>();
				
			header.put("x-auth-id","1021");
			header.put("x-auth-token","804c745b5a68508f78f08742d16f07ba");
				header.put("Content-Type", "application/json");
				Map<String, String> map = new HashMap<String, String>();
				map.put("borrowerUuid","6f6c96da-1749-11ed-8e6c-0aa99d118edc");
				 map.put("firstName","priya");
			    
			   
				
			    Response response = RestAssured.given()
								.baseUri("https://crmtest.credenc.com/credenc-crm/api/public/overviewdata/LEAD-202829")
								.headers(header)
								.body(map)
								.post();
			    System.out.println("Response should be passed"+response.jsonPath().get("message"));
				Assert.assertEquals(response.jsonPath().get("message"),"Success");
			}
	
	}
}
