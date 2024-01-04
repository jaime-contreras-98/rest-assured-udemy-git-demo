package graphql;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class GraphQLTest {

	public static void main(String[] args) {
		String bodyMutation = "{\"query\":\"mutation($episodeId: String!){\\n  createEpisode(episode:{\\n    name:\\\"Mi segunda chamba loca!!\\\",\\n    air_date:\\\"02-01-2023\\\"\\n    episode:$episodeId\\n  }){\\n    id\\n  }\\n}\\n\",\"variables\":{\"episodeId\":\"1044\"}}";

		String reqMut = given().log().all().header("Content-Type", "application/json").when().body(bodyMutation)
				.post("https://rahulshettyacademy.com/gq/graphql").then().log().all().assertThat().statusCode(200)
				.extract().asString();

		JsonPath js = new JsonPath(reqMut);
		int episodeId = js.getInt("data.createEpisode.id");

		String bodyQuery = "{\"query\":\"query{\\n  episode(episodeId:" + episodeId
				+ "){\\n    name\\n    air_date\\n  }\\n}\\n\\n\\n\",\"variables\":{\"episodeName\":\"netflix\"}}";

		String reqQuery = given().log().all().header("Content-Type", "application/json").when().body(bodyQuery)
				.post("https://rahulshettyacademy.com/gq/graphql").then().log().all().assertThat().statusCode(200)
				.extract().asString();
	}

}
