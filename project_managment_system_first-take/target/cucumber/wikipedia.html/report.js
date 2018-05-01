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
  "name": "the credentials is \"dd\" and the password is \"1234\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginLogoutSteps.theCredentialsIsAndThePasswordIs(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer login succeeds",
  "keyword": "When "
});
formatter.match({
  "location": "LoginLogoutSteps.theDeveloperLoginSucceeds()"
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
  "name": "the username is \"wrong username\"",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginLogoutSteps.theUsernameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the developer login fails",
  "keyword": "When "
});
formatter.match({
  "location": "LoginLogoutSteps.theDeveloperLoginFails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the error message \"Wrong username\"",
  "keyword": "Then "
});
formatter.match({
  "location": "UserSteps.iGetTheErrorMessage(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: \nExpected: is \"Wrong username\"\n     but: was \"\"\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\r\n\tat org.junit.Assert.assertThat(Assert.java:956)\r\n\tat org.junit.Assert.assertThat(Assert.java:923)\r\n\tat acceptance_tests.UserSteps.iGetTheErrorMessage(UserSteps.java:141)\r\n\tat ✽.I get the error message \"Wrong username\"(use_cases/Developer_Login.feature:14)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});