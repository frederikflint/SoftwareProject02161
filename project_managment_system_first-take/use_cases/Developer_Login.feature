Feature: Developer login
  Description: The developer logs into the system
  Actor: Developer

  Scenario: Developer can login
    Given that there is no active user on the system
    And the credentials is "dd" and the password is "1234"
    When the developer login succeeds
    Then the developer is logged in

  Scenario: Developer has the wrong username
    Given the username is "wrong username"
    When the developer login fails
    Then I get the error message "Wrong username"

#  Scenario: Developer has the wrong password
#    Given the password is "wrong password"
#    When the developer login fails
#    Then I get the error message "Wrong password"