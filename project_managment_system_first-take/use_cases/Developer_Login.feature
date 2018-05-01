Feature: Developer login
  Description: The developer logs into the system
  Actor: Developer

  Scenario: Developer can login
    Given that there is no active user on the system
    And there is a developer with username "dd" registered in the system
    When the password "1234" is entered correctly
    Then the developer is logged in

#  Scenario: Developer has the wrong username
#    Given that there is no active user on the system
#    And the username is "wrong username"
#    When the developer login fails
#    Then I get the error message "wrong username"

#  Scenario: Developer has the wrong password
#    Given the password is "wrong password"
#    When the developer login fails
#    Then I get the error message "wrong password"


  #@KOPI
#  Scenario: Developer can login
#    Given that there is no active user on the system
#    And the credentials is "dd" and the password is "1234"
#    When the developer login succeeds
#    Then the developer is logged in