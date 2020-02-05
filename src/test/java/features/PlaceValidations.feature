Feature: Validate Add Place API 

Scenario: Verify if Place is successfully added with Add Place API 
	Given Add Place payload 
	When user calls "addPlaceAPI" Api with "POST" http request 
	Then the Api call is success with status code 200 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	
	
	
#Scenario Outline: Verify if Place is successfully added with Add Place API 
#	Given Add Place payload with values "<name"> <"language"> <"address"> 
#	When user calls "AddPlace" Api with Post http request 
#	Then the Api call is success with status code 200 
#	And "status" in response body is "OK" 
#	And "scope" in response body is "APP" 
	
#	Examples: 
#		| name            | language  | address                  |
#		| Frontline house | French-IN |29, side layout, cohen 09 |
#		| house           |eng       |adder                     |
 		 