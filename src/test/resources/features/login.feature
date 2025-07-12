Feature: Login Feature

  @Smoke @Positive
  Scenario: Successful Login
    Given the app is launched
    When I enter valid credentials
    Then I should be navigated to home screen
    
  @Negative 
  Scenario: Unsuccessful Login with invalid credentials
    Given the app is launched
    When I enter invalid credentials
    Then I should see an error message "Invalid username or password"
