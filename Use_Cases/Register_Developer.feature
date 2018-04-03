Feature: Register developer
  Description: The administrator registers a developer of Softwarehuset
  Actors: Administrator

  Scenario: Register a developer
    Given that the administrator is logged in
    And the administrator enters initials for the developer
    When the administrator registers the developer
    Then that developer is a registered developer of Softwarehuset with the
  given initials

  Scenario: Register a developer without administrator rights
    Given that the administrator is not logged in
    And the administrator enters initials for the developer
    When the administrator registers the user
    Then I get the error message "Administrator rights required for this action"

  Scenario: Register a user that is already registered
    Given the administrator is logged in
    And a user is registered with the given initials
    When the administrator registers the user
    Then I get the error message "User is already registered"