package acceptance_tests;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.IsNot;
import planner.app.OperationNotAllowedException;
import planner.app.Planner;
import planner.domain.Developer;

public class LoginLogoutSteps {

    private Planner planner;
    private Developer developer = new Developer("dd","1234");
    private ErrorMessageHolder errorMessage;


    public LoginLogoutSteps(Planner planner, ErrorMessageHolder errorMessage) {
        this.planner = planner;
        this.errorMessage = errorMessage;

        planner.developers.add(developer);
    }



    @Given("^that there is no active user on the system$")
    public void thatThereIsNoActiveUserOnTheSystem() throws Exception {
        assertFalse(planner.activeSession());
    }

    @Given("^there is a developer with username \"([^\"]*)\" registered in the system$")
    public void thereIsADeveloperWithUsernameRegisteredInTheSystem(String credentials) throws Exception {
        assertTrue(planner.getDeveloper(credentials).getCredentials().equals(credentials));
    }

    @When("^the password \"([^\"]*)\" is entered correctly$")
    public void thePasswordIsEnteredCorrectly(String password) throws Exception {
        assertTrue(planner.getDeveloper(developer.getCredentials()).getPassword().equals(password));
        planner.userLogIn(developer.getCredentials(),developer.getPassword());
    }

    @Then("^the developer is logged in$")
    public void theDeveloperIsLoggedIn() throws Exception {
        assertTrue(planner.activeSession());
    }

    @Given("^there is a not developer with username \"([^\"]*)\" registered in the system$")
    public void thereIsANotDeveloperWithUsernameRegisteredInTheSystem(String credentials) throws Exception {
        assertThat(planner.getDeveloper(credentials), is(equalTo(null)));
    }

    @When("^the developer enters the password \"([^\"]*)\"$")
    public void theDeveloperEntersThePassword(String password) throws Exception {
        try {
            planner.userLogIn("wrong username", password);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Given("^the password \"([^\"]*)\" does not match the credentials$")
    public void thePasswordDoesNotMatchTheCredentials(String password) throws Exception {
        assertThat(planner.getDeveloper(developer.getCredentials()).getPassword(),is(not(password)));
    }

    @Given("^that there is an active user on the system$")
    public void thatThereIsAnActiveUserOnTheSystem() throws Exception {
        planner.userLogIn(developer.getCredentials(),developer.getPassword());
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
