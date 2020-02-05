package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;

public class StepDefinitions extends Utils {

	ResponseSpecification resSpec;
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_Id; 
	//Static:-so that value does not become null when used in another step :refer to same place id everytime
	//The variabe is shared across all test cases for that particular run.
	JsonPath js;

	@Given("Add Place payload")
	public void add_Place_payload() throws IOException {

		
		res = given().spec(requestSpecification()).body(data.addPlacePayload());

	}

	@When("user calls {string} Api with {string} http request")
	public void user_calls_Api_with_http_request(String resource, String method) {

		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		//response = res.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();
		//using Enum:resource can be addplace or deleteplace or getplace :if else can work but what if there are 100 resorces
		 APIResources resApi=APIResources.valueOf(resource); //it will execute the constructor of Enum and extract the value
		  if(method.equalsIgnoreCase("POST")) {
		 response = res.when().post(resApi.getResource()).then().spec(resSpec).extract().response();
		  }
		  else if(method.equalsIgnoreCase("GET"))
		  {
			  response = res.when().get(resApi.getResource()).then().spec(resSpec).extract().response();
		  }
	}

	@Then("the Api call is success with status code {int}")
	public void the_Api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void the_in_response_body_is(String keyValue, String expectedStatusValue) {
//		String resp = response.asString();
//		js = new JsonPath(resp);
//		String actualStatus = js.get(keyValue);
//		assertEquals(actualStatus, expectedStatusValue);
		assertEquals(getJsonPath(response,keyValue),expectedStatusValue);
	}
	
	//Scenario Outline	
	@Given("Add Place payload with values {string}> <{string}> <{string}>")
	public void add_Place_payload_with_values(String name, String language, String address) throws IOException 
	{
		res = given().spec(requestSpecification()).body(data.addPlacePayloadDynamic(name,  language,  address));
	}

	
	@Then("verify 	place_Id created maps to {string}  using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {
		//extract place id
		 place_Id=getJsonPath(response,"place_id"); 
		//Create request
		res = given().spec(requestSpecification()).queryParam("place_id", place_Id);
		//hit the resource by calling above step
		user_calls_Api_with_http_request(resource,"GET");
		//use the utility to get the value
		String actualName=getJsonPath(response,"name");
		assertEquals(expectedName,actualName);
		
	}
	
	//Delete place :ADD->Get->Delete
	@Given("Delete Place payload")
	public void delete_Place_payload() throws IOException {
	   res= given().spec(requestSpecification()).body(data.deletePlacePayload(place_Id));
	}
	
	

}
