Feature: Delete developer
  Description: Admin deletes a developer from the system
  Actor: Administrator

  Scenario: An administrator deletes a developer from the system
    Given that the administrator is logged in
    And a developer with credentials "ff" and password "1234" is defined
    When the administrator deletes the developer with credentials "ff" from the system
    Then the developer with credentials "ff" is removed from the system

  Scenario: An administrator tries to delete a developer not given in the system
    Given that the administrator is logged in
    And a developer with credentials "ff" and password "1234" is defined
    When the administrator tries to delete the developer with credentials "mvc"
    Then I get the error message "No such user is defined in the system"

  Scenario: The administrator is not logged in, but tries to remove a developer from the system
    Given that there is an active user on the system
    And that the administrator is not logged in
    When the administrator deletes a developer with credentials "ff" from the system
    Then I get the error message "Administrator required"