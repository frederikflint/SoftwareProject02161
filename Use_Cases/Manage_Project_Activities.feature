Feature: Manage project activities
  Description: Project manager manages projects and edits them
  Actor: Project manager

  Scenario: Project activity is edited successfully
    Given that the project manager is logged in
    And the project contains at least one project activity
    When the project manager edits the project activity
    Then the project activity is changed

  Scenario: Project activity is not edited, due to being unknown to the system
    Given that the project manager is logged in
    And the project does not contain the project activity being edited
    When the project manager edits the project activity
    Then I get the error message "Activity unknown"

  Scenario: Project manager is trying to manage another project than his own
    Given that the project manager is logged in
    And another project than the one he's managing contains at least one
  project activity
    When the project manager edits that project activity
    Then I get the error message "You have not managing this project"