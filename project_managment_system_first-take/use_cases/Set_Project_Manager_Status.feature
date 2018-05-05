Feature: Set project manager status
  Description: Register developer as project manager
  Actors: Admin

  Scenario: Administrator assigns a developer as project manager to a project.
    Given that the administrator is logged in
    And a project is defined
    And that a project has no project manager
    And a developer is defined
    When the admin assigns user to project manager
    Then the user is project manager

  Scenario: Assign project manager status when project already has a project manager
    Given that the administrator is logged in
    And a project is defined
    And a developer is defined
    And a project has a project manager
    When the admin assigns user to project manager
    Then I get the error message "Project already has a registered project manager"

  Scenario: Remove project manager status
    Given that the administrator is logged in
    And a project is defined
    And a developer is defined
    And a project has a project manager
    When the administrator removes the project manager status from the user
    Then the developer is no longer project manager


  Scenario: Assigns a developer as project manager to a project without admin rights.
    Given a developer is defined
    And  that a developer is logged in
    And a project is defined
    And that a project has no project manager
    When the admin assigns user to project manager
    Then the user is project manager
