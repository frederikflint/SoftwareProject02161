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

