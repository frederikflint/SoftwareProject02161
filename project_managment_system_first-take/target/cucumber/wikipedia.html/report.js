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
  "location": "Users.thatTheUserIsNotLoggedIn()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat acceptance_tests.Users.thatTheUserIsNotLoggedIn(Users.java:14)\r\n\tat ✽.that the user is not logged in(use_cases/Admin_Login.feature:6)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the password is entered correctly",
  "keyword": "And "
});
formatter.match({
  "location": "Users.thePasswordIsEnteredCorrectly()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the user log-in succeeds",
  "keyword": "When "
});
formatter.match({
  "location": "Users.theUserLogInSucceeds()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "Users.theUserIsLoggedIn()"
});
formatter.result({
  "status": "skipped"
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
  "location": "Users.thatTheUserIsNotLoggedIn()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat acceptance_tests.Users.thatTheUserIsNotLoggedIn(Users.java:14)\r\n\tat ✽.that the user is not logged in(use_cases/Admin_Login.feature:12)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "the password entered is wrong",
  "keyword": "And "
});
formatter.match({
  "location": "Users.thePasswordEnteredIsWrong()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the user log-in fails",
  "keyword": "When "
});
formatter.match({
  "location": "Users.theUserLogInFails()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I get the error message \"Wrong password\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Users.iGetTheErrorMessage(String)"
});
formatter.result({
  "status": "skipped"
});
});