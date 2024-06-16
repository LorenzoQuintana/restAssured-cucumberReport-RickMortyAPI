package com.example.rickmortyapi;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CharacterSearchByStatusStepDefinitions {

    private Response response;

    @Before
    public void setup() {
        baseURI = "https://rickandmortyapi.com/api";
    }

    @Given("the user filters characters by status {string}")
    public void the_user_filters_characters_by_status(String status) {
        response = given()
            .queryParam("status", status)
            .when()
            .get("/character");
    }

    @When("the user presses the search button for status")
    public void the_user_presses_the_search_button_for_status() {
        response.then().statusCode(200);
    }

    @Then("the system displays a list of characters with status {string}")
    public void the_system_displays_a_list_of_characters_with_status(String status) {
        response.then().body("results.status", everyItem(equalToIgnoringCase(status)));
    }
}

