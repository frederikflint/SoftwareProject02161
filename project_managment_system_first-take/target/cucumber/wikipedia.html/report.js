$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases/Create_Project.feature");
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
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters a valid project number, name, description, start and end date",
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
  "name": "the project with that project number, name, description and start and end date is created",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.theProjectWithThatProjectNumberNameDescriptionAndStartAndEndDateIsCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The developer doesn\u0027t enter valid start and end dates",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer enters a project with an invalid time consumption",
  "keyword": "And "
});
formatter.match({
  "location": "UserSteps.theDeveloperEntersAnInvalidProjectNumberNameDescriptionStartOrEndDate()"
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
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
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
  "name": "there is a developer with username \"dd\" registered in the system",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.thereIsADeveloperWithUsernameRegisteredInTheSystem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the password \"1234\" is entered correctly",
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
  "name": "the developer enters the password \"1234\"",
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
  "name": "there is a developer with username \"dd\" registered in the system",
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
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
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
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
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
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
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
  "name": "developer registers time to a project the developer is not registered to",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
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
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
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
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
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
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
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
formatter.uri("use_cases/Set_Project_Manager_Status.feature");
formatter.feature({
  "name": "Set project manager status",
  "description": "  Description: Register developer as project manager\n  Actors: Admin",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Administrator assigns a developer as project manager to a project.",
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
  "name": "a project is defind",
  "keyword": "And "
});
formatter.match({
  "location": "ManagerSteps.aProjectIsDefind()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that a project has no project manager",
  "keyword": "And "
});
formatter.match({
  "location": "ManagerSteps.thatAProjectHasNoProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a developer is defined",
  "keyword": "And "
});
formatter.match({
  "location": "ManagerSteps.aDeveloperIsDefined()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the admin assigns user to project manager",
  "keyword": "When "
});
formatter.match({
  "location": "ManagerSteps.theAdminAssignsUserToProjectManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is project manager",
  "keyword": "Then "
});
formatter.match({
  "location": "ManagerSteps.theUserIsProjectManager()"
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