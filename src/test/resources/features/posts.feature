Feature: Posts API Automation

  Scenario: Create a new post
    Given JSONPlaceholder API is available
    When User create a new post with title "Learn API Testing", body "Practicing API testing with JSONPlaceholder", and userId 101
    Then the response status code should be 201
    And the response title should be "Learn API Testing"
    And the response body should be "Practicing API testing with JSONPlaceholder"
    And the response userId should be 101
    And the response should match create post JSON schema

  @retrieve
  Scenario: Retrieve all posts
    Given JSONPlaceholder API is available
    When User retrieve all posts
    Then the response status code should be 200
    And each post should have a non null id
    And the response should match posts list JSON schema

  @delete
  Scenario: Delete a post
    Given JSONPlaceholder API is available
    When User delete post with id 1
    Then the response status code should be 200
    And the delete response body should be an empty object
    And the response should match delete post JSON schema

  @update
  Scenario: Update a post
    Given JSONPlaceholder API is available
    When User update post with id 1 using title "Updated Post Title", body "This is the updated body content.", and userId 99
    Then the response status code should be 200
    And the response id should be 1
    And the response title should be "Updated Post Title"
    And the response body should be "This is the updated body content."
    And the response userId should be 99
    And the response should match update post JSON schema