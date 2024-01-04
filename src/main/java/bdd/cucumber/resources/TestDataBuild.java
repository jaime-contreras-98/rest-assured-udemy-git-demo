package bdd.cucumber.resources;

import java.util.ArrayList;
import java.util.List;

import bdd.cucumber.pojo.AddPlace;
import bdd.cucumber.pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload(String name, String address, String language) {
		Location location = new Location(45.97f, 35.94f);

		List<String> types = new ArrayList<String>();
		types.add("Un tipo");
		types.add("Dos tipos");
		types.add("Tres tipos");

		AddPlace addPlace = new AddPlace(location, 50, name, "644 129 5130", address, types, "www.jcontreraasv.com",
				language);

		return addPlace;
	}

	public String deletePlacePayload(String placeId) {
		return "{\r\n\"place_id\":\"" + placeId + "\"\r\n}\r\n";
	}

}
