#Feature: Developer login
#  Description: The developer logs into the system
#  Actor: Developer
#
#  Scenario: Developer can login
#    Given that there is no active user on the system
#    And the credentials is "dd" and the password is "1234"
#    When the admin login succeeds
#    Then the admin is logged in
#
#  Scenario: Developer has the wrong username
#    Given that there is no active user
#    And the username is "wrong username"
#    Then the admin login fails
#    And the admin is not logged in
#
#  Scenario: Administrator has the wrong password
#    Given that there is no active user
#    And the password is "wrong password"
#    Then the admin login fails
#    And the admin is not logged in