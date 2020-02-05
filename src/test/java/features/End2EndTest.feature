Feature: Add a place using addPlaceAPI ,capture place id and get the records of that place id using getPlaceAPI

@AddPlace
Scenario: Verify if Place is successfully added with Add Place API 
	Given Add Place payload
	When user calls "addPlaceAPI" Api with "POST" http request 
	Then the Api call is success with status code 200 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	And verify 	place_Id created maps to "Frontline house1"  using "getPlaceAPI"
	
	
@DeletePlace	
Scenario: Verify if delete place functionality is working
    Given Delete Place payload
    When user calls "deletePlaceAPI" Api with "POST" http request 
    Then the Api call is success with status code 200 
    And "status" in response body is "OK" 