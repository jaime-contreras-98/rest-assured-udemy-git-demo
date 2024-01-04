package bdd.cucumber.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		if (req == null) { // SE DEJA EN CONDICIONAL PARA LA SEGUNDA/TERCERA VUELTA QUE SE GUARDEN LOS LOGS
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
		}

		return req;
	}

	public String getGlobalValue(String keyEnv) throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/jaime.contreras/eclipse-workspace/cucumber.ra/src/main/java/bdd/cucumber/resources/global.properties");
		props.load(fis);

		return props.getProperty(keyEnv);
	}

	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);

		return js.get(key).toString();
	}
}
