package step.definitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import bdd.cucumber.resources.APIResources;
import bdd.cucumber.resources.TestDataBuild;
import bdd.cucumber.resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild bodyData = new TestDataBuild();
	static String place_id;

	@Given("Add place payload with {string}, {string} and {string}")
	public void add_place_payload(String name, String address, String language) throws IOException {
		res = given().spec(requestSpecification()).body(bodyData.addPlacePayload(name, address, language));
	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		res = given().spec(requestSpecification()).body(bodyData.deletePlacePayload(place_id));
	}

	@When("user calls {string} with {string} request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		APIResources resourceAPI = APIResources.valueOf(resource);

		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (httpMethod.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource()).then().spec(resSpec).extract().response();
		else if (httpMethod.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource()).then().spec(resSpec).extract().response();
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int statusCode) {
		int respStatusCode = response.getStatusCode();

		assertEquals(respStatusCode, statusCode);
	}

	@Then("validate {string} in response body is {string}")
	public void in_response_body_is(String respMessage, String stringMessage) {
		assertEquals(getJsonPath(response, respMessage), stringMessage);
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) {
		place_id = getJsonPath(response, "place_id");

		res = given().spec(res).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");

		String name = getJsonPath(response, "name");
		assertEquals(name, expectedName);
	}

}
