Feature: Admin log-in
  Description: The administrator logs into the system
  Actor: User

  Scenario: User logs in
    Given that the user is not logged in
    And the password is entered correctly
    When the user log-in succeeds
    Then the user is logged in

  Scenario: User enters wrong password
    Given that the user is not logged in
    And the password entered is wrong
    When the user log-in fails
    Then I get the error message "Wrong password"