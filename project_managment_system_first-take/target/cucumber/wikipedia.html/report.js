$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases/Admin_Login.feature");
formatter.feature({
  "name": "Admin log-in",
  "description": "  Description: The administrator logs into the system\n  Actor: User",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User logs in",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the user is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UsersSteps.thatTheUserIsNotLoggedIn()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat acceptance_tests.UsersSteps.thatTheUserIsNotLoggedIn(UsersSteps.java:19)\r\n\tat ✽.that the user is not logged in(use_cases/Admin_Login.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the password is entered correctly",
  "keyword": "And "
});
formatter.match({
  "location": "UsersSteps.thePasswordIsEnteredCorrectly()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the user log-in succeeds",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "User enters wrong password",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the user is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UsersSteps.thatTheUserIsNotLoggedIn()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat acceptance_tests.UsersSteps.thatTheUserIsNotLoggedIn(UsersSteps.java:19)\r\n\tat ✽.that the user is not logged in(use_cases/Admin_Login.feature:12)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the password entered is wrong",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user log-in fails",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"Wrong password\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer enters a valid project number, name, description, start and end date",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user creates the project",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project with that project number, name, description and start and end date is created",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer enters an invalid project number, name, description, start or end date",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer creates the project",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"Invalid project credentials\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a developer is defined",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the administrator deletes a developer from the system",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is removed from the system",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "The administrator is not logged in, but tries to remove a developer from",
  "description": "  the system",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is not logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the administrator deletes a developer from the system",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"Administrator rights required for this action\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the administrator deletes a project",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project is deleted",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Administrator deletes a project that doesn\u0027t exist",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the administrator deletes a project",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that project doesn\u0027t exist",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"the entered project doesn\u0027t exist\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("use_cases/Include_Developer_In_Project.feature");
formatter.feature({
  "name": "Include developer in project",
  "description": "  Description: Project manager includes a developer in a project\n  Actors: Project manager",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "The project manager includes a developer in a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a developer is available",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager adds the developer to the project",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is included in the project",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "A project manager is not logged in, trying to include a developer",
  "description": "  in a project",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the project manager is not logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a developer is available",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager adds the developer to the project",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"This action required project manager rights\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "A project manager includes an unavailable developer in a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a developer is unavailable",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager adds the developer to the project",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"Developer is not available in this period\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "A project manager assigns a available developer to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a developer is available",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project the project manager manages contains a project activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is assigned to the project",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager assigns the developer to the activity",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is assigned to the activity",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "A project manager assigns an unavailable developer to an activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that an activity is defined",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a project manager exists",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a developer is unavailable",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager is manager of the project with the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is assigned to the project",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager assigns the developer to the activity",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager gets the error message: \"The developer is unavailable\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "A project manager assigns a developer to an activity outside the project",
  "description": "  managers\u0027 project",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that an activity is defined",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a project manager exists",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a developer is available",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager is not manager of the project with the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is assigned to the project",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager assigns the developer to the activity",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager gets the error message: \"You are not manager of this project\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "A project manager assigns a developer to an activity outside the project",
  "description": "  managers\u0027 project",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that an activity is defined",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a project manager exists",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a developer is available",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager is not manager of the project with the activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is assigned to the project",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager assigns the developer to the activity",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager gets the error message: \"You are not manager of this project\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer has a list of activities",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer wants the list of his activites",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer gets the list of his activites",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer has no activities in his list of activities",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer wants the list of his activities",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"You are assigned to no activities\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
  "name": "that a developer is available",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager retrieves the list",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the available developers appear on the available list",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Project manager check an empty list of available developers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that no developer is available",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project manager retrieves the list",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"No developer is currently available\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is assigned to an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer registers time spent on an activity",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the registered time is registered to the activity",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the registered time is registered to the developer",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "developer registers time to a project the developer is not registered to",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is not assigned to an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer registers time to the activity",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer gets the error message: \"You are not assigned to any activities\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is assigned to an activity",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer registers an invalid amount of time",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer gets the error message: \"The input of time spent is not valid\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "developer wants to see registered time spent",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that a developer is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer wants to see registered time spent",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer checks time spent",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the time spent registered by the developer is displayed",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer wants to see registered time spent",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer checks time spent",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"No registered time spent\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "there is a personal activity with a given title and type",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that activity is removed",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that activity is removed from the developer activities",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Remove a project activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "there is a project activity with a given title and type",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that activity is removed",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that activity is removed from the project",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Remove project activity from user",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that project contains an activity with the given title and type",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that project manager removes a project activity",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that project activity is removed from the project and the developer",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Removal of a nonexistent personal activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that a user is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "there is no personal activity with the given title and type",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the activity is removed",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"Activity not found\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Removal of nonexistent project activity",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "a project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "there is no project activity with a given title and type",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that activity is removed",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"Activity not found\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Removal of nonexistent project activity from user",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the project manager is logged in",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that project does not contain an activity with the given title and type",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that project manager removes a project activity",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I get the error message \"Activity not found\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that a project has no project manager",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a developer is defined",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user is registered as project manager of the project",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user is project manager",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Assign project manager status when project already has a project manager",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that a user is defined",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a project is registered",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the project has a project manager",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that user registers as project manager",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the error message \"Project already has a registered project leader\" occur",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Remove project manager status",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that a developer is project manager",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "that the administrator is logged in",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the administrator removes the project manager status from the user",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the developer is no longer project manager",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});