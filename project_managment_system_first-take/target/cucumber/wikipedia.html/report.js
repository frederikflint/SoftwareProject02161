$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases/Admin_Login.feature");
formatter.feature({
  "name": "Admin login",
  "description": "  Description: The admin logs into the system\n  Actor: Admin",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Admin can login",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
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
  "name": "the admin username is \"admin\" and password \"adminadmin\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the admin login succeeds",
  "keyword": "When "
});
formatter.match({
  "location": "LoginLogoutSteps.theAdminLoginSucceeds()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the admin is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginLogoutSteps.theAdminIsLoggedIn()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
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
formatter.before({
  "status": "passed"
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
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "The developer doesn\u0027t enter valid start and end dates",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
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
  "name": "the developer enters an invalid project number, name, description, start or end date",
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
  "name": "I get the error message \"Invalid project credentials\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
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
formatter.before({
  "status": "passed"
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
  "name": "the developer registers time spent on an activity",
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
formatter.after({
  "status": "passed"
});
});