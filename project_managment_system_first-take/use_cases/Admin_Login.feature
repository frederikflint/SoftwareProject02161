#Feature: Admin login
#  Description: The admin logs into the system
#  Actor: Admin
#
#  Scenario: Admin can login
#    Given that there is no active user on the system
#    And the admin username is "admin" and password "adminadmin"
#    When the admin login succeeds
#    Then the admin is logged in

#  Scenario: Admin has the wrong username
#    Given that there is no active user on the system
#    And there is a not developer with username "notRegistered" registered in the system
#    When the developer enters the password "1234"
#    Then I get the error message "Your credentials or password was wrong"
#
#  Scenario: Admin has the wrong password
#    Given that there is no active user on the system
#    And there is a developer with username "dd" registered in the system
#    And the password "wrong password" does not match the credentials
#    When the developer enters the password "wrong password"
#    Then I get the error message "Your credentials or password was wrong"












#Feature: Administrator login
#  Description: The administrator logs into the system
#  Actor: Administrator
#
#  Scenario: Administrator can login
#    Given that there is no active user on the system
#    And the credentials is "admin" and the password is "adminadmin"
#    When the admin login succeeds
#    Then the admin is logged in

#  Scenario: Administrator has the wrong username
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