#Feature: Promote to project manager
#  Description: Promote developer to project manager
#  Actors: Administrator
#
#  Scenario: Administrator promotes a developer to project manager of a project.
#    Given that the administrator is logged in
#    And a valid project is defined
#    And that the project has no project manager
#    And a developer is defined
#    And the developer is part of the project
#    When the admin promotes developer to project manager
#    Then the developer is project manager
#
#  Scenario: Assign project manager status when project already has a project manager
#    Given that the administrator is logged in
#    And a valid project is defined
#    And a developer is defined
#    And the developer is part of the project
#    And the project has a project manager
#    When the admin promotes developer to project manager
#    Then I get the error message "Project already has a registered project manager"
#
#  Scenario: Administrator promotes a developer to project manager of a project.
#    Given that the administrator is logged in
#    And a valid project is defined
#    And that the project has no project manager
#    And a developer is defined
#    And not part
#    When the admin promotes developer to project manager
#    Then I get the error message "Developer must be a part of the project"
#
#
