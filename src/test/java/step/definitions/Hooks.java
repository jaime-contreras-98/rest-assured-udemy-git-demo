package step.definitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		StepDefinition sd = new StepDefinition();
		if (StepDefinition.place_id == null) {
			sd.add_place_payload("Jaime Contreras", "MX 1203", "UK ENG");
			sd.user_calls_with_http_request("AddPlaceAPI", "POST");
			sd.verify_place_id_created_maps_to_using("Jaime Contreras", "GetPlaceAPI");
		}
	}

}
