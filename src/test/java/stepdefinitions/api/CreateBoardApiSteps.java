package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import utilities.ConfigFileReader;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class CreateBoardApiSteps {
    private static ConfigFileReader configFileReader = new ConfigFileReader();
    private RequestSpecification reqSpec;

    private String id;

    @Given("user creates board via api")
    public void user_creates_board_via_api() {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri(configFileReader.getApiUrl())
                .addQueryParam("key", configFileReader.getApiKey()).addQueryParam("token", configFileReader.getToken())
                .build();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "This is a new board via API");

        id = given().spec(reqSpec).body(requestParams.toJSONString()).contentType(ContentType.JSON).when().
                post("/boards").then().log().all().assertThat().statusCode(HttpStatus.SC_OK).extract().path("id");


        given()
                .spec(reqSpec)
                .when()
                .get("/members/me/boards")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK).body("results.size()", equalTo(1));

    }

    @When("user creates a new list via api")
    public void user_creates_a_new_list_via_api() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "This is a new list");

        given().spec(reqSpec).body(requestParams.toJSONString()).contentType(ContentType.JSON).when().header("Accept", "application/json").
                post("/boards/" + id + "/lists").then().log().all().assertThat().statusCode(HttpStatus.SC_OK);

    }

    @Then("user deletes the board via api")
    public void user_deletes_the_board_via_api() {

        given().spec(reqSpec)
                .when()
                .delete("/boards/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}

