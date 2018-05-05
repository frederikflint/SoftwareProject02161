Feature: Add activity
  Description: An activity is added
  Actors: Developer

  Scenario: An activity is created successfully
    Given that a developer is logged in
    And the developer enters a valid activity
    When the developer creates the activity
    Then the activity is created

  Scenario: The developer doesn't enter valid start date
    Given that a developer is logged in
    And the developer enters an activity with an invalid start date
    When the developer creates the activity
    Then I get the error message "Invalid time for activity"

  Scenario: Add a project activity successfully
    Given that a developer is logged in
    And that the developer is a project manager
    And a project with title "Heisenberg" is defined
    And the developer enters a valid activity
    And the user is a part of the project
    When the project manager creates the project activity
    Then the activity is added to the project
#
#  Scenario: Add a project activity unsuccessfully
#    Given that a project is defined
#    And a project manager is logged in
#    And there is an activity with the title, type, starting and end week
#    And the project already contains that project
#    When the activity is added to a project
#    Then I get the error message "Project already contains the activity"
#
#  Scenario: Add project activity to developer successfully
#    Given that a project activity is defined
#    And a developer is logged in
#    When a user adds a project activity to user
#    Then the project activity is added to the user
#
#  Scenario: Add project activity to developer unsuccessfully
#    Given that a project activity is defined
#    And a developer is logged in
#    And the developer already contains the project
#    When a developer adds a project activity to the developer
#    Then I get the error message "Developer already contains the activity"