Feature: Delete project
  Description: Administrator deletes a project
  Actor: Administrator

  Scenario: Administrator deletes a project
    Given that the administrator is logged in
    And a project with title "Heisenberg" is defined
    When the administrator deletes the project with title "Heisenberg"
    Then the project with title "Heisenberg" is deleted

  Scenario: Administrator deletes a project
    Given that the administrator is logged in
    And a project with title "Heisenberg" is not defined
    When the administrator deletes the project with title "Heisenberg"
    Then I get the error message "No project with the given title was found"