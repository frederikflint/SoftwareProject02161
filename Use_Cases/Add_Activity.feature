Feature: Add activity
  Description: An activity is added
  Actors: Developer

  Scenario: Add a personal activity successfully
    Given a developer  is logged in
    And the the developer enters a valid title, type, starting and end week for the activity
    When the activity is created
    Then the activity with the given title, type, starting week and end week is added to
  the developer

  Scenario: Add a personal activity unsuccessfully
    Given a developer  is logged in
    And the the developer enters an invalid title, type, starting and end week for
  the activity
    When the activity is created
    Then I get the error message "Activity does not satisfy credentials"

  Scenario: Add a project activity successfully
    Given that a project is defined
    And a project manager is logged in
    And there is have an activity with the title, type, starting and end week
    When an activity is added
    Then the activity with title, type, starting and end week is added to the project

  Scenario: Add a project activity unsuccessfully
    Given that a project is defined
    And a project manager is logged in
    And there is an activity with the title, type, starting and end week
    And the project already contains that project
    When the activity is added to a project
    Then I get the error message "Project already contains the activity"

  Scenario: Add project activity to developer successfully
    Given that a project activity is defined
    And a developer is logged in
    When a user adds a project activity to user
    Then the project activity is added to the user

  Scenario: Add project activity to developer unsuccessfully
    Given that a project activity is defined
    And a developer is logged in
    And the developer already contains the project
    When a developer adds a project activity to the developer
    Then I get the error message "Developer already contains the activity"