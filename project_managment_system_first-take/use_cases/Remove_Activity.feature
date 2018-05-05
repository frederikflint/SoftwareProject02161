Feature: Remove activity
  Description: An activity is removed by developer or project manager
  Actors: Developer or project manager

  Scenario: Remove a personal activity
    Given that a developer is logged in
    And there is a activity with the title "Herimundus" defined
    When the developer removes the activity
    Then the activity is removed

  Scenario: Remove a project activity
    Given that a developer is logged in
    And a project with title "Heisenberg" is defined
    And that the developer is a project manager
    And the user is a part of the project
    And there is a activity with the title "Herimundus" defined
    When the project manager removes the activity with title "Herimundus"
    Then the activity with title "Herimundus" is removed from the project
#
#  Scenario: Remove a project activity
#    Given a project manager is logged in
#    And there is a project activity with a given title and type
#    When that activity is removed
#    Then that activity is removed from the project
#
#  Scenario: Remove project activity from user
#    Given that the project manager is logged in
#    And that project contains an activity with the given title and type
#    When that project manager removes a project activity
#    Then that project activity is removed from the project and the developer
#
#  Scenario: Removal of a nonexistent personal activity
#    Given that a user is logged in
#    And there is no personal activity with the given title and type
#    When the activity is removed
#    Then I get the error message "Activity not found"
#
#  Scenario: Removal of nonexistent project activity
#    Given a project manager is logged in
#    And there is no project activity with a given title and type
#    When that activity is removed
#    Then I get the error message "Activity not found"
#
#  Scenario: Removal of nonexistent project activity from user
#    Given that the project manager is logged in
#    And that project does not contain an activity with the given title and type
#    When that project manager removes a project activity
#    Then I get the error message "Activity not found"