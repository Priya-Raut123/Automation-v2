package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidationException;
import io.restassured.response.Response;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



public class GetApi {

	@Test
	public void testGet() throws IOException {
	
		Map<String,String> header = new HashMap<String, String>();
		
		header.put("x-auth-id","347");
		header.put("x-auth-token","705cb7883bcbe7e039d4ba0fde9c8ac6");
		
		
	Response response = RestAssured.given()
						.baseUri("https://crmtest.credenc.com/v1/overviewdata/LEAD-202829")
						.headers(header)
						.get();
	try {		
		response.then().assertThat().body(matchesJsonSchemaInClasspath("get.json"));
	} catch (JsonSchemaValidationException e) {
		Assert.assertTrue(false);
	}
			
//	RestAssured.get("https://crmtest.credenc.com/v1/overviewdata/LEAD-202829");
	System.out.println("status Code" + response.getStatusCode());
//	System.out.println(""response.getTime());
//	System.out.println(response.getBody().asString());
	System.out.println(response.getBody());
//	System.out.println(response.getHeader("content-type"));
	
	//utils.WriteData writeData = new utils.WriteData();
	
	//writeData.priya(response.getBody());
	
	
		
	
	}
	
}
