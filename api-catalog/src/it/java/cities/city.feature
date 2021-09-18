Feature: Catalog

  Background:
    * url AppUrl

  Scenario: City OK
    * def catalog_response = read('response/catalog_response.json')
    Given path '/cities/BUE'
    When method GET

    Then status 200
    Then match response == search_response