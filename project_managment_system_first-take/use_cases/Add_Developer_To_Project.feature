Feature: Add developer to project
  Description: Project manager includes a developer in a project
  Actors: Project manager

  Scenario: The developer who is a project manager adds a developer to the project
    Given that the developer is logged in
    And a valid project is defined
    And that the developer is a project manager
    And that a developer is available
    When the developer adds a developer to the project
    Then the developer is added to the project

  Scenario: The developer is not project manager and adds a developer to a project
    Given that the developer is logged in
    And a valid project is defined
    And the developer is not a project manager
    And that a developer is available
    When the developer adds a developer to the project
    Then the developer is not added to the project
    And I get the error message "You need to have project manager rights to edit this project"

  Scenario: The developer who is a project manager adds an unavailable developer to the project
    Given that the developer is logged in
    And a valid project is defined
    And that the developer is a project manager
    And the developer is unavailable
    When the developer adds a developer to the project
    Then the developer is not added to the project