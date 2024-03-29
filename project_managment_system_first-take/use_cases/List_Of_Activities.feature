  Feature: List of activities
  Description: a developer can see a list of his activities.
  Actors: Developer

  Scenario: Developer wishes to see his list of activities
    Given that the developer is logged in
    And the developer has a non-empty list of activities
    When the developer wants the list of his activities
    Then the developer gets the list of his activities

  Scenario: Developer has no activities in his list, but wants to see it
    Given that the developer is logged in
    And the developer has no activities in his list of activities
    When the developer wants the list of his activities
    Then I get the error message "You are assigned to no activities"