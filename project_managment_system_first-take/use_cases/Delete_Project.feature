Feature: Delete project
  Description: Administrator deletes a project
  Actor: Administrator

  Scenario: Manager deletes a project
    Given that the developer is logged in
    And a project with title "Heisenberg" is defined
    When the administrator deletes the project with title "Heisenberg"
    Then the project with title "Heisenberg" is deleted

  Scenario: Developer deletes a project unsuccessfully
    Given that the developer is logged in
    And a valid project is defined in the system by another developer
    When the developer removes the project
    Then I get the error message "You need to have project manager rights to edit this project"

