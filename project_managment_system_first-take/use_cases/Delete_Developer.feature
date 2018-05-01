#Feature: Delete developer
#  Description: Admin deletes a developer from the system
#  Actor: Administrator
#
#  Scenario: An administrator deletes a developer from the system
#    Given that the administrator is logged in
#    And a developer is defined
#    When the administrator deletes a developer from the system
#    Then the developer is removed from the system
#
#  Scenario: The administrator is not logged in, but tries to remove a developer from
#  the system
#    Given that the administrator is not logged in
#    When the administrator deletes a developer from the system
#    Then I get the error message "Administrator rights required for this action"