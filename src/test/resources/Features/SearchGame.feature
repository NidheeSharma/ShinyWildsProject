Feature: Home Page Search Functionality

  As a user on the Home page,
  I want to search for games using title or provider filters,
  So that I can find relevant games easily or get alerts when no results are found.

  # Positive Test Cases

  Scenario: Display essential elements of the search dialog
    Given the user is on the Home page
    When the user clicks on the search icon
    Then the title and close button should be displayed

  Scenario: Interact with Load More, Load All, and Close buttons after search
    Given the user is on the Home page
    When the user clicks on the search icon
    And enters "Blue" in the search field
    Then Load More, Load All, and Close buttons should be visible and clickable

  Scenario: Remove provider filters from the search dialog
    Given the user is on the Home page
    When the user clicks on the search icon
    And selects multiple providers from the provider dropdown
    And clicks the (X) icon on any filter tag
    Then the selected provider filter should be removed from the search dialog

  Scenario: Search for a game by exact title
    Given the user is on the Home page
    When the user clicks on the search icon
    And enters "Saxon" in the search field
    Then the "Saxon" game should be displayed in the results

  Scenario: Filter games by a single provider
    Given the user is on the Home page
    When the user clicks on the search icon
    And selects "Silver Scratch" from the provider dropdown
    Then only games provided by "Silver Scratch" should be displayed

  Scenario: Search for games by partial title
    Given the user is on the Home page
    When the user clicks on the search icon
    And enters "Mega" in the search field
    Then games with titles containing "Mega" should be displayed

  Scenario: Filter games by multiple providers
    Given the user is on the Home page
    When the user clicks on the search icon
    And selects "Saxon" and "Wild Frames" from the provider dropdown
    Then games provided by "Saxon" and "Wild Frames" should be displayed in the results

  Scenario: Remove a specific provider filter from the dialog
    Given the user is on the Home page
    When the user clicks on the search icon
    And selects "Saxon" and "Wild Frames" from the provider dropdown
    And clicks the (X) icon on the "Saxon" filter
    Then the "Saxon" filter should be removed and only "Wild Frames" games should be displayed

  # Negative Test Cases

  Scenario: Search for a non-existent game
    Given the user is on the Home page
    When the user clicks on the search icon
    And enters "Non-Existent Game" in the search field
    Then an alert message saying "No game Found!" should be displayed

  Scenario: Search for a game with special characters in the title
    Given the user is on the Home page
    When the user clicks on the search icon
    And enters "Mega@ Drago" in the search field
    Then an alert message saying "No game Found!" should be displayed
