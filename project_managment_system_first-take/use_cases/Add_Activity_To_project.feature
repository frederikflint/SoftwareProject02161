Feature: Add activity to project
  Description: Project manager includes a developer in a project
  Actors: Project manager

  Scenario: Add a project activity successfully
    Given that the developer is logged in
    And a valid project is defined in the system
    And the developer is project manager of the project
    And the developer enters a valid activity
    When the project manager creates the project activity
    Then the activity is added to the project

  Scenario: Add a project activity unsuccessfully
    Given that the developer is logged in
    And a valid project is defined in the system
    And the developer is project manager of the project
    And the project already contains that activity
    When the project manager creates the project activity
    Then I get the error message "The activity is already a part of the project"