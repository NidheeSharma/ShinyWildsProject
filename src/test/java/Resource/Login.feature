
  Feature: Login with valid credentials

    Scenario Outline: Login with multiple data set

    Given Go to login page
    When user enters "<username>" and "<password>"
    Then user should redirect on home page

    Examples:
      |username|password|
      |arpitfr|Test@123|

