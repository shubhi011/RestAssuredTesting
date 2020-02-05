package resources;


//Enum is special class in java which has collection of constants and methods
//more optimized code
//
public enum APIResources {
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),   //Separarted by comma since enum treats methods as collection
	deletePlaceAPI("/maps/api/place/delete/json"); 
	
	public String resource;
	
	APIResources(String resource)   //Rule to define a constructor
	//when this constructor is called ,resource will be loaded with actual value
	{
		this.resource=resource;   //this refers to current class resource.Now the value of resource in constructor is assigned to local resource.
		
	}
	
	public String getResource()
	{
		return resource;   
	}

}
