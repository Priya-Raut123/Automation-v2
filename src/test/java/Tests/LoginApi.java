package Tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.HashMap;
import java.util.Map;

//import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginApi {

	@Test
	public void LoginAPISucess() {
		
		Map<String,String> header = new HashMap<String, String>();
		
	header.put("x-auth-id","347");
	header.put("x-auth-token","705cb7883bcbe7e039d4ba0fde9c8ac6");
		header.put("Content-Type", "application/json");
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobile","6333333377");
	    map.put("otp","3649"); 
		
	    Response response = RestAssured.given()
						.baseUri("https://webtest.credenc.com/otpverify")
                        
						.headers(header)
						.body(map)
						.post();
		Assert.assertEquals(response.jsonPath().get("type"), "success");
	}
	
	@Test
	public void LoginAPIFailure() {
		
		Map<String,String> header = new HashMap<String, String>();
		
	header.put("x-auth-id","347");
	header.put("x-auth-token","705cb7883bcbe7e039d4ba0fde9c8ac6");
		header.put("Content-Type", "application/json");
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobile","6333333377");
	    map.put("otp","3333"); 
		
	    Response response = RestAssured.given()
						.baseUri("https://webtest.credenc.com/otpverify")
                        
						.headers(header)
						.body(map)
						.post();
		Assert.assertEquals(response.jsonPath().get("type"), "error");
	}
	@Test
	public void LoginAPINull() {
		
		Map<String,String> header = new HashMap<String, String>();
		
	header.put("x-auth-id","347");
	header.put("x-auth-token","705cb7883bcbe7e039d4ba0fde9c8ac6");
		header.put("Content-Type", "application/json");
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobile","6333333377");
	    map.put("otp","   "); 
		
	    Response response = RestAssured.given()
						.baseUri("https://webtest.credenc.com/otpverify")
                        
						.headers(header)
						.body(map)
						.post();
		Assert.assertEquals(response.jsonPath().get("type"), "OTP NULL");
	}
}


				    //    System.out.println("Priya ne kiya" +response.getBody().asString());
						        
//	System.out.println("Body of response" + response.getBody());
//	//try {		
//	//	System.out.println(response.  .toString();
//		response.then().assertThat().body(matchesJsonSchemaInClasspath("test.json"));
//			
//	} catch (JsonSchemaValidationException e) {
//		Assert.assertTrue(false);
//	}
//			
////	RestAssured.get("https://crmtest.credenc.com/v1/overviewdata/LEAD-202829");
//	System.out.println("status Code" + response.getStatusCode());
////	System.out.println(""response.getTime());
////	System.out.println(response.getBody().asString());
//	System.out.println(response.getBody());
////	System.out.println(response.getHeader("content-type"));

	

//		
//		//Map<String,String> header = new HashMap<String, String>();
//		
//	//header.put("x-auth-id","347");
//	//header.put("x-auth-token","705cb7883bcbe7e039d4ba0fde9c8ac6");
//		//header.put("Content-Type", "application/json");
//		//Map<String, String> map = new HashMap<String, String>();
//		map.put("mobile","6333333377");
//	    map.put("otp","3555"); 
//		
//	Response response = RestAssured.given().log().all()
//						.baseUri("https://webtest.credenc.com/otpverify")
//						.headers(header)
//						.body(map)
//						.post();
//						//System.out.println(response.jsonPath().get("type"));
//	Assert.assertEquals(response.jsonPath().get("type"), "success");
//				    //    System.out.println("Priya ne kiya" +response.getBody().asString());
//	
//	
//	
////	Assert.assertEquals(response.jsonPath().get("type"), "error");
//	}
//	
//}
//
//
