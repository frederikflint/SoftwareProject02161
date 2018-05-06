Feature: Create activity
  Description: An activity is added
  Actors: Developer

  Scenario: An activity is created successfully
    Given that the developer is logged in
    And the developer enters a valid activity
    When the developer creates the activity
    Then the activity is created
    
  Scenario: An activity is created unsuccessfully
    Given that the developer is logged in
    And the developer enters a valid activity
    And the activity is already registered to the developer
    When the developer creates the activity
    Then I get the error message "The activity is already created"

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
