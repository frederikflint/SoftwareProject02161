#Feature: Delete project
#  Description: Administrator deletes a project
#  Actor: Administrator
#
#  Scenario: Administrator deletes a project
#    Given that the administrator is logged in
#    When the administrator deletes a project
#    Then the project is deleted
#
#  Scenario: Administrator deletes a project that doesn't exist
#    Given that the administrator is logged in
#    When the administrator deletes a project
#    And that project doesn't exist
#    Then I get the error message "the entered project doesn't exist"