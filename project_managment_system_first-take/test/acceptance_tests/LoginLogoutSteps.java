package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.app.AuthenticationException;
import planner.app.Planner;
import planner.domain.User;

public class LoginLogoutSteps {

    private Planner planner;
    private User user;

    private ErrorMessageHolder errorMessage;
    private UserHelper userHelper;


    public LoginLogoutSteps(Planner planner, ErrorMessageHolder errorMessage, UserHelper userHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.userHelper = userHelper;
    }

    @Given("^that there is no active user on the system$")
    public void thatThereIsNoActiveUserOnTheSystem() throws Exception {
        assertFalse(planner.activeSession());
    }

    @Given("^there is a developer with username \"([^\"]*)\" and password \"([^\"]*)\" registered in the system$")
    public void thereIsADeveloperWithUsernameAndPasswordRegisteredInTheSystem(String arg1, String arg2) throws Exception {
        user = new User(arg1,arg2);
        planner.users.add(user);
        assertTrue(planner.getUser(arg1)!=null);
    }


    @When("^the password \"([^\"]*)\" is entered correctly$")
    public void thePasswordIsEnteredCorrectly(String password) throws Exception {
        assertTrue(planner.getUser(user.getCredentials()).getPassword().equals(password));
        planner.userLogIn(user.getCredentials(),user.getPassword());
    }

    @Then("^the developer is logged in$")
    public void theDeveloperIsLoggedIn() throws Exception {
        assertTrue(planner.activeSession());
    }

    @Given("^there is a not developer with username \"([^\"]*)\" registered in the system$")
    public void thereIsANotDeveloperWithUsernameRegisteredInTheSystem(String credentials) throws Exception {
        assertThat(planner.getUser(credentials), is(equalTo(null)));
    }

    @When("^the developer enters the password \"([^\"]*)\"$")
    public void theDeveloperEntersThePassword(String password) throws Exception {
        try {
            planner.userLogIn("wrong username", password);
        } catch (AuthenticationException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Given("^there is a developer with username \"([^\"]*)\" registered in the system$")
    public void thereIsADeveloperWithUsernameRegisteredInTheSystem(String arg1) throws Exception {
        user = new User(arg1,"rightpassword");
        planner.users.add(user);
        assertTrue(planner.getUser(arg1)!=null);
    }

    @Given("^the password \"([^\"]*)\" does not match the credentials$")
    public void thePasswordDoesNotMatchTheCredentials(String password) throws Exception {
        assertThat(planner.getUser(user.getCredentials()).getPassword(),is(not(password)));
    }

    @Given("^that there is an active user on the system$")
    public void thatThereIsAnActiveUserOnTheSystem() throws Exception {
        user = userHelper.getUser();
        planner.userLogIn(user.getCredentials(),user.getPassword());
        assertTrue(planner.activeSession());
    }

    @When("^the user logs off the system$")
    public void theUserLogsOffTheSystem() throws Exception {
        planner.userLogOut();
    }

    @Then("^the user is logged off$")
    public void theUserIsLoggedOff() throws Exception {
        assertFalse(planner.activeSession());
    }

}
