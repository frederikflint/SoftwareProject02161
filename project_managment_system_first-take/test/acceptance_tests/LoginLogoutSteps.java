package acceptance_tests;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.app.Planner;
import planner.domain.Developer;

public class LoginLogoutSteps {

    private Planner planner;
    private Developer developer = new Developer("dd","1234");

    public LoginLogoutSteps(Planner planner) {
        this.planner = planner;
    }

    @Given("^that there is no active user on the system$")
    public void thatThereIsNoActiveUserOnTheSystem() throws Exception {
        assertThat(planner.activeUser,is(equalTo(null)));
        }

    @Given("^the credentials is \"([^\"]*)\" and the password is \"([^\"]*)\"$")
    public void theCredentialsIsAndThePasswordIs(String credentials, String password) throws Exception {
        // TODO: Make this a helper
        planner.developers.add(developer);
        assertThat(developer.getCredentials(),is(equalTo(credentials)));
        assertThat(developer.getPassword(),is(equalTo(password)));
    }

    @When("^the developer login succeeds$")
    public void theDeveloperLoginSucceeds() throws Exception {
        planner.userLogIn(developer.getCredentials(),developer.getPassword());
        assertThat(planner.activeUser,is(equalTo(developer)));
    }

    @Then("^the developer is logged in$")
    public void theDeveloperIsLoggedIn() throws Exception {
        assertThat(planner.getActiveUser() != null, is(equalTo(true)));
    }

    @Given("^the username is \"([^\"]*)\"$")
    public void theUsernameIs(String credentials) throws Exception {
        assertFalse(developer.getCredentials() == credentials);
    }

    @When("^the developer login fails$")
    public void theDeveloperLoginFails() throws Exception {

        try{
            planner.userLogIn(developer.getCredentials(), "MRX");
        } catch (Exception e){
            assertThat(e.getMessage(),is(equalTo("No developers registered with the planner")));
        }
    }

    @Then("^the developer is not logged in$")
    public void theDeveloperIsNotLoggedIn() throws Exception {
        assertTrue(planner.activeUser == null);

    }

}
