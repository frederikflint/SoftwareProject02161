Feature: Remove activity
  Description: An activity is removed by developer or project manager
  Actors: Developer or project manager

  Scenario: Remove a personal activity
    Given that the developer is logged in
    And there is a personal activity with a given title and type
    When that activity is removed
    Then that activity is removed from the developer activities

  Scenario: Remove a project activity
    Given a project manager is logged in
    And there is a project activity with a given title and type
    When that activity is removed
    Then that activity is removed from the project

  Scenario: Remove project activity from user
    Given that the project manager is logged in
    And that project contains an activity with the given title and type
    When that project manager removes a project activity
    Then that project activity is removed from the project and the developer

  Scenario: Removal of a nonexistent personal activity
    Given that a user is logged in
    And there is no personal activity with the given title and type
    When the activity is removed
    Then I get the error message "Activity not found"

  Scenario: Removal of nonexistent project activity
    Given a project manager is logged in
    And there is no project activity with a given title and type
    When that activity is removed
    Then I get the error message "Activity not found"

  Scenario: Removal of nonexistent project activity from user
    Given that the project manager is logged in
    And that project does not contain an activity with the given title and type
    When that project manager removes a project activity
    Then I get the error message "Activity not found"