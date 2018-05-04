Feature: Create Project
  Description: A developer creates a project
  Actors: Developer

  Scenario: A project is created successfully
    Given that a developer is logged in
    And the developer enters a valid project
    When the developer creates the project
    Then the project is created
#
#  Scenario: The developer doesn't enter valid start date
#    Given that a developer is logged in
#    And the developer enters a project with an invalid start date
#    When the developer creates the project
#    Then I get the error message "Invalid time for project"
#
#  Scenario: The developer enters a project that already exists in the planner
#    Given that a developer is logged in
#    And a project already exist in the planner
#    And the developer enters a project with the same name as another project
#    When the developer creates the project
#    Then I get the error message "Project is already in the planner"
