$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases/Developer_Login.feature");
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
  "name": "there is a developer with username \"dd\" registered in the system",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.thereIsADeveloperWithUsernameRegisteredInTheSystem(String)"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat acceptance_tests.LoginLogoutSteps.thereIsADeveloperWithUsernameRegisteredInTheSystem(LoginLogoutSteps.java:35)\r\n\tat ✽.there is a developer with username \"dd\" registered in the system(use_cases/Developer_Login.feature:7)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the password \"1234\" is entered correctly",
  "keyword": "When "
});
formatter.match({
  "location": "LoginLogoutSteps.thePasswordIsEnteredCorrectly(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the developer is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginLogoutSteps.theDeveloperIsLoggedIn()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});