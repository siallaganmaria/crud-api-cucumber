package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.anEmptyMap;

public class PostSteps {

    private Response response;
    private Map<String, Object> requestBody;

//  Function Create
    @Given("JSONPlaceholder API is available")
    public void jsonplaceholder_api_is_available() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("User create a new post with title {string}, body {string}, and userId {int}")
    public void i_create_a_new_post_with_title_body_and_user_id(
            String title,
            String body,
            Integer userId
    ) {
        requestBody = new HashMap<>();
        requestBody.put("title", title);
        requestBody.put("body", body);
        requestBody.put("userId", userId);

        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .post("/posts")
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("CREATE RESPONSE:");
        System.out.println(response.asPrettyString());
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the response title should be {string}")
    public void the_response_title_should_be(String expectedTitle) {
        response.then().body("title", equalTo(expectedTitle));
    }

    @Then("the response body should be {string}")
    public void the_response_body_should_be(String expectedBody) {
        response.then().body("body", equalTo(expectedBody));
    }

    @Then("the response userId should be {int}")
    public void the_response_user_id_should_be(Integer expectedUserId) {
        response.then().body("userId", equalTo(expectedUserId));
    }

    @Then("the response should match create post JSON schema")
    public void the_response_should_match_create_post_json_schema() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/create-post-schema.json"));
    }
//   Retrieve Function
    @When("User retrieve all posts")
    public void user_retrieve_all_posts() {
        response = RestAssured
                .given()
                .log().all()
                .when()
                .get("/posts")
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("RETRIEVE POSTS RESPONSE:");
        System.out.println(response.asPrettyString());
    }

    @Then("each post should have a non null id")
    public void each_post_should_have_a_non_null_id() {
        List<Integer> ids = response.jsonPath().getList("id");

        assertNotNull(ids);
        assertFalse(ids.isEmpty());

        for (Integer id : ids) {
            assertNotNull(id);
        }
    }

    @Then("the response should match posts list JSON schema")
    public void the_response_should_match_posts_list_json_schema() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/posts-list-schema.json"));
    }

//    Delete Function
@When("User delete post with id {int}")
public void user_delete_post_with_id(Integer id) {
    response = RestAssured
            .given()
            .log().all()
            .when()
            .delete("/posts/" + id)
            .then()
            .log().all()
            .extract()
            .response();

    System.out.println("DELETE RESPONSE:");
    System.out.println(response.asPrettyString());
}

    @Then("the delete response body should be an empty object")
    public void the_delete_response_body_should_be_an_empty_object() {
        response.then().body("$", anEmptyMap());
    }

    @Then("the response should match delete post JSON schema")
    public void the_response_should_match_delete_post_json_schema() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/delete-post-schema.json"));
    }

//    Update Function
@When("User update post with id {int} using title {string}, body {string}, and userId {int}")
public void user_update_post_with_id_using_title_body_and_user_id(
        Integer id,
        String title,
        String body,
        Integer userId
) {
    requestBody = new HashMap<>();
    requestBody.put("id", id);
    requestBody.put("title", title);
    requestBody.put("body", body);
    requestBody.put("userId", userId);

    response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .log().all()
            .when()
            .put("/posts/" + id)
            .then()
            .log().all()
            .extract()
            .response();
}

    @Then("the response id should be {int}")
    public void the_response_id_should_be(Integer expectedId) {
        response.then().body("id", equalTo(expectedId));
    }

    @Then("the response should match update post JSON schema")
    public void the_response_should_match_update_post_json_schema() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/update-post-schema.json"));
    }
}