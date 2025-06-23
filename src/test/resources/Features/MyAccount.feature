@myAccount
Feature: My Account Management

  As a registered user
  I want to manage my account settings
  So that I can view my personal details, address details and update password

  Background:
    Given User is logged into the application
    And User navigates to the My Account page

  Scenario: Verify Email ID and Username is displayed correctly
    Then Verify the Email ID and Username data fields should be visible

  Scenario: Verify private data is displayed correctly
    When User opens the Private Data tab
    Then Verify the private data fields should be visible

  Scenario: Verify address data is displayed correctly
    When User opens the Address tab
    Then Verify the address data fields should be visible

  @changePassword
  Scenario: Successfully change password with valid inputs
    When User opens the Change Password tab
    And User enters a valid new password
    And User confirms the password
    And User clicks on Save Changes
    Then A success message Password updated successfully should be displayed

  @changePassword
  Scenario: Change password with invalid inputs
    When User opens the Change Password tab
    And User try to enters a same password
    And User confirms with the same password
    And User clicks on Save Changes
    Then A error message should be displayed






