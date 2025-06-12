@login
Feature: Login Functionality

  Background:
    Given Navigate to login page

  @regression
  Scenario: Login with valid credentials
    When User enters valid Username and password
    Then User should redirect on home page

  # Negative Scenarios - Invalid or Empty Credentials
  @negative @regression
  Scenario: Login with invalid credentials
    When User enters invalid Username and password
    Then User should see login error message

  Scenario: Login with empty username and password
    When User enters empty Username and password
    Then User should see required field validation messages

  Scenario: Login with valid username and empty password
    When User enters valid Username and empty password
    Then User should see required password field validation messages

  Scenario: Login with empty username and valid password
    When User enters empty Username and valid password
    Then User should see required username field validation messages

  # UI Elements Verification
  @uiVerification @regression
  Scenario: Verify Sign Up button redirects to registration page
    When User clicks on Sign Up button
    Then User should be redirected to the registration page

  Scenario: Verify password is hidden by default
    When User enters password
    Then Password field should mask the entered characters

  Scenario: Verify Show Password toggle functionality
    When User clicks on Show Password icon
    Then Password should be visible in plain text

  Scenario: Verify Forgot Password link functionality
    When User clicks on Forgot Password link
    Then User should be redirected to forgot password page

  Scenario: Verify language change functionality
    When User selects a different language from dropdown
    Then UI text should be displayed in selected language

#  Scenario: Verify logout functionality
#    When User clicks on Logout button
#    Then Then user should be logout successfully
