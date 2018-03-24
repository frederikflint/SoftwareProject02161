Feature: Set project manager status
  Description: Register developer as project manager
  Actors: Admin

  Scenario: Administrator assigns a developer as project manager to a project.
    Given that the administrator is logged in
    And that a project has no project manager
    And a developer is defined
    When the user is registered as project manager of the project
    Then the user is project manager

  Scenario: Assign project manager status when project already has a project manager
    Given that a user is defined
    And a project is registered
    And the project has a project manager
    When that user registers as project manager
    Then the error message "Project already has a registered project leader" occur

  Scenario: Remove project manager status
    Given that a developer is project manager
    And that the administrator is logged in
    When the administrator removes the project manager status from the user
    Then the developer is no longer project manager