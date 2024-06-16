package com.example.rickmortyapi;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CharacterDetailsStepDefinitions {

    private int characterId;

    @Before
    public void setup() {
        baseURI = "https://rickandmortyapi.com/api";
    }

    @Given("the user has the ID {string}")
    public void the_user_has_the_id(String id) {
        characterId = Integer.parseInt(id);
    }

    @When("the user requests details for the character")
    public void the_user_requests_details_for_the_character() {
        given()
            .pathParam("id", characterId)
        .when()
            .get("/character/{id}")
        .then()
            .statusCode(200);
    }

    @Then("the system displays details for the character with ID {string}")
    public void the_system_displays_details_for_the_character_with_id(String id) {
        given()
            .pathParam("id", Integer.parseInt(id))
        .when()
            .get("/character/{id}")
        .then()
            .statusCode(200)
            .body("id", equalTo(Integer.parseInt(id)));
    }

    @Then("the details include name, status, species, gender, origin, location, image, and episodes")
    public void the_details_include_name_status_species_gender_origin_location_image_and_episodes() {
        given()
            .pathParam("id", characterId)
        .when()
            .get("/character/{id}")
        .then()
            .statusCode(200)
            .body("name", notNullValue())
            .body("status", notNullValue())
            .body("species", notNullValue())
            .body("gender", notNullValue())
            .body("origin.name", notNullValue())
            .body("location.name", notNullValue())
            .body("image", notNullValue())
            .body("episode", notNullValue());
    }
}

