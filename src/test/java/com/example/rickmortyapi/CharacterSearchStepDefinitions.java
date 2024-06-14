package com.example.rickmortyapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CharacterSearchStepDefinitions {
    
    private String characterName;
    private String approxName;
    private String exactName;

    @Given("the user enters {string} in the search field")
    public void the_user_enters_in_the_search_field(String name) {
        characterName = name;
    }

    @Given("the user approximately enters {string} in the search field")
    public void the_user_approximately_enters_in_the_search_field(String approx) {
        approxName = approx;
    }

    @When("the user presses the search button")
    public void the_user_presses_the_search_button() {
        given()
            .queryParam("?name", characterName)
        .when()
            .get("https://rickandmortyapi.com/api/character/")
        .then()
            .statusCode(200)
            .body("results.size()", greaterThan(0));
    }

    @Then("the system displays details for {string}")
    public void the_system_displays_details_for(String expectedName) {
        given()
            .queryParam("name", characterName)
        .when()
            .get("https://rickandmortyapi.com/api/character/")
        .then()
            .statusCode(200)
            .body("results[0].name", equalTo(expectedName));
    }

    @Then("the details include name, status, location, image, and episodes")
    public void the_details_include_name_status_location_image_and_episodes() {
        given()
            .queryParam("name", characterName)
        .when()
            .get("https://rickandmortyapi.com/api/character/")
        .then()
            .statusCode(200)
            .body("results[0].name", notNullValue())
            .body("results[0].status", notNullValue())
            .body("results[0].location.name", notNullValue())
            .body("results[0].image", notNullValue())
            .body("results[0].episode", notNullValue());
    }

    @Then("the system displays a list of characters that include {string} in their name")
    public void the_system_displays_a_list_of_characters_that_include_in_their_name(String partialName) {
        given()
            .queryParam("name", partialName)
        .when()
            .get("https://rickandmortyapi.com/api/character/")
        .then()
            .statusCode(200)
            .body("results.size()", greaterThan(0));
    }

    @Then("each character in the list shows name, status, location, image, and episodes")
    public void each_character_in_the_list_shows_name_status_location_image_and_episodes() {
        given()
            .queryParam("name", characterName)
        .when()
            .get("https://rickandmortyapi.com/api/character/")
        .then()
            .statusCode(200)
            .body("results[0].name", notNullValue())
            .body("results[0].status", notNullValue())
            .body("results[0].location.name", notNullValue())
            .body("results[0].image", notNullValue())
            .body("results[0].episode", notNullValue());
    }

    @Then("the system offers suggestions close to {string}")
    public void the_system_offers_suggestions_close_to(String exact) {
        exactName = exact;
        given()
            .queryParam("name", approxName)
        .when()
            .get("https://rickandmortyapi.com/api/character/")
        .then()
            .statusCode(200)
            .body("results[0].name", equalTo(exactName));
    }
}
