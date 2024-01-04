@Places
Feature: Validation of place APIs.

  @AddPlace
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add place payload with "<name>", "<address>" and "<language>"
    When user calls "AddPlaceAPI" with "Post" request
    Then the API call got success with status code 200
    And validate "status" in response body is "OK"
    And validate "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "GetPlaceAPI"

    Examples: 
      | name      | address              | language |
      | Demoss    | Emily Shoe 911       | SPANISH  |
      | Alejandro | Guillermo Prieto 120 | ENGLISH  |
      | Francisco | Colina 5188          | FRENCH   |

  @DeletePlace
  Scenario: Verify if Delete place functionality is working
    Given DeletePlace Payload
    When user calls "DeletePlaceAPI" with "POST" request
    Then the API call got success with status code 200
    And validate "status" in response body is "OK"
