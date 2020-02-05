package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//Code to create place id if its null
		//place id will not be null if all the test cases are run in sequence
		
		StepDefinitions m=new StepDefinitions();
		if(StepDefinitions.place_Id!=null)
		{
		m.add_Place_payload_with_values("shetty", "french", "Asia");
		m.user_calls_Api_with_http_request("addPlaceAPI", "POST");
		m.verify_place_Id_created_maps_to_using("Shetty", "getPlaceAPI");
		}

	}

}
