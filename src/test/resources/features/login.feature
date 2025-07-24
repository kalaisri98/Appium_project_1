Feature: Login Feature

  @Smoke @Positive
  Scenario: Successful Login
    Given the application is launched
    When I enter valid credentials
    Then I should be navigated to home screen
    
  @Negative 
  Scenario: Unsuccessful Login with invalid credentials
    Given the application is launched
    When I enter invalid credentials
    Then I should see an error message "Invalid user_name or password"
  
  @Mobile @Regression
  Scenario: Forgot Password Flow
    Given the application is launched
    When I tap on the "Forgot Password" link
    Then the Forgot Password screen should be displayed