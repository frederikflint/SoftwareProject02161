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
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Developer has the wrong username",
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
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Developer has the wrong password",
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
formatter.after({
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
formatter.before({
  "status": "passed"
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
formatter.after({
  "status": "passed"
});
});