Feature: Login Feature

  Scenario: Successful Login
    Given the app is launched
    When I enter valid credentials
    Then I should be navigated to home screen
