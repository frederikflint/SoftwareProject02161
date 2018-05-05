Feature: Create developer
  Description: Admin creates a developer to the system
  Actor: Administrator

  Scenario: An administrator creates a developer to the system
    Given that the administrator is logged in
    And a developer with credentials "ff" is not defined
    When the administrator creates the developer with credentials "ff" and password "1234" from the system
    Then the developer with credentials "ff" is added to the system

  Scenario: An administrator creates a developer already defined in the system
    Given that the administrator is logged in
    And a developer with credentials "nn" is defined in the system
    When the administrator creates the developer with credentials "nn" and password "1234" to the system
    Then I get the error message "This developer is already defined in the system"
    
   Scenario: A user without administrator rights tries to create a developer
     Given that there is an active user on the system
     And that the administrator is not logged in
     When the user creates the developer with credentials "mn" and password "1234" from the system
     Then I get the error message "Administrator required"