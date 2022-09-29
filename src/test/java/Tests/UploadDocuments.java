package Tests;

//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

//import org.apache.http.HttpStatus;
import org.testng.Assert;
//import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;

//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import static org.hamcrest.Matchers.*;


public class UploadDocuments {

	
	//public class  Documents{

	  //  @Test
	   // public void sampleTest() {

	        // Json Body to pass in the request
//	        String jsonBody = "{\"cosignerData\":{\"id\":157767,\"cosignerId\":\"5838d976-368b-11ed-9e2d-0aa99d118edc\",\"firstName\":\"Testinggg2\",\"middleName\":\"\",\"lastName\":\"\",\"cosignerName\":\"Testinggg2\",\"dob\":\"\",\"mobile\":\"2345678909\",\"gender\":\"\",\"landline\":\"\",\"cosignerEmail\":\"\",\"netMonthlyIncome\":\"\",\"occupation\":\"\",\"relation\":\"\",\"relationProof\":\"\",\"citizeship\":\"\",\"hlMtInstallment\":\"\",\"panNo\":\"\",\"currentCountry\":\"\",\"currentState\":\"\",\"currentCity\":\"\",\"permanentCountry\":\"\",\"permanentState\":\"\",\"permanentCity\":\"\",\"employmentStatusId\":\"\",\"consent\":\"P\",\"otpVerifiedAt\":\"\",\"olMtInstallment\":\"\",\"banking\":[],\"work\":[],\"address\":[],\"advance\":[]},\"lead\":{\"id\":202829,\"leadId\":\"LEAD-202829\",\"borrowerId\":\"6f6c96da-1749-11ed-8e6c-0aa99d118edc\",\"takeIn\":\"\",\"priority\":\"0\",\"assignee\":1019,\"leadType\":\"\",\"emailId\":\"priya.raut@credenc.com\",\"firstName\":\"priya\",\"lastName\":\"testinHHHHH\",\"mobile\":\"6333333377\",\"status\":31,\"updatedBy\":741,\"followuptime\":\"\",\"modified\":{\"date\":\"2022-09-17 17:37:24.000000\",\"timezone_type\":3,\"timezone\":\"Asia/Kolkata\"},\"created\":{\"date\":\"2022-08-09 00:09:28.000000\",\"timezone_type\":3,\"timezone\":\"Asia/Kolkata\"},\"leadSubType\":\"41\",\"closedStatement\":\"\",\"creditNote\":\"\",\"creditStatus\":\"\",\"pendingDocList\":\"\",\"productType\":\"3\",\"leadlogs\":[{\"log\":\"\",\"name\":\"Priya Raut\",\"createdTime\":\"10-Aug-2022 04:18 PM\"},{\"log\":\"\",\"name\":\"Priya Raut\",\"createdTime\":\"10-Aug-2022 04:18 PM\"},{\"log\":\"\",\"name\":\"Priya Raut\",\"createdTime\":\"09-Aug-2022 02:39 PM\"}],\"banklogs\":[],\"creditRemarks\":[],\"callRecordings\":[],\"pdfExist\":{\"incred\":{\"path\":\"/var/www/html/credenc-crm/api/public/BANK_DATA/LEAD-202829/incred.pdf\",\"isGenerated\":0},\"avanse\":{\"path\":\"/var/www/html/credenc-crm/api/public/BANK_DATA/LEAD-202829/avanse.pdf\",\"isGenerated\":0},\"credila\":{\"path\":\"/var/www/html/credenc-crm/api/public/BANK_DATA/LEAD-202829/credila.pdf\",\"isGenerated\":0},\"auxilo\":{\"path\":\"/var/www/html/credenc-crm/api/public/BANK_DATA/LEAD-202829/auxilo.pdf\",\"isGenerated\":0}},\"leadBankStatus\":[],\"leadCallStatus\":[{\"status\":\"14\",\"log\":\"\"},{\"status\":\"41\",\"log\":\"\"},{\"status\":\"31\",\"log\":\"\"}],\"lastremark\":\"\",\"bankStatus\":[],\"callstat\":\" =>  => \",\"selectedStatus\":31},\"consentFor\":\"cosigner\",\"init\":\"resend\"}";
//
//	        given().header("authorization", "Brearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiRmluYW5jZSBQZWVyIiwidXNlcklkIjo1MjYyLCJzb3VyY2UiOiJGaW5hbmNlIiwic3ViU291cmNlIjoiRmluYW5jZSBQZWVyIiwiaWF0IjoxNjMzNTAxMzg4fQ.Sblkad9bIJFBz4HI1SONQGetrsins8WXtdHRaO5v-eY")
//	                //.header("content-type","application/json")
//	        .accept(ContentType.JSON)
//	                .contentType("application/json")
//	                .and()
//	                .body(jsonBody)
//	                .when()
//	                .post("https://staging.credenc.com/v2/getconsent")   //hit the post end point
//	                .then().
//	                assertThat()
//	                .statusCode(HttpStatus.SC_OK)
//	                .and()
//	                .body("data", equalTo("updated")); // Match the output actual to expected

	    	@Test
	        public void uploadFile() {
	    		
	    		Map<String,Object> header = new HashMap<String, Object>();
	    		header.put("x-auth-id","348");
	            File testUploadFile = new File("/home/credenc/Pictures/Screenshot.png"); //Specify your own location and file
	    		
	    		Map<String, String> map = new HashMap<String, String>();
	    		map.put("fileName","PAN_CARD");
	    	    map.put("referenceId","11d5348d-38a9-11ed-9e2d-0aa99d118edc"); 
	    	    map.put("reference","Borrower"); 
	    	    map.put("documentType","AADHAR_CARD"); 
	    	    map.put("leadId","203126"); 
	    	    map.put("file[]","testUploadFile"); 
		    	
	    		//header.put("x-auth-token","2d30e6771a040a8ed8d2a1f2674164f8");
	    		//header.put("Content-Type", "application/json");
	            
	            

	            
	            Response response = RestAssured.given()
						.baseUri("https://crmtest.credenc.com/credenc-crm/api/public/upload-multiple")
						.headers(header)
						//.File testUploadFile = new File("/home/credenc/Pictures/Screenshot.png");//Specify your own location and file
	           // multiPart(testUploadFile)
						.body(map)
						.post();
	    System.out.println("Response should be passed"+response.jsonPath().get("message"));
		Assert.assertEquals(response.jsonPath().get("message"), "Document Uploaded Successfully.");
	}
	            		
//	            		given().header("x-auth-id","348")
//	                .multiPart(testUploadFile)
//	                .when()
//	            .post()


	            //System.out.println(response.getStatusCode());
	           // System.out.println(response.toString());

	            //assertTrue(response.toString().contains("Document Uploaded Successfully."));
	            
//	            .then().
//               assertThat()
//             .statusCode(HttpStatus.SC_OK)
//              .and()
//            .body("message", equalTo("Document Uploaded Successfully.")); // Match the output actual to expected

	      
	    
	    }
	   
	    

