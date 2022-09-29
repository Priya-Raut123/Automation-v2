package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestExamples {

	 @Test
	    public void sampleTest() {

	        // Json Body to pass in the request
	        String jsonBody = "mobile=6333333377&otp=3649";

	        given().//header("authorization", "Brearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiRmluYW5jZSBQZWVyIiwidXNlcklkIjo1MjYyLCJzb3VyY2UiOiJGaW5hbmNlIiwic3ViU291cmNlIjoiRmluYW5jZSBQZWVyIiwiaWF0IjoxNjMzNTAxMzg4fQ.Sblkad9bIJFBz4HI1SONQGetrsins8WXtdHRaO5v-eY")
	                //.header("content-type","application/json")
	        accept(ContentType.JSON)
	               .contentType("application/json")
	                .and()
	                .body(jsonBody)
	                .when()
	                .post("https://webtest.credenc.com/otpverify")   //hit the post end point
	                .then().
	                assertThat()
	                .statusCode(HttpStatus.SC_OK)
	                .and()
	                .body("type", equalTo("success")); // Match the output actual to expected

	    }
	}

