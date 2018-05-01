#Feature: Administrator login
#  Description: The administrator logs into the system
#  Actor: Administrator
#
#  Scenario: Administrator can login
#    Given that there is no active user on the system
#    And the credentials is "admin" and the password is "adminadmin"
#    When the admin login succeeds
#    Then the admin is logged in
<<<<<<< HEAD
#
=======

>>>>>>> eb25da430b6c10eff49b62fb0c0551760bad2bc8
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