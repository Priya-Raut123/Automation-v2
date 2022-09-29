package Tests;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.json.JSONString;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class testExample1{
	@Test
	public void validateResponseJSONBody() {
	Map<String, String> request = new HashMap<>();
    request.put("message", "otp_verified");
    request.put("type", "success");
    

    JSONString movieId = given().contentType("application/json")
   
	//x-auth-token("705cb7883bcbe7e039d4ba0fde9c8ac6")

	
      .body(request)
      .when()
      .post("https://webtest.credenc.com/otpverify")
      .then()
      .assertThat()
      .statusCode(HttpStatus.CREATED.value())
      .extract()
      .path("id");
    assertThat("String","message").isEqualTo("otp_verified");
}
}
//	@Test
//	public void validateResponseJSONBody()
//	{
//	    RestAssured.baseURI = "https://webtest.credenc.com";
//    RequestSpecification httpRequest = RestAssured.given();
//
//	    // Set HTTP Headers
//	    httpRequest.header("Content-Type", "application/json");
//	    httpRequest.header("x-auth-token","705cb7883bcbe7e039d4ba0fde9c8ac6");
//	    httpRequest.header("x-auth-id","347");
//	    
//	    Response response = httpRequest.get("/otpverify");
//	    
//
//  // Get Response Body 
//	    ResponseBody body = response.getBody();    
//    // Get Response Body as String 
//    String bodyStringValue = body.asString();
//	    // Validate if Response Body Contains a specific String
//    Assert.assertTrue(bodyStringValue.contains("otp_verified"));
//    
//    // Get JSON Representation from Response Body 
//    JsonPath jsonPathEvaluator = response.jsonPath();
//
//	    // Get specific element from JSON document 
//	    String message = jsonPathEvaluator.get("success");
//
//	    // Validate if the specific JSON element is equal to expected value
//	    Assert.assertTrue("message".equalsIgnoreCase("otp_verified"));
//	}}
//
//



