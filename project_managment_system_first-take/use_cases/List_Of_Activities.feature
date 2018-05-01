##Feature: List of activities
#  Description: a developer can see a list of his activities.
#  Actors: Developer
#
#  Scenario: Developer wishes to see his list of activities
#    Given that a developer is logged in
#    And the developer has a list of activities
#    When the developer wants the list of his activites
#    Then the developer gets the list of his activites
#
#  Scenario: Developer has no activities in his list, but wants to see it
#    Given that a developer is logged in
#    And the developer has no activities in his list of activities
#    When the developer wants the list of his activities
#    Then I get the error message "You are assigned to no activities"