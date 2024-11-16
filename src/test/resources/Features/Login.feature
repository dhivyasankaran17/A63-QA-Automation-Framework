Feature: Login Feature
  Scenario: Login Positive Scenario
    Given I open Koel login page
    When I enter email "dhivya.sankaran@testpro.io"
    And I enter password "v5eUH9H2"
    And I click login button
    Then I am logged in