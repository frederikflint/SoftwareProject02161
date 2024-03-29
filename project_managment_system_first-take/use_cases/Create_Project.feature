Feature: Create Project
  Description: A developer creates a project
  Actors: Developer

  Scenario: A project is created successfully
    Given that the developer is logged in
    And the developer enters a valid project
    When the developer creates a project
    Then the project is created
    And the developer is project manager of the project

  Scenario: The developer enters a project that already exists in the planner
    Given that the developer is logged in
    And a project already exist in the planner
    And the developer enters a project with the same name as another project
    When the developer creates the project
    Then I get the error message "Project is already in the planner"
