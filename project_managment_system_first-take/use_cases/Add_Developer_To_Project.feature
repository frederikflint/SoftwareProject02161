Feature: Add developer to project
  Description: Project manager includes a developer in a project
  Actors: Developer who is project manager

  Scenario: The developer who is a project manager adds a developer to the project
    Given that the developer is logged in
    And a valid project is defined
    And that the developer is a project manager
    And that a developer is available
    When the developer adds a developer to the project
    Then the developer is added to the project

  Scenario: The developer is not project manager and adds a developer to a project
    Given that the developer is logged in
    And a valid project is defined
    And the developer is not a project manager
    And that a developer is available
    When the developer adds a developer to the project
    Then the developer is not added to the project
    And I get the error message "You need to have project manager rights to edit this project"

  Scenario: The developer who is a project manager adds an unavailable developer to the project
    Given that the developer is logged in
    And a valid project is defined
    And that the developer is a project manager
    And the developer is unavailable
    When the developer adds a developer to the project
    Then the developer is not added to the project


#  Scenario: A project manager who is not logged in tries to add a developer
#  to a project
#    Given that the user is not logged in
#    And that a developer is available
#    When the project manager adds the developer to the project
#    Then I get the error message "This action requires project manager rights"

#
#  Scenario: A project manager assigns a available developer to an activity
#    Given that the project manager is logged in
#    And a developer is available
#    And the project the project manager manages contains a project activity
#    And the developer is assigned to the project
#    When the project manager assigns the developer to the activity
#    Then the developer is assigned to the activity
#
#  Scenario: A project manager assigns an unavailable developer to an activity
#    Given that the project manager is logged in
#    And that an activity is defined
#    And a project manager exists
#    And a developer is unavailable
#    And the project manager is manager of the project with the activity
#    And the developer is assigned to the project
#    When the project manager assigns the developer to the activity
#    Then the project manager gets the error message: "The developer is unavailable"
#
#  Scenario: A project manager assigns a developer to an activity outside the project
#  managers' project
#    Given that the project manager is logged in
#    And that an activity is defined
#    And a project manager exists
#    And a developer is available
#    And the project manager is not manager of the project with the activity
#    And the developer is assigned to the project
#    When the project manager assigns the developer to the activity
#    Then the project manager gets the error message: "You are not manager of this project"
#
#  Scenario: A project manager assigns a developer to an activity outside the project
#  managers' project
#    Given that the project manager is logged in
#    And that an activity is defined
#    And a project manager exists
#    And a developer is available
#    And the project manager is not manager of the project with the activity
#    And the developer is assigned to the project
#    When the project manager assigns the developer to the activity
#    Then the project manager gets the error message: "You are not manager of this project"