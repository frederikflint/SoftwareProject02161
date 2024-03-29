Feature: Register time
  Description: developer registers time spent on an activity
  Actors: developer

  Scenario: developer registers time
    Given that the developer is logged in
    And the developer is assigned to an activity
    When the developer registers time spent on the activity
    Then the registered time is registered to the activity
    And the registered time is registered to the developer

  Scenario: developer registers time to an activity the developer is not registered to
    Given that the developer is logged in
    And the developer is not assigned to the activity
    When the developer registers time spent on the activity
    Then the developer gets the error message: "You are not assigned to this activity"

  Scenario: developer registers an invalid amount of time
    Given that the developer is logged in
    And the developer is assigned to an activity
    When the developer registers an invalid amount of time
    Then the developer gets the error message: "The input of time spent is not valid"

  Scenario: developer wants to see registered time spent to an activity
    Given that the developer is logged in
    And the developer has time registered to an activity
    When the developer checks time spent
    Then the time spent registered by the developer is displayed

  Scenario:  developer wants to see registered time spent, but hasn't registered any time
    Given that the developer is logged in
    And the developer has no time registered to an activity
    When the developer checks time spent
    Then the developer gets the error message: "No registered time spent"