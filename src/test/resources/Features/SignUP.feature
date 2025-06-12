@Signup
Feature: User Registration

  As a new user
  I want to sign up with valid details
  So that I can create an account on the platform

  Background:
    Given Navigate to the Sign Up page

  @positive @signup
  Scenario: Successful signup with valid details
    When User fill the Sign Up form with valid details
    And agree to the terms and conditions
    And user submit the SignUp form
    Then account should be created successfully

  @Negative
  Scenario: Signup with missing required fields
    When User fills only email and username fields
    And user submit the SignUp form
    Then appropriate error message should be displayed for required fields

  @Negative
  Scenario: Signup with invalid email format
    When User fills the form with invalid email format
    And user submit the SignUp form
    Then error message for invalid email should be shown

  @Negative
  Scenario: Signup with mismatched password and confirm password
    When User fills the form with mismatched password and confirm password
    And user submit the SignUp form
    Then error message for password mismatch should be shown

  @Negative
  Scenario: Signup with weak password
    When User fills the form with weak password
    And user submit the SignUp form
    Then error message for weak password should be shown

  @Negative
  Scenario: Signup with already registered email
    When User fills the form with already registered email
    And user submit the SignUp form
    Then error message for duplicate email should be shown

  @Negative
  Scenario: Signup with invalid phone number
    When User fills the form with invalid phone number
    And user submit the SignUp form
    Then error message for invalid phone number should be shown

  @Negative
  Scenario: Signup with invalid postal code
    When User fills the form with invalid postal code
    And user submit the SignUp form
    Then error message for invalid postal code should be shown

  @Negative
  Scenario: Submit SignUp form without accepting terms and conditions
    When User fill the Sign Up form with valid details
    And user submit the SignUp form
    Then user should be prompted to accept terms and conditions

  @Negative
  Scenario: Submit empty form
    When user submit the SignUp form
    Then appropriate error message should be displayed for all required fields

