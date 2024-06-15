package com.example.rickmortyapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class EpisodeSearchStepDefinitions {

    private Response response;

    @Given("the user knows the episode ID {string}")
    public void the_user_has_the_episode_id(String id) {
        RestAssured.baseURI = "https://rickandmortyapi.com/api";
        response = given()
            .pathParam("id", id)
            .when()
            .get("/episode/{id}");
    }

    @When("the user requests details for the episode")
    public void the_user_requests_details_for_the_episode() {
        response.then().statusCode(200);
    }

    @Then("the system displays details for the episode with ID {string}")
    public void the_system_displays_details_for_the_episode_with_id(String id) {
        response.then().body("id", equalTo(Integer.parseInt(id)));
    }

    @Then("the details include name, air date, and characters")
    public void the_details_include_name_air_date_and_characters() {
        response.then().body("$", hasKey("name"))
                .body("$", hasKey("air_date"))
                .body("$", hasKey("characters"));
    }
}
