Feature: Developer login
  Description: The developer logs into the system
  Actor: Developer

  Scenario: Developer can login
    Given that there is no active user on the system
    And there is a developer with username "nl" registered in the system
    When the password "12345" is entered correctly
    Then the developer is logged in

  Scenario: Developer has the wrong username
    Given that there is no active user on the system
    And there is a not developer with username "notRegistered" registered in the system
    When the developer enters the password "12345"
    Then I get the error message "Your credentials or password was wrong"

  Scenario: Developer has the wrong password
    Given that there is no active user on the system
    And there is a developer with username "nl" registered in the system
    And the password "wrong password" does not match the credentials
    When the developer enters the password "wrong password"
    Then I get the error message "Your credentials or password was wrong"


