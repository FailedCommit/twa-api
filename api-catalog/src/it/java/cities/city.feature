Feature: Catalog Cities

  Background:
    * url AppUrl

  Scenario: City OK
    * def catalogRes = read('response/response.json')
    Given path '/city/BUE'
    When method GET

    Then status 200
    Then match response == catalogRes