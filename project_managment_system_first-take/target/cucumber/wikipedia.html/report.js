$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases/Create_Activity.feature");
formatter.feature({
  "name": "Add activity",
  "description": "  Description: An activity is added\n  Actors: Developer",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "An activity is created successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters a valid activity",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theDeveloperEntersAValidActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer creates the activity",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theDeveloperCreatesTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity is created",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theActivityIsCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The developer doesn\u0027t enter valid start date",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters an activity with an invalid start date",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theDeveloperEntersAnActivityWithAnInvalidStartDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer creates the activity",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theDeveloperCreatesTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"Invalid time for activity\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a project activity successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the developer is a project manager",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatTheDeveloperIsAProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project with title \"Heisenberg\" is defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.aProjectWithTitleIsDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters a valid activity",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theDeveloperEntersAValidActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is a part of the project",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theUserIsAPartOfTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project manager creates the project activity",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theProjectManagerCreatesTheProjectActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity is added to the project",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theActivityIsAddedToTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/Create_Developer.feature");
formatter.feature({
  "name": "Create developer",
  "description": "  Description: Admin creates a developer to the system\n  Actor: Administrator",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "An administrator creates a developer to the system",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "ManagerSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a developer with credentials \"ff\" is not defined",
  "keyword": "And "
});
formatter.match({
  "location": "CRUD.aDeveloperWithCredentialsIsNotDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator creates the developer with credentials \"ff\" and password \"1234\" from the system",
  "keyword": "When "
});
formatter.match({
  "location": "CRUD.theAdministratorCreatesTheDeveloperWithCredentialsAndPasswordFromTheSystem(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer with credentials \"ff\" is added to the system",
  "keyword": "Then "
});
formatter.match({
  "location": "CRUD.theDeveloperWithCredentialsIsAddedToTheSystem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "An administrator creates a developer already defined in the system",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "ManagerSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a developer with credentials \"nn\" is defined in the system",
  "keyword": "And "
});
formatter.match({
  "location": "CRUD.aDeveloperWithCredentialsIsDefinedInTheSystem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator creates the developer with credentials \"nn\" and password \"1234\" to the system",
  "keyword": "When "
});
formatter.match({
  "location": "CRUD.theAdministratorCreatesTheDeveloperWithCredentialsAndPasswordToTheSystem(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"This developer is already defined in the system\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A user without administrator rights tries to create a developer",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that there is an active user on the system",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatThereIsAnActiveUserOnTheSystem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the administrator is not logged in",
  "keyword": "And "
});
formatter.match({
  "location": "CRUD.thatTheAdministratorIsNotLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user creates the developer with credentials \"mn\" and password \"1234\" from the system",
  "keyword": "When "
});
formatter.match({
  "location": "CRUD.theUserCreatesTheDeveloperWithCredentialsAndPasswordFromTheSystem(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"Administrator required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/Create_Project.feature");
formatter.feature({
  "name": "Create Project",
  "description": "  Description: A developer creates a project\n  Actors: Developer",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "A project is created successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters a valid project",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theDeveloperEntersAValidProjectNumberNameDescriptionStartAndEndDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer creates the project",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theDeveloperCreatesTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project is created",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theProjectWithThatProjectNumberNameDescriptionAndStartAndEndDateIsCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The developer doesn\u0027t enter valid start date",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters a project with an invalid start date",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theDeveloperEntersAProjectWithAnInvalidStartDate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer creates the project",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theDeveloperCreatesTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"Invalid time for project\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The developer enters a project that already exists in the planner",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project already exist in the planner",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.aProjectAlreadyExistInThePlanner()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters a project with the same name as another project",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theDeveloperEntersAProjectWithTheSameNameAsAnotherProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer creates the project",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theDeveloperCreatesTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"Project is already in the planner\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/Delete_Developer.feature");
formatter.feature({
  "name": "Delete developer",
  "description": "  Description: Admin deletes a developer from the system\n  Actor: Administrator",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "An administrator deletes a developer from the system",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "ManagerSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a developer with credentials \"ff\" and password \"1234\" is defined",
  "keyword": "And "
});
formatter.match({
  "location": "CRUD.aDeveloperWithCredentialsAndPasswordIsDefined(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator deletes the developer with credentials \"ff\" from the system",
  "keyword": "When "
});
formatter.match({
  "location": "CRUD.theAdministratorDeletesTheDeveloperWithCredentialsFromTheSystem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer with credentials \"ff\" is removed from the system",
  "keyword": "Then "
});
formatter.match({
  "location": "CRUD.theDeveloperWithCredentialsIsRemovedFromTheSystem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "An administrator tries to delete a developer not given in the system",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "ManagerSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a developer with credentials \"ff\" and password \"1234\" is defined",
  "keyword": "And "
});
formatter.match({
  "location": "CRUD.aDeveloperWithCredentialsAndPasswordIsDefined(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator tries to delete the developer with credentials \"mvc\"",
  "keyword": "When "
});
formatter.match({
  "location": "CRUD.theAdministratorTriesToDeleteTheDeveloperWithCredentials(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"No such user is defined in the system\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The administrator is not logged in, but tries to remove a developer from the system",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that there is an active user on the system",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatThereIsAnActiveUserOnTheSystem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the administrator is not logged in",
  "keyword": "And "
});
formatter.match({
  "location": "CRUD.thatTheAdministratorIsNotLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator deletes a developer with credentials \"ff\" from the system",
  "keyword": "When "
});
formatter.match({
  "location": "CRUD.theAdministratorDeletesADeveloperWithCredentialsFromTheSystem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"Administrator rights required for this action\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/Delete_Project.feature");
formatter.feature({
  "name": "Delete project",
  "description": "  Description: Administrator deletes a project\n  Actor: Administrator",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Administrator deletes a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "ManagerSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project with title \"Heisenberg\" is defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.aProjectWithTitleIsDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator deletes the project with title \"Heisenberg\"",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theAdministratorDeletesTheProjectWithTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project with title \"Heisenberg\" is deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theProjectWithTitleIsDeleted(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Administrator deletes a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "ManagerSteps.thatTheAdministratorIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project with title \"Heisenberg\" is not defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.aProjectWithTitleIsNotDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the administrator deletes the project with title \"Heisenberg\"",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theAdministratorDeletesTheProjectWithTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"No such project in the system\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/Developer_Login.feature");
formatter.feature({
  "name": "Developer login",
  "description": "  Description: The developer logs into the system\n  Actor: Developer",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Developer can login",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that there is no active user on the system",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatThereIsNoActiveUserOnTheSystem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a developer with username \"nl\" and password \"12345\" registered in the system",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.thereIsADeveloperWithUsernameAndPasswordRegisteredInTheSystem(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the password \"12345\" is entered correctly",
  "keyword": "When "
});
formatter.match({
  "location": "LoginLogoutSteps.thePasswordIsEnteredCorrectly(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginLogoutSteps.theDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Developer has the wrong username",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that there is no active user on the system",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatThereIsNoActiveUserOnTheSystem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a not developer with username \"notRegistered\" registered in the system",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.thereIsANotDeveloperWithUsernameRegisteredInTheSystem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters the password \"12345\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginLogoutSteps.theDeveloperEntersThePassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"Your credentials or password was wrong\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Developer has the wrong password",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that there is no active user on the system",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatThereIsNoActiveUserOnTheSystem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a developer with username \"nl\" registered in the system",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.thereIsADeveloperWithUsernameRegisteredInTheSystem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the password \"wrong password\" does not match the credentials",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.thePasswordDoesNotMatchTheCredentials(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters the password \"wrong password\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginLogoutSteps.theDeveloperEntersThePassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"Your credentials or password was wrong\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/Include_Developer_In_Project.feature");
formatter.feature({
  "name": "Include developer in project",
  "description": "  Description: Project manager includes a developer in a project\n  Actors: Developer",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "The developer who is a project manager adds a developer to a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the developer is a project manager",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatTheDeveloperIsAProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that a developer is available",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatADeveloperIsAvailable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer adds a developer to the project",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectManagerSteps.theDeveloperAddsADeveloperToTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer is included in the project",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectManagerSteps.theDeveloperIsIncludedInTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The developer is not project manager and adds a developer to a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a valid project is defined",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.aValidProjectIsDefined()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer is not a project manager",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.theDeveloperIsNotAProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that a developer is available",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatADeveloperIsAvailable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer adds a developer to the project",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectManagerSteps.theDeveloperAddsADeveloperToTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer is included in the project",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectManagerSteps.theDeveloperIsIncludedInTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/List_Of_Activities.feature");
formatter.feature({
  "name": "List of activities",
  "description": "  Description: a developer can see a list of his activities.\n  Actors: Developer",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Developer wishes to see his list of activities",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer has a non-empty list of activities",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.the_developer_has_a_non_empty_list_of_activities()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer wants the list of his activities",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theDeveloperWantsTheListOfHisActivities()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer gets the list of his activities",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theDeveloperGetsTheListOfHisActivities()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Developer has no activities in his list, but wants to see it",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer has no activities in his list of activities",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.the_developer_has_no_activities_in_his_list_of_activities()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer wants the list of his activities",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theDeveloperWantsTheListOfHisActivities()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"You are assigned to no activities\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/List_Of_Available_Developers.feature");
formatter.feature({
  "name": "list of available developers",
  "description": "  Description: project manager gets a list of available developers\n  Actors: Project manager",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Project manager checks list of available developers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the developer is a project manager",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatTheDeveloperIsAProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that a developer is available",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatADeveloperIsAvailable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project manager asks for a list",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectManagerSteps.theProjectManagerAsksForAList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project manager gets a list of available developers",
  "keyword": "Then "
});
formatter.match({
  "location": "ProjectManagerSteps.theProjectManagerGetsAListOfAvailableDevelopers()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Project manager check an empty list of available developers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters a valid activity",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theDeveloperEntersAValidActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the developer is a project manager",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatTheDeveloperIsAProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that no developer is available",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatNoDeveloperIsAvailable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project manager asks for a list",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectManagerSteps.theProjectManagerAsksForAList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"No developer is currently available\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/Register_Time.feature");
formatter.feature({
  "name": "Register time",
  "description": "  Description: developer registers time spent on an activity\n  Actors: developer",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "developer registers time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer is assigned to an activity",
  "keyword": "And "
});
formatter.match({
  "location": "TimeSteps.theDeveloperIsAssignedToAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer registers time spent on the activity",
  "keyword": "When "
});
formatter.match({
  "location": "TimeSteps.theDeveloperRegistersTimeSpentOnAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the registered time is registered to the activity",
  "keyword": "Then "
});
formatter.match({
  "location": "TimeSteps.theRegisteredTimeIsRegisteredToTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the registered time is registered to the developer",
  "keyword": "And "
});
formatter.match({
  "location": "TimeSteps.theRegisteredTimeIsRegisteredToTheDeveloper()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "developer registers time to an activity the developer is not registered to",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer is not assigned to the activity",
  "keyword": "And "
});
formatter.match({
  "location": "TimeSteps.theDeveloperIsNotAssignedToTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer registers time spent on the activity",
  "keyword": "When "
});
formatter.match({
  "location": "TimeSteps.theDeveloperRegistersTimeSpentOnAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer gets the error message: \"You are not assigned to this activity\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TimeSteps.theDeveloperGetsTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "developer registers an invalid amount of time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer is assigned to an activity",
  "keyword": "And "
});
formatter.match({
  "location": "TimeSteps.theDeveloperIsAssignedToAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer registers an invalid amount of time",
  "keyword": "When "
});
formatter.match({
  "location": "TimeSteps.theDeveloperRegistersAnInvalidAmountOfTime()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer gets the error message: \"The input of time spent is not valid\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TimeSteps.theDeveloperGetsTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "developer wants to see registered time spent to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer has time registered to an activity",
  "keyword": "And "
});
formatter.match({
  "location": "TimeSteps.theDeveloperHasTimeRegisteredToAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer checks time spent",
  "keyword": "When "
});
formatter.match({
  "location": "TimeSteps.theDeveloperChecksTimeSpent()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the time spent registered by the developer is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "TimeSteps.theTimeSpentRegisteredByTheDeveloperIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "developer wants to see registered time spent, but hasn\u0027t registered any time",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer has no time registered to an activity",
  "keyword": "And "
});
formatter.match({
  "location": "TimeSteps.theDeveloperHasNoTimeRegisteredToAnActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer checks time spent",
  "keyword": "When "
});
formatter.match({
  "location": "TimeSteps.theDeveloperChecksTimeSpent()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer gets the error message: \"No registered time spent\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TimeSteps.theDeveloperGetsTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/Remove_Activity.feature");
formatter.feature({
  "name": "Remove activity",
  "description": "  Description: An activity is removed by developer or project manager\n  Actors: Developer or project manager",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Remove a personal activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a activity with the title \"Herimundus\" defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.thereIsAActivityWithTheTitleDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer removes the activity",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theDeveloperRemovesTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity is removed",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theActivityIsRemoved()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Remove a personal activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a activity with the title \"Herimundus\" is not defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.thereIsAActivityWithTheTitleIsNotDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer removes the activity",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theDeveloperRemovesTheActivity()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity is removed",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theActivityIsRemoved()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Remove a project activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project with title \"Heisenberg\" is defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.aProjectWithTitleIsDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the developer is a project manager",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatTheDeveloperIsAProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is a part of the project",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theUserIsAPartOfTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a activity with the title \"Herimundus\" defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.thereIsAActivityWithTheTitleDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project manager removes the activity with title \"Herimundus\"",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theProjectManagerRemovesTheActivityWithTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity with title \"Herimundus\" is removed from the project",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theActivityWithTitleIsRemovedFromTheProject(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Remove a project activity failure",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project with title \"Heisenberg\" is defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.aProjectWithTitleIsDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the developer is a project manager",
  "keyword": "And "
});
formatter.match({
  "location": "ProjectManagerSteps.thatTheDeveloperIsAProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is a part of the project",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theUserIsAPartOfTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is not an activity with the title \"Herimundus\" defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.thereIsNotAnActivityWithTheTitleDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project manager removes the activity with title \"Herimundus\"",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theProjectManagerRemovesTheActivityWithTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"No such activity defined\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Remove a project activity unsuccessfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatTheDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a project with title \"Heisenberg\" is defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.aProjectWithTitleIsDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer is not project manager",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theDeveloperIsNotProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is a part of the project",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theUserIsAPartOfTheProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there is a activity with the title \"Herimundus\" defined",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.thereIsAActivityWithTheTitleDefined(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the project manager removes the activity with title \"Herimundus\"",
  "keyword": "When "
});
formatter.match({
  "location": "UserSteps.theProjectManagerRemovesTheActivityWithTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the activity with title \"Herimundus\" is removed from the project",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theActivityWithTitleIsRemovedFromTheProject(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("use_cases/User_Logout.feature");
formatter.feature({
  "name": "User logout",
  "description": "  Description: The user logs off the system\n  Actor: User",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User can logoff",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that there is an active user on the system",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.thatThereIsAnActiveUserOnTheSystem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs off the system",
  "keyword": "When "
});
formatter.match({
  "location": "LoginLogoutSteps.theUserLogsOffTheSystem()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged off",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginLogoutSteps.theUserIsLoggedOff()"
});
formatter.result({
  "status": "passed"
});
});