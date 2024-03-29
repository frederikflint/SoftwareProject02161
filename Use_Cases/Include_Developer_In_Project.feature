Feature: Include developer in project
  Description: Project manager includes a developer in a project
  Actors: Project manager

  Scenario: The project manager includes a developer in a project
    Given that the project manager is logged in
    And a developer is available
    When the project manager adds the developer to the project
    Then the developer is included in the project

  Scenario: A project manager is not logged in, trying to include a developer
  in a project
    Given that the project manager is not logged in
    And a developer is available
    When the project manager adds the developer to the project
    Then I get the error message "This action required project manager rights"

  Scenario: A project manager includes an unavailable developer in a project
    Given that the project manager is logged in
    And a developer is unavailable
    When the project manager adds the developer to the project
    Then I get the error message "Developer is not available in this period"

  Scenario: A project manager assigns a available developer to an activity
    Given that the project manager is logged in
    And a developer is available
    And the project the project manager manages contains a project activity
    And the developer is assigned to the project
    When the project manager assigns the developer to the activity
    Then the developer is assigned to the activity

  Scenario: A project manager assigns an unavailable developer to an activity
    Given that the project manager is logged in
    And that an activity is defined
    And a project manager exists
    And a developer is unavailable
    And the project manager is manager of the project with the activity
    And the developer is assigned to the project
    When the project manager assigns the developer to the activity
    Then the project manager gets the error message: "The developer is unavailable"

  Scenario: A project manager assigns a developer to an activity outside the project
  managers' project
    Given that the project manager is logged in
    And that an activity is defined
    And a project manager exists
    And a developer is available
    And the project manager is not manager of the project with the activity
    And the developer is assigned to the project
    When the project manager assigns the developer to the activity
    Then the project manager gets the error message: "You are not manager of this project"

  Scenario: A project manager assigns a developer to an activity outside the project
  managers' project
    Given that the project manager is logged in
    And that an activity is defined
    And a project manager exists
    And a developer is available
    And the project manager is not manager of the project with the activity
    And the developer is assigned to the project
    When the project manager assigns the developer to the activity
    Then the project manager gets the error message: "You are not manager of this project"