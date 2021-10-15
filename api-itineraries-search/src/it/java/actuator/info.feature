Feature: A basic test for info/ end-point of Spring boot Actuator

  Background:
  # this section is optional !
  # steps here are executed before each Scenario in this file
  # variables defined here will be 'global' to all scenarios
  # and will be re-initialized before every scenario
    * url ItinaririesSearchAppUrl

  Scenario: Actuator info/ end-point success scenario
  # steps for this scenario
    * def infoResponse = read('response/infoResponse.json')
    Given path '/info'
    When method GET

    Then status 200
    And match response == infoResponse
    Then match response ==
      """
        {
          "build": {
              "groupId": "com.twa.flights",
              "artifactId": "api-itineraries-search",
              "version": "#ignore",
              "appName": "api-itineraries-search"
          }
        }
      """

  Scenario: a different scenario
  # steps for this other scenario