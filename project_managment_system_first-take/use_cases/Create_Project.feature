#Feature: Create Project
#  Description: A developer creates a project
#  Actors: Developer
#
#  Scenario: A project is created successfully
#    Given that a developer is logged in
#    And the developer enters a valid project number, name, description, start and end date
#    When the user creates the project
#    Then the project with that project number, name, description and start and end date is created
#
#  Scenario: The developer doesn't enter valid start and end dates
#    Given that a developer is logged in
#    And the developer enters an invalid project number, name, description, start or end date
#    When the developer creates the project
#    Then I get the error message "Invalid project credentials"
