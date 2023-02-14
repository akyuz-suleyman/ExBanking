@functional
Feature: Testing API for functional test

  @create_user
  Scenario: Verify that a new user account can be created with valid input data.
    Given Prepare the request data for creating a new user account
    When Send a POST request to the create_user API endpoint
    Then Verify that the API response is a 201 status code
    Then Verify that the response contains success field set to true

  @deposit
  Scenario:Verify that the deposit history is updated after a successful deposit.
    Given Prepare the request data for making a deposit with valid input data
    When Send a POST request to the deposit API endpoint
    Then Verify that the API response is a 200 status code

  @withdraw
  Scenario: Verify that a withdrawal can be made successfully with valid input data
    Given Prepare the request data for making a withdrawal with a valid account number and amount
    When Send a POST request to the withdraw API endpoint with the request data
    Then Verify that the API response is a 200 status code

  @get_balance
  Scenario: Verify that the API returns the correct account ID in the response
    Given Send a GET request to the get_balance API endpoint with the request data
    When Verify that the API response is a 200 status code

  @send
  Scenario: Verify that a user can successfully send money to another user with valid input data
    Given Prepare the request data for sending money
    When Send a POST request to the send API endpoint
    Then Verify that the API response is a 200 status code
    Then Verify that the response contains success field set to true


