$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases/Include_Developer_In_Project.feature");
formatter.feature({
  "name": "Include developer in project",
  "description": "  Description: Project manager includes a developer in a project\n  Actors: Project manager",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "The project manager adds a developer to a project",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that the developer is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "UserSteps.thatADeveloperIsLoggedIn()"
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
  "name": "the project manager adds the developer to the project",
  "keyword": "When "
});
formatter.match({
  "location": "ProjectManagerSteps.theProjectManagerAddsTheDeveloperToTheProject()"
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
});