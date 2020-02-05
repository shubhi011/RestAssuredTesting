package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlacePojo;

public class TestDataBuild {
	
	public AddPlacePojo addPlacePayload()
	{
		pojo.AddPlacePojo ap=new pojo.AddPlacePojo();
		ap.setAccuracy(50);
		ap.setName("Frontline house1");
		ap.setPhone_number("(+91) 123 893 3937");
		ap.setAddress("29, side layout, cohen 091");
		ap.setWebsite("http://google.com");
		ap.setLanguage("French-INd");
		List<String> types=new ArrayList<String>();
		types.add("shoe parking");
		types.add("shops");
		ap.setTypes(types);
		
		pojo.LocationPojo l=new pojo.LocationPojo();
		l.setLat(-38.383494);
		l.setLng(33.427362);		
		ap.setLocation(l);
		
		return ap;
	}
	
	public AddPlacePojo addPlacePayloadDynamic(String name, String language, String address)
	{
		pojo.AddPlacePojo ap=new pojo.AddPlacePojo();
		ap.setAccuracy(50);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress(address);
		ap.setWebsite("http://google.com");
		ap.setLanguage(language);
		List<String> types=new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		ap.setTypes(types);
		
		pojo.LocationPojo l=new pojo.LocationPojo();
		l.setLat(-38.383494);
		l.setLng(33.427362);		
		ap.setLocation(l);
		
		return ap;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return ("{"+
				  "\"place_id\": \""+placeId+"\""+
				"}");
	}

}
