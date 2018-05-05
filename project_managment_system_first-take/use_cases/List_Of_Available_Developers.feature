Feature: list of available developers
  Description: project manager gets a list of available developers
  Actors: Project manager

  Scenario: Project manager checks list of available developers
    Given that the developer is logged in
    And that the developer is a project manager
    And that a developer is available
    When the project manager asks for a list
    Then the project manager gets a list of available developers

  Scenario: Project manager check an empty list of available developers
    Given that the developer is logged in
    And the developer enters a valid activity
    And that the developer is a project manager
    And that no developer is available
    When the project manager asks for a list
    Then I get the error message "No developer is currently available"