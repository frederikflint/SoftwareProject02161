Feature: Delete activity
  Description: An activity is removed by developer or project manager
  Actors: Developer or project manager

  Scenario: Remove a personal activity
    Given that the developer is logged in
    And there is a activity with the title "Herimundus" defined
    When the developer removes the activity
    Then the activity is removed

  Scenario: Remove a personal activity
    Given that the developer is logged in
    And there is a activity with the title "Herimundus" is not defined
    When the developer removes the activity
    Then the activity is removed

  Scenario: Remove a project activity
    Given that the developer is logged in
    And a valid project is defined
    And a project with title "Heisenberg" is defined
    And that the developer is a project manager
    And the developer is a part of the project
    And there is a activity with the title "Herimundus" defined
    When the project manager removes the activity with title "Herimundus"
    Then the activity with title "Herimundus" is removed from the project

  Scenario: Remove a project activity failure
    Given that the developer is logged in
    And a valid project is defined
    And a project with title "Heisenberg" is defined
    And that the developer is a project manager
    And the developer is a part of the project
    And there is not an activity with the title "Herimundus" defined
    When the project manager removes the activity with title "Herimundus"
    Then I get the error message "The activity you are trying to remove is not in this project"

  Scenario: Remove a project activity unsuccessfully
    Given that the developer is logged in
    And a valid project is defined
    And a project with title "Heisenberg" is defined
    And there is a activity project with the title "Herimundus" defined
    And the developer is not project manager
    When the project manager removes the activity with title "Herimundus"
    Then I get the error message "You need to have project manager rights to edit this project"
