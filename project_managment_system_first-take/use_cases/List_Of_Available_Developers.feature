#Feature: list of available developers
#  Description: project manager gets a list of available developers
#  Actors: Project manager
#
#  Scenario: Project manager checks list of available developers
#    Given that a developer is available
#    When the project manager retrieves the list
#    Then the available developers appear on the available list
#
#  Scenario: Project manager check an empty list of available developers
#    Given that no developer is available
#    When the project manager retrieves the list
#    Then I get the error message "No developer is currently available"